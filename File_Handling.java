import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File_Handling {
    public static void main(String[] args) throws IOException {
            // Đọc mảng số nguyên từ tệp input.txt
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            List<Integer> numbers = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                for (String part : parts) {
                    numbers.add(Integer.parseInt(part));
                }
            }
            reader.close();

            // Ghi mảng số nguyên ra tệp output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for (int number : numbers) {
                writer.write(number + " ");
            }
            writer.newLine();
            writer.close();
    }
}

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.PrintWriter;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class Solution {
//     public static void main(String[] args) {
//         try {
//             // Đọc mảng số nguyên từ tệp input.txt
//             Scanner scanner = new Scanner(new File("input.txt"));
//             List<Integer> numbers = new ArrayList<>();
//             while (scanner.hasNextInt()) {
//                 numbers.add(scanner.nextInt());
//             }
//             scanner.close();

//             // Ghi mảng số nguyên ra tệp output.txt
//             PrintWriter writer = new PrintWriter("output.txt");
//             for (int number : numbers) {
//                 writer.print(number + " ");
//             }
//             writer.println();
//             writer.close();
//         } catch (FileNotFoundException e) {
//             e.printStackTrace();
//         }
//     }
// }