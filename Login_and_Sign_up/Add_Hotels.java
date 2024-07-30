package Login_and_Sign_up;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Add_Hotels extends JFrame
{
    JPanel panel;
    JLabel header,lname,llocation,lcountry,lprice,lcimg,ldesc,laddress;
    JButton cimg,add,goback;
    JTextField tfname,tflocation,tfcountry,tfprice,tfaddress;
    JTextArea tadesc;
    String nm,lc,cn,pr,ad,desc,s = "";
    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";
    public Add_Hotels()
    {
        setBounds(220,90,900,620);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.WHITE);

        /*ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("eg.png"));
        Image img1=img.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        bgimg = new JLabel(img2);
        bgimg.setBounds(0,0,900,600);
        add(bgimg);*/
        panel = new JPanel(){

            protected void paintComponent(Graphics j) {
                super.paintComponents(j);

                // Create a 2D gradient paint
                Point2D start = new Point2D.Float(0, 0);
                Point2D end = new Point2D.Float(getWidth(), getHeight());
                float[] fractions = {0.0f, 1.0f};
                Color[] colors = {new Color(97,154,96), new Color(128,238,232)}; // You can use your desired colors

                LinearGradientPaint gradientPaint = new LinearGradientPaint(start, end, fractions, colors);
                Graphics2D g2d = (Graphics2D) j;
                g2d.setPaint(gradientPaint);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null);
        panel.setSize(950,600);
        header = new JLabel("Add Hotels");
        header.setBounds(400,30,250,30);
        header.setForeground(Color.black);
        header.setFont(new Font("Segoe Print",Font.BOLD,24));
        panel.add(header);

        lname = new JLabel("Name");
        lname .setBounds(30,90,150,30);
        lname .setForeground(Color.black);
        lname .setFont(new Font("Segoe Print",Font.PLAIN,20));
        panel.add(lname);

        tfname = new JTextField();
        tfname.setBounds(180,90,300,30);
        panel.add(tfname);

        llocation = new JLabel("Location");
        llocation.setBounds(30,140,150,30);
        llocation.setForeground(Color.black);
        llocation.setFont(new Font("Segoe Print",Font.PLAIN,20));
        panel.add(llocation);

        tflocation = new JTextField();
        tflocation.setBounds(180,140,300,30);
        panel.add(tflocation);

        laddress = new JLabel("Address");
        laddress.setBounds(30,190,150,30);
        laddress.setForeground(Color.black);
        laddress.setFont(new Font("Segoe Print",Font.PLAIN,20));
        panel.add(laddress);

        tfaddress = new JTextField();
        tfaddress.setBounds(180,190,300,40);
        panel.add(tfaddress);

        lcountry = new JLabel("Country");
        lcountry .setBounds(30,240,150,30);
        lcountry .setForeground(Color.black);
        lcountry .setFont(new Font("Segoe Print",Font.PLAIN,20));
        panel.add(lcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(180,240,300,30);
        panel.add(tfcountry);

        lprice = new JLabel("Price");
        lprice .setBounds(30,290,150,30);
        lprice.setForeground(Color.black);
        lprice .setFont(new Font("Segoe Print",Font.PLAIN,20));
        panel.add(lprice);

        tfprice = new JTextField();
        tfprice.setBounds(180,290,300,30);
        panel.add(tfprice);



        ldesc = new JLabel("Description");
        ldesc .setBounds(30,340,250,30);
        ldesc .setForeground(Color.black);
        ldesc .setFont(new Font("SANS_SERIF",Font.PLAIN,20));
        panel.add(ldesc );

        tadesc= new JTextArea();
        tadesc.setBounds(180,340,300,120);
        panel.add(tadesc);

        cimg= new JButton("Choose Image");
        cimg.setBounds(600,460,200,40);
        //cimg.setBackground(Color.WHITE);
        cimg.setForeground(Color.BLACK);
        cimg.setBorder(new LineBorder(Color.darkGray));
        cimg.setFont(new Font("Segoe Print",Font.BOLD,15));
        panel.add(cimg);

        /*ImageIcon img3 = new ImageIcon(ClassLoader.getSystemResource("eg.png"));
        Image img4=img3.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon img5 = new ImageIcon(img4);
        lcimg = new JLabel(img5);
        lcimg.setBounds(600,220,150,40);
        bgimg.add(lcimg);*/

        add= new JButton("Add");
        add.setBounds(200,500,115,35);
        //add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        //add.setBorder(new LineBorder(Color.darkGray));
        add.setFont(new Font("Segoe Print",Font.BOLD,15));
        panel.add(add);

        goback= new JButton("Go Back");
        goback.setBounds(350,500,115,35);
        //goback.setBackground(Color.WHITE);
        goback.setForeground(Color.BLACK);
        //goback.setBorder(new LineBorder(Color.darkGray));
        goback.setFont(new Font("Segoe Print",Font.BOLD,15));
        panel.add(goback);
        ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\loc.png");
        Image i = img.getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
        ImageIcon ima =new ImageIcon(i);

        lcimg = new JLabel();
        lcimg.setBounds(540,100,300,300);

        lcimg.setIcon(ima);
        panel.add(lcimg);

        goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    set(s);
                    if (s != "")
                        JOptionPane.showMessageDialog(add,"Inserted Successfully...");
                        setVisible(false);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cimg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lcimg = new JLabel();
                JFileChooser f = new JFileChooser();
                int a = f.showOpenDialog(null);
                if (a == JFileChooser.APPROVE_OPTION){
                    File file = f.getSelectedFile();
                    s = file.getAbsolutePath();
                    //JOptionPane.showMessageDialog(null,"Success" + s);
                    //lcimg = new JLabel();
                    //lcimg.setBounds(600,220,150,150);
                    ImageIcon i = new ImageIcon(s);
                    Image image = i.getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
                    lcimg.setIcon(new ImageIcon(image));
                    panel.add(lcimg);
                }
            }
        });


        add(panel);






        setVisible(true);

    }
    public void set(String s) throws ClassNotFoundException, SQLException, IOException {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        nm = tfname.getText();
        lc = tflocation.getText();
        cn = tfcountry.getText();
        pr = tfprice.getText();
        ad = tfaddress.getText();
        desc = tadesc.getText();
        String q = "INSERT INTO Hotels(Name,Location,Price,Image,Address,Country,Description) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement p =con.prepareStatement(q);
        p.setString(1,nm);
        p.setString(2,lc);
        p.setString(3,pr);
        p.setString(5,ad);
        p.setString(6,cn);
        p.setString(7,desc);
        if (s.equals("")){
            JOptionPane.showMessageDialog(add,"Please Choose an Image...");
        }
        else{
            FileInputStream fis = new FileInputStream(s);
            p.setBinaryStream(4,fis,fis.available());
            p.executeUpdate();
        }

    }
    public static void main(String args[])
    {

        Add_Hotels hp = new Add_Hotels();
    }

}

