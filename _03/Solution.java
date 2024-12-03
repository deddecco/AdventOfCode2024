package _03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

     public static int runningSum = 0;


     public static void main(String[] args) throws IOException {
          String filePath = args[0];

          // Create an empty list to store the arrays of numbers
          List<int[]> multiplicationPairs = extractToListOfArrays(filePath);

          // Print the list of arrays and add the product of the good pairs to the sum
          for (int[] pair : multiplicationPairs) {
               System.out.println(Arrays.toString(pair));
               addToRunningSum(pair);
          }

          System.out.println("runningSum = " + runningSum);
     }

     private static void addToRunningSum(int[] pair) {
          int intermediateResult = pair[0] * pair[1];
          runningSum += intermediateResult;
     }

     public static List<int[]> extractToListOfArrays(String filePath) throws IOException {
          List<int[]> result = new ArrayList<>();
          String regex = "mul\\((-?\\d+),\\s*(-?\\d+)\\)";
          Pattern pattern = Pattern.compile(regex);
          processFile(filePath, pattern, result);
          return result;
     }

     private static void processFile(String filePath, Pattern pattern, List<int[]> result) throws IOException {
          try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
               String line;
               while ((line = br.readLine()) != null) {
                    // Create a matcher for the current line
                    Matcher matcher = pattern.matcher(line);

                    // Check for matches in the current line
                    while (matcher.find()) {
                         int num1 = Integer.parseInt(matcher.group(1));  // First number
                         int num2 = Integer.parseInt(matcher.group(2));  // Second number
                         result.add(new int[]{num1, num2});
                    }
               }
          }
     }
}