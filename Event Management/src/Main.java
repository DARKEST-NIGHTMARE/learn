import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java .util.*;
public class Main {
    private static EventManage em = new EventManage();
    static Scanner ns = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = ns.nextLine();
            switch (choice) {
                case "1":
                    addEvent();
                    break;
                case "2":
                    viewUpcoming();
                    break;
                case "3":
                    viewAllEvents();
                    break;
                case "4":
                    System.out.println("exiting");
                default:
                    System.out.println("Invalid input");

            }
        }
    }

    private static void showMenu() {
        System.out.println("--- Event Management Menu ---");
        System.out.println("1. Add a new event");
        System.out.println("2. View upcoming events");
        System.out.println("3. View all events");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }


    private static void addEvent() {
        System.out.println("Enter event name");
        String name = ns.nextLine();
        System.out.println("Enter event date (YYYY-MM-DD) format");
        String tempDate = ns.nextLine();
        try {
            LocalDate date = LocalDate.parse(tempDate);
            em.addEvent(name, date);

        } catch (DateTimeParseException e) {
            System.out.println("Invalid format, enter in proper format");
        }
    }

    private static void viewUpcoming() {
        System.out.println("**********Upcoming events********");
        List<Event> upcomingEvents = em.getUpcoming();
        if ((upcomingEvents.isEmpty())) {
            System.out.println("no events upcoming");
        } else {
            upcomingEvents.forEach(System.out::println);
        }
    }

    private static void viewAllEvents() {
        System.out.println("All events");
        List<Event> allEvent = em.getAllEvents();
        if (allEvent.isEmpty()) {
            System.out.println("no events");

        } else {
            allEvent.forEach(System.out::println);
        }
    }
}
