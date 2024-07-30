package Login_and_Sign_up;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Personal_Details extends JFrame{
    String us,name,gender,id,id_num,ph_num,email,address,country;
    int age;
    private JTextField ustxt;
    private JPanel MainP;
    private JTextField nmbtxt;
    private JRadioButton mrb;
    private JRadioButton frb;
    private JTextField emtxt;
    private JTextField nmtxt;
    private JComboBox idcmb;
    private JTextField mbtxt;
    private JTextField adtxt;
    private JTextField cntxt;
    private JLabel uslbl;
    private JLabel nmlbl;
    private JLabel gnlbl;
    private JLabel idlbl;
    private JLabel idlbl2;
    private JLabel mblbl;
    private JLabel emlbl;
    private JLabel adlbl;
    private JLabel cnlbl;
    private JPanel panel2;
    private JSpinner agsp;
    private JLabel aglbl;
    private JLabel imlbl;
    private JLabel lbl;
    private JPanel panel3;
    private JButton adbtn;
    private JButton cnbtn;

    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";

    public Personal_Details(String user) throws SQLException {
        Connection con = DriverManager.getConnection(url,username,Password);
        String n = "SELECT Username,Name,Mobile_Number FROM Sign_Up WHERE Username = ?";
        PreparedStatement y = con.prepareStatement(n);
        y.setString(1,user);
        ResultSet r = y.executeQuery();
        if (r.next()){
            us = r.getString("Username");
            name = r.getString("Name");
            ph_num = r.getString("Mobile_Number");
        }
        System.out.println(us);
        System.out.println(name);
        System.out.println(ph_num);
        ustxt.setText(us);
        nmtxt.setText(name);
        mbtxt.setText(ph_num);

        adbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    set();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cnbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //UserDB u = new UserDB(user);
                setVisible(false);
            }
        });
    }
    public void initialize(){
        this.setContentPane(MainP);
        this.setTitle("Add Personal Details");
        this.setSize(800,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    public void set() throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        Statement s = con.createStatement();
        //s.executeUpdate(T);
        ButtonGroup btns = new ButtonGroup();
        btns.add(mrb);
        btns.add(frb);
        if (mrb.isSelected()){
            gender = "Male";
        }
        else{
            gender = "Female";
        }
        String Q = "INSERT INTO Personal_Details(Username,Name,Gender,ID,ID_Number,Phone_Number,Age,Email,Address,Country) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement p = con.prepareStatement(Q);
        id = (String) idcmb.getSelectedItem();
        id_num = nmbtxt.getText();
        ph_num = mbtxt.getText();
        age = (int) agsp.getValue();
        email = emtxt.getText();
        address = adtxt.getText();
        country = cntxt.getText();
        p.setString(1,us);
        p.setString(2,name);
        p.setString(3,gender);
        p.setString(4,id);
        p.setString(5,id_num);
        p.setString(6,ph_num);
        p.setInt(7,age);
        p.setString(8,email);
        p.setString(9,address);
        p.setString(10,country);
        p.executeUpdate();
        System.out.println("Inserted");
    }

    /*public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Login_and_Sign_up.Login o = new Login_and_Sign_up.Login();
        Personal_Details p = new Personal_Details();
        p.initialize();
    }*/

}
