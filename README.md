Toy Robot Simulator Solution
============================

Description
-----------
This is the java version of Toy Robot simulator.

How to Build And Run
--------------------
You can choose either way of the following method:

1. By using IDE, you can open maven project by import pom.xml file in your favorite ide(Intellij Idea is suggested), run the com.rea.robot.Main class

2. To create a executable jar file with dependencies included. then you can run by:
```bash
    cd {PROJECT_ROOT_DIR}
    mvn clean package
    java -jar target/toy-robot-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Code Quality
------------
Using TestNG for unit tests, and jacoco for code coverage. You can find the code coverage report at target/site/jacoco after mvn test.
    
How to Play
-----------
Input commands to control robot after you started the application. Supported commands:
- Place x,y,(NORTH|EAST|SOUTH|WEST), e.g. PLACE 1,2,EAST
- Move: move one step towards current direction
- Left: turn left
- Right: turn right
- Report: report current location
- PowerOff : quit the application

Any invalid commands are ignored, e.g. typo or invalid format PLACE command.

Implementation Details
----------------------
- This solution is using Command Pattern to control robot actions: place, left, right, move and report.
- Robot's state can only be changed in xxxCommand
- During playing with robot by read commands from System.in, we never know when should we quit the program.
  By introducing 'PowerOff' command, application can quit after read this special command.
- Because we are reading commands from console or stream, it's possible that the command is invalid.
  With the help of NoopCommand, there's no need for extra logic to handle invalid commands.
- Value Object Classes are made final, like Position and Direction
- Using Builder pattern to prepare Robot object for easy testing
- Using CommandReader interface to make the robot easy to read commands from stub

