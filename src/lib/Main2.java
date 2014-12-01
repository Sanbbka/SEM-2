package lib; /**
 * Created by Sanbka on 20.11.2014.
 */import java.sql.*;
import java.util.Scanner;

public class Main2 {
    public static int jj = 20;
    static String test="";
    private static Connection con = null;
    private static String username = "";
    private static String password = "";
    private static String URL = "jdbc:h2:file:C:/db/my";
  
  /*  public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Username ");

        String us = sc.nextLine();

        System.out.println("NumberTel");
        String telNum = sc.nextLine();

      *//*      try {//создание таблицы
                createDbUserTable();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
*//*

        addDBUser("33", "Sso", "4489177751");//тоже добавление


    }
*/

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(URL, username,password);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private static void createDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE DBUSER("
                + "USER_ID VARCHAR(5) NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, "
                + "CREATED_BY VARCHAR(20) NOT NULL, "
                + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser\" is created!");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public String getCurrentTimeStamp() {

        return new java.util.Date().toString ();

    }

    public   void addDBUser(String id, String userr, String telN){
        Connection dbConnection = null;
        Statement statement = null;

        dbConnection = getDBConnection();
        try {
            statement = dbConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String insertTableSQL = "INSERT INTO DBUSER "
                + "(USER_ID, USERNAME, TELNUMB) " + "VALUES "
                + "('"+id+"'"+",'"+ userr+"','"+ telN+"')";


        try {
            statement.executeUpdate(insertTableSQL);


            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public String[][] getDBUser(){

        Connection dbConnection = null;
        Statement statement = null;



        String mas[][] = new String[jj][5];

        dbConnection = getDBConnection();
        try {
            statement = dbConnection.createStatement();
            PreparedStatement order = dbConnection.prepareStatement("SELECT * FROM MY.PUBLIC.DBUSER;");
            if(order.execute()) {
                ResultSet r1 = order.getResultSet();
                int k1=0;
                while (r1.next()) {
                    for(int i = 1; i <= 4; i++) {//получаем итый столбец таблицы

                        System.out.print(order.getResultSet().getString(i) + " ");
                        mas[k1][i-1] = order.getResultSet().getString(i) + " ";

                    }
                    System.out.println();
                    k1++;
                }
            }

            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mas;
    }

    public  String[] getDbBook(){

        String mas[] = new String[20];

        Connection dbConnection = null;
        Statement statement = null;

        dbConnection = getDBConnection();
        try {
            statement = dbConnection.createStatement();
            PreparedStatement order = dbConnection.prepareStatement("SELECT * FROM MY.PUBLIC.BOOK;");

            if(order.execute()) {
                ResultSet r1 = order.getResultSet();
                int k1=0;

                while (r1.next()) {
                    for(int i = 2; i <= 2; i++) {//получаем итый столбец таблицы
                        System.out.print(order.getResultSet().getString(i) + " ");
                        mas[k1] = order.getResultSet().getString(i) + "("+order.getResultSet().getString(4)+")";
                    }
                    System.out.println();
                    k1++;
                }
                jj = k1;
            }

            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mas;

    }

    public String[][] setZak(){
        Connection dbConnection = null;
        Statement statement = null;



        String mas[][] = new String[jj][5];

        dbConnection = getDBConnection();
        try {
            statement = dbConnection.createStatement();
            PreparedStatement order = dbConnection.prepareStatement("SELECT * FROM MY.PUBLIC.ORDERS;");
            if(order.execute()) {
                ResultSet r1 = order.getResultSet();
                int k1=0;
                while (r1.next()) {
                    for(int i = 1; i <= 4; i++) {//получаем итый столбец таблицы

                        System.out.print(order.getResultSet().getString(i) + " ");
                        mas[k1][i-1] = order.getResultSet().getString(i) + " ";

                    }
                    System.out.println();
                    k1++;
                }
            }

            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mas;
    }


}