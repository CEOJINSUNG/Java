import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        // ======================= Task 2 Start =======================

        // Declare Scanner Object for input
        Scanner scanner = new Scanner(System.in);

        // Declare day, money, savings variable
        // total days for savings
        int day;
        // first week money 2000, every week money will be increased 1000
        int money = 2000;
        // this is total money of savings and will be printed out
        int totalSaving = 0;

        // Request number of days
        System.out.print("Enter number of days: ");
        day = scanner.nextInt();

        // week is calculated by day/7
        int week = day/7;

        // remain means day%7
        int remain = day%7;

        // if day is over 7, consider week & remain. if not? only consider the remain for calculating savings
        if (day >= 7) {
            // After one week, savings and money will increase
            for (int i = 0; i < week; i++) {
                totalSaving += (7 * money);
                // After one week, money change
                money += 1000;
            }

            // finally, add the remain money
            totalSaving += (remain * money);
        } else {
            // just add remain money
            totalSaving += (remain * money);
        }

        // After Calculating money, Print the total saving money
        System.out.println("=======================");
        System.out.println("Jin's total savings after " + day + " days: " + String.format("%.2f", (float) totalSaving) + " won");

        // ======================= Task 2 End =======================
    }

}
