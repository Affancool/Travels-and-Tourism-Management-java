package Login_and_Sign_up;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Package extends JFrame{
    private JTextField ptxt;
    private JTextField stxt;
    private JTextField prtxt;
    private JTextField ctxt;
    private JTextField dtxt;
    private JLabel aplbl;
    private JLabel plbl;
    private JLabel slbl;
    private JLabel clbl;
    private JLabel prlbl;
    private JLabel dlbl;
    private JButton abtn;
    private JPanel PMain;
    private JTextArea txta;
    private JLabel dslbl;
    private JButton cbtn;
    private JPanel pi;
    private JLabel imlbl;
    private JButton gbtn;
    private JLabel imglbl;
    String pl,st,cn,pr,du,ds;
    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";
    String s;
    public void set(String s) throws ClassNotFoundException, SQLException, IOException {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        pl = ptxt.getText();
        st = stxt.getText();
        cn = ctxt.getText();
        pr = prtxt.getText();
        du = dtxt.getText();
        ds = txta.getText();
        String q = "INSERT INTO Packages(Place,State,Country,Price,Duration,Description,Icon) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement p =con.prepareStatement(q);
        p.setString(1,pl);
        p.setString(2,st);
        p.setString(3,cn);
        p.setString(4,pr);
        p.setString(5,du);
        p.setString(6,ds);
        FileInputStream fis = new FileInputStream(s);
        p.setBinaryStream(7,fis,fis.available());
        p.executeUpdate();

    }
    public void initialize(){
        /*pi = new JPanel();
        pi.setLayout(null);*/
        this.setContentPane(PMain);
        this.setSize(700,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Packages");
        this.setVisible(true);
        /*PMain = new JPanel(){
        */
    }
        /*imglbl = new JLabel("aaa");
        imglbl.setPreferredSize(new Dimension(120,120));
        pi.add(imglbl);*/
    Add_Package(){
        initialize();
        abtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    set(s);
                    JOptionPane.showMessageDialog(abtn,"Added Successfully!");
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        cbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imglbl = new JLabel();
                JFileChooser f = new JFileChooser();
                int a = f.showOpenDialog(null);
                if (a == JFileChooser.APPROVE_OPTION){
                    File file = f.getSelectedFile();
                    s = file.getAbsolutePath();
                    //JOptionPane.showMessageDialog(null,"Success" + s);
                    ImageIcon i = new ImageIcon(s);
                    Image image = i.getImage().getScaledInstance(imlbl.getWidth(),imlbl.getHeight(),Image.SCALE_SMOOTH);
                    imlbl.setIcon(new ImageIcon(image));
                }
            }
        });
        gbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Packages p = new Packages();
                    setVisible(false);
                    p.initialize();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public static void main(String[] args) {
        Add_Package a = new Add_Package();
        a.initialize();
    }
}
