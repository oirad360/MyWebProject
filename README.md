# MyWebProject
A simple Maven project created by Eclipse ("Dynamic Web Project" -> converted in Maven) that exposes SOAP and REST web services on Red Hat JBoss EAP 7.0 with database interaction through MyBatis.
- Install Sakila Sample Database with MySQL, provide connection details on "mybatis-config.xml"
- Make sure you added the Server Runtime "Red Hat JBoss EAP 7.0 Runtime" to Eclipse with jdk-1.8: "Window" > "Preferences" > expand "Server" > "Runtime Environments" > "Add"
- Right click on the imported project on Eclipse and choose "Run as" > "Run on server" and choose Red Hat JBoss EAP 7.0
- visit http://localhost:8080/MyWebProject/<MySOAPWS/MySOAPWS1>?wsdl o for SOAP web services WSDL (you could use SoapUI to test SOAP services) and http://localhost:8080/MyWebProject/rest/<see "MyRESTWS.java" and "MyRESTWS1.java" for available routes> for REST services
