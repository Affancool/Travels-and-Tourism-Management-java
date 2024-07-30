package Login_and_Sign_up;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.sql.*;

public class Updatedetails extends JFrame
{
    JPanel p1,p2,p3;
    JLabel lusername,lname,lgender,lid,lnumber,lphone,lage,lemail,laddress,lcountry,ldetails,limg;
    JTextField tfusername,tfname,tfgender,tfid,tfnumber,tfphone,tfage,tfemail,tfaddress,tfcountry;
    JButton btnupdate,btncancel;

    String us,name,gender,id,id_num,ph_num,email,address,country;
    int age;
    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";

    public Updatedetails(String user) throws SQLException, ClassNotFoundException {
        setTitle("Update Personal Details");
        setSize(800,500);
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
                Color [] colors = { new Color(97,154,96),new Color(128,238,232)};

                LinearGradientPaint gp = new LinearGradientPaint(start,end,fractions,colors);
                Graphics2D g2d =  (Graphics2D) g;
                g2d.setPaint(gp);
                g2d.fillRect(0,0,getWidth(),getHeight());
            }
        };
        p1.setLayout(null);
        p1.setBackground(Color.white);
        p1.setBounds(0,0,800,500);
        add(p1);

        lusername = new JLabel("Username: ");
        lusername .setBounds(20,25,150,28);
        lusername .setForeground(Color.black);
        lusername .setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(lusername);

        tfusername= new JTextField();
        tfusername.setBounds(150,25,280,28);
        tfusername.setFont(new Font("segoe print",Font.PLAIN,18));
        p1.add(tfusername);

        lname = new JLabel("Name: ");
        lname .setBounds(20,68,150,28);
        lname .setForeground(Color.black);
        lname .setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(lname);

        tfname= new JTextField();
        tfname.setBounds(150,68,280,28);
        tfname.setFont(new Font("segoe print",Font.PLAIN,18));
        p1.add(tfname);

        lgender= new JLabel("Gender: ");
        lgender.setBounds(20,111,150,28);
        lgender .setForeground(Color.black);
        lgender .setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(lgender);

        tfgender= new JTextField();
        tfgender.setBounds(150,111,280,28);
        tfgender.setFont(new Font("segoe print",Font.PLAIN,18));
        p1.add(tfgender);


        lid = new JLabel("Id: ");
        lid.setBounds(20,154,150,28);
        lid .setForeground(Color.black);
        lid.setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(lid);

        tfid= new JTextField();
        tfid.setBounds(150,154,280,28);
        tfid.setFont(new Font("segoe print",Font.PLAIN,18));
        p1.add(tfid);

        lnumber = new JLabel("Number: ");
        lnumber .setBounds(20,197,150,28);
        lnumber .setForeground(Color.black);
        lnumber .setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(lnumber);

        tfnumber= new JTextField();
        tfnumber.setBounds(150,197,280,28);
        tfnumber.setFont(new Font("segoe print",Font.PLAIN,18));
        p1.add(tfnumber);

        lphone = new JLabel("Phone: ");
        lphone .setBounds(20,240,150,28);
        lphone .setForeground(Color.black);
        lphone .setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(lphone);

        tfphone= new JTextField();
        tfphone.setBounds(150,240,280,28);
        tfphone.setFont(new Font("segoe print",Font.PLAIN,18));
        p1.add(tfphone);

        lage = new JLabel("Age: ");
        lage .setBounds(20,283,150,28);
        lage .setForeground(Color.black);
        lage .setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(lage);

        tfage= new JTextField();
        tfage.setBounds(150,283,280,28);
        tfage.setFont(new Font("segoe print",Font.PLAIN,18));
        p1.add(tfage);

        lemail = new JLabel("Email: ");
        lemail .setBounds(20,326,150,28);
        lemail .setForeground(Color.black);
        lemail .setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(lemail);

        tfemail= new JTextField();
        tfemail.setBounds(150,326,280,28);
        tfemail.setFont(new Font("segoe print",Font.PLAIN,18));
        p1.add(tfemail);

        laddress = new JLabel("Address: ");
        laddress .setBounds(20,369,150,28);
        laddress .setForeground(Color.black);
        laddress .setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(laddress);

        tfaddress= new JTextField();
        tfaddress.setBounds(150,369,280,28);
        tfaddress.setFont(new Font("segoe print",Font.PLAIN,18));
        p1.add(tfaddress);

        lcountry = new JLabel("Country: ");
        lcountry .setBounds(20,412,150,28);
        lcountry .setForeground(Color.black);
        lcountry .setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(lcountry);

        tfcountry= new JTextField();
        tfcountry.setBounds(150,412,280,28);
        tfcountry.setFont(new Font("segoe print",Font.PLAIN,18));
        p1.add(tfcountry);

        /*ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("eg.png"));
        Image img1=img.getImage().getScaledInstance(330,220,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        limg = new JLabel(img2);
        limg.setBounds(490,15,280,230);
        p1.add(limg);*/

        ldetails = new JLabel("Update your Personal Details...");
        ldetails .setBounds(470,323,300,28);
        ldetails .setForeground(Color.black);
        ldetails .setFont(new Font("segoe print",Font.PLAIN,17));
        p1.add(ldetails);

        btnupdate = new JButton("Update");
        btnupdate.setBounds(490,379,100,30);
        btnupdate.setBackground(Color.WHITE);
        btnupdate.setForeground(Color.BLACK);
        //btnupdate.setBorder(new LineBorder(Color.darkGray));
        btnupdate.setFont(new Font("segoe print",Font.BOLD,18));
        p1.add(btnupdate);

        try {
            set(user);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        btnupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String usern = tfusername.getText();
                String name= tfname.getText();
                String gender = tfgender.getText();
                String id = tfid.getText();
                String number = tfnumber.getText();
                String phone = tfphone.getText();
                int age = Integer.parseInt(tfage.getText());
                String email = tfemail.getText();
                String address = tfaddress.getText();
                String country = tfcountry.getText();

                try {
                    Class.forName(Driver);
                    Connection con = DriverManager.getConnection(url,username,Password);
                    String p = "UPDATE Personal_Details SET Username = ?,name = ?,gender = ?,id = ?,ID_number = ?,phone_Number = ?,age = ?,email = ?,address = ?,country = ?";
                    PreparedStatement ps = con.prepareStatement(p);
                    ps.setString(1,usern);
                    ps.setString(2,name);
                    ps.setString(3,gender);
                    ps.setString(4,id);
                    ps.setString(5,number);
                    ps.setString(6,phone);
                    ps.setInt(7,age);
                    ps.setString(8,email);
                    ps.setString(9,address);
                    ps.setString(10,country);

                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(btnupdate,"Details Updated Succesfully");
                    setVisible(false);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        btncancel = new JButton("Cancel");
        btncancel.setBounds(610,379,100,30);
        btncancel.setBackground(Color.WHITE);
        btncancel.setForeground(Color.BLACK);
        //btncancel.setBorder(new LineBorder(Color.darkGray));
        btncancel.setFont(new Font("segoe print",Font.BOLD,18));
        p1.add(btncancel);


        btncancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //UserDB u = new UserDB(user);
                setVisible(false);
            }
        });
        setVisible(true);
        // set(user);
    }

    public  void set(String us) throws ClassNotFoundException, SQLException
    {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        String p = "SELECT * FROM Personal_Details WHERE Username = ?";
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
        tfusername.setText(this.us);
        tfname.setText(name);
        if (gender.equals("Male")){
            tfgender.setText("Male");
        }
        else{
            tfgender.setText("Female");
        }
        tfid.setText(id);
        tfnumber.setText(id_num);
        tfphone.setText(ph_num);
        tfage.setText(String.valueOf(age));
        tfemail.setText(email);
        tfaddress.setText(address);
        tfcountry.setText(country);

        tfusername.setEditable(false);
        tfname.setEditable(false);
        tfid.setEditable(true);
        tfnumber.setEditable(true);
        tfgender.setEditable(true);
        tfphone.setEditable(true);
        tfage.setEditable(true);
        tfemail.setEditable(true);
        tfaddress.setEditable(true);
        tfcountry.setEditable(true);
        con.close();
    }



    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Updatedetails ud = new Updatedetails("Affancool");
    }

}