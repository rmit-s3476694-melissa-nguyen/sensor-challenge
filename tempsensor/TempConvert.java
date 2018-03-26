//====== Temp conversion utility === file TempConvert.java

package tempsensor ;                    // added to define membership of package.

public class TempConvert {

  public double raw_to_C (double raw, double rawMin, double rawMax, double tempMin, double tempMax){
    double tempIncr = (tempMax - tempMin) / (rawMax - rawMin);
    double temp = tempMin + (tempIncr * raw);
    return temp;
  }
    
}
