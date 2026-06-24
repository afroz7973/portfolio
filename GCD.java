public class GCD {
    // public static void gcdFind(int a, int b){
    //     while(a>0 && b>0){
    //         if(a>b) {
    //             a=a%b;
    //         }
    //         else{
    //             b=b%a;
    //         }
    //     }
    //     if(a == 0){
    //         System.out.println(b);
    //     }
    //     else{
    //         System.out.println(a);
    //     }
    // }

    // it's using Euclidean Algorithm
    public static int findGCD(int a, int b){
        while(a>0 && b>0 ){
            if(a>b){
                a = a%b;
            }
            else{
                b = b%a;
            }
        }
        if(a == 0){
            return b;
        }
        else{
            return a;
        }
    }
    public static void main(String[] args) {
        // int a = 36;
        // int b = 60;
        // gcdFind(a, b);
        int a = 20;
        int b = 15;
        int gdc = findGCD(a, b);
        System.out.println("GCD of " + a +" and " + b +" is: "+ gdc);
    }
}
