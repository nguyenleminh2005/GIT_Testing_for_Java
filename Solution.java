import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.*;



public class Solution {

    static Scanner scanner = new Scanner(System.in); 

    static int[] a = new int[105]; 
    static int N;


    static class Pair<first, second> {
        public first X; 
        public second Y; 
        
        public Pair(){}
    
        public Pair(first X, second Y){
            this.X = X; 
            this.Y = Y;
        }
    
        @Override
        public String toString(){
            return "{" + X + ", " + Y + "}";   
        }

        public void printClassName() {
            System.out.println("Class name: " + this.getClass().getName());
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true; 
            if(o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o; 
            return Objects.equals(X, pair.X) && Objects.equals(Y, pair.Y);  
        }

        @Override 
        public int hashCode(){
            return Objects.hash(X, Y); 
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            scanner = new Scanner(System.in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        HashSet<Pair<String, String>> set = new HashSet(); 
        int Q = scanner.nextInt();
        scanner.nextLine();  
        for(int i = 1; i <= Q; i++){
            String X = scanner.next(); 
            String Y = scanner.next(); 

            Pair<String, String> pair = new Pair<>(X, Y);
            pair.printClassName();

            set.add(pair);
            
            System.out.println(set.size());
        }
    }
}   

