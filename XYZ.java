import java.util.*; 

public class XYZ {
  private String name; 
  private String ID; 

  private XYZ(String name, String ID){
    this.name = name; 
    this.ID = ID; 
  }

  public String getName(){return this.name;}

  private String getID(){return this.ID;}

  @Override
  public String toString() {
      return "XYZ{name='" + name + "', ID='" + ID + "'}";
  }
}
