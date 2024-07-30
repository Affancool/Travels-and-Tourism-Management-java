package Login_and_Sign_up;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Payment extends JFrame
{
    JPanel p1;
    JLabel limg,l1;
    JButton btnpay,btnback;
    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";

    public Payment(String s,String p,int q,int t,int x,String z) {


        setTitle("Payment");
        setBounds(500, 200, 800, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 800, 600);
        p1.setBackground(Color.WHITE);
        add(p1);

        ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\py.jpg");
        Image img1=img.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        limg = new JLabel(img2);
        limg.setBounds(0,0,800,600);
        p1.add(limg);


        l1 = new JLabel();
        l1.setBounds(500,350,300,80);
        l1.setForeground(Color.BLACK);
        String tot = Integer.toString(t);
        l1.setFont(new Font("Segoe Print",Font.BOLD,20));
        l1.setText("Total Amount Rs: " + tot);
        limg.add(l1);

        btnpay = new JButton("  Pay  ");
        btnpay.setBounds(530,500,100,30);
        btnpay.setBackground(Color.BLACK);
        btnpay.setForeground(Color.WHITE);
        //btnpay.setBorder(new LineBorder(Color.darkGray));
        btnpay.setFont(new Font("segoe print",Font.BOLD,18));
        limg.add(btnpay);

        btnpay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sets(s,p,q,t,x,z);
                    JOptionPane.showMessageDialog(btnpay,"Package Booked Successfully\nThank You...");
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
               // new Paytm();
            }
        });

        btnback = new JButton("Back");
        btnback.setBounds(650,500,100,30);
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.WHITE);
        //btnback.setBorder(new LineBorder(Color.darkGray));
        btnback.setFont(new Font("segoe print",Font.BOLD,18));
        limg.add(btnback);


        setVisible(true);


    }

    public void sets(String un,String pl,int pr,int total,int a,String s) throws ClassNotFoundException, SQLException
    {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        String f = "INSERT INTO Booked_Packages(Place,Username,Price,Persons,Dates,Total_Price) VALUES(?,?,?,?,?,?)";
        PreparedStatement p =con.prepareStatement(f);
        p.setString(1,pl);
        p.setString(2,un);
        p.setInt(3,pr);
        p.setInt(4,a);
        p.setString(5,s);
        p.setInt(6,total);
        p.executeUpdate();
        con.close();
    }

}

