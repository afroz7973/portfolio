public class Patterns {
    public static void pattern(int N) {

        // Pattern-1: Rectangular Star Pattern

        // for(int i=0; i<N; i++){
        // for(int j=0; j<N; j++){
        // System.out.print("* ");
        // }
        // System.out.println();
        // }

        // Pattern-2: Right-Angled Triangle Pattern
        // for(int i=0; i<N; i++){
        // for(int j=0;j<=i; j++){
        // System.out.print("* ");
        // }
        // System.out.println();
        // }
        // }

        // Pattern - 3: Right-Angled Number Pyramid

        // for(int i=1; i<=N; i++){
        // for(int j=1; j<=i; j++){
        // System.out.print(j+" ");
        // }
        // System.out.println();
        // }

        // Pattern - 4: Right-Angled Number Pyramid - II

        // for(int i=1; i<=N; i++){
        // for(int j=1; j<=i; j++){
        // System.out.print(i+" ");
        // }
        // System.out.println();
        // }

        // Pattern-5: Inverted Right Pyramid

        // for(int i=1; i<=N; i++){
        // for(int j=0; j<N-i+1;j++){
        // System.out.print("* ");
        // }
        // System.out.println();
        // }

        // Pattern - 6: Inverted Numbered Right Pyramid

        // for(int i=0; i<=N; i++){
        // for(int j=1; j<N-i+1; j++){
        // System.out.print(j+" ");
        // }
        // System.out.println();
        // }

        // Pattern - 7: Star Pyramid
        // for(int i=0; i<N; i++){
        // // space
        // for(int j=0; j<N-i-1; j++){
        // System.out.print(" ");
        // }
        // // star
        // for(int j=0; j< 2*i+1; j++){
        // System.out.print("*");
        // }
        // // space
        // for(int j=0; j<N-i-1; j++){
        // System.out.print(" ");
        // }
        // System.out.println();
        // }

        // Pattern - 8: Inverted Star Pyramid

        // for(int i=0; i<N; i++){
        // //space
        // for(int j=0; j<i; j++){
        // System.out.print(" ");
        // }
        // // star
        // for(int j=0; j<2*N-(2*i+1);j++){
        // System.out.print("*");
        // }
        // // space
        // for(int j=0; j<i; j++){
        // System.out.print(" ");
        // }
        // System.out.println();
        // }

        // Pattern - 10: Half Diamond Star Pattern

        // for(int i=1; i<2*N-1; i++){
        // int stars = i;
        // if(i > N) stars = 2*N-i;
        // for(int j=1; j<stars; j++){
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // Pattern - 11: Binary Number Triangle Pattern

        // for(int i=0; i<N; i++){
        //     int starts = 1;
        //     if(i % 2 == 0) starts = 1;
        //     else starts = 0;
        //     for(int j=0; j<=i; j++){
        //         System.out.print(starts);
        //         starts = 1-starts;
        //     }
        //     System.out.println();
        // }

        // Pattern - 12: Number Crown Pattern
        // int space = 2*(N-1);
        // for(int i=1; i<=N; i++){
        //     // number
        //     for(int j=1; j<=i; j++){
        //         System.out.print(j);
        //     }
        //     // space
        //     for(int j=1; j<=space; j++){
        //         System.out.print(" ");
        //     }
        //     // number
        //     for(int j=i; j>=1; j--){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        //     space -= 2;
        // }

        // Pattern - 13: Increasing Number Triangle Pattern

        // int num = 1;
        // for(int i=1; i<=N; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print(num+" ");
        //         num += 1;
        //     }
        //     System.out.println();
        // }

        // Pattern-14: Increasing Letter Triangle Pattern

        // for(int i = 0; i<=N; i++){
        //     for(char ch = 'A'; ch<='A'+i; ch++){
        //         System.out.print(ch);
        //     }
        //     System.out.println();
        // }

        // Pattern-15: Reverse Letter Triangle Pattern

        // for(int i=0; i<=N; i++){
        //     for(char ch='A'; ch<='A'+N-i-1; ch++){
        //         System.out.print(ch+" ");
        //     }
        //     System.out.println();
        // }

        // Pattern - 16: Alpha-Ramp Pattern

        // for(int i=0; i<N; i++){
        //     char ch = (char) ('A'+i);
        //     for(int j=0; j<=i; j++){
        //         System.out.print(ch+" ");
        //     }
        //     System.out.println();
        // }

        // Pattern - 17: Alpha-Hill Pattern


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
    // Pattern-18: Alpha-Triangle Pattern

        // for(int i=0; i<N; i++){
        //     for(char ch = (char)('E'-i); ch<='E'; ch++){
        //         System.out.print(ch+" ");
        //     }
        //     System.out.println();
        // }

        // Pattern-19: Symmetric-Void Pattern

        // int iniSp = 0;
        // for(int i=0; i<N; i++){
        //     // stars
        //     for(int j=1; j<=N-i; j++){
        //         System.out.print("*");
        //     }
        //     // space
        //     for(int j=0; j<iniSp; j++){
        //         System.out.print(" ");
        //     }
        //     // stars
        //     for(int j=1; j<=N-i; j++){
        //         System.out.print("*");
        //     }
        //     iniSp += 2;
        //     System.out.println();
        // }

        //  iniSp = 2*N-2;
        //  for(int i=1; i<=N; i++){
        //      for (int j = 1; j <=i; j++) {
        //          System.out.print("*");
        //      }
        //      // space
        //      for (int j = 0; j < iniSp; j++) {
        //          System.out.print(" ");
        //      }
        //      // stars
        //      for (int j = 1; j <= i; j++) {
        //          System.out.print("*");
        //      }
        //      iniSp -= 2;
        //      System.out.println();
        //  }

        // Pattern - 20: Symmetric-Butterfly Pattern

        // int spaces = 2*N-2;
        // for(int i=1; i<=2*N-1; i++){
        //     int stars = i;
        //     if(i>N) stars = 2*N-i;
        //     // star
        //     for(int j=1; j<=stars; j++){
        //         System.out.print("*");
        //     }
        //     // space
        //     for(int j=1; j<=spaces; j++){
        //         System.out.print(" ");
        //     }
        //     // star
        //     for(int j=1; j<=stars; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        //     if(i<N) spaces -= 2;
        //     else spaces +=2;
        // }

        // Pattern - 21: Hollow Rectangle Pattern

        // for(int i=0; i<N; i++){
        //     for(int j=0; j<N; j++){
        //         if(i==0 || j==0 || i==N-1 || j==N-1){
        //             System.out.print("*");
        //         }
        //         else System.out.print(" ");
        //     }
        //     System.out.println();
        // }
        
        // Pattern - 22: The Number Pattern

        for(int i=0; i<2*N-1; i++){
            for(int j=0; j<2*N-1; j++){
                int top = i;
                int left = j;
                int right = (2*N-2)-j;
                int down = (2*N-2)-i;
                System.out.print(N-Math.min(Math.min(top, down), Math.min(left, right)));
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int N = 4;
        pattern(N);
    }
}
