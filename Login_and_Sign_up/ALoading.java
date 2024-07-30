package Login_and_Sign_up;
import javax.swing.*;
import java.awt.*;
public class ALoading extends JFrame implements Runnable
{
    Thread t;
    JProgressBar bar;
    String username;
    JLabel l1;

    public ALoading()
    {
        this.username=username;
        t=new Thread(this);

        setBounds(500,200,700,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocationRelativeTo(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,400);
        ImageIcon i = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\bgs.jpg");
        Image im = i.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(im);
        l1.setIcon(img);
        add(l1);

        JLabel text=new JLabel("Travels and Tourism Management");
        text.setBounds(80,5,600,40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Segoe Print",Font.BOLD,30));
        l1.add(text);

        bar =  new JProgressBar();
        bar.setBounds(180,150,300,35);
        bar.setStringPainted(true);
        l1.add(bar);

        JLabel Loading=new JLabel("Loading please wait...");
        Loading.setBounds(240,190,250,30);
        Loading.setForeground(Color.WHITE);
        Loading.setFont(new Font("Segoe Print",Font.BOLD,16));
        l1.add(Loading);

        JLabel lblusername=new JLabel("Welcome Admin");
        lblusername.setBounds(90,310,400,40);
        lblusername.setForeground(Color.WHITE);
        lblusername.setFont(new Font("Segoe Print",Font.BOLD,16));
        l1.add(lblusername);
        t.start();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }


    @Override
    public void run() {
        try{
            for(int i=1;i<=101;i++)
            {
                int max=bar.getMaximum(); //100
                int value=bar.getValue();

                if(value < max)
                {
                    bar.setValue(bar.getValue() + 1);
                }
                else {
                    setVisible(false);
                    //new class object
                    AdminDB n = new AdminDB();
                }
                Thread.sleep(45);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ALoading l = new ALoading();
    }
}

