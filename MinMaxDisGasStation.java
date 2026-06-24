
public class MinMaxDisGasStation {

    // brute force
    /*
     * time complexity: O(k*n)+O(n),where n is the size of the array,k=no of gas
     * station to be placed.
     * space complexity: O(n-1) as we are using an array to keep track of placed gas
     * station
     */
    // public double minMaxDistance(int arr[], int k) {
    // int n = arr.length;
    // int howMany[] = new int[n - 1];
    // for (int gasstation = 1; gasstation <= k; gasstation++) {
    // double maxSection = -1;
    // int maxInd = -1;
    // for (int i = 0; i < n - 1; i++) {
    // double diff = arr[i + 1] - arr[i];
    // double sectionLength = diff / (howMany[i] + 1.0);
    // if (sectionLength > maxSection) {
    // maxSection = sectionLength;
    // maxInd = i;
    // }
    // }
    // howMany[maxInd]++;
    // }
    // double maxAns = -1;
    // for (int i = 0; i < n - 1; i++) {
    // double diff = arr[i + 1] - arr[i];
    // double sectionLength = diff / (howMany[i] + 1.0);
    // maxAns = Math.max(maxAns, sectionLength);
    // }
    // return maxAns;
    // }

    // better approach
    /*
     * time complexity: O(nlogn+klogn) where n is the size of the array.k=no. of gas
     * station to be placed
     * space complexity: O(n-1)+O(n-1) the O(n-1) is for the array to keep track of
     * placeed gas station and the second for priority queue.
     */
    // class Pair{
    // double distance;
    // int index;

    // public Pair(double distance,int index) {
    // this.distance = distance;
    // this.index = index;
    // }
    // }

    // public double minMaxDistance(int arr[],int k){
    // int n = arr.length;
    // int howMany[] = new int[n-1];
    // PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->
    // Double.compare(b.distance, a.distance));
    // for(int i=0; i<n-1; i++){
    // pq.add(new Pair(arr[i+1]-arr[i],i));
    // }
    // for(int gasstation=1; gasstation<=k; gasstation++){
    // Pair top = pq.poll();
    // int indx = top.index;
    // howMany[indx]++;

    // double totalDist = arr[indx+1]-arr[indx];
    // double newDist = totalDist/(howMany[indx]+1);
    // pq.add(new Pair(newDist, indx));
    // }
    // return pq.peek().distance;
    // }

    // optimal approach

    /*
     * time complexity: O(N*log(Len))+O(N), where N is the size of the array.Len is
     * the length of the answer space.
     * space complexity: O(1) as we are not using any extra space to solve this problem
     */
    // methods to calculate the required number of gas station
    public int noOfGasStation(double dist, int arr[]) {
        int n = arr.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            count += numberInBetween;
        }
        return count;
    }

    // methods to minimize maximum distance between gas station
    public double minMaxDistance(int arr[], int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int count = noOfGasStation(mid, arr);
            if (count > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int k = 4;
        MinMaxDisGasStation obj = new MinMaxDisGasStation();
        double result = obj.minMaxDistance(arr, k);
        System.out.println("Minimized max distance between gasstation is: " + result);
    }
}
