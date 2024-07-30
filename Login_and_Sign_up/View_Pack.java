package Login_and_Sign_up;

import javax.swing.*;
import java.awt.*;

public class View_Pack extends JFrame{
    private JPanel panel1;
    private JLabel icon;
    View_Pack(){
        setContentPane(panel1);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(700,600);
    }

    public static void main(String[] args) {
        View_Pack p = new View_Pack();
    }
}
