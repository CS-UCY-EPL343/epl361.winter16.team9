Team 9
----------------------

Case Management Platform and Tools  for reporting cyber crime and providing technical support

___

You can visit the website on : [https://31.216.88.66:8000](https://31.216.88.66:8000)
If the website is not accessible, send an email on zacharias33@gmail.com
###Description

This project is divided into 5 sub projects in allprojects directory:
*   CMS Library (Prototype version)
*   Web App (Prototype version)
*   Hotline Platform (Prototype version)
*   Helpline Platform (Not implemented yet)
*   Description Platform (Not implemented yet)

We've used the Gradle Build Tool in order to build our project.
###How to install
1. Run the scripts for the database located in the db/scripts/ directory. The database is Mysql.
2. If you want to build the WebApp:
    1.Build the WebApp project using the following command from allProjects directory:
      ```bash
      ./gradlew :WebApp:exportJar
      ```
    2.Go to WebApp/build/libs and copy WebApp-x.x.jar , keys and public directory into your preferred location
    3. Execute the following command in order to start the server:
      ```bash
      # It runs on the default port which is 8000
      java -jar WebApp-x.x.jar
      # If you want to specify the port you can run:
      sudo java -jar WebApp-x.x.jar 80 ./data/
      ```
3. If you want to build HotlinePlatform:
    1.Build the HotlinePlatform project using the following command from allProjects directory:
      ```bash
      ./gradlew :HotlinePlatform:exportJar
      ```
    2.Go to HotlinePlatform/build/libs and copy HotlinePlatform-x.x.jar  into your preferred location
    3. Execute the following command in order to start the application:
      ```bash
      # Make sure you have the necessary database
      java -jar HotlinePlatform-x.x.jar
      ```

HotlinePlatform has access to the data directory of the webserver. By default webserver and platform must be in the same directory.
With some steps not described here you can run the platform in a different host, using sshfs to mount the directory. There is an example script for this in the /HotlinePlatform/build/libs directory

___
###Modules
####CMSLibrary
A library project that provides the necessary components for the whole project, such as connection to database,
GUI and security.

####Web App
A web application that provides the user with the service of reporting a case.
This application runs on a jetty server using the sparkframework:[http://www.sparkjava.com](http://www.sparkjava.com)

####Hotline Platform
An application that helps the operator to handle the hotline cases.


####Helpline Platform
An application that helps the operator to handle the helpline cases.

####Description Platform
An application that helps the operator to decide in which platform the description belongs to.




