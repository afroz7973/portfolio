import java.util.ArrayList;

public class LeadersInArray {
    // using brute force approach
    // time complexity is O(N^2) since there are nested loop being used,at the worst
    // case n^2 time is consumed
    // public static ArrayList<Integer> printLeaders(int arr[],int n){
    // ArrayList<Integer> ans = new ArrayList<>();
    // for(int i=0; i<n; i++){
    // boolean leader = true;
    // for(int j=i+1; j<n; j++){
    // if(arr[j] > arr[i]){
    // leader = false;
    // break;
    // }
    // }
    // if(leader) ans.add(arr[i]);
    // }
    // return ans;
    // }

    // using optimal approach
    // time complexity is O(N) Since the array is traversed single time back to
    // front, it will consume O(N) time
    // public static ArrayList<Integer> printLeader(int arr[],int n){
    // ArrayList<Integer> ans = new ArrayList<>();
    // int max = arr[n-1];
    // ans.add(arr[n-1]);
    // for(int i=n-2; i>=0; i--){
    // if(arr[i] > max){
    // ans.add(arr[i]);
    // max = arr[i];
    // }
    // }
    // return ans;
    // }

    public static ArrayList<Integer> leaderArray(int arr[], int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean leader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]){

                    leader = false;
                break;
                }
            }
            if(leader) ans.add(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        // int n = 6;
        // int arr[] = {10,22,12,3,0,6};
        // ArrayList<Integer> ans = printLeaders(arr, n);
        // for(int i=0; i<ans.size(); i++){
        // System.out.print(ans.get(i)+" ");
        // }

        // int n = 6;
        // int arr[] = {10,22,12,3,0,6};
        // ArrayList<Integer> ans = printLeader(arr, n);
        // Collections.sort(ans,Collections.reverseOrder());
        // for(int i=0; i<ans.size(); i++){
        // System.out.print(ans.get(i)+" ");
        // }

        int n = 6;
        int arr[] = {10,22,12,3,0,6};
        ArrayList<Integer> ans = leaderArray(arr, n);
        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
