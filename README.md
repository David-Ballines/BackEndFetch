# Prerequisites
1. Install Eclipse for Java EE development
    * Copy and paste the following link to download Eclipse Neon3 IDE https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/neon/3/eclipse-jee-neon-3-win32-x86_64.zip
    When downloaded Eclipse will prompt you to set-up a workspace, select the desired location for the workspace.
2. Install Tomcat
    * Tomcat is a local that lets you run web services in your browser. To install Tomcat follow the link and select the version that works with your system https://tomcat.apache.org/download-10.cgi
    Pick the desired location of the Tomcat directory when unziping the files.

# Download and Run
Download the Java project into your Java workspace, or any other location. 
Open up the Eclipse IDE that you downloaded earlier and select the current workspace. 
Inside the Eclipse IDE, under the file menu select "open project from file system" and select the downloaded project from the directory you downloaded it in.
Once opened, the maven project will update. 

Now we will have to set up the Java project with the local Tomcat server to test and run. First right click on the Project folder in the project explorer and select properties. From the properties, menu select "Targeted Runtime" and click on "New" to create a new local server. In the Installation directory field select the directory where you downloaded Tomcat earlier. Select the latest version of Apache Tomcat and click finish afterward. Check the box of the newly created server. In the IDE there should be a window called "Servers" under the editor. If the window is not there, from the "window" menu select "Show View" and click on "Servers". Now in the "Servers" view there should be a "No Servers Available...", click on it and select the Apache Tomcat version that you made earlier in the "Targeted Runtime" menu. The server should now show up in the view, double click the newly added server. Select the modules window under the editor and click add web module and select the project.
In the "servers" window right-click on the Tomcat server and select run. This allows you to run a local server using the web service.

# Testing the web service
The web service I created takes HTTP GET requests and returns the desired output depending on the given Path. There are three functions that I created, two to handle either one version input or zero version inputs, they ask the user to input the correct amount of versions. The third function, getVers, takes the two versions given to it and finds out the hierarchy of the versions depending on the given criteria.
Use the Path "http://localhost:8080/hierarchy/test/check/{version 1}/{version 2}" insde your desired web browser, and replace "version 1" and "version 2" with the desired input to test the code.
