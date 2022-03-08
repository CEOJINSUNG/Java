import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        // ======================= Task 2 Start =======================

        // Declare Scanner Object for input
        Scanner scanner = new Scanner(System.in);

        // Declare day, money, savings variable
        int day;
        int money = 2000;
        int totalSaving = 0;

        // Request number of days
        System.out.print("Enter number of days: ");
        day = scanner.nextInt();

        // a means week
        int a = day/7;

        // b means remain days
        int b = day%7;

        // if day is over 7, consider a & b. if not? only consider the b for calculating savings
        if (day >= 7) {
            // After one week, savings and money will increase
            for (int i = 0; i < a; i++) {
                totalSaving += (7 * money);
                // After one week, money change
                money += 1000;
            }

            totalSaving += (b * money);
        } else {
            totalSaving += (b * money);
        }

        // After Calculating money, Print the total saving money
        System.out.println("=======================");
        System.out.println("Jin's total savings after " + day + " days: " + String.format("%.2f", (float) totalSaving) + " won");

        // ======================= Task 2 End =======================
    }

}
