package Login_and_Sign_up;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Team extends JFrame
{
    JLabel lhead,limg1,limg2,limg3,l1,l2,l3;
    JPanel p1;
    JButton btnback;
    Team()
    {
        setBounds(400,300,1065,550);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,1065,500);
        p1.setBackground(Color.darkGray);
        add(p1);

        lhead=new JLabel("Team Members");
        lhead.setBounds(30,30,250,30);
        lhead.setForeground(Color.white);
        lhead.setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(lhead);

        btnback = new JButton("    Back   ");
        btnback.setBounds(900,30,100,30);
        btnback.setBackground(Color.darkGray);
        btnback.setForeground(Color.white);
        btnback.setBorder(new LineBorder(Color.black));
        btnback.setFont(new Font("segoe print",Font.BOLD,18));
        p1.add(btnback);

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new About();
            }
        });


        ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\aff.jpg");
        Image img1=img.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        limg1 = new JLabel(img2);
        limg1.setBounds(30,100,300,300);
        p1.add(limg1);

        l1=new JLabel("Affan Rahmathulah. K");
        l1.setBounds(65,430,250,30);
        l1.setForeground(Color.white);
        l1.setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(l1);

        ImageIcon img3 = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\thani.jpg");
        Image img4=img3.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon img5 = new ImageIcon(img4);
        limg2 = new JLabel(img5);
        limg2.setBounds(380,100,300,300);
        p1.add(limg2);

        l2=new JLabel("Thanigaivel. V");
        l2.setBounds(450,430,200,30);
        l2.setForeground(Color.white);
        l2.setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(l2);

        ImageIcon img6 = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\aakash.jpg");
        Image img7=img6.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon img8 = new ImageIcon(img7);
        limg3 = new JLabel(img8);
        limg3.setBounds(730,100,300,300);
        p1.add(limg3);

        l3=new JLabel("Aakash. K");
        l3.setBounds(830,430,200,30);
        l3.setForeground(Color.white);
        l3.setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(l3);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Team();
    }

}
