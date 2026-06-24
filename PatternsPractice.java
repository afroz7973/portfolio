



public class PatternsPractice {
    // public static void rectangle(int n){

    // for(int i=0; i<n; i++){
    // for(int j=0; j<n; j++){
    // System.out.print("* ");
    // }
    // System.out.println();
    // }
    // }

    // public static void trinagle(int n){
    // for(int i=0; i<=n; i++){
    // for(int j=0; j<=i; j++){
    // System.out.print("* ");
    // }
    // System.out.println();
    // }
    // }

    // public static void numberPyramid(int n){
    // for(int i=1; i<=n; i++){
    // for(int j=1; j<=i; j++){
    // System.out.print(j+" ");
    // }
    // System.out.println();
    // }
    // }

    // public static void numberPyraII(int n){
    // for(int i=1; i<=n; i++){
    // for(int j=1; j<=i; j++){
    // System.out.print(i+" ");
    // }
    // System.out.println();
    // }
    // }

    // public static void pyramidInverted(int n){
    // for(int i=0; i<=n; i++){
    // for(int j=1; j<n-i+1; j++){
    // System.out.print("* ");
    // }
    // System.out.println();
    // }
    // }

    // public static void numberPyramid(int N){
    // for(int i=1; i<N; i++){
    // for(int j=1; j<=N-i+1; j++){
    // System.out.print(j+" ");
    // }
    // System.out.println();
    // }
    // }

    // public static void pyramidTriangle(int N){
    // for(int i=0; i<N; i++){
    // // for space
    // for(int j=0; j<N-i-1; j++){
    // System.out.print(" ");
    // }
    // // for star
    // for(int j=0; j< 2*i+1; j++){
    // System.out.print("*");
    // }
    // // for space
    // for(int j=0; j<N-i-1; j++){
    // System.out.print(" ");
    // }
    // System.out.println();
    // }
    // }

    // public static void revStar(int N){
    // for(int i=0; i<N; i++){
    // // space
    // for(int j=0; j<i; j++){
    // System.out.print(" ");
    // }
    // // star
    // for(int j=0; j<2*N-(2*i+1); j++){
    // System.out.print("*");
    // }
    // // space
    // for(int j=0; j<i; j++){
    // System.out.print(" ");
    // }
    // System.out.println();
    // }
    // }

