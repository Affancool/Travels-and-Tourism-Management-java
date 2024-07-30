package Login_and_Sign_up;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserDB extends JFrame
{

    JButton apdetails,updetails,vdetails,Package,Hotel,bp,bh,feedback,about,logout;
    JTabbedPane tabbedPane;
    JLabel l1;
    public UserDB(String str)
    {
        String username = str;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
        p3.setBackground(Color.CYAN);
        p3.setBounds(220,10,1137,70);
        add(p3);


        JPanel p4= new JPanel();
        p4.setLayout(null);
        p4.setBackground(Color.GRAY);
        p4.setBounds(220,88,1137,620);
        add(p4);

        l1 = new JLabel();
        l1.setBounds(0,0,1137,620);
        ImageIcon i = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\udb.jpg");
        Image im = i.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(im);
        l1.setIcon(img);
        p4.add(l1);

        JLabel luser = new JLabel(username);
        luser.setBounds(20,20,150,30);
        luser.setForeground(Color.WHITE);
        luser.setFont(new Font("Segoe Print",Font.BOLD,20));
        p1.add(luser);

        JLabel lhead = new JLabel("Home Page");
        lhead.setBounds(20,20,150,30);
        lhead.setForeground(Color.black);
        lhead.setFont(new Font("Segoe Print",Font.BOLD,20));
        p3.add(lhead);

        apdetails = new JButton("Add Personal Details");
        apdetails.setBounds(10,10,170,50);
        apdetails.setBackground(Color.DARK_GRAY);
        apdetails.setForeground(Color.WHITE);
        apdetails.setBorder(new LineBorder(Color.darkGray));
        apdetails.setFont(new Font("Segoe Print",Font.BOLD,15));
        //apdetails.addActionListener(this);
        p2.add(apdetails);

        updetails = new JButton("Update Personal Details");
        updetails.setBounds(10,50,190,50);
        updetails.setBackground(Color.DARK_GRAY);
        updetails.setForeground(Color.WHITE);
        updetails.setBorder(new LineBorder(Color.darkGray));
        updetails.setFont(new Font("Segoe Print",Font.BOLD,15));
        //updetails.addActionListener(this);
        p2.add(updetails);

        vdetails = new JButton("View Personal Details");
        vdetails.setBounds(10,90,170,50);
        vdetails.setBackground(Color.DARK_GRAY);
        vdetails.setForeground(Color.WHITE);
        vdetails.setBorder(new LineBorder(Color.darkGray));
        vdetails.setFont(new Font("Segoe Print",Font.BOLD,15));
        //vdetails.addActionListener(this);
        p2.add(vdetails);

        Package= new JButton("Packages");
        Package.setBounds(10,130,75,50);
        Package.setBackground(Color.DARK_GRAY);
        Package.setForeground(Color.WHITE);
        Package.setBorder(new LineBorder(Color.darkGray));
        Package.setFont(new Font("Segoe Print",Font.BOLD,15));
        p2.add(Package);

        Hotel= new JButton("Hotels");
        Hotel.setBounds(10,170,55,50);
        Hotel.setBackground(Color.DARK_GRAY);
        Hotel.setForeground(Color.WHITE);
        Hotel.setBorder(new LineBorder(Color.darkGray));
        Hotel.setFont(new Font("Segoe Print",Font.BOLD,15));
        p2.add(Hotel);

        bp = new JButton("Booked Packages");
        bp.setBounds(10,210,140,50);
        bp.setBackground(Color.DARK_GRAY);
        bp.setForeground(Color.WHITE);
        bp.setBorder(new LineBorder(Color.darkGray));
        bp.setFont(new Font("Segoe Print",Font.BOLD,15));
        p2.add(bp);

        bh = new JButton("Booked Hotels");
        bh.setBounds(10,250,110,50);
        bh.setBackground(Color.DARK_GRAY);
        bh.setForeground(Color.WHITE);
        bh.setBorder(new LineBorder(Color.darkGray));
        bh.setFont(new Font("Segoe Print",Font.BOLD,15));
        p2.add(bh);

        feedback = new JButton("Feedback");
        feedback .setBounds(10,290,80,50);
        feedback .setBackground(Color.DARK_GRAY);
        feedback .setForeground(Color.WHITE);
        feedback .setBorder(new LineBorder(Color.darkGray));
        feedback .setFont(new Font("Segoe Print",Font.BOLD,15));
        p2.add(feedback );

        about = new JButton("About");
        about .setBounds(10,330,60,50);
        about .setBackground(Color.DARK_GRAY);
        about .setForeground(Color.WHITE);
        about .setBorder(new LineBorder(Color.darkGray));
        about .setFont(new Font("Segoe Print",Font.BOLD,15));
        p2.add(about);

        logout = new JButton("Log Out");
        logout .setBounds(10,370,70,50);
        logout .setBackground(Color.DARK_GRAY);
        logout.setForeground(Color.WHITE);
        logout .setBorder(new LineBorder(Color.darkGray));
        logout .setFont(new Font("Segoe Print",Font.BOLD,15));
        p2.add(logout);

        setVisible(true);

        apdetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personal_Details p = new Personal_Details(str);
                    p.initialize();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        vdetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    View_Details v = new View_Details(str);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        Package.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    View_Package p = new View_Package(str);
                    //p.initialize();
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
                    View_Hotels h = new View_Hotels("aa");
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
                    UBooked_Packages ubp = new UBooked_Packages(str);
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
                    UBooked_Hotels ubh = new UBooked_Hotels(str);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        feedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Feedback f = new Feedback(str);
            }
        });

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About a = new About();
            }
        });

        updetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Updatedetails u = new Updatedetails(str);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Welcome w = new Welcome();
                setVisible(false);
            }
        });


    }
    public static void main(String[] args) {
        UserDB s = new UserDB("Affancool");
    }


}

