package Login_and_Sign_up;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book_Hotel extends JFrame  {
    JPanel p1,p2;
    JLabel lhead,lhotel,lcustomer,lpersons,ldays,lac,lfood,ltotal,lblprice,lprice;
    JTextField tfhotel,tfcustomer,tfprice;
    JButton btncheckp,btnbook,btnback;
    JSpinner sp1,sp2 ;
    JComboBox ac,food;
    String place,customer;
    int price,total = 0;
    String p;

    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";

    public Book_Hotel(String hn, String un, BigDecimal pr)
    {
        setSize(630,535);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.cyan);
        p1.setBounds(0,0,650,50);
        add(p1);

        p2 = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Point2D start = new Point2D.Float(0,0);
                Point2D end = new Point2D.Float(getWidth(),getHeight());
                float[] fractions = {0.0f,1.0f};
                Color [] colors = { new Color(97,154,96),new Color(128,238,232)};

                LinearGradientPaint gp = new LinearGradientPaint(start,end,fractions,colors);
                Graphics2D g2d =  (Graphics2D) g;
                g2d.setPaint(gp);
                g2d.fillRect(0,0,getWidth(),getHeight());
            }
        };
        p2.setLayout(null);
        p2.setBounds(0,52,650,500);
        add(p2);

        lhead = new JLabel("Book Hotels");
        lhead.setBounds(50,10,250,30);
        lhead.setForeground(Color.black);
        lhead.setFont(new Font("segoe print",Font.BOLD,24));
        p1.add(lhead);

        lhotel = new JLabel("Hotel Name");
        lhotel .setBounds(50,20,150,28);
        lhotel .setForeground(Color.black);
        lhotel .setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(lhotel);

        tfhotel = new JTextField();
        tfhotel.setBounds(230,20,300,30);
        tfhotel.setFont(new Font("segoe print",Font.PLAIN,18));
        p2.add(tfhotel);

        lcustomer = new JLabel("Customer Name");
        lcustomer.setBounds(50,65,160,28);
        lcustomer .setForeground(Color.black);
        lcustomer.setFont(new Font("segoe print",Font.PLAIN,18));
        p2.add(lcustomer);

        tfcustomer = new JTextField();
        tfcustomer.setBounds(230,65,300,30);
        tfcustomer.setFont(new Font("segoe print",Font.PLAIN,18));
        p2.add(tfcustomer);

        lprice = new JLabel("Hotel Rent");
        lprice.setBounds(50,110,150,30);
        lprice.setForeground(Color.black);
        lprice.setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(lprice);

        tfprice = new JTextField();
        tfprice.setBounds(230,110,300,30);
        tfprice.setFont(new Font("segoe print",Font.PLAIN,18));
        p2.add(tfprice);

        lpersons = new JLabel("Total Persons");
        lpersons.setBounds(50,155,150,28);
        lpersons .setForeground(Color.black);
        lpersons.setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(lpersons);

        SpinnerModel model1 = new SpinnerNumberModel(0,0,100,1);
        sp1 = new JSpinner(model1);
        sp1.setBounds(230,155,300,30);
        sp1.setFont(new Font("segoe print",Font.PLAIN,18));
        p2.add(sp1);

        ldays = new JLabel("No. of days");
        ldays.setBounds(50,200,150,28);
        ldays.setForeground(Color.black);
        ldays.setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(ldays);

        SpinnerModel model2 = new SpinnerNumberModel(0,0,100,1);
        sp2 = new JSpinner(model2);
        sp2.setBounds(230,200,300,30);
        sp2.setFont(new Font("segoe print",Font.PLAIN,18));
        p2.add(sp2);

        lac = new JLabel("AC/Non-Ac");
        lac.setBounds(50,245,150,28);
        lac .setForeground(Color.black);
        lac.setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(lac);

        ac = new JComboBox();
        ac.setBounds(230,245,300,28);
        ac.setBackground(Color.white);
        ac.setFont(new Font("segoe print",Font.PLAIN,17));
        p2.add(ac);

        ac.addItem("Ac");
        ac.addItem("Non-Ac");

        lfood = new JLabel("Food Included");
        lfood.setBounds(50,290,150,28);
        lfood .setForeground(Color.black);
        lfood.setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(lfood);

        food = new JComboBox();
        food.setBounds(230,290,300,28);
        food.setBackground(Color.white);
        food.setFont(new Font("segoe print",Font.PLAIN,17));
        p2.add(food);

        food.addItem("Yes");
        food.addItem("No");

        ltotal = new JLabel("Total Price");
        ltotal.setBounds(50,335,150,30);
        ltotal.setForeground(Color.black);
        ltotal.setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(ltotal);

        lblprice = new JLabel("");
        lblprice .setBounds(230,335,150,30);
        lblprice .setForeground(Color.black);
        lblprice .setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(lblprice );

        btncheckp = new JButton("Check Price");
        btncheckp.setBounds(290,400,140,35);
        btncheckp.setBackground(Color.WHITE);
        btncheckp.setForeground(Color.BLACK);
        //btncheckp.setBorder(new LineBorder(Color.darkGray));
        btncheckp.setFont(new Font("segoe print",Font.BOLD,18));
        p2.add(btncheckp);
        btncheckp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int no,price,days;
                int AcRent = 2000;
                int FoodRent = 1000;
                no = (int) sp1.getValue();
                days = (int) sp2.getValue();
                price = Integer.parseInt(tfprice.getText());
                if(ac.getSelectedItem()=="Ac")
                {
                    if(food.getSelectedItem()=="Yes")
                    {
                        price = price + AcRent + FoodRent;
                        total = price * no *days;
                    }
                    else
                    {
                        price = price + AcRent;
                        total = price * no * days;
                    }
                }
                else
                {
                    if(food.getSelectedItem()=="Yes")
                    {
                        price = price + FoodRent;
                        total = price * no *days;
                    }
                    else
                    {
                        total = price * no * days;
                    }
                }
                lblprice.setText("Rs "+ total);
            }
        });

        btnbook = new JButton("Book");
        btnbook.setBounds(470,400,100,35);
        btnbook.setBackground(Color.WHITE);
        btnbook.setForeground(Color.BLACK);
        //btnbook.setBorder(new LineBorder(Color.darkGray));
        btnbook.setFont(new Font("segoe print",Font.BOLD,18));
        p2.add(btnbook);

        btnback = new JButton("Back");
        btnback.setBounds(530,15,100,30);
        btnback.setBackground(Color.cyan);
        btnback.setForeground(Color.BLACK);
        btnback.setBorder(new LineBorder(Color.cyan));
        btnback.setFont(new Font("segoe print",Font.BOLD,18));
        p1.add(btnback);


        tfhotel.setText(hn);
        tfcustomer.setText(un);
        p = pr.toString();
        int wp = Integer.parseInt(p);
        tfprice.setText(p);

        btnbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sets(hn,un,wp);
                    JOptionPane.showMessageDialog(btnbook,"Hotel Booked Successfully...");
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    View_Hotels h = new View_Hotels(un);
                    setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        setVisible(true);

    }

    public void sets(String hn,String un,int pr) throws ClassNotFoundException, SQLException
    {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        int a = (int) sp1.getValue();
        System.out.println(a);
        int b = (int) sp2.getValue();
        String m,n;
        m = (String) ac.getSelectedItem();
        n = (String) food.getSelectedItem();
        int t = total;
        String f = "INSERT INTO Booked_Hotel(Name,Username,Rent,Persons,No_of_days,AC_Status,Food_Status,Total_Price) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement p =con.prepareStatement(f);
        p.setString(1,hn);
        p.setString(2,un);
        p.setInt(3,pr);
        p.setInt(4,a);
        p.setInt(5,b);
        p.setString(6,m);
        p.setString(7,n);
        p.setInt(8,total);
        p.executeUpdate();
        con.close();
    }

    public static void main(String[] args)
    {
        Book_Hotel BH = new Book_Hotel("ii","zzz",new BigDecimal(2));
    }
}
