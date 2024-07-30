package Login_and_Sign_up;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.sql.*;

public class UBooked_Hotels extends JFrame{
        JLabel l1,l2,l3;
        JButton b1,b2,b3;
        JPanel panel;
        JTable bh;

        String Driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "affan";
        String Password = "Affan2004";
        JScrollPane scp;
        public UBooked_Hotels(String un) throws ClassNotFoundException, SQLException {
            Class.forName(Driver);
            Connection con = DriverManager.getConnection(url,username,Password);
            panel = new JPanel(){

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
            setSize(800,650);
            setContentPane(panel);
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            panel.setLayout(null);
            panel.setBounds(10,10,800,650);

            int n;

            bh = new JTable();
            String q = "SELECT *FROM Booked_Hotel WHERE Username = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1,un);
            ResultSet r = ps.executeQuery();

                bh.setModel(DbUtils.resultSetToTableModel(r));
                // table.setBounds(10,50,400,500);
                bh.setBackground(Color.PINK);
                bh.setRowHeight(35);
                bh.setFont(new Font("Segoe Print",Font.PLAIN,18));
                //PMain.add(hotels);
                scp = new JScrollPane();
                scp.setBounds(10,10,770,500);
                scp.setViewportView(bh);
                panel.add(scp);

                b2 = new JButton("Go Back");
                b2.setBounds(300,540,170,40);
                b2.setBackground(Color.YELLOW);
                b2.setForeground(Color.DARK_GRAY);
                //b2.setBorder(new LineBorder(Color.PINK));
                b2.setFont(new Font("Segoe Print",Font.BOLD,18));
                panel.add(b2);
                //JOptionPane.showMessageDialog(null,"You haven't booked any packages till now...");

            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //UserDB u = new UserDB(un);
                    setVisible(false);
                }
            });
        }

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            UBooked_Hotels p = new UBooked_Hotels("Affancool");
        }
}

