// import java.util.*;

// public class dB {
//   Comparator<Student> com = new Comparator<Student>() {
//       public int compare(Student X, Student Y){
//         if(X.get() < Y.get()) return 1; 
//         return -1; 
//       }
//   };

//   private ArrayList<Student> Student_List = new ArrayList<Student>();

//   public void displayStudents(){
//     for(Student x : Student_List) System.out.println(x);
//   }

//   public void calc(){
//     for(int i = 0; i < Student_List.size(); i++) Student_List.get(i).calc();
//   }


//   public static void main(String[] args) {
//     dB db = new dB(); 

//     Student X1 = new Student("Nguyen Le Minh", "23020114"); 
//     Student X2 = new Student("Hoang Le Minh", "23200111"); 
//     Student X3 = new Student("Han Vu Long", "23020102"); 
//     Student X4 = new Student("Phi Dinh Manh", "23020108"); 

//     Pair<String, Double> xxx = new Pair<String,Double>("xx", 10.5); 

//     db.Student_List.add(X1); db.Student_List.add(X2); db.Student_List.add(X3); db.Student_List.add(X4); 


//     X1.RegisterACourse("Advanced C++", 9.8); 
//     X2.RegisterACourse("Advanced C++", 5.6);
//     X3.RegisterACourse("Advanced C++", 6.4);
//     X4.RegisterACourse("Advanced C++", 7.2);


//     db.calc();
//     Collections.sort(db.Student_List, db.com);
//     db.displayStudents();
//   }
// }