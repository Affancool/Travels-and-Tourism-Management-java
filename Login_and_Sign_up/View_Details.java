package Login_and_Sign_up;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class View_Details extends JFrame{
    String us,name,gender,id,id_num,ph_num,email,address,country;
    int age;
    private JPanel MainP;
    private JPanel panel3;
    private JTextField mbtxt;
    private JTextField nmbtxt;
    private JLabel idlbl2;
    private JLabel mblbl;
    private JTextField adtxt;
    private JTextField cntxt;
    private JTextField emtxt;
    private JLabel emlbl;
    private JLabel adlbl;
    private JLabel cnlbl;
    private JLabel aglbl;
    private JLabel gnlbl;
    private JRadioButton mrb;
    private JRadioButton frb;
    private JTextField ustxt;
    private JLabel uslbl;
    private JLabel nmlbl;
    private JLabel idlbl;
    private JTextField nmtxt;
    private JComboBox idcmb;
    private JPanel panel2;
    private JLabel imlbl;
    private JLabel lbl;
    private JButton cnbtn;
    private JTextField agtxt;
    private JTextField gntxt;

    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";
    public View_Details(String user) throws SQLException, ClassNotFoundException {

        initialize();
        set(user);
        cnbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //UserDB u = new UserDB(user);

            }
        });
    }
    public void set(String us) throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        String p = "SELECT *FROM Personal_Details WHERE Username = ?";
        PreparedStatement ps = con.prepareStatement(p);
        ps.setString(1,us);
        ResultSet r = ps.executeQuery();
        if (r.next()){
            this.us = r.getString("Username");
            name = r.getString("Name");
            gender = r.getString("Gender");
            id = r.getString("ID");
            id_num = r.getString("ID_Number");
            ph_num = r.getString("Phone_Number");
            age = r.getInt("Age");
            email = r.getString("Email");
            address = r.getString("Address");
            country = r.getString("Country");
        }
        ustxt.setText(this.us);
        nmtxt.setText(name);
        if (gender.equals("Male")){
            gntxt.setText("Male");
        }
        else{
            gntxt.setText("Female");
        }
        idcmb.setSelectedItem(id);
        nmbtxt.setText(id_num);
        mbtxt.setText(ph_num);
        agtxt.setText(String.valueOf(age));
        emtxt.setText(email);
        adtxt.setText(address);
        cntxt.setText(country);
        ustxt.setEditable(false);
        nmtxt.setEditable(false);
        idcmb.setEditable(false);
        nmbtxt.setEditable(false);
        gntxt.setEditable(false);
        mbtxt.setEditable(false);
        agtxt.setEditable(false);
        emtxt.setEditable(false);
        adtxt.setEditable(false);
        cntxt.setEditable(false);
        con.close();
    }
    public void initialize(){
        this.setContentPane(MainP);
        this.setTitle("View Details");
        this.setSize(900,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
