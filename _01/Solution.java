package _01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
     static List<Integer> leftList = new ArrayList<>();
     static List<Integer> rightList = new ArrayList<>();

     public static void main(String[] args) throws IOException {
          Solution solution = new Solution();
          solution.readFile(args[0]);
          Collections.sort(leftList);
          Collections.sort(rightList);

          int result = solution.calculateDistance(leftList, rightList);
          System.out.println("total distance: " + result);
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

     public int calculateDistance(List<Integer> leftList, List<Integer> rightList) {
          int totalDistance = 0;

          for (int i = 0; i < leftList.size(); i++) {
               totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
          }

          return totalDistance;
     }


}
