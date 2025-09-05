import java.time.LocalDate;
import java.util.*;
public class EventManage {
    private List<Event> events;
    public EventManage(){
        this.events= new ArrayList<>();
    }
    public void addEvent(String name,LocalDate date){
        events.add(new Event(name,date));
        System.out.println("Event: "+name+" added successfully");
    }
    public List<Event> getUpcoming(){
        List<Event>upcomingEvents = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate twoDays = today.plusDays(2);
        for(Event event:events){
            Boolean isUpcoming = event.getDate().isAfter(today.minusDays(1))
                    &&event.getDate().isBefore(twoDays.plusDays(1));
            if(isUpcoming){
                upcomingEvents.add(event);
            }
        }
        return upcomingEvents;
    }
    public List<Event> getAllEvents(){
        return events;
    }

}
