//====== Temperature sensor based on switches ======  file AdcTempSensor.java
//
//  PURPOSE - Inherit from TempSensor to create a temp sensor based on OUSB trim pot.

package tempsensor ;                    // added to define membership of package.

public class AdcTempSensor extends ATempSensor {
//--- class member data (variables) are called fields.
    
//--- class member functions (services) are often called simply members. 

//--- Constructor, called when class is created.

  public AdcTempSensor(){
    super("OUSB ADC Temp Sensor") ;
  }
  
//--- Member functions.

  public double getTempC() { // Overwrites parent's version.
    
    // Read the trim pot
    cmd = "ousb -r adc 5";
    runCmd();
    
    // Convert to celsius
    TempConvert t = new TempConvert();
    double adcTemp = t.raw_to_C(cmd_number, 0, 1023, -20.00, 250.00);
    
    return adcTemp;
    
  }
 
} //ATempSensor
