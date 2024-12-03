package _03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

     public static void main(String[] args) {
          // File path of the text file to scan
          String filePath = "example.txt";  // Update with the path to your file

          // Regular expression to match "mul([number], [number])"
          String regex = "mul\\((-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)\\)";

          // Compile the regex pattern
          Pattern pattern = Pattern.compile(regex);

          // Open the file for reading
          try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
               String line;
               while ((line = br.readLine()) != null) {
                    // Create a matcher for the current line
                    Matcher matcher = pattern.matcher(line);

                    // Check for matches in the current line
                    while (matcher.find()) {
                         // Output the matched substring
                         System.out.println("Found match: " + matcher.group());
                    }
               }
          } catch (IOException e) {
               e.printStackTrace();
          }
     }
}
