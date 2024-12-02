package _02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

     int countSafe = 0;

     private int[][] transformFile(String fileName) throws IOException {
          BufferedReader reader = new BufferedReader(new FileReader(fileName));

          String line;
          int[][] file = new int[1000][];
          int fileIdx = 0;
          while ((line = reader.readLine()) != null) {
               String[] arr = line.trim().split("\\s+");
               int[] lineArray = new int[arr.length];
               for (int i = 0; i < arr.length; i++) {
                    lineArray[i] = Integer.parseInt(arr[i]);
               }
               file[fileIdx] = lineArray;
               fileIdx++;
          }

          reader.close();

          return file;
     }

     public boolean levelIsSafe(int[] level) {
          // Variable to track the direction: 1 for increasing, -1 for decreasing, 0 for no direction set
          int direction = 0;

          for (int i = 1; i < level.length; i++) {
               int diff = level[i] - level[i - 1];

               // Check if the difference is within the allowed range (1 to 3)
               if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                    return false;
               }

               if (direction == 0) {
                    // increasing
                    if (diff > 0) {
                         direction = 1;
                    }
                    // decreasing
                    else if (diff < 0) {
                         direction = -1;
                    }
               } else {
                    // change directions from what was first set
                    if ((direction == 1 && diff < 0) || (direction == -1 && diff > 0)) {
                         return false;
                    }
               }
          }
          // no direction changes, differences OK
          return true;
     }

     public int readThroughFile(int[][] file) {
          for (int[] ints : file) {
               if (levelIsSafe(ints)) {
                    countSafe++;
               }
          }
          return countSafe;
     }

     public static void main(String[] args) throws IOException {
          Solution solution = new Solution();
          int[][] fileArray = solution.transformFile(args[0]);
          int safeLevels = solution.readThroughFile(fileArray);
          System.out.println("safeLevels = " + safeLevels);
     }
}