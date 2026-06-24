public class PrimeNumbers {
    // public static void checkPrime(int n){
    // int count = 0;
    // for(int i=1; i<=n; i++){
    // if(n%i == 0){
    // count++;
    // }
    // }
    // if(count == 2){
    // System.out.println("This is a Prime number.");
    // }
    // else{
    // System.out.println("This is not a Prime Number.");
    // }
    // }
    // public static void primeCheck(int n) {
    //     int count = 0;
    //     for (int i = 1; i * i <= n; i++) {
    //         if (n % i == 0) {
    //             count++;
    //             if ((n / i) != i) {
    //                 count++;
    //             }
    //         }
    //     }
    //     if(count == 2) System.out.println("True");
    //     else System.out.println("False");

    // }

    public static boolean checkPrime(int n){
        int count = 0;
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                count++;
                if(n/i!= i){
                    count++;
                }
            }
        }
        if(count == 2){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        // int n = 50;
        // checkPrime(n);
        // int n = 1483;
        // primeCheck(n);
        int n = 504;
        boolean isPrime = checkPrime(n);
        if(isPrime){
            System.out.println(n + " is a prime number ");
        }
        else{
            System.out.println(n + " is not a prime number");
        }
    }
}