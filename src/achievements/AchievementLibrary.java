package achievements;

import java.util.HashMap;


public class AchievementLibrary {

    private static AchievementLibrary instance = null;
    protected HashMap<String, Achievement> achievements = new HashMap<>();

    public AchievementLibrary(){
        initAchievements();
    }

    public static AchievementLibrary getInstance()
    {
        if (instance == null)
        {
            return new AchievementLibrary();
        }
        else
        {
            return instance;
        }
    }



    public Achievement getAchievement(String achievementName) {
        return achievements.get(achievementName);
    }

    public int getAchievementRequirement(String achievementName){
        return getAchievement(achievementName).getRequiredPoints();
    }
    public int getAchievementMaxTier(String achievementName){
        return achievements.get(achievementName).getMaxTier();
    }
    public String getAchievementTitle(String achievementName){
        return achievements.get(achievementName).getTitle();
    }
    public String getAchievementDescription(String achievementName){
        return achievements.get(achievementName).getDescription();
    }

    public boolean addNewAchievement(String name, String title, String description, int requiredPoints, int maxTier){
        if(achievements.containsKey(name)){
            return false;
        }
        else{
            achievements.put(name, new Achievement(name, title, description, requiredPoints, maxTier));
        } return true;
    }

    public void initAchievements(){
        //Send a message - Times: 25 - Max Tier: 3
        addNewAchievement("sendMessage",
                     "Sender of many messages",
                "Send some messages to earn this achievement",
                25,
                    3);

        //Create a project - Times: 5 - Max Tier: 3
        addNewAchievement("createProject",
                "Good idea?",
                "Create some projects to earn this achievement",
                5,
                3);

        //Delete a project - Times: 3 - Max Tier: 3
        addNewAchievement("deleteProject",
                "Maybe not so good of an idea...",
                "Delete some of your projects to earn this achievement",
                3,
                3);

        //Create a task - Times: 10 - Max Tier: 3
        addNewAchievement("createTask",
                "So you think your a supervisor now?",
                "Create some tasks in a project to earn this achievement",
                10,
                3);
    }




}
