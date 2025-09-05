import java.time.LocalDate;
import java.time.LocalTime;
public class Event {
    private String name;
    private LocalDate date;

public Event(String name,LocalDate date){
  this.name = name;
  this.date= date;
}

    public String getName() {
        return name;
    }
    public LocalDate getDate(){
    return date;
    }
    @Override
    public String toString(){
    return "Event:"+name+ " Date: "+date;
    }
}