# Bball_project
- Introduction to Software Engineering 
- Spring Semester 2024
- Authors: Austin Leibensperger, Saul Sanchez, Nathan Hajel, and Brandon Yang


The TermTeamProject repo holds everything for the backend properties of the project.
- The FetchCreateTeamDatabase.java class creates the given MoravianWomenBasketball database locally within your computer using mysql. This uses the JDBC Driver to connect to mysql with the required Url, username, and password

- Instructions to Run Web App:
    - 1. Install mysql onto your machine. 
          Download MySQL Installer:
          Visit the MySQL Community Downloads page: MySQL Community Downloads.
          Scroll down to find the macOS section.
          Download the macOS disk image (DMG) file for the version of MySQL you want to install.
          Install MySQL:
          Once the DMG file is downloaded, locate it in your Downloads folder or wherever you saved it.
          Double-click the DMG file to mount it.
          Double-click the MySQL installer package file (.pkg) inside the mounted DMG file.
          Follow the on-screen instructions in the installer.
          You may be prompted to enter your password to allow the installer to make changes.
          Configure MySQL:
          After the installation completes, you may need to configure MySQL.
          Follow the instructions provided by the installer.
          You'll likely be asked to set a root password for MySQL. Make sure to choose a strong password and remember it.
          Start MySQL Server:
          Once MySQL is installed and configured, you can start the MySQL server.
          You can do this by opening "System Preferences" on your Mac, then selecting "MySQL" (you might need to scroll down to find it).
          Click the "Start MySQL Server" button.
          Verify Installation:
          Open a terminal window.
          You can verify that MySQL is installed and running by typing the following command: mysql --version
    - 2. Installing required extensions: 
          The first extension to download on vscode will be the live server extension. The other extensions will be the Spring Boot Dashboard and Spring Boot Extension Pack. Also make sure to have java extension pack installed. Next installation is gradle for java and Gradle Language Support.
    - 3.  Log into root user for mysql:
          Log into mysql root user with: mysql -u root -p.
          enter your password in next. 
          Then use the command CREATE USER 'project'@'localhost' IDENTIFIED BY 'project';
          Next run the command to grant privileges to all databases: GRANT ALL PRIVILEGES ON *.* TO 'project'@'localhost';
          Run this command to make the privileges take effect: FLUSH PRIVILEGES;
          Then you can exit using EXIT; This will allow you to exit the root account. 
    - 4.  Then start the web app by opening the Bball_project folder in the terminal. Then use the npm install --global http-server command to use live server. Finally, run the shell script with "sh StartApp.sh".


  - Problems Brandon had while trying to run web app(Possible fixes For Schaper)
      - 1. had to brew install gradle.
        2. from there updated my java incase, even tho it was at its      most updated version.
        3. changed the gradle.properties or whatever it was.


- Sprint 1 Goal:
  Create a simple GUI that takes user input to add and delete players from the roster, freethrow, and threepoint tables in the MoravianWomenBasketball database. Also create web app prerequisites we have within the group for the next sprint. 

- Sprint 2 Goal:
  Complete our SpringBoot Web App and get it running correctly. Implement an archiving method for the roster and allow practices to be separrated by dates.

- Sprint 3 Goal:
  Complete our springboot web app and get it running correctly. Creating web app page to be displayable. Active or not active attribute for the database not a archiving system. Practice variable for the number of practices per day.

- Sprint 4 Goal: 
  Get the frontend web app working and get all previous product backlog goals completed. Getting the active roster variable implemented. Being able to look players by certain variables like the players number and the most recent and oldest dates for free throws and three pointers. Write README.md to explain how to run code for the project. 
  

