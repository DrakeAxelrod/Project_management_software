package entities;

import java.time.LocalDate;
// 0.50 means 30minutes for workedHours
public class WorkedHours {
    private LocalDate logTime;
    private User user;
    private double workedHours;

    public WorkedHours(User user, double workedHours){
        LocalDate logTime=LocalDate.now();
        this.workedHours=workedHours;
        this.user = user;
    }
    
    public WorkedHours() {}

    public User getUser() {
        return user;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public String getHours() {
        return Double.toString(workedHours);
    }

    public LocalDate getLogTime() {
        return logTime;
    }
    
    public void setLogTime(LocalDate logTime) {
        this.logTime = logTime;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }
}
