// import java.util.ArrayList;

// class Pair<first, second> {
//   public first X;
//   public second Y;  

//   public Pair(){}

//   public Pair(first X, second Y) {
//     this.X = X; 
//     this.Y = Y; 
//   }

//   @Override
//   public String toString() {
//     return "{" + X + ", " + Y + "}"; 
//   }
// }

// public class Student {
//   private String fullname;
//   private String StudentId; 
//   private ArrayList<Pair<String, Double>> ListOfCourse = new ArrayList<Pair<String, Double>>(); 
//   private double avgGrade;  

//   public Student(String _fullname, String _StudentID) {
//     this.fullname = _fullname; 
//     this.StudentId = _StudentID; 
//     ListOfCourse = new ArrayList<Pair<String, Double>>(); 
//     avgGrade = 0;  
//   }

//   public void RegisterACourse(String course_name, double Grade) { 
//     ListOfCourse.add(new Pair<String, Double>(course_name, Grade)); 
//   }

//   public void calc() {
//     double sum = 0; 
//     for (int i = 0; i < ListOfCourse.size(); i++) {
//       sum += ListOfCourse.get(i).Y; 
//     }
//     avgGrade = (sum / ListOfCourse.size());  
//   }

//   public double get() {
//     return avgGrade; 
//   }

//   @Override
//   public String toString(){
//     return "{" + fullname + ", " + StudentId + ", " + avgGrade + "}"; 
//   }
// }