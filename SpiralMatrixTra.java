
import java.util.ArrayList;
import java.util.List;



public class SpiralMatrixTra {
    // time complexity: O(m*n) since all elements are being traversed at once and there are total n*m elements
    // public static List<Integer> spiralMat(int[][] mat) {
    //     List<Integer> ans = new ArrayList<>();
    //     int n = mat.length;
    //     int m = mat[0].length;
    //     int top = 0, left = 0, bottom = n - 1, right = m - 1;
    //     while (top <= bottom && left <= right) {
    //         for (int i = left; i <= right; i++)
    //             ans.add(mat[top][i]);
    //         top++;

    //         for (int i = top; i <= bottom; i++)
    //             ans.add(mat[i][right]);
    //         right--;

    //         if (top <= bottom) {
    //             for (int i = right; i >= left; i--)
    //                 ans.add(mat[bottom][i]);
    //             bottom--;
    //         }
    //         if (left <= right) {
    //             for (int i = bottom; i >= top; i--)
    //                 ans.add(mat[i][left]);
    //             left++;
    //         }
    //     }
    //     return ans;
    // }

    public static List<Integer> printSpiral(int[][] matrixx){
        List<Integer> ans = new ArrayList<>();
        int n = matrixx.length;
        int m = matrixx[0].length;
        int top=0,left=0,bottom=n-1,right=m-1;
        while(top <= bottom && left <= right){
            for(int i=left; i<=right; i++){
                ans.add(matrixx[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++){
                ans.add(matrixx[i][right]);
            }
            right--;
            if(top <= bottom){
                for(int i=right; i>=left; i--){
                    ans.add(matrixx[bottom][i]);
                }
                bottom--;
                if(left <= right){
                    for(int i=bottom; i>=top; i--){
                        ans.add(matrixx[i][left]);
                    }
                    left++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        // List<Integer> ans = spiralMat(mat);
        // for (int i = 0; i < ans.size(); i++) {
        //     System.out.print(ans.get(i) + " ");
        // }
        // System.out.println();

        int matrixx[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> ans = printSpiral(matrixx);
        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
    }
}
