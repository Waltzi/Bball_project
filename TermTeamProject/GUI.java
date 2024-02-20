import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;
    private TeamPlayer roster;
    private JPanel buttonPanel;


    public GUI() {   
        setTitle("Women's Basketball Roster");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        
    }
}