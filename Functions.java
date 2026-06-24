
public class Functions {
    // void printName(String name){
    //     System.out.println("Hey " + name);
    // }

    // public static int sum(int num1, int num2){
    //     int num3 = num1 + num2;
    //     return num3;
    // }

    // void something(int num){
    //     System.out.println(num);
    //     num += 5;
    //     System.out.println(num);
    //     num += 5;
    //     System.out.println(num);
    // }

    // pass by value

    public static String dosomething(String a){
        a = "s" + a.substring(1);
        return a;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the name: ");
        // String name = sc.nextLine();
        // Functions obj = new Functions();
        // obj.printName(name);
        
        // sum of two numbers

        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number1: ");
        // int num1 = sc.nextInt();
        // System.out.println("Enter the number2: ");
        // int num2 = sc.nextInt();
        // int sum = num1+num2;
        // System.out.println("The sum of two number is: "+sum);

        
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number1");
        // int num1 = sc.nextInt();
        // int num2 = sc.nextInt();
        // int res = sum(num1, num2);
        // System.out.println("The sum of two number is: "+res);


        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number1: ");
        // int num1 = sc.nextInt();
        // System.out.println("Enter the number2: ");
        // int num2 = sc.nextInt();
        // int minimum = Math.max(num2, num2);
        // System.out.println(minimum);

        // int num = 10;
        // Functions obj = new Functions();
        // obj.something(num);

        String a = "aaj";
        dosomething(a);
        a = dosomething(a);
        System.out.println(a);
    }
}
