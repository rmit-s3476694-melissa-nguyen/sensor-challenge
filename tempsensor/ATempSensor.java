//====== Parent class, a general temperature sensor ======  file TempSensor.java
//
//  PURPOSE - provide a parent class for temperature sensors on the OUSB board.
//
//    NOTES - the OUSB board has the switch inputs, ADC inputs, I2C inputs,
//            and RS-232.  All these could be used as temperature sensors
//            but each would need this base class plus their own hardware bits
//            added.  In other words a particular sensor could be created
//            by extending this abstract class into a usage class and overriding
//            some parent members.  
//            Somewhere on the live-DVD there is a java example which shows you
//            how to access the OUSB board.


package tempsensor ;                    // added to define membership of package.

import java.io.* ;


public abstract class ATempSensor{  // abstract=can have children inherit
                                    //  from this class, but no instantiation.
//--- class member data (variables) are called fields.
  static int numberTempSensors = 0 ;// static means one item shared over all
                                    // objects created from this class.
  String  sensorName = "";        
  boolean active = false ;          // T/F if active.
  double   tempDegC  ;              // Measured temperature. 
  final static double absoluteZero = -273 ;
  double   errorPercent ;            // Reading error as %.
  final static double defaultAccuracy = 5.0 ;
  double   upperLimitC ;
  double   lowerLimitC ;
  
  static String cmd ;        // command to send to shell.
  static String cmd_result ; // Line returned by command.
  static int    cmd_number ; // if command just returned a number, here it is.
  
  
//--- class member functions (services) are often called simply members. 

//--- Constructor, called whne class is created.
  public ATempSensor(String name){
    sensorName = name ;
    active = true ;
    numberTempSensors++ ;
    tempDegC = absoluteZero ;        // Mark that not initialized yet.
    errorPercent = defaultAccuracy ;  
    upperLimitC =  absoluteZero ;    // Mark that not initialized yet.
    lowerLimitC =  absoluteZero ;    // Mark that not initialized yet.
  }
  
  
  //--- Parent member functions access in child with super.name_of_function()
  public String getName() {
    return(sensorName) ;
  }  
  
  public  void setName(String newName) {
    sensorName = newName ;
  }  
  
  public  void setEnabled() {
    active = true ;
  }  
  
  public  void setDisabled() {
    active = false ;
  }  
  
  public double C_to_F (double celsius){
    return( 32.0 + celsius * 1.8) ;
  }
  
  public double F_to_C (double fahrenheit ){
    return( (fahrenheit-32.0)/ 1.8) ;
  }
  
  public double getTempC() { // Child class overwirites with it's own version.
    return( tempDegC) ;
  }
  
 //------ Shell Command: this is probably a bad place to put this functionality.
 //       It would be better as it's own class.
    
    //------ Execute a shell command.  No error checking for timeouts, no exceptions handled.
    public void runCmd(){
    try { Runtime run = Runtime.getRuntime() ; // get runtime shell.
          Process pr = run.exec(cmd) ;         // start command.
          pr.waitFor() ;                       // wait for command to finish.       
          BufferedReader buf = new BufferedReader  // get output from command.
              ( new InputStreamReader( pr.getInputStream() ) ) ;
          cmd_result = buf.readLine() ;
          cmd_number = Integer.parseInt(cmd_result) ;
        }
     catch (Exception e ) { // can get exceptions for exec, waitfor, parseInt
                          }        
    } //runCmd

}

