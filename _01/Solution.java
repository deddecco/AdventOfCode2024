package _01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
     static List<Integer> leftList = new ArrayList<>();
     static List<Integer> rightList = new ArrayList<>();

     public static void main(String[] args) throws IOException {
          Solution solution = new Solution();
          solution.readFile(args[0]);
          System.out.println(leftList);
          System.out.println(rightList);
     }

     private void readFile(String fileName) throws IOException {
          BufferedReader reader = new BufferedReader(new FileReader(fileName));

          String line;
          while ((line = reader.readLine()) != null) {
               String[] arr = line.split("\t");
               leftList.add(Integer.parseInt(arr[0]));
               rightList.add(Integer.parseInt(arr[1]));
          }
     }


}
