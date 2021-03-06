package entities;
import budget.Budget;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@JsonDeserialize(as = Project.class)
public class Project extends Data {
    private String name;
    private String description;
    private String status; // Active/Inactive
    private LocalDate createdDate;
    private LocalDate startDate;
    private LocalDate endDate;
    protected Budget budget;
    protected TeamLibrary teamLibrary = TeamLibrary.getInstance();
    private User projectManager;
    private Team team;
    protected TaskLibrary taskList;

    public Project(String name, User projectManager, String description, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.description = description;
        this.createdDate = LocalDate.now();
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskList = new TaskLibrary();
        this.status = "";
        this.projectManager = projectManager;
        this.budget = new Budget();
        this.team = new Team(projectManager);
    }

    public Project() {
        this.team = new Team();
        this.taskList = new TaskLibrary();
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
        team.setOwner(projectManager);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(Team team) { this.team = team; }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public User getProjectManager() {return projectManager; }

    public Team getTeam() { return team; }

    public Budget getBudget() {
        return budget;
    }
    
    public void setBudget(Budget budget) {
        this.budget = budget;
    }
    
    public TaskLibrary getTaskList() {
        return taskList;
    }
    
    public long duration() {
        long daysBetween = ChronoUnit.DAYS.between(getStartDate(), getEndDate());
        return daysBetween;
    }

    public String timeLeftBeforeExceedingBudget()
    {
        return "Total Time Before Exceeding budget\n" +
                "Recommend Member to cut" // to be implemented
                + timeLeftBeforeExceedingBudget();
    }

    @Override
    public String toString() {
        return  "Name: " + name +
                "\n Description: " + description +
                "\n createdDate: " + createdDate +
                "\n startDate: " + startDate +
                "\n endDate: " + endDate +
                "\n projectManager: " + projectManager.getUserName();
    }

    //not mentioned in the user stories soooo idk
    /*
    public void updateName(){
        if(team.findTeamMember(currentUser).getRole().adminAccess()){
            Input input = Input.getInstance();
            String newDesc = input.getStr("Enter the description: ");
            setName(newDesc);
        }
        else{
            System.out.println("You are not authorized to perform this action!!");
        }

    }

    public void updateDescription(){
         if(team.findTeamMember(currentUser).getRole().adminAccess()){
            Input input = Input.getInstance();
            String newName = input.getStr("Enter the name: ");
            setDescription(newName);
        }
        else{
            System.out.println("You are not authorized to perform this action!!");
        }

    }
    */
}


