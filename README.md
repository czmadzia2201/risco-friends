To make the project run on your computer you will need a database with data.

*To import database:*

1. Create database 'risco_friends' in your local database.
2. Create param.bat file in the project main folder that will contain login and password to your local database:

set user=your_login
set password=your_password

(Replace your_login and your_password respectively.)

3. In the main project folder there's file dbexport.sql - it contains an exported database filled with data, you need to import it locally. 
For that purpose, run importDatabase.bat just by clicking on it - it should do all the job. You don't need to worry about deleting the data 
in case you already have some data in the db - it will be done by the script.

============================================================================

*To export database:*

1. Run dumpDatabase.bat just by clicking on it - it will dump all database to dbexport.sql file.

============================================================================

*To run the application:*

1. Edit data in spring-database.xml to fit your personal info: host, port, user, password.
2. Run tomcat in your IDE // Run Application.java main method.
3. The app will be available at: http://localhost:8080/friendApp

