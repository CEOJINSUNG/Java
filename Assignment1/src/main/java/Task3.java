import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        // ======================= Task 3 Start =======================

        // Declare Scanner Object for input
        Scanner scanner = new Scanner(System.in);

        // Declare number, power of above number variable for input
        // number is first argument
        int number;
        // powerOfNumber is second argument for knowing whether this is number's exponential or not
        int powerOfNumber;

        // Declare power, output variable for output
        int power = 0;
        boolean output = true;

        // Get Values from User
        System.out.print("Enter the number: ");
        number = scanner.nextInt();
        System.out.print("Enter your guessed power of above number: ");
        powerOfNumber = scanner.nextInt();

        // Calculate whether guessed number is power of number.
        int remain = powerOfNumber%number;

        // If remain is zero, guessed number consist of number.
        // If not, guessed number is not power of number.
        while (remain == 0) {
            // Divide powerOfNumber using number and increase power until powerOfNumber becomes 1
            powerOfNumber /= number;
            power += 1;

            // if powerOfNumber != 1, re-calculate remain
            // if powerOfNumber == 1, break the while format
            if (powerOfNumber != 1) {
                remain = powerOfNumber % number;
            } else {
                break;
            }
        }

        // if remain is not zero, output should be false
        if (remain != 0) {
            output = false;
        }

        // print the result depending on whether output is false or true.
        System.out.println("=======================");
        if (output) {
            System.out.println("power = " + power);
            System.out.println("Output: " + output);
        } else {
            System.out.println("Output: " + output);
        }

        // ======================= Task 3 End =======================
    }

}
