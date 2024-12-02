package _02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

     int countSafe = 0;

     private int[][] transformFile(String fileName) throws IOException {
          BufferedReader reader = new BufferedReader(new FileReader(fileName));

          String line;
          int[][] file = new int[6][];
          int fileIdx = 0;
          while ((line = reader.readLine()) != null) {
               String[] arr = line.split("\t");
               int[] lineArray = new int[arr.length];
               for (int i = 0; i < arr.length; i++) {
                    lineArray[i] = Integer.parseInt(arr[i]);
               }
               file[fileIdx] = lineArray;
          }

          return file;
     }

     public boolean safe(int[] level) {
          for (int i = 1; i < level.length - 1; i++) {
               if (!(Math.abs(level[i] - level[i - 1]) >= 1 && Math.abs(level[i] - level[i - 1]) <= 3)) {
                    return false;
               }
          }
          countSafe++;
          return true;
     }


}
