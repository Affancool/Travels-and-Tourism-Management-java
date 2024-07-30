package Login_and_Sign_up;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Forget_Password extends JFrame{
    String Username,question,answer,password,us;
    private JTextField ustxt;
    private JPanel MainPanel;
    private JComboBox sqbox;
    private JTextField anstxt;
    private JTextField pstxt;
    private JLabel uslbl;
    private JLabel sclbl;
    private JLabel anslbl;
    private JLabel pslbl;
    private JButton sbbtn;
    private JButton gbbtn;
    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";
    public void initialize(){
        this.setContentPane(MainPanel);
        this.setTitle("Forget Password");
        this.setSize(700,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    public Forget_Password() {

        sbbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = set();
                    if (a == 1){
                        pstxt.setText(password);
                    }
                    else{
                        sbbtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(sbbtn,"User not found...");
                            }
                        });
                    }
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        gbbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login l = new Login();
                setVisible(false);
                l.initialize();
            }
        });
    }
    public int set() throws ClassNotFoundException, SQLException {
        int c = 0;
        Class.forName(Driver);
        Connection con =DriverManager.getConnection(url,username,Password);
        Username = ustxt.getText();
        question = (String) sqbox.getSelectedItem();
        answer = anstxt.getText();
        String T ="SELECT Password From Sign_Up WHERE Username = ? AND Question = ? AND Answer = ?";
        PreparedStatement p = con.prepareStatement(T);
        p.setString(1,Username);
        p.setString(2,question);
        p.setString(3,answer);
        ResultSet r = p.executeQuery();
        if (r.next()){
            password = r.getString("Password");
        }
        String Q = "SELECT Username FROM Sign_Up WHERE Username = ?";
        PreparedStatement q = con.prepareStatement(Q);
        q.setString(1,Username);
        ResultSet r1 = q.executeQuery();
        if (r1.next()){
            us = r1.getString("Username");
            if (us.equals(Username)){
                c = 1;
            }
            else {
                c = 0;
            }
        }
        con.close();
        return c;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Forget_Password f = new Forget_Password();
        f.initialize();
    }
}
