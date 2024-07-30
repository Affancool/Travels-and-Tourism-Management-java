package Login_and_Sign_up;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame{
    private JButton psbtn;
    private JButton tvbtn;
    private JButton vwbtn;
    private JButton tubtn;
    private JPanel panel2;
    private JPanel Panelmain;
    private JLabel inlbl;
    private JLabel sllbl;
    private JLabel sl1lbl;
    private JButton upbtn;

    public Menu(){

    }
    public Menu(String user){
        psbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personal_Details p = new Personal_Details(user);
                    p.initialize();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        vwbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View_Details v = null;
                try {
                    v = new View_Details(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    v.set(user);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                v.initialize();
            }
        });
    }
    public void initialize(){
        this.setContentPane(Panelmain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1050,600);
        this.setTitle("Main Menu");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /*public static void main(String[] args) {
        Login_and_Sign_up.Login l = new Login_and_Sign_up.Login();
        Menu m = new Menu();
        m.initialize();
    }*/
}
