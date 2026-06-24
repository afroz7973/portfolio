



public class PascalTriangle {
    /*
     * Time Complexity: O(N^2), we generate all the elements in first N rows
     * sequentially one by one.
     * Space Complexity: O(N^2), additional space used for storing the entire pascal
     * triangle.
     */
    // public List<List<Integer>> generate(int n){
    //     List<List<Integer>> triangle = new ArrayList<>();
    //     for(int i=0; i<n;i++){
    //         List<Integer> row = new ArrayList<>(Collections.nCopies(i+1, 1));
    //         for(int j=1; j<i; j++){
    //             row.set(j, triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
    //         }
    //         triangle.add(row);
    //     }
    //     return triangle;
    // }

    // public List<Long> getPascall(int n){
    //     List<Long> row = new ArrayList<>();
    //     long val = 1;
    //     row.add(val);

    //     for(int k=1; k<n; k++){
    //         val = val*(n-k)/k;
    //         row.add(val);
    //     }
    //     return row;
    // }

    /*
     * Time Complexity: O(min(c,r−c)), The loop runs for min(c−1,r−c) iterations
     * because binomial coefficients are symmetric.
     * Space Complexity: O(1), constant additional space is used.
     */
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
        // PascalTriangle pass = new PascalTriangle();
        // int k = 5;
        // List<List<Integer>> result = pass.generate(k);
        // for(List<Integer> row : result){
        //     for(Integer val : row){
        //         System.out.print(val + " ");
        //     }
        //     System.out.println();
        // }

        // int n = 6;
        // PascalTriangle pass = new PascalTriangle();
        // List<Long> result = pass.getPascall(n);
        // for(long num : result){
        //     System.out.print(num + " ");
        // }

        PascalTriangle pass = new PascalTriangle();
        int r = 5;
        int c = 3;
        System.out.println(pass.findPascal(r, c));
    }
}