    // public static void triangleBinary(int N){
    //     for(int i=0; i<N; i++){
    //         int star = 1;
    //         if(i%2 == 0) star = 1;
    //         else star = 0;
    //         for(int j=0; j<=i; j++){
    //             System.out.print(star);
    //             star = 1-star;
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void patternCrown(int N){
    //     int space = 2*(N-1);
    //     for(int i=1; i<=N; i++){
    //         // number
    //         for(int j=1; j<=i; j++){
    //             System.out.print(j);
    //         }
    //         // space
    //         for(int j=1; j<=space; j++){
    //             System.out.print(" ");
    //         }
    //         // number
    //         for(int j=i; j>=1; j--){
    //             System.out.print(j);
    //         }
    //         System.out.println();
    //         space -= 2;
    //     }
    // }

    // public static void incNumTriangle(int N){
    //     int num = 1;
    //     for(int i=1; i<=N; i++){
    //         for(int j=1; j<=i; j++){
    //             System.out.print(num+" ");
    //             num = num+1;
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void incLatterPattern(int N){
    //     for(int i=0; i<=N; i++){
    //         for(char ch='A'; ch<='A'+i; ch++){
    //             System.out.print(ch+" ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void revLetterPatt(int N){
    //     for(int i=0; i<=N; i++){
    //         for(char ch='A'; ch<='A'+N-i-1; ch++){
    //             System.out.print(ch+" ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void AlphaRamp(int N){
    //     for(int i=0; i<=N; i++){
    //         char ch = (char)('A'+i);
    //         for(int j=0; j<=i; j++){
    //             System.out.print(ch+" ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void alphaHill(int N){
    //     for(int i=0; i<N; i++){
    //         // space
    //         for(int j=0; j<N-i-1; j++){
    //             System.out.print(" ");
    //         }
    //         // character
    //         char ch = (char)('A');
    //         int breakPoints = (2*i+1)/2;
    //         for(int j=1; j<=2*i+1; j++){
    //             System.out.print(ch);
    //             if(j<=breakPoints) ch++;
    //             else ch--;
    //         }
    //         // space
    //         for(int j=0; j<N-i-1; j++){
    //             System.out.print(" ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void alphaTriangle(int N){
    //     for(int i=0; i<N; i++){
    //         for(char ch = (char)('E'-i); ch<='E'; ch++){
    //             System.out.print(ch+" ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void symmetricVoid(int N){
    //     int iniSp = 0;
    //     for(int i=0; i<=N; i++){
    //         // star
    //         for(int j=1; j<=N-i; j++){
    //             System.out.print("*");
    //         }
    //         // space
    //         for(int j=0; j<=iniSp; j++){
    //             System.out.print(" ");
    //         }
    //         // star
    //         for(int j=1; j<=N-i; j++){
    //             System.out.print("*");
    //         }
    //         iniSp += 2;
    //         System.out.println();
    //     }
    //     iniSp = 2*N-2;
    //     for(int i=1; i<=N; i++){
    //         for (int j = 1; j <=  i; j++) {
    //             System.out.print("*");
    //         }
    //         // space
    //         for (int j = 0; j <= iniSp; j++) {
    //             System.out.print(" ");
    //         }
    //         // star
    //         for (int j = 1; j <=  i; j++) {
    //             System.out.print("*");
    //         }
    //         iniSp -= 2;
    //         System.out.println();
    //     }
    // }

    // public static void symmetricButterfly(int N){
    //     int spaces = 2*N-2;
    //     for(int i=1; i<=2*N-1; i++){
    //         int star = i;
    //         if(i>N) star = 2*N-i;
    //         // star
    //         for(int j=1; j<=star; j++){
    //             System.out.print("*");
    //         }
    //         // space
    //         for(int j=1; j<=spaces; j++){
    //             System.out.print(" ");
    //         }
    //         // star
    //         for(int j=1; j<=star; j++){
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //         if(i<N) spaces -= 2;
    //         else spaces += 2;

    //     }
    // }

    // public static void HallowRectangle(int N){
    //     for(int i=0; i<N; i++){
    //         for(int j=0; j<N; j++){
    //             if(i==0 || j==0 || i==N-1 || j==N-1){
    //                 System.out.print("*");
    //             }
    //             else System.out.print(" ");
    //         }
    //         System.out.println();
    //     }
    // }

    public static void NumberPattern(int N){
        for(int i=0; i<2*N-1; i++){
            for(int j=0; j<2*N-1; j++){
                int top = i;
                int left = j;
                int right = (2*N-2)-j;
                int down = (2*N-2)-i;
                System.out.print(N-Math.min(Math.min(top, down),Math.min(left, right)));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // int n = 5;
        // trinagle(n);
        // int n = 5;
        // numberPyramid(n);
        // int n = 5;
        // numberPyraII(n);
        // int n = 5;
        // pyramidInverted(n);
        // int N = 5;
        // numberPyramid(N);
        // int N = 5;
        // starPyramid(N);
        // int N = 6;
        // pyramidTriangle(N);
        // int N = 6;
        // pyramidTriangle(N);
        // revStar(N);
        // int N = 6;
        // halfDiamond(N);
        // int N = 6;
        // diamondHalf(N);
        // int N = 5;
        // binaryTriangle(N);
        // int N = 5;
        // crownPattern(N);
        // int N = 5;
        // triangleBinary(N);
        // int N = 5;
        // patternCrown(N);
        // int N=5;
        // incNumTriangle(N);
        // int N = 5;
        // incLatterPattern(N);
        // int N = 5;
        // revLetterPatt(N);
        // int N = 5;
        // AlphaRamp(N);
        // int N = 5;
        // alphaHill(N);
        // int N = 5;
        // alphaTriangle(N);
        // int N = 5;
        // symmetricVoid(N);
        // int N = 5;
        // symmetricButterfly(N);
        // int N = 6;
        // HallowRectangle(N);
        int N =4;
        NumberPattern(N);
    }
}
