public class PatternDiamond {
    public static void pyramid(int N){
        for(int i=0; i<N; i++){
            // space
            for(int j=0; j<N-i+1; j++){
                System.out.print(" ");
            }
            // star
            for(int j=0; j<2*i+1; j++){
                System.out.print("*");
            }
            // space
            for(int j=0; j<N-i-1; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public static void revPyramid(int N){
        for(int i=0; i<N; i++){
            // space
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            // star
            for(int j=0; j<2*N-(2*i+1); j++){
                System.out.print("*");
            }
            // space
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int N =6;
        pyramid(N);
        revPyramid(N);
    }
}
