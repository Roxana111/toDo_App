package md.tekwill.task;

public class Task {
    private final int id;
    private String title;
    private String description;
    private String targetDate;
    private boolean done;

    public Task(int newId, String newTitle, String newDescription, String newTargetDate) {
        id = newId;
        title=newTitle;
        description=newDescription;
        targetDate=newTargetDate;
        done=false;

    }

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return done;
    }

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getTargetDate(){
        return targetDate;
    }
    public void setDone(boolean newDone) {
        done = newDone;
    }
}
