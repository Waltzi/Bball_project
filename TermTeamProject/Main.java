import javax.swing.SwingUtilities;

public class Main
{
   public static void main(String[] args)
   {
      TeamDatabase teamDatabase = new TeamDatabase();
      teamDatabase.loadDatabase();
      TableRoster tableRoster = new TableRoster();
      tableRoster.createTableRoster(); 
      SwingUtilities.invokeLater(() -> new GUI().setVisible(true));    
   }
}