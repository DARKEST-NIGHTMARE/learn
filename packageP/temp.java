////import java.time.LocalDate;
////import java.time.format.DateTimeParseException;
////import java.util.List;
////import java.util.Scanner;
////
////public class EventApp {
////    private static EventManager eventManager = new EventManager();
////    private static Scanner scanner = new Scanner(System.in);
////
////    public static void main(String[] args) {
////        while (true) {
////            showMenu();
////            String choice = scanner.nextLine();
////            switch (choice) {
//                case "1":
//                    addEvent();
//                    break;
//                case "2":
//                    viewUpcomingEvents();
//                    break;
//                case "3":
//                    viewAllEvents();
//                    break;
//                case "4":
//                    System.out.println("Exiting application. Goodbye!");
//                    return;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void showMenu() {
//        System.out.println("\n--- Event Management Menu ---");
//        System.out.println("1. Add a new event");
//        System.out.println("2. View upcoming events");
//        System.out.println("3. View all events");
//        System.out.println("4. Exit");
//        System.out.print("Enter your choice: ");
//    }
//
//    private static void addEvent() {
//        System.out.print("Enter event name: ");
//        String name = scanner.nextLine();
//
//        System.out.print("Enter event date (YYYY-MM-DD): ");
//        String dateString = scanner.nextLine();
//
//        try {
//            LocalDate date = LocalDate.parse(dateString);
//            eventManager.addEvent(name, date);
//        } catch (DateTimeParseException e) {
//            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
//        }
//    }
//
//    private static void viewUpcomingEvents() {
//        System.out.println("\n--- Upcoming Events ---");
//        List<Event> upcomingEvents = eventManager.getUpcomingEvents();
//        if (upcomingEvents.isEmpty()) {
//            System.out.println("No upcoming events in the next two days.");
//        } else {
//            upcomingEvents.forEach(System.out::println);
//        }
//    }
//
//    private static void viewAllEvents() {
//        System.out.println("\n--- All Events ---");
//        List<Event> allEvents = eventManager.getAllEvents();
//        if (allEvents.isEmpty()) {
//            System.out.println("No events have been added yet.");
//        } else {
//            allEvents.forEach(System.out::println);
//        }
//    }
//
//}
