package animalShelter;

import java.time.LocalDate;

public class AvailableTimeSlot {
    private LocalDate date;
    private String time;

    public AvailableTimeSlot(LocalDate date, String time) {
        this.date = date;
        this.time = time;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        if(time == "AM")
            return date + " " + "9:00 " + time;
        else
            return date + " " + "1:00 " + time;
    }
}
