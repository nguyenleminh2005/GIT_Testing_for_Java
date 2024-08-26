import java.util.*;
import java.lang.reflect.*;
import javax.swing.*;

public class ABC {
  public static void main(String args[]) throws Exception{
    Class<?> cls = XYZ.class; 
    Constructor<?> constructor = cls.getDeclaredConstructor(String.class, String.class); 
    constructor.setAccessible(true);
    Object o = constructor.newInstance("Minh", "2302"); 

    Method[] methods = cls.getDeclaredMethods(); 

    for(int i = 0; i < methods.length; i++){
      Method method = methods[i]; 
      if(method.getName().equals("getID")){
        method.setAccessible(true);
        String res = (String) method.invoke(o); 
        System.out.println(res);
      }
    }
  }
}