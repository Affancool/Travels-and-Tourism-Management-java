package Login_and_Sign_up;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AdminDB extends JFrame
{
    JButton Package,Hotel,Customer,bp,bh,logout;
    JLabel bgimg,ladmin,lhead;
    public AdminDB()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.DARK_GRAY);
        p1.setBounds(10,10,200,70);
        add(p1);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.DARK_GRAY);
        p2.setBounds(10,88,200,620);
        add(p2);

        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(Color.GRAY);
        p3.setBounds(220,10,1137,70);
        add(p3);

        JPanel p4= new JPanel();
        p4.setLayout(null);
        p4.setBackground(Color.DARK_GRAY);
        p4.setBounds(220,88,1137,620);
        add(p4);

        ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\adb.jpg");
        Image img1=img.getImage().getScaledInstance(1137,620,Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(img1);
        bgimg = new JLabel(img2);
        bgimg.setBounds(0,0,1137,620);
        p4.add(bgimg);

        ladmin = new JLabel("Administrator");
        ladmin.setBounds(20,20,150,30);
        ladmin.setForeground(Color.WHITE);
        ladmin.setFont(new Font("segoe print",Font.BOLD,20));
        p1.add(ladmin);

        lhead = new JLabel("Home Page");
        lhead.setBounds(20,20,150,30);
        lhead.setForeground(Color.WHITE);
        lhead.setFont(new Font("segoe print",Font.BOLD,20));
        p3.add(lhead);

        Package= new JButton("Packages");
        Package.setBounds(10,10,75,50);
        Package.setBackground(Color.DARK_GRAY);
        Package.setForeground(Color.WHITE);
        Package.setBorder(new LineBorder(Color.darkGray));
        Package.setFont(new Font("segoe print",Font.BOLD,15));
        p2.add(Package);

        Hotel= new JButton("Hotels");
        Hotel.setBounds(10,50,55,50);
        Hotel.setBackground(Color.DARK_GRAY);
        Hotel.setForeground(Color.WHITE);
        Hotel.setBorder(new LineBorder(Color.darkGray));
        Hotel.setFont(new Font("segoe print",Font.BOLD,15));
        p2.add(Hotel);

        Customer = new JButton("Customers INFO");
        Customer.setBounds(10,90,125,50);
        Customer.setBackground(Color.DARK_GRAY);
        Customer.setForeground(Color.WHITE);
        Customer.setBorder(new LineBorder(Color.darkGray));
        Customer.setFont(new Font("segoe print",Font.BOLD,15));
        p2.add(Customer);

        bp = new JButton("Booked Packages");
        bp.setBounds(10,130,130,50);
        bp.setBackground(Color.DARK_GRAY);
        bp.setForeground(Color.WHITE);
        bp.setBorder(new LineBorder(Color.darkGray));
        bp.setFont(new Font("segoe print",Font.BOLD,15));
        p2.add(bp);

        bh = new JButton("Booked Hotels");
        bh.setBounds(10,170,110,50);
        bh.setBackground(Color.DARK_GRAY);
        bh.setForeground(Color.WHITE);
        bh.setBorder(new LineBorder(Color.darkGray));
        bh.setFont(new Font("segoe print",Font.BOLD,15));
        p2.add(bh);

        logout = new JButton("Log Out");
        logout .setBounds(10,210,70,50);
        logout .setBackground(Color.DARK_GRAY);
        logout.setForeground(Color.WHITE);
        logout .setBorder(new LineBorder(Color.darkGray));
        logout .setFont(new Font("segoe print",Font.BOLD,15));
        p2.add(logout);

        setVisible(true);


        Package.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Packages p = new Packages();
                    p.initialize();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Hotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AHotel ah = new AHotel();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        bp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Booked_Packages p = new Booked_Packages();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        bh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Booked_Hotels h = new Booked_Hotels();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Customer c = new Customer();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Welcome w = new Welcome();
            }
        });

    }

    public static void main(String[] arg)
    {

        AdminDB dba = new AdminDB();

    }


}

