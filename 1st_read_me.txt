SENSOR PACKAGE CHALLENGE
~~~~~~~~~~~~~~~~~~~~~~~~~~

This file will help guide you and help you complete the 
Sensor Package challenge.

The aim of this challenge is to get you to the stage of 
creating a distributable JAR package which is the equivalent
of an executable C or C++ command line program.
If you successfully complete this challenge then you should
be able to create a Java based command line program that you 
could send to other people who use Windows, Linux, MAC, or
any mobile phone.

Another aim is to help you appreciate the virtues of packing
functionality into classes and using inheritance 
(when appropriate).  The tutor will talk about good and bad 
ways to put code into classes, for example-
  * Do not put everything into the constructor.
  * If there is a parent put member function names
    in that, often they have no content.
    In a child class create a member function with
    code and use @Override.



PRACTICE BEFORE LAB
~~~~~~~~~~~~~~~~~~~
This challenge is too big to complete entirely in the lab 
time available.  You will have to do the reading at home, 
and practice it at home. 
You should get this challenge fully working before coming
to the lab where the challenge is run.



PREREADING
~~~~~~~~~~
Before looking at this challenge there are several things 
you must master-

  * Read thoroughly the lecture note chapter titled
    "Java for C++ Programmers"
    In particular read the section on 
    "Java Packages & Jar files with javac"
    
  * You should have completed the first challenge which printed
    out a temperature reading based on the switches and trim pot
    of the OUSB board.
    You will need to reuse a lot of code from here such as how to
    call another program from Java,  and how to take the switch
    and ADC readings and convert them to degrees C.
    
  * Find the /home/extras/public_examples/java/sensor_package/
    directory and copy it into your work area (/home/user/Documents).
    Look carefully at the code and try compiling and turning the
    package into a jar file.  The steps necessary are all shown in
    the lecture notes.
    
  * Make sure you understand the public, protected, private
    attributes in a class and what they mean for accessibility
    of a member to other classes both inside and outside a package.
    
    
GOAL
~~~~~
You are going to utilize an abstract (parent) class to create
child classes. One child will handle the OUSB switches acting
as a temperature sensor, another will handle the trim pot acting
as a temperature sensor.

Next you will package the code into a single jar file which
could be sent to anyone.



PROVIDED FILES
~~~~~~~~~~~~~~
This directory has several files which partially implement the solution.
You must read them carefully and understand each section.

MyMain.java provides a basic main file that declares the package name
and the name of the two classes you must create.  You will need to add
code in this file.

ATempSensor.java is complete and provides an abstract parent class that
defines what a generic temperature sensor should do.  An abstract class
can never be instantiated into a run time object,  it can only act as
a parent.
You may add new function members here.

SwitchTempSensor.java is one of the two child classes you must create
but is not complete and you must add code to make it work.
There is one other class you must create which is named in 
the MyMain.java file.



SPECIFIC REQUIREMENTS
~~~~~~~~~~~~~~~~~~~~~~~
* You must add code to MyMain.java,  SwitchTempSensor.java.
  You must create the class named in MyMain.java that
  implements the temperature sensor for the trim pot.
  
* Your code in MyMain must loop forever and every one second
  printout the temperature derived from the OUSB switches and
  the trim pot.
  The switches are reported as a temperature with zero being 
  35 degrees C,  255 as 45 degrees C.
  The trimpot is reported with zero being printed as 
  -20 degrees C, 1023 is +250 degrees C.
  
* MyMain should do any printing, no printout should
  be done from the sensor classes.  
  
* Package the code into a jar file and demonstrate
  to your tutor.
  Have all source files open in the editor and be ready to 
  explain any part if the code.
  
* The output every second should be of form-
     OUSB Switch Temp Sensor = 45.0
     OUSB ADC Temp Sensor = 72.11143695014663
  Show the tutor that the sensors work at either extreme and
  in a middle setting.
  
* You must be able to explain to the tutor the costs and benefits
  of packaging code into parent classes and inheriting from that
  class.
  
* You must know when inheritance is appropriate.  If there is 
  a test be able to use it on both child classes in this problem.
  
* Be ready for the tutor to demand a small change in your code. 
  Note that these marks for this element are only available 
  to students who finish in the first one hour of the lab.
  
* You must submit your file to the tutor via the submission system
  which the tutor will show you, or possibly just the tutor's memory
  stick.
  If time is short in the labs then the tutor will mark your work
  outside lab time.
  
* Do not use Eclipse or Android Studio to program Java.
  Use the Kate editor (Utilities->Kate, or just double click
  on the *.java file).
  
  
HINTS
~~~~~~
* You will be surprised how little code you have to write.  Look
  at the functions in the parent and use them when appropriate.
  Look at the examples and cut and paste.
  
* Try to put most of the functionality into the classes and not
  MyMain.java.
  
* The whole directory structure and naming of files can be confusing
  so make sure you understand this part of the lecture notes.

* Make sure you understand casting in Java.  The conversion between
  int and double may cause compiler errors if you get it wrong.
  
* You really do need to get it working at home first.
  Understanding what to do,  and where to find code to copy and
  paste on the live-DVD,  will take much more time.
  If you know what you are doing you should be ready to 
  demonstrate in 10 minutes or less!
  
* Look up Stroustrup's Rule as regard inheritance.
  
* Your tutor may ask for a small change to the code.  If you want
  to get quick access to a field in ATempSensor from MyMain
  then it is OK just to add "public" rather than creating a member
  function to report the variable.
  
* When in a terminal use Ctrl-Shift-C to copy and Ctrl-Shift-V to
  paste.  Using this you can copy commands from a document to the
  command line and then modify before hitting enter to execute.
  
  
  
MARKING GUIDE
~~~~~~~~~~~~~~

* 25%: switch sensor successfully prints out every second.
       Switch settings of zero gives 35 degC,
       128 gives about 40 degC, and 255 45 degC.
       
* 25%: trim pot sensor successfully prints out every second.
       The trim pot at maximum anti-clockwise setting gives -20 degC.
       At the middle about +115 degC.  
       At full clockwise +250 degC.
       
* 25%: can answer questions.

* 25%: can modify code as per tutor's request.
       Note this is available only to students who finish the 
       previous sections within the first hour.
       
  
    


