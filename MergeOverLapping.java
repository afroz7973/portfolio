
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MergeOverLapping {
    // brute force approach
    /*
     * time complexity: O(N^2)for every interval we check all future intervals.
     * Space Complexity: O(N), additonal space used to store the non-overlapping
     * intervals.
     */
    // public List<List<Integer>> merger(int[][] intervals){
    //     // Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
    //     Arrays.sort(intervals);
    //     List<List<Integer>> ans = new ArrayList<>();
    //     int n = intervals.length;
    //     int i=0;
    //     while(i<n){
    //         int start = intervals[i][0];
    //         int end = intervals[i][1];
    //         int j=i+1;
    //         while(j<n && intervals[j][0] <= end){
    //             end = Math.max(end, intervals[j][i]);
    //             j++;
    //         }
    //         ans.add(Arrays.asList(start,end));
    //         i=j;
    //     }
    //     return ans;
    // }

    // Optimal approach
    /*
     * time compexity: O(N*logN)+O(N) WE sort the entire array and then merge them
     * in a single pass
     * space complexity: O(N) additional space used to store the non overlapping intervals.
     */
    public List<List<Integer>> merge(int[][] intervals){
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<List<Integer>> merge = new ArrayList<>();
        for(int[] interval:intervals){
            if(merge.isEmpty() || merge.get(merge.size()-1).get(1)<interval[0]){
                merge.add(Arrays.asList(interval[0],interval[1]));
            }
            else{
                int last = merge.size()-1;
                int maxEnd = Math.max(merge.get(last).get(1),interval[1]);
                merge.get(last).set(1, maxEnd);
            }
        }
        return merge;
    }
    public static void main(String[] args) {
        // MergeOverLapping mergeOver = new MergeOverLapping();
        // int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        // List<List<Integer>> result = mergeOver.merger(intervals);
        // for(List<Integer> interval:result){
        //     System.out.println(interval+" ");
        // }

        MergeOverLapping mergeOver = new MergeOverLapping();
        int[][] intervals = {{1,3},{1,6},{8,10},{15,18}};
        List<List<Integer>> result = mergeOver.merge(intervals);
        for(List<Integer> interval:result){
            System.out.println("["+interval.get(0)+","+interval.get(1)+"]");
        }
    }   
}
