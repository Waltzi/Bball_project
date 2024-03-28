import javax.swing.SwingUtilities;

public class Main
{
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(() -> {
         GUI gui = new GUI(20);
         gui.setVisible(true);
      });    
   }

}