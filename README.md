# MyWebProject
A simple Java project created by Eclipse -> Dynamic Web Project that exposes SOAP and REST web services on Red Hat JBoss EAP 7.0

- Make sure you added Red Hat JBoss EAP 7.0 Runtime to Eclipse with jdk-1.8
- Right click on the imported project on Eclipse and choose "Run as" > "Run on server" and choose Red Hat JBoss EAP 7.0
- visit http://localhost:8080/MyWebProject/MySOAPWS?wsdl for SOAP web service's WSDL and http://localhost:8080/MyWebProject/rest/MyRESTWS/<see MyRESTWS.java for available routes> for REST services
