# Bball_project
Introduction to Software Engineering 
Spring Semester 2024
Authors: Austin Leibensperger, Saul Sanchez, Nathan Hajel, and Brandon Yang


The TermTeamProject repo holds everything for the backend properties of the project.
- The FetchCreateTeamDatabase.java class creates the given MoravianWomenBasketball database locally within your computer using mysql. This uses the JDBC Driver to connect to mysql with the required Url, username, and password
- In order to run the program properly in vscode add the mysql-connector file to your referenced libraries of the java project.
  - To do this:
    1. Download The MySQL Connector:
      - Visit the MySQL Connector download page: https://dev.mysql.com/downloads/connector/j/?os=26  
      - Choose the appropriate platform and download the ZIP file.
      - Download the latest version of the MySQL Connector.
    2. Extract the ZIP file:
      - Once the download is complete, extract the contents of the ZIP file to a location on your computer.
    3. Open your Java project in Visual Studio Code:
      - Launch Visual Studio Code.
      - Open your Java project by selecting the project folder or using File > Open Folder.
    4. Add Connector to Java Project:
      - In the Explorer tab, click on Java Projects.
      - Click on the arrow next to the name of the Java Project.
      - Hover over "Referenced Libraries" and click the plus sign that appears.
      - Select your connector from your downloads folder.

- Sprint 1 Goal:
  Create a simple GUI that takes user input to add and delete players from the roster, freethrow, and threepoint tables in the MoravianWomenBasketball database. Also create web app prerequisites we have within the group for the next sprint. 

- Sprint 2 Goal:
  Complete our SpringBoot Web App and get it running correctly. Implement an archiving method for the roster and allow practices to be separrated by dates.

- Sprint 3 Goal:
  Complete our springboot web app and get it running correctly. Ceating web app page to be displayable. Active or not active attribute for the database not a archiving system. Practice variable for the number of practices per day.
  

