package Login_and_Sign_up;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

public class About extends JFrame
{
    JLabel l1;
    JPanel p1;
    JButton btnteam,btnback;
    About()
    {
        setBounds(600,200,600,550);
        setLayout(null);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        p1 = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Point2D start = new Point2D.Float(0,0);
                Point2D end = new Point2D.Float(getWidth(),getHeight());
                float[] fractions = {0.0f,1.0f};
                Color [] colors = { new Color(210,104,96),new Color(98,188,232)};

                LinearGradientPaint gp = new LinearGradientPaint(start,end,fractions,colors);
                Graphics2D g2d =  (Graphics2D) g;
                g2d.setPaint(gp);
                g2d.fillRect(0,0,getWidth(),getHeight());
            }
        };
        p1.setLayout(null);
        p1.setBounds(0,0,600,550);
        p1.setBackground(Color.WHITE);
        add(p1);

        l1=new JLabel("ABOUT");
        l1.setBounds(40,15,100,40);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("segoe print",Font.PLAIN,20));
        p1.add(l1);

        String s = "Welcome to the Tours and Travels Management System \n"+"\n"+"At the heart of the modern travel industry lies the Tours and Travel Management System, a revolutionary software platform designed to redefine the way we experience and manage travel. Whether you are an avid traveler seeking adventures or a travel service provider looking to streamline your operations, our system offers an array of compelling advantages and uses."+
                "\n\n"+ "Travelling is a fundamental part of human exploration and cultural exchange. To make this experience even more enjoyable, we introduce the Tours and Travel Management System - an innovative software solution aimed at transforming the travel industry and bringing unparalleled convenience and efficiency to both travelers and travel service providers"
                + "\n\nKey Features:\n " + " \n" + "* Efficient Booking System\n* Customer Management\n* Tour Package Management\n* Reservation and payment processing\n* Admin Dashboard"
                +"\n"+"\nAdvantages of project: \n"+"\n"+"* Gives accurate information\n* Simplifies the manual work\n* It minimizes the documentation related work\n* Streamlined Booking Process\n* Personalisation and Customer Management\n* Optimal Resource utilization"+
                "\n\n"+"Why Choose Our System?"+"\n\n"+"* Simplicity \n* Reliability \n* User Friendly Interface \n* Flexible Customization \n* Ongoing Support and Updates \n* Reliable and Secure "+
                "\n\n" + " The Tours and Travels Management System is your passport to a world of possibilities in the travel industry."
                + "\n\n"+"It's more than just a software platform; it's a revolution that brings travelers closer to their dreams and empowers service providers to offer unparalleled experiences."
                + "\n\n"+"Join us in the journery of simplifying,enhancing, and democratizing travel for all.";

        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,550,300);
        p1.add(area);

        btnteam = new JButton("Team Members");
        btnteam .setBounds(420,20,140,30);
        btnteam .setBackground(Color.WHITE);
        btnteam .setForeground(Color.BLACK);
        btnteam .setBorder(new LineBorder(Color.black));
        btnteam .setFont(new Font("segoe print",Font.BOLD,18));
        p1.add(btnteam );
        btnteam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                new Team();
            }
        });

        btnback = new JButton("Back");
        btnback.setBounds(480,470,100,30);
        btnback.setBackground(Color.white);
        btnback.setForeground(Color.BLACK);
        btnback.setBorder(new LineBorder(Color.black));
        btnback.setFont(new Font("segoe print",Font.BOLD,18));
        p1.add(btnback);

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setVisible(true);
    }
    public static void main(String[] args) {
        new About();
    }

}
