import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Event {

    private String eventName;
    private String eventDescription;
    private String eventEffectExplanation;
    private double percentageChange;
    private String affectedSector;
    private String affectedCompany;



    public Event(String eventName, String eventDescription, String eventEffectExplanation, double percentageChange, String affectedSector, String affectedCompany) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventEffectExplanation = eventEffectExplanation;
        this.percentageChange = percentageChange;
        this.affectedSector = affectedSector;
        this.affectedCompany = affectedCompany;
    }


    // Getter methods:
    // Method to get event
    public String getEventName() {
        return eventName;
    }

    // Method to get event description
    public String getEventDescription() {
        return eventDescription;
    }


    // Method to get event effect explanation
    public String getEventEffectExplanation() {
        return eventEffectExplanation;
    }

    // Method to get percentage change
    public double getPercentageChange() {
        return percentageChange;
    }

    // Method to get affected sector
    public String getAffectedSector() {
        return affectedSector;
    }


    // Method to get affected company
    public String getAffectedCompany() {
        return affectedCompany;
    }











}



















    }
} 
