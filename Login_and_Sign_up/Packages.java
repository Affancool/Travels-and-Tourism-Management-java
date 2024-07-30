package Login_and_Sign_up;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.sql.*;

import static javax.swing.SwingUtilities.paintComponent;

public class Packages extends JFrame{
    private JButton dbtn;
    private JButton ibtn;
    private JTable ptbl;
    private JPanel MainP;
    private JButton apbtn;
    private JPanel panel1;
    private JTextArea txta;
    private JLabel dslbl;
    private JLabel imgicon;
    private JScrollPane scp;

    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";
    String un;
    Packages() throws SQLException, ClassNotFoundException {
        set();
        apbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Pack ap = new Add_Pack();
            }
        });
        /*ptbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ptbl.setBackground(Color.green);
            }
        });
        ptbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                ptbl.setBackground(Color.RED);
            }
        });*/
        ptbl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = ptbl.getSelectedRow();
                ptbl.setSelectionBackground(Color.ORANGE);
                DefaultTableModel model = (DefaultTableModel)ptbl.getModel();
                un = (String) model.getValueAt(i,0);
                try {
                    sets(un);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        dbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName(Driver);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                Connection con;
                try {
                    con = DriverManager.getConnection(url,username,Password);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String q = "SELECT Place,State,Country,Price,Duration FROM Packages WHERE Country = ?";
                try {
                    PreparedStatement ps = con.prepareStatement(q);
                    ps.setString(1,"India");
                    ResultSet r = ps.executeQuery();
                    ptbl.setModel(DbUtils.resultSetToTableModel(r));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ibtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName(Driver);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                Connection con;
                try {
                    con = DriverManager.getConnection(url,username,Password);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String q = "SELECT Place,State,Country,Price,Duration FROM Packages WHERE Country != ?";
                try {
                    PreparedStatement ps = con.prepareStatement(q);
                    ps.setString(1,"India");
                    ResultSet r = ps.executeQuery();
                    ptbl.setModel(DbUtils.resultSetToTableModel(r));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void set() throws SQLException, ClassNotFoundException {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        String q = "SELECT Place,State,Country,Price,Duration FROM Packages";
        PreparedStatement ps = con.prepareStatement(q);
        ResultSet r = ps.executeQuery();
        ptbl.setModel(DbUtils.resultSetToTableModel(r));
    }
    public void sets(String str) throws SQLException {
        Connection con = DriverManager.getConnection(url,username,Password);
        String t = "SELECT Description,Icon FROM Packages WHERE Place = ?";
        PreparedStatement pst = con.prepareStatement(t);
        pst.setString(1,str);
        ResultSet rs = pst.executeQuery();
        if (rs.next()){
            txta.setText(rs.getString("Description"));
            byte[] img = rs.getBytes("Icon");
            ImageIcon image = new ImageIcon(img);
            Image im = image.getImage();
            Image myimg = im.getScaledInstance(imgicon.getWidth(),imgicon.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon ima = new ImageIcon(myimg);
            imgicon.setIcon(ima);
        }

    }
    public void initialize(){
        this.setContentPane(MainP);
        this.setSize(1137,620);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ptbl.setRowHeight(35);
        }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Packages p = new Packages();
        p.initialize();
    }

}
