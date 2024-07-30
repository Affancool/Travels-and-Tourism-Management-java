package Login_and_Sign_up;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class A_Login extends JFrame{
    private JPanel MainPanel;
    private JTextField ustxt;
    private JPanel panel1;
    private JLabel iclbl;
    private JLabel wllbl;
    private JPasswordField pw;
    private JButton submbtn;
    private JLabel userlbl;
    private JLabel pwlbl;
    private JButton clbtn;
    private JLabel icnlbl;
    private JButton fgbtn;
    String Username,password,us,pass;
    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";
    public A_Login(){

        submbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = set();
                    if (a == 1){
                        String k = ustxt.getText();
                        System.out.println(k);
                        setVisible(false);
                        new ALoading();
                    }
                    else{
                        JOptionPane.showMessageDialog(submbtn,"Invalid Username/Password...");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        clbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    public void initialize(){
        this.setContentPane(MainPanel);
        this.setSize(900,500);
        this.setTitle("Login_and_Sign_up.Login");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        ImageIcon i = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\la.jpg");
        Image im = i.getImage().getScaledInstance(iclbl.getWidth(),iclbl.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(im);
        iclbl.setIcon(img);
        ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\li.jpg");
        Image im1 = i1.getImage().getScaledInstance(icnlbl.getWidth(),icnlbl.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(im1);
        icnlbl.setIcon(img1);

    }
    public int set() throws SQLException, ClassNotFoundException {
        int x;
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        String un = "Admin";
        String ps = "12345";
        Username = ustxt.getText();
        char[] q = pw.getPassword();
        password = new String(q);
        if (Username.equals(un) && password.equals(ps)){
            x = 1;
        }
        else{
            x = -1;
        };
        /*String a = "SELECT username,password FROM Sign_Up WHERE username = ?";
        PreparedStatement p = con.prepareStatement(a);
        p.setString(1,Username);
        ResultSet r = p.executeQuery();
        if (r.next()){
            us = r.getString("Username");
            pass = r.getString("Password");

        }
        else{
            x = -1;
        }*/
        con.close();
        return x;
    }

    public static void main(String[] args) {
        A_Login ob = new A_Login();
        ob.initialize();
    }
}
