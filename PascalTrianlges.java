
public class PascalTrianlges {
    // TIME complexity: O(N^2) WE GENERATE all the elements in first n rows sequentially one by ine 
    // space complexity: O(N^2)
    // public List<List<Integer>> generate(int n){
    //     List<List<Integer>> triangle = new ArrayList<>();
    //     for(int i=0; i<n; i++){
    //         List<Integer> row = new ArrayList<>(Collections.nCopies(i+1, 1));
    //         for(int j=1; j<i; j++){
    //             row.set(j, triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
    //         }
    //         triangle.add(row);
    //     }
    //     return triangle;
    // }

    // time complexity: O(N), we iterate N times to compute each element of the row
    // in O(1) time using the direct relation.
    // Space complexity: O(N), additional space used for storing the Nth row.

    // public List<Long> getNthRow(int n){
    //     List<Long> row = new ArrayList<>();
    //     long val = 1;
    //     row.add(val);

    //     for(int k=1; k<n; k++){
    //         val = val*(n-k)/k;
    //         row.add(val);
    //     }
    //     return row;
    // }

    public long findPascal(int r,int c){
        int n = r-1;
        int k = c-1;
        long result = 1;

        for(int i=0; i<k; i++){
            result = result*(n-i);
            result = result/(i+1);
        }
        return result;
    }
    public static void main(String[] args) {
        // PascalTrianlges obj = new PascalTrianlges();
        // int k = 5;
        // List<List<Integer>> result = obj.generate(k);
        // for(List<Integer> row : result){
        //     for(Integer val : row){
        //         System.out.print(val + " ");
        //     }
        //     System.out.println();
        // }

        // PascalTrianlges obj = new PascalTrianlges();
        // int k = 5;
        // List<Long> result = obj.getNthRow(k);
        // for(long num : result){
        //     System.out.print(num + " ");
        // }
        // System.out.println();

        PascalTrianlges obj = new PascalTrianlges();
        int r = 5;
        int c = 3;
        System.out.println(obj.findPascal(r, c));
    }
}
