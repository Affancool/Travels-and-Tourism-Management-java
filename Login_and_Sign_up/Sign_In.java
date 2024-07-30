package Login_and_Sign_up;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import static java.lang.Character.isLetterOrDigit;

public class Sign_In extends JFrame{
    String Name,Mobile_Number,Username,password,question,answer;
    private JPanel Mainpanel;
    private JTextField nametxt;
    private JTextField numtxt;
    private JTextField ustxt;
    private JPasswordField PW1;
    private JLabel Namelbl;
    private JLabel Numlbl;
    private JLabel usrlbl;
    private JLabel PWlbl;
    private JPanel panel2;
    private JButton subbtn;
    private JButton cnlbtn;
    private JLabel Loginlbl;
    private JButton Loginbtn;
    private JLabel iconlbl;
    private JPanel panel3;
    private JLabel wllbl;
    private JLabel sclbl;
    private JComboBox qbox;
    private JTextField anstxt;

    public Sign_In() throws SQLException, ClassNotFoundException {
        subbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = set();
                    if (a != 1){
                        JOptionPane.showMessageDialog(subbtn,"Password does not meet the requirement...");
                    }
                    else{
                        JOptionPane.showMessageDialog(subbtn,"Account created Successfully!");
                        Login l = new Login();
                        l.initialize();
                        setVisible(false);

                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        Loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login l = new Login();
                l.initialize();
            }
        });
        cnlbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    public int Password_Check(String s){
        int n = s.length();
        int count,count1;
        count = count1 = 0;
        if (n < 8 ){
            return -1;
        }
        else {
            for (int i = 0; i < n; i++){
                if (isLetterOrDigit(s.charAt(i)) == true){
                    count ++;
                }
                else {
                    count1++;
                }
            }
            if (count > 0 && count1 > 0){
                return 1;
            }
            else {
                return -1;
            }
        }
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        this.setContentPane(Mainpanel);
        this.setTitle("Sign Up");
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }
    public int set() throws SQLException, ClassNotFoundException {
        int c;
        String Driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "affan";
        String Password = "Affan2004";
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        Name = nametxt.getText();
        Mobile_Number = numtxt.getText();
        Username = ustxt.getText();
        char[] ps = PW1.getPassword();
        password = new String(ps);
        question = (String) qbox.getSelectedItem();
        answer = anstxt.getText();
        int a = Password_Check(password);
        if (a != 1){
            return -1;
        }
        else{
            String I = "INSERT INTO Sign_Up(Name,Mobile_Number,Username,Password,Question,Answer) VALUES(?,?,?,?,?,?)";
            PreparedStatement p =con.prepareStatement(I);
            p.setString(1,Name);
            p.setString(2,Mobile_Number);
            p.setString(3,Username);
            p.setString(4,password);
            p.setString(5,question);
            p.setString(6,answer);
            p.executeUpdate();
            c = 1;
        }
        con.close();
        return 1;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Sign_In obj = new Sign_In();
        obj.initialize();
    }
}
