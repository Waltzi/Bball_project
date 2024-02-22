import javax.swing.SwingUtilities;

public class Main
{
   public static void main(String[] args)
   {
      TeamDatabase teamDatabase = new TeamDatabase();
      teamDatabase.loadDatabase();
      TableRoster tableRoster = new TableRoster();
      tableRoster.createTableRoster(); 
      SwingUtilities.invokeLater(() -> {
         GUI gui = new GUI();
         gui.setVisible(true);
      });    
   }

}