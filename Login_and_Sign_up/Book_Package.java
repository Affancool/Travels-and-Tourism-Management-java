package Login_and_Sign_up;
import com.toedter.calendar.JDateChooser;

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
import java.util.Calendar;
import java.util.Date;

public class Book_Package extends JFrame
{
    JPanel p1,p2;
    JLabel lhead,lplace,lcustomer,lprice,lpersons,ldate,ltotal,lblprice;
    JTextField tfplace,tfusername,tfprice;
    JButton btncheckp,btnbook,btnback;
    JSpinner sp;
    String place,customer;
    int price,total = 0;

    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";

    JDateChooser dc;
    String p;

    public Book_Package(String un, String pl, BigDecimal pr)
    {
        setSize(630,490);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.CYAN);
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
        p2.setBounds(0,52,650,520);
        add(p2);

        lhead = new JLabel("Book Packages");
        lhead.setBounds(50,10,250,30);
        lhead.setForeground(Color.black);
        lhead.setFont(new Font("segoe print",Font.BOLD,24));
        p1.add(lhead);

        lplace = new JLabel("Place Name");
        lplace .setBounds(50,30,150,30);
        lplace .setForeground(Color.black);
        lplace .setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(lplace);

        tfplace = new JTextField();
        tfplace.setBounds(230,30,300,30);
        tfplace.setFont(new Font("segoe print",Font.PLAIN,18));
        p2.add(tfplace);

        lcustomer = new JLabel("Customer Name");
        lcustomer .setBounds(50,80,160,30);
        lcustomer .setForeground(Color.black);
        lcustomer .setFont(new Font("segoe print",Font.PLAIN,18));
        p2.add(lcustomer);

        tfusername = new JTextField();
        tfusername.setBounds(230,80,300,30);
        tfusername.setFont(new Font("segoe print",Font.PLAIN,18));
        p2.add(tfusername);

        lprice = new JLabel("Package Price");
        lprice.setBounds(50,130,150,30);
        lprice.setForeground(Color.black);
        lprice.setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(lprice);

        tfprice = new JTextField();
        tfprice.setBounds(230,130,300,30);
        tfprice.setFont(new Font("segoe print",Font.PLAIN,18));
        p2.add(tfprice);

        lpersons = new JLabel("Total Persons");
        lpersons.setBounds(50,180,150,30);
        lpersons.setForeground(Color.black);
        lpersons.setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(lpersons);

        SpinnerModel model = new SpinnerNumberModel(0,0,100,1);
        sp = new JSpinner(model);
        sp.setBounds(230,180,300,30);
        sp.setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(sp);


        ldate = new JLabel("Date");
        ldate.setBounds(50,230,150,30);
        ldate.setForeground(Color.black);
        ldate.setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(ldate);

        dc = new JDateChooser();
        dc.setDateFormatString("dd-mon-yyyy");
        dc.setBounds(230,230,300,30);
        p2.add(dc);



        ltotal = new JLabel("Total Price");
        ltotal.setBounds(50,280,150,30);
        ltotal.setForeground(Color.black);
        ltotal.setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(ltotal);

        lblprice = new JLabel();
        lblprice .setBounds(230,280,150,30);
        lblprice .setForeground(Color.black);
        lblprice .setFont(new Font("segoe print",Font.PLAIN,20));
        p2.add(lblprice );

        btncheckp = new JButton("Check Price");
        btncheckp.setBounds(290,340,140,35);
        btncheckp.setBackground(Color.WHITE);
        btncheckp.setForeground(Color.BLACK);
        // btncheckp.setBorder(new LineBorder(Color.white));
        btncheckp.setFont(new Font("segoe print",Font.BOLD,18));
        p2.add(btncheckp);
        btncheckp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int no,price;
                no = (int) sp.getValue();
                price = Integer.parseInt(tfprice.getText());
                total = price * no;
                lblprice.setText("Rs: "+ total);

            }
        });

        btnbook = new JButton("Book");
        btnbook.setBounds(470,340,100,35);
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


        tfusername.setText(un);
        tfplace.setText(pl);
        p = pr.toString();
        int wp = Integer.parseInt(p);
        tfprice.setText(p);

        btnbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //sets(un,pl,wp);
                //JOptionPane.showMessageDialog(btnbook,"Package Booked Successfully!");
                int a = (int) sp.getValue();

                String s = null;
                Date d = dc.getDate();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                s = df.format(d);
                new Payment(un,pl,wp,total,a,s);
                setVisible(false);
            }
        });
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //View_Package vp = new View_Package(un);
                setVisible(false);
            }
        });

        setVisible(true);
    }
    /*public void sets(String un,String pl,int pr) throws ClassNotFoundException, SQLException
    {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);

        System.out.println(a);
        System.out.println(s);
        int t = total;
        System.out.println(t);
        String f = "INSERT INTO Booked_Packages(Place,Username,Price,Persons,Dates,Total_Price) VALUES(?,?,?,?,?,?)";
        PreparedStatement p =con.prepareStatement(f);
        p.setString(1,pl);
        p.setString(2,un);
        p.setInt(3,pr);
        p.setInt(4,a);
        p.setString(5,s);
        p.setInt(6,t);
        p.executeUpdate();
        con.close();
    }*/


    public static void main(String[] args)
    {
        Book_Package BP = new Book_Package("Affancool","bbb",new BigDecimal(10));
    }


}

