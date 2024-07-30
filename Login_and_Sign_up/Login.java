package Login_and_Sign_up;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame{
    String Username,password,us,pass;
    private JTextField ustxt;
    private JPanel MainPanel;
    private JPasswordField pw;
    private JButton submbtn;
    private JButton clbtn;
    private JPanel panel1;
    private JLabel userlbl;
    private JLabel pwlbl;
    private JLabel iclbl;
    private JLabel wllbl;
    private JLabel wellbl;
    private JButton sgbtn;
    private JLabel icnlbl;
    private JLabel frlbl;
    private JButton fgbtn;

    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";
    public Login(){

        submbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = set();
                    if (a == 1){
                        String k = ustxt.getText();
                        System.out.println(k);
                        setVisible(false);
                        Loading m = new Loading(k);
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
        sgbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Sign_In z = new Sign_In();
                    setVisible(false);
                    z.initialize();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        fgbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Forget_Password f = new Forget_Password();
                setVisible(false);
                f.initialize();
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
    }
    public int set() throws SQLException, ClassNotFoundException {
        int x;
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        Username = ustxt.getText();
        char[] q = pw.getPassword();
        password = new String(q);
        String a = "SELECT username,password FROM Sign_Up WHERE username = ?";
        PreparedStatement p = con.prepareStatement(a);
        p.setString(1,Username);
        ResultSet r = p.executeQuery();
        if (r.next()){
            us = r.getString("Username");
            pass = r.getString("Password");
            if (Username.equals(us) && password.equals(pass)){
                x = 1;
            }
            else{
                x = -1;
            }
        }
        else{
            x = -1;
        }
        con.close();
        return x;
    }

    public static void main(String[] args) {
        Login ob = new Login();
        ob.initialize();
    }
}