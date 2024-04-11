import javax.swing.SwingUtilities;

/**
 * The Main class is the entry point for the application.
 */
public class Main
{
   /**
    * The main method is the entry point for the JVM.
    * It creates an instance of the GUI class and sets it to visible.
    *
    * @param args command-line arguments (not used)
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(() -> {
         GUI gui = new GUI(20);
         gui.setVisible(true);
      });    
   }
}