package Login_and_Sign_up;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame implements ActionListener
{
    JLabel bgimg;
    JButton home,admin,Login;
    Timer tm;
    int x = 0;
    String[] imglist = {"C:\\Users\\Admin\\Pictures\\Saved Pictures\\ss3.jpg", "C:\\Users\\Admin\\Pictures\\Saved Pictures\\ss1.jpg", "C:\\Users\\Admin\\Pictures\\Saved Pictures\\ws3.jpg","C:\\Users\\Admin\\Pictures\\Saved Pictures\\ws1.jpg"};
    public Welcome()  {
        //setBounds(10,30,1350,800);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.darkGray);
        p1.setBounds(0, 0, 1600, 80);
        add(p1);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\logo.jpg");
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(20, 8, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Travels and Tourism Management");
        heading.setBounds(110, 23, 500, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Raleway", Font.BOLD, 27));
        p1.add(heading);

        home = new JButton("Home");
        home.setBounds(1050, 38, 100, 50);
        home.setBackground(Color.darkGray);
        home.setForeground(Color.white);
        home.setBorder(new LineBorder(Color.darkGray));
        home.setFont(new Font("SEGOE PRINT", Font.BOLD, 18));
        home.addActionListener(this);
        // home.setMargin(new Insets(0,0,0,60));
        p1.add(home);

        admin = new JButton("Admin");
        admin.setBounds(1150, 38, 100, 50);
        admin.setBackground(Color.darkGray);
        admin.setForeground(Color.white);
        admin.setBorder(new LineBorder(Color.darkGray));
        admin.setFont(new Font("SEGUE_PRINT", Font.BOLD, 18));
        admin.addActionListener(this);
        p1.add(admin);

        Login = new JButton("Login");
        Login.setBounds(1250, 38, 100, 50);
        Login.setBackground(Color.darkGray);
        Login.setForeground(Color.white);
        Login.setBorder(new LineBorder(Color.darkGray));
        Login.setFont(new Font("SEGUE_PRINT", Font.BOLD, 18));
        Login.addActionListener(this);
        p1.add(Login);

        bgimg = new JLabel();
        bgimg.setBounds(0, 80, 1600, 780);
        setImage(2);

        tm = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setImage(x);
                x += 1;
                if (x >= imglist.length)
                    x = 0;
            }
        });

        add(bgimg);
        tm.start();

        setVisible(true);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login l = new Login();
                l.initialize();
            }
        });
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A_Login l = new A_Login();
                l.initialize();
            }
        });
    }

    public void setImage(int i) {
        ImageIcon icon = new ImageIcon(imglist[i]);
        Image newimg = icon.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
        ImageIcon newicon = new ImageIcon(newimg);
        bgimg.setIcon(newicon);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == home)
        {
            new Welcome();
        }
    }

    public static void main(String[] args) {
        Welcome n = new Welcome();
    }
}

