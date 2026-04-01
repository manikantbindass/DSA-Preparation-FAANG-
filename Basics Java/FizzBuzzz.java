import java.util.Scanner;

public class FizzBuzzz {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Your Number : ");
        int N = sc.nextInt();

        int ctr3 = 0, ctr5 = 0;

        for(int i = 1; i <= N; i++) {
            ctr3++;
            ctr5++;

            if(ctr3 == 3 && ctr5 == 5) {
                System.out.println("FizzBuzz");
                ctr3 = 0;
                ctr5 = 0;
            }
            else if(ctr3 == 3) {
                System.out.println("Fizz");
                ctr3 = 0;
            }
            else if(ctr5 == 5) {
                System.out.println("Buzz");
                ctr5 = 0;
            }
            else {
                System.out.println(i);
            }
        } //closing for loop
    } // closing main method
} // closing class