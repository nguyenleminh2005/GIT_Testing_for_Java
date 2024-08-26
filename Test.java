import java.util.*;
import java.io.*;

class Student{
  private int id;
  private String name; 
  private double cgpa; 

  public Student(int id, String name, double cgpa){
    this.id = id;
    this.name = name;
    this.cgpa = cgpa; 
  }

  int getID(){
    return this.id; 
  }
  
  String getName(){ 
    return this.name; 
  }

  double getCGPA(){
    return this.cgpa;
  }
}

class Priorities{

  List<String[]> query = new ArrayList<>(); 

  Comparator<Student> com = new Comparator<Student>() {
    @Override 
    public int compare(Student A, Student B){
      if(A.getCGPA() != B.getCGPA()) return Double.compare(B.getCGPA(), A.getCGPA());
      else if(A.getName() != B.getName()) return A.getName().compareTo(B.getName()); 
      else return Integer.compare(A.getID(), B.getID());  
    }
  };

  PriorityQueue<Student> pq = new PriorityQueue<Student>(com); 

  public List<Student> getStudents(List<String> events){
    for(int i = 0; i < events.size(); i++){
      String[] s = events.get(i).split(" "); 
      query.add(s); 
    }

    List<Student> res = new ArrayList<>(); 

    for(String e[] : query){
      if(e[0].equals("ENTER")){
        pq.add(new Student(Integer.parseInt(e[3]), e[1], Double.parseDouble(e[2]))); 
      }
      else{
        if(pq.isEmpty()) continue; 
        pq.poll(); 
      }
    }
    while (!pq.isEmpty()) res.add(pq.poll()); 
    return res; 
  }
}
 

public class Test {
    private static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
      try {
        System.setIn(new FileInputStream("input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        scan = new Scanner(System.in);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    

        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}