@echo on
javac -cp .;C:/xampp/tomcat/lib/servlet-api.jar;classes -d C:/xampp/tomcat/webapps/airline_webapp/WEB-INF/classes src/com/example/web/Authenticate.java
javac -d C:/xampp/tomcat/webapps/airline_webapp/WEB-INF/classes src/com/example/model/Database.java
pause
C:/xampp/catalina_start.bat
