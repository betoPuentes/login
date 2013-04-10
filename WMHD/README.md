# WMHD #

## Developer Notes ##

WMHD is being developed in [Java](http://en.wikipedia.org/wiki/Java_%28programming_language%29). It uses a variety of open source libraries including [Vaadin](https://vaadin.com/home). For a full list of dependencies see the [build file](pom.xml). The project requires [Maven 3](http://maven.apache.org/) and a Java compiler to build.

## Building the Project (Quickstart) ##

__The codebase depends on Maven 2 or Gradle to build.__

___Maven___
In a regular development-testing-cycle use `mvn compile` to compile the codebase, and `mvn jetty:run` to compile the codebase and start the embedded webserver for live testing.

___Gradle___
In addition, we have provided a Gradle build script which you can use to compile the code. You are highly encouraged to use Gradle to do all the builds/testing. 

To import the projects into Eclipse, you first need to run `gradle eclipse eclipsewtp` in the working directory. This is only needed for the first import of the project to eclipse. To test the code, you need to run `gradle jettyRun`. This is the command which you will use to develop-test the code.

___Web server___
The running web server instance can be accessed @ [http://localhost:8080/worldmediahd/](http://localhost:8080/worldmediahd/).

## Other Files / Resources ##

__Eclipse Java Coding Style__
A set of XML files that define the style of the code is available. Please download [this zip file](http://dropbox.mofirouz.com/EclipseJavaStyle.zip) and unzip, and apply them in your Eclipse Preferences.
