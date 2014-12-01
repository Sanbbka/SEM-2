package lib;

/**
 * Created by Sanbka on 25.11.2014.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {

    String items[] = new String[15];

    private JLabel sss;
    private JLabel nameBook;
    private JLabel telN;

    private JButton addZ;
    private JButton removeZ;

    private JTextField textFieldName;
    private  JTextField textFieldNBook;
    private JTextField textFieldNumber;

    public Main() {
        super("Admin");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font font = new Font("Verdana", Font.PLAIN, 12);


        ArrayList<String> itemms = new ArrayList<String>();
        itemms.add("21qwe");
        itemms.add("21qswe");
        itemms.add("21qwsssae");

        Container content = getContentPane();

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        final JLabel label = new JLabel(" ");
        label.setAlignmentX(LEFT_ALIGNMENT);
        label.setFont(font);
        content.add(label);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                String item = (String)box.getSelectedItem();
                //label.setText(item);
            }
        };

        Main2 ssss = new Main2();

        items = ssss.getDbBook();

        JComboBox comboBox = new JComboBox(items);
        comboBox.setFont(font);
        comboBox.setAlignmentX(LEFT_ALIGNMENT);
        comboBox.addActionListener(actionListener);
     //   content.add(comboBox);

     /* Подготавливаем компоненты объекта  */
        addZ = new JButton("Make order");
        removeZ = new JButton("Remove order");

        sss = new JLabel("NAME: " );
        telN = new JLabel("Telephone");
        nameBook = new JLabel("Name book");

        textFieldNBook = new JTextField(15);
        textFieldNumber = new JTextField(15);
        textFieldName = new JTextField(15);
///////////////////////
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);
//        tabbedPane.addTab("Users " + "", new JPanel());
////////////
     /* Подготавливаем временные компоненты  */
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JPanel ss = new JPanel(new FlowLayout());
     /* Расставляем компоненты по местам  */
       // add(countLabel, BorderLayout.NORTH); /* О размещении компонент поговорим позже  */
        buttonsPanel.add(addZ);
        buttonsPanel.add(removeZ);

//////////////////
        JPanel content1 = new JPanel();

        content1.setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        content1.add(buttons, BorderLayout.NORTH);

        JButton add = new JButton("Add");
        add.setFont(font);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // tabbedPane.addTab("Order ", new JPanel());

                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        new TestFrame();
                    }
                });
            }
        });
      //  tabbedPane.addTab("Order " , new JPanel());
        JComponent panel1 = makeTextPanel(1);// 1 - users 2 - orders
        panel1.add(sss);

        tabbedPane.addTab("Users", null, panel1,
                "Does nothing");
        JComponent panel2 = makeTextPanel(2);// 1 - users 2 - orders
        panel1.add(sss);
        tabbedPane.addTab("Order", null, panel2,
                "Does nothing");

        buttons.add(add);
        ////////////
        ss.add(sss);
        ss.add(textFieldName);
        ss.add(nameBook);
        ss.add(comboBox);
        ss.add(telN);
        ss.add(textFieldNumber);

        add(buttonsPanel, BorderLayout.SOUTH);
        add(ss, BorderLayout.NORTH);

        content1.add(tabbedPane, BorderLayout.CENTER);

        getContentPane().add(content1);

        initListeners();
       // add(textField);
    }

    private JComponent makeTextPanel(int a) {
        JPanel panel = new JPanel(false);
        DefaultTableModel model;
        JTable table;
        String users[][] = new String[Main2.jj][5];
        String userss[] = new String[] {"user","username","telnumb","kolorder"};



        Main2 db1 = new Main2();

        users = db1.getDBUser();

        if(a == 1) {
            model = new DefaultTableModel(users, userss);
            table = new JTable(model);
        }else {
            model = new DefaultTableModel(users, userss);
            table = new JTable(model);
        }

        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        pack();
        panel.setLayout(new GridLayout(1, 1));
        panel.add(table);

        return panel;
    }

    private void initListeners() {

        final Main2 db =  new Main2();

        addZ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String sName = textFieldName.getText();
                String bookName = textFieldNBook.getText();
                String telNumber = telN.getText();

               // db.addDBUser("23", "sss","89654313");

                textFieldName.setText(null);
                textFieldNBook.setText(null);
                textFieldNumber.setText(null);

            }
        });

        removeZ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                textFieldName.setText(null);
                textFieldNBook.setText(null);
                textFieldNumber.setText(null);

            }
        });
    }

    public static void main(String[] args) {

        Main app = new Main();
        app.setVisible(true);
        app.pack(); /* Эта команда подбирает оптимальный размер в зависимости от содержимого окна  */

    }
}