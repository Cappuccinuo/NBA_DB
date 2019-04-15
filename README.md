Database:
1. Install MySql workbench: https://www.mysql.com/products/workbench/
2. Execute dump_nba.sql in Database folder.

Backend:
1. Install Intellij IDEA Community version: https://www.jetbrains.com/idea/download
2. Install Maven: https://maven.apache.org/
3. Import backend code(easy-notes folder) in Intellij.
4. Make sure all dependency in pom.xml is installed by maven automatically. Otherwise, right click pom.xml, click Maven/reimport.
5. Modify the database username and password in easy-notes/src/main/resources/application.properties.
6. After all dependency is imported, then execute the following command in terminal: **mvn spring-boot:run**, this will start the server in http://localhost:8080.

Frontend:
1. npm install http-server -g (https://www.npmjs.com/package/http-server)
2. in terminal of the /front-end folder path, execute **http-server -c-1**, the terminal will give a address of the client, e.g. http://127.0.0.1:8080. Type that in chrome, and the application can be used.
