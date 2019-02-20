/**
 * Sliding windows.
 */

import java.util.*;

public class ShortestCycle {

    public int shortestCycle(int[] data) {
        if(data == null || data.length == 0) {
            return -1;
        }

        // Use a map of {number -> indexOfFirstOccurrence} to track each num.
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        int minSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < data.length; i++) {
            if(numIndexMap.containsKey(data[i])) {
                int distance = i - numIndexMap.get(data[i]) + 1;
                minSoFar = Math.min(minSoFar, distance);
            }
            numIndexMap.put(data[i], i);
        }
        System.out.println(minSoFar);
        return minSoFar;
    }


    public static void main(String[] args) {
        ShortestCycle solution = new ShortestCycle();
        int[] data = {9,6,8,7,1,2,3,4,5,1};
        solution.shortestCycle(data);
    }
}
