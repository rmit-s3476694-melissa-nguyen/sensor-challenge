//====== main class where execution starts === File MyMain.java
//
//  PURPOSE - main program for OUSB temperature sensor lab activity.
//
//    * Compile with   javac MyMain.java
//      Run with       java MyMain

import tempsensor.* ;

public class MyMain {
    // references for switch and adc based temperature sensors.
    static SwitchTempSensor ousbSwitchTempSensor ; // this is a reference not an instantiated class.
    static AdcTempSensor ousbAdcTempSensor ; 

 public static void main(String[] args) {
    System.out.println("\nWelcome to OUSB Temperature Sensors\n") ;
    
    ousbSwitchTempSensor = new SwitchTempSensor();
    ousbAdcTempSensor = new AdcTempSensor();
    
    int runTime = 0;
    
    while(true) {
        
        System.out.println("Program has been running for " + runTime + " seconds") ;
        System.out.printf("OUSB Switch Temp Sensor = %.2f \n", ousbSwitchTempSensor.getTempC());
        System.out.printf("OUSB ADC Temp Sensor = %.2f \n\n", ousbAdcTempSensor.getTempC());
        
        // Sleep for 1 second
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println("Awakened prematurely");
        }
        
        // Increase timer
        runTime++;
        
    }
    
 } //main
} //MyMain
