import java.time.LocalTime;
import java.util.List;
import java.lang.*;

class Event {
    private int startHours;
    private int endHours;
    private int startMinutes;
    private int endMinutes;

    public int getStartHours() {
        return startHours;
    }

    public void setStartHours(int startHours) {
        this.startHours = startHours;
    }

    public int getEndHours() {
        return endHours;
    }

    public void setEndHours(int endHours) {
        this.endHours = endHours;
    }

    public int getStartMinutes() {
        return startMinutes;
    }

    public void setStartMinutes(int startMinutes) {
        this.startMinutes = startMinutes;
    }

    public int getEndMinutes() {
        return endMinutes;
    }

    public void setEndMinutes(int endMinutes) {
        this.endMinutes = endMinutes;
    }

    public Event(int startHours, int startMinutes, int endHours, int endMinutes) {
        this.startHours = startHours;
        this.endHours = endHours;
        this.startMinutes = startMinutes;
        this.endMinutes = endMinutes;
    }


    public LocalTime getStartTime() {
        return LocalTime.of(startHours, startMinutes);
    }

    public LocalTime getEndTime() {
        return LocalTime.of(endHours, endMinutes);
    }


    @Override
    public String toString() {
        return "Event{" +
                "startHours=" + startHours +
                ", endHours=" + endHours +
                ", startMinutes=" + startMinutes +
                ", endMinutes=" + endMinutes +
                '}';
    }
}

public class EventMain {
    public static void main(String[] args) {
        List<Event> timeList1 = List.of(
                new Event(10, 30, 11, 30),
                new Event(12, 0, 12, 15),
                new Event(15, 10, 15, 30),
                new Event(16, 30, 17, 0)
        );
        List<Event> timeList2 = List.of(
                new Event(7, 30, 8, 30),
                new Event(12, 10, 12, 45),
                new Event(18, 30, 18, 45)
        );
        if (hasOverlap(timeList1)) {
            System.out.println("timeList1 has overlapping events within itself.");
        } else {
            System.out.println("timeList1 does not have overlapping events within itself.");
        }

        if (hasOverlap(timeList2)) {
            System.out.println("timeList2 has overlapping events within itself.");
        } else {
            System.out.println("timeList2 does not have overlapping events within itself.");
        }

        if (hasOverlapBetweenLists(timeList1, timeList2)) {
            System.out.println("timeList1 and timeList2 have overlapping events between them.");
        } else {
            System.out.println("timeList1 and timeList2 do not have overlapping events between them.");
        }
    }


    public static boolean hasOverlap(List<Event> events) {
        for (int i = 0; i < events.size() - 1; i++) {
            for (int j = i + 1; j < events.size(); j++) {
                Event event1 = events.get(i);
                Event event2 = events.get(j);

                if (event1.getStartTime().isBefore(event2.getEndTime()) &&
                        event2.getStartTime().isBefore(event1.getEndTime())) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean hasOverlapBetweenLists(List<Event> list1, List<Event> list2) {
        for (Event event1 : list1) {
            for (Event event2 : list2) {
                if (event1.getStartTime().isBefore(event2.getEndTime()) &&
                        event2.getStartTime().isBefore(event1.getEndTime())) {
                    return true;
                }
            }
        }
        return false;
    }
}







