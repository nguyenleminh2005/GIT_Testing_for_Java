import java.util.*;

class Pair<First, Second> {
    First X; 
    Second Y; 

    public Pair() {}

    public Pair(First X, Second Y) {
        this.X = X; 
        this.Y = Y; 
    }

    @Override
    public String toString() {
        return "{" + X + ", " + Y + "}"; 
    }
}

public class SwingApp {
    public static void main(String[] args) {
        Pair<String, Double> Student = new Pair<>("Minh", 9.5);
        System.out.println(Student); 

        HashSet<Pair<String, Double>> set = new HashSet<Pair<String, Double>>(); 

        set.add(Student);
        System.out.println(set);
    }
}