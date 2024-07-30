package Login_and_Sign_up;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class View_Package extends JFrame {
    //JFrame frame;
    JPanel MainP;
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2,b3,b4;
    JTable table;
    String un;
    BigDecimal bd;

    JTextArea txta;
    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";
    View_Package(String us) throws SQLException, ClassNotFoundException {
        initialize(us);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                table.setSelectionBackground(Color.ORANGE);
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                un = (String) model.getValueAt(i,0);
                bd = (BigDecimal) model.getValueAt(i,3);
                MainP.add(txta);
               // Book_Package p = new Book_Package(us,un,bd);
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
    }
    public void initialize(String us) throws SQLException, ClassNotFoundException {
        //frame = new JFrame("View Packages");
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        MainP = new JPanel(){
            protected void paintComponent(Graphics j) {
                super.paintComponents(j);

                // Create a 2D gradient paint
                Point2D start = new Point2D.Float(0, 0);
                Point2D end = new Point2D.Float(getWidth(), getHeight());
                float[] fractions = {0.0f, 1.0f};
                Color[] colors = {Color.PINK, Color.BLUE}; // You can use your desired colors

                LinearGradientPaint gradientPaint = new LinearGradientPaint(start, end, fractions, colors);
                Graphics2D g2d = (Graphics2D) j;
                g2d.setPaint(gradientPaint);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        setContentPane(MainP);
        MainP.setLayout(null);
        setLocation(220,100);
        setSize(1137,620);
        setVisible(true);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //l3 = new JLabel();
       // l3.setBounds();
        MainP.setBounds(10,10,1100,550);
        b1 = new JButton("Domestic");
        b1.setBounds(50,10,120,40);
        b1.setBackground(Color.PINK);
        b1.setForeground(Color.DARK_GRAY);
        b1.setFont(new Font("Segoe Print",Font.BOLD,18));
        b1.setBorder(new LineBorder(Color.PINK));
        MainP.add(b1);
        b2 = new JButton("International");
        b2.setBounds(190,10,170,40);
        b2.setBackground(Color.PINK);
        b2.setForeground(Color.DARK_GRAY);
        b2.setBorder(new LineBorder(Color.PINK));
        b2.setFont(new Font("Segoe Print",Font.BOLD,18));
        MainP.add(b2);
        table = new JTable();
        String q = "SELECT Place,State,Country,Price,Duration FROM Packages";
        PreparedStatement ps = con.prepareStatement(q);
        ResultSet r = ps.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(r));
       // table.setBounds(10,50,400,500);
        table.setBackground(Color.PINK);
        //MainP.add(table);
        JScrollPane sp = new JScrollPane();
        sp.setViewportView(table);
        sp.setBounds(10,70,620,400);
        table.setRowHeight(35);
        table.setFont(new Font("Segoe Print",Font.PLAIN,20));
        //sp.setBackground(Color.BLUE);
        l2 = new JLabel();
        l2.setBounds(675,80,400,250);
        txta = new JTextArea();
        txta.setBounds(650,360,490,220);
        txta.setFont(new Font("Segoe Print",Font.BOLD,16));
        txta.setBackground(Color.BLUE);
        txta.setForeground(Color.WHITE);
        b3 = new JButton("Book Now");
        b3.setFont(new Font("Segoe Print",Font.BOLD,16));
        b3.setBounds(810,10,170,40);
        b3.setVisible(false);
        b3.setBackground(Color.PINK);
        b3.setForeground(Color.WHITE);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "SELECT Place,State,Country,Price,Duration FROM Packages WHERE Country = ?";
                try {
                    PreparedStatement ps = con.prepareStatement(q);
                    ps.setString(1,"India");
                    ResultSet r = ps.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(r));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "SELECT Place,State,Country,Price,Duration FROM Packages WHERE Country != ?";
                try {
                    PreparedStatement ps = con.prepareStatement(q);
                    ps.setString(1,"India");
                    ResultSet r = ps.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(r));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book_Package b = new Book_Package(us,un,bd);
            }
        });
       // b3.setBackground(Color.BLUE);
       // b3.setForeground(Color.WHITE);
        MainP.add(b3);
        MainP.add(l2);
        //MainP.add(txta);
        MainP.add(sp);
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
                Image myimg = im.getScaledInstance(l2.getWidth(),l2.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon ima = new ImageIcon(myimg);
                l2.setIcon(ima);
                b3.setVisible(true);
            }
        }



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        View_Package p = new View_Package("Affancool");
        p.initialize("Affancool");
    }
}
