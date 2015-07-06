/*

Question: Given a sorted integer array where the range of elements are [0, 99]
inclusive, return its missing ranges. For example, given [0, 1, 3, 50, 75],
return [“2”, “4->49”, “51->74”, “76->99”]

Example Questions Candidate Might Ask: Q: What if the given array is empty? A:
Then you should return [“0->99”] as those ranges are missing. Q: What if the
given array contains all elements from the ranges? A: Return an empty list,
which means no range is missing.

*/

import java.util.List;
import java.util.ArrayList;

public class MissingRanges {
    public List<String> FindMissingRanges(int[] array, int start, int end) {
        List<String> ranges = new ArrayList<String>();
        
        int prev = start - 1;
        
        for (int i = 0; i <= array.length; i++) {
            int curt = (i == array.length) ? end + 1 : array[i];
            
            if (curt - prev > 1) {
                ranges.add(getRange(prev + 1, curt - 1));
            }
            
            prev = curt;
        }
        
        return ranges;
    }
    
    public String getRange(int start, int end) {
        return (start == end) ? String.valueOf(start) : start + "->" + end;
    }
    
    public void printResults(List<String> list) {
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        MissingRanges missRange = new MissingRanges();
        
        int[] array = new int[] {0, 1, 3, 50, 75};
        List<String> results = new ArrayList<String>();
        results = missRange.FindMissingRanges(array, 0, 99);
        missRange.printResults(results);
        
        
        array = new int[] {};       
        results = missRange.FindMissingRanges(array, 0, 99);
        missRange.printResults(results);
        
        array = new int[] {0, 1, 2, 99};        
        results = missRange.FindMissingRanges(array, 0, 99);
        missRange.printResults(results);
    }
}
