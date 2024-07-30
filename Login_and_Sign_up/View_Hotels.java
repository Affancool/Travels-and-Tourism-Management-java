package Login_and_Sign_up;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.sql.*;
public class View_Hotels extends JFrame {
    JPanel PMain;
    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3,b4;
    JTable hotels;
    JTextArea tadesc;
    String hn;

    BigDecimal bd;
    // JScrollPane scp;

    String Driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "affan";
    String Password = "Affan2004";
    public View_Hotels(String u) throws SQLException, ClassNotFoundException {
        initialize(u);
    }
    public void initialize(String us) throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,username,Password);
        PMain = new JPanel(){

            protected void paintComponent(Graphics j) {
                super.paintComponents(j);

                // Create a 2D gradient paint
                Point2D start = new Point2D.Float(0, 0);
                Point2D end = new Point2D.Float(getWidth(), getHeight());
                float[] fractions = {0.0f, 1.0f};
                Color[] colors = {Color.CYAN, Color.ORANGE}; // You can use your desired colors

                LinearGradientPaint gradientPaint = new LinearGradientPaint(start, end, fractions, colors);
                Graphics2D g2d = (Graphics2D) j;
                g2d.setPaint(gradientPaint);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        PMain.setLayout(null);
        setSize(1137,620);
        setLocation(220,88);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(PMain);
        PMain.setBounds(10,10,1137,650);
        b1 = new JButton("Domestic");
        b1.setBounds(60,10,120,40);
        b1.setBackground(Color.PINK);
        b1.setForeground(Color.DARK_GRAY);
        b1.setFont(new Font("Segoe Print",Font.BOLD,18));
        b2 = new JButton("International");
        b2.setBounds(440,10,170,40);
        b2.setBackground(Color.PINK);
        b2.setForeground(Color.DARK_GRAY);
        //b2.setBorder(new LineBorder(Color.PINK));
        b2.setFont(new Font("Segoe Print",Font.BOLD,18));
        /*b3 = new JButton("Add Hotels");
        b3.setBounds(500,10,170,40);
        b3.setBackground(Color.PINK);
        b3.setForeground(Color.DARK_GRAY);
        //b2.setBorder(new LineBorder(Color.PINK));
        b3.setFont(new Font("Segoe Print",Font.BOLD,18));*/
        PMain.add(b1);
        PMain.add(b2);
        //PMain.add(b3);
        hotels = new JTable();
        String q = "SELECT Name,Location,Price,Address,Country FROM Hotels";
        PreparedStatement ps = con.prepareStatement(q);
        ResultSet r = ps.executeQuery();
        hotels.setModel(DbUtils.resultSetToTableModel(r));
        // table.setBounds(10,50,400,500);
        hotels.setBackground(Color.PINK);
        hotels.setRowHeight(35);
        hotels.setFont(new Font("Segoe Print",Font.PLAIN,18));
        //PMain.add(hotels);
        JScrollPane scp= new JScrollPane();
        scp.setBounds(10,70,750,550);
        scp.setViewportView(hotels);/*
        JPanel p = new JPanel();
        p.setBounds(800,10,250,600);
        p.setBackground(Color.RED);*/
        PMain.add(scp);
        l1 = new JLabel();
        l1.setBounds(770,70,330,300);
        tadesc = new JTextArea();
        tadesc.setBounds(770,400,330,150);
        tadesc.setFont(new Font("Segoe Print",Font.PLAIN,20));
        tadesc.setBackground(Color.PINK);
        PMain.add(l1);
        PMain.add(tadesc);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "SELECT Name,Location,Price,Address,Country FROM Hotels WHERE Country = ?";
                try {
                    PreparedStatement ps = con.prepareStatement(q);
                    ps.setString(1,"India");
                    ResultSet r = ps.executeQuery();
                    hotels.setModel(DbUtils.resultSetToTableModel(r));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "SELECT Name,Location,Price,Address,Country FROM Hotels WHERE Country != ?";
                try {
                    PreparedStatement ps = con.prepareStatement(q);
                    ps.setString(1,"India");
                    ResultSet r = ps.executeQuery();
                    hotels.setModel(DbUtils.resultSetToTableModel(r));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



        b4 = new JButton("Book Now");
        b4.setBounds(850,10,170,40);
        b4.setBackground(Color.PINK);
        b4.setForeground(Color.DARK_GRAY);
        //b2.setBorder(new LineBorder(Color.PINK));
        b4.setFont(new Font("Segoe Print",Font.BOLD,18));
        b4.setVisible(false);
        PMain.add(b4);


        hotels.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = hotels.getSelectedRow();
                //hotels.setSelectionBackground(Color.ORANGE);
                DefaultTableModel model = (DefaultTableModel)hotels.getModel();
                hn = (String) model.getValueAt(i,0);
                bd = (BigDecimal) model.getValueAt(i,2);
                try {
                    Connection con = DriverManager.getConnection(url,username,Password);
                    String t = "SELECT Image,Description FROM Hotels WHERE Name = ?";
                    PreparedStatement pst = con.prepareStatement(t);
                    pst.setString(1,hn);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()){
                        tadesc.setText(rs.getString("Description"));
                        byte[] img = rs.getBytes("Image");
                        ImageIcon image = new ImageIcon(img);
                        Image im = image.getImage();
                        Image myimg = im.getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_SMOOTH);
                        ImageIcon ima = new ImageIcon(myimg);
                        l1.setIcon(ima);
                        b4.setVisible(true);
                        //l1.setVisible(true);
                        //tadesc.setVisible(true);

                    }
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

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book_Hotel hp = new Book_Hotel(hn,us,bd);
            }
        });
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        View_Hotels n = new View_Hotels("aa");
    }
}
