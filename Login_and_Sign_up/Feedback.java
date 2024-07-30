package Login_and_Sign_up;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.jar.JarFile;

public class Feedback extends JFrame
{
    JLabel ldesc,lrating,lsugges,lcomment;
    JTextArea tacomment;
    JComboBox Rating;
    JPanel p1;
    JButton btnsubmit;
    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";

    String c,m;
    public Feedback(String us) {

        setTitle("Feedback");
        setBounds(300, 300, 600, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        p1 = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Point2D start = new Point2D.Float(0,0);
                Point2D end = new Point2D.Float(getWidth(),getHeight());
                float[] fractions = {0.0f,1.0f};
                Color [] colors = { new Color(210,104,96),new Color(98,188,232)};

                LinearGradientPaint gp = new LinearGradientPaint(start,end,fractions,colors);
                Graphics2D g2d =  (Graphics2D) g;
                g2d.setPaint(gp);
                g2d.fillRect(0,0,getWidth(),getHeight());
            }
        };
        p1.setLayout(null);
        p1.setBounds(0, 0, 600, 500);
        p1.setBackground(Color.WHITE);
        add(p1);

        ldesc = new JLabel("How's your rating for our app performance?");
        ldesc.setBounds(30, 30, 450, 40);
        ldesc.setForeground(Color.black);
        ldesc.setFont(new Font("segoe print", Font.PLAIN, 18));
        p1.add(ldesc);

        lrating = new JLabel("Rating: ");
        lrating.setBounds(30, 80, 100, 40);
        lrating.setForeground(Color.darkGray);
        lrating.setFont(new Font("segoe print", Font.PLAIN, 20));
        p1.add(lrating);

        Rating = new JComboBox();
        Rating.setBounds(150, 85, 250, 28);
        Rating.setBackground(Color.WHITE);
        Rating.setFont(new Font("segoe print", Font.PLAIN, 17));

        Rating.addItem("1 Star");
        Rating.addItem("2 Star");
        Rating.addItem("3 Star");
        Rating.addItem("4 Star");
        Rating.addItem("5 Star");

        p1.add(Rating);

        lsugges = new JLabel("Give any suggestion to make our app better");
        lsugges.setBounds(30, 130, 500, 40);
        lsugges.setForeground(Color.black);
        lsugges.setFont(new Font("segoe print", Font.PLAIN, 18));
        p1.add(lsugges);

        lcomment = new JLabel("Comment: ");
        lcomment.setBounds(30, 180, 120, 40);
        lcomment.setForeground(Color.darkGray);
        lcomment.setFont(new Font("segoe print", Font.PLAIN, 20));
        p1.add(lcomment);

        tacomment = new JTextArea(5,15);
        tacomment.setBounds(150, 180, 400, 200);
        tacomment.setBackground(Color.white);
        tacomment.setBorder(new LineBorder(Color.black));
        tacomment.setFont(new Font("segoe print", Font.PLAIN, 20));
        p1.add(tacomment);

        btnsubmit = new JButton("Submit");
        btnsubmit .setBounds(420,420,140,30);
        btnsubmit .setBackground(Color.WHITE);
        btnsubmit .setForeground(Color.BLACK);
        btnsubmit .setBorder(new LineBorder(Color.black));
        btnsubmit .setFont(new Font("segoe print",Font.BOLD,18));
        p1.add(btnsubmit);

        setVisible(true);

        m = (String) Rating.getSelectedItem();
        int p = tacomment.getRows();
        System.out.println(p);
        int y = tacomment.getColumns();
        System.out.println(y);

        c = tacomment.getText();
        System.out.println(c);

        btnsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sets(us);
                    JOptionPane.showMessageDialog(btnsubmit,"Feedback Saved...\nThank You for your Response...");
                    setVisible(false);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
    public void sets(String un) throws ClassNotFoundException, SQLException
    {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        String f = "INSERT INTO Feedback(Username,Rating,Comments) VALUES(?,?,?)";
        PreparedStatement p =con.prepareStatement(f);
        p.setString(1,un);
        p.setString(2,m);
        p.setString(3,c);
        p.executeUpdate();
        con.close();
    }

    public static void main(String[] args) {
        new Feedback("Thanigai");
    }

}