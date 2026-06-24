
import java.util.Scanner;



public class Basics {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter the number:");
    //     int num = sc.nextInt();
    //     System.out.println("You have entered: "+num);

    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the age: ");
        int age = sc.nextInt () ;
        if(age < 18){
            System.out.println("Not eligible for job.");
        }
        else if(age >= 18 && age <= 54){
            System.out.println("Eligible for job");
        }
        else if (age >= 55 && age <= 57) {
            System.out.println("Eligible for job, but retirement soon.");
        }
        else if(age > 57){
            System.out.println("retirement time...");
        }

    }
}
