//Trip Planner v1.0. Dhiganth Rao.
import java.util.Scanner;
public class TripPlanner {
    public static void main(String[] args) {
        Welcome();
        TTBudget();
        TimeDifference();
        CountryArea();
        System.out.println("Thank you for using TripPlanner. We hope you enjoyed using it!");
    }
    public static void Welcome() {
        Scanner input = new Scanner(System.in);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("Welcome to Trip Planner!");
        System.out.print("May I know your name?: ");
        String name = input.nextLine();
        System.out.print("It's very nice to meet you, " + name + "! Where do you wish to go?: ");
        String destination = input.nextLine();
        System.out.println("Lovely! " + destination + " sounds like a great place to travel to!");
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }
    public static void TTBudget() {
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you planning to spend in your destination?: " );
        int days = input.nextInt();
        System.out.print("What is your preferred currency?: ");
        String currency = input.next();
        System.out.print("What is the unit of currency in your destination?: ");
        String currency_dest = input.next();
        System.out.print("Enter your total budget for this trip, in " + currency + ": ");
        float budget = input.nextInt();
        System.out.print("How many" + currency + " are there in 1 " + currency_dest + "?:");
        float factor = input.nextFloat();
        int hours = days * 24;
        int minutes = hours * 60;
        float budget_per_day = budget / days;
        float budget_dest = budget * factor;
        float budget_dest_day = budget_dest / days;
        System.out.println("All right! Crunching up the numbers now...");
        System.out.print("You mentioned you would be staying at your destination for " + days + " days");
        System.out.println(", so that means you'd be staying for " + hours + " hours or " + minutes + " minutes!");
        System.out.println("Your budget is " + budget + currency + ", hence you can spend " + budget_per_day + currency + "per day!");
        System.out.println("Since the conversion factor is " + factor + ", your budget in " + currency_dest + " is " + budget_dest + "and you can spend " + budget_dest_day + currency_dest + "per day!");
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }
    public static void TimeDifference() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the time difference between your home and the destination: ");
        System.out.print("Difference in hours: ");
        int difference_hours = input.nextInt();
        System.out.print("Difference in minutes: ");
        int difference_minutes = input.nextInt();
        System.out.print("Enter the time in your home in hours: ");
        int hours_home = input.nextInt();
        System.out.print("Enter the time at your home in minutes: ");
        int minutes_home = input.nextInt();
        int hours_dest = hours_home + difference_hours;
        int minutes_dest = minutes_home + difference_minutes;
        if(minutes_dest > 59)
        {
            minutes_dest = minutes_dest - 60;
            hours_dest++;
        }
        if(hours_dest > 23)
        {
            hours_dest = hours_dest % 24;
        }
        System.out.println("The time in your home is: " + hours_home + ":" + minutes_home);
        System.out.print("The time difference between your home and the destination is: ");
        System.out.println(difference_hours + " hours and " + difference_minutes +" minutes");
        System.out.println("Therefore, the time at the destination is: " + hours_dest + ":" + minutes_dest);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    }
    public static void CountryArea() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the area of the destination in km^2: ");
        double area_km_2 = input.nextFloat();
        double area_miles_2 = (0.386102 * area_km_2) / 100;
        System.out.println("The area of your destination in km^2 is: " + area_km_2);
        System.out.println("The area of your destination in miles^2 is: " + area_miles_2);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");


    }
}
