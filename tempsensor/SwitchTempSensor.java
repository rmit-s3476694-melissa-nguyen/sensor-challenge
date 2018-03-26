//====== Temperature sensor based on switches ======  file SwitchTempSensor.java
//
//  PURPOSE - Inherit from TempSensor to create a temp sensor based on OUSB switches.

package tempsensor ;                    // added to define membership of package.

public class SwitchTempSensor extends ATempSensor {
//--- class member data (variables) are called fields.
    
//--- class member functions (services) are often called simply members. 

//--- Constructor, called when class is created.

  public SwitchTempSensor(){
    super("OUSB Switch Temp Sensor") ;
  }
  
//--- Member functions.

  public double getTempC() { // Overwrites parent's version.
    
    // Read the switches
    cmd = "ousb -r io pinc";
    runCmd();
    
    // Convert to celsius
    TempConvert t = new TempConvert();
    double switchTemp = t.raw_to_C(cmd_number, 0, 255, 35.00, 45.00);
    
    return switchTemp;
    
  }
 
} //ATempSensor
 
