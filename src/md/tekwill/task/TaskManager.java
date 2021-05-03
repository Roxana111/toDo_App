package md.tekwill.task;

public class TaskManager {
    private TaskStorage taskStorage;

    public TaskManager() {
        taskStorage = new TaskStorage();

    }

    public Task[] getAll() {
        return taskStorage.findAll();
    }

    public void add(Task newTask) {
        Task existingTask = taskStorage.findById(newTask.getId());
        if (existingTask == null) {
            taskStorage.create(newTask);
        } else {
            System.out.println("A task with this ID already exists, thus this one cannot be added \u2639");
        }
    }

    public void delete(int index) {
        Task existingTask = taskStorage.findById(index);
        if (existingTask != null) {
            taskStorage.removeById(index);
        }
    }

    public void update(int index, boolean value) {
        Task existingTask = taskStorage.findById(index);
        if (existingTask != null) {
            existingTask.setDone(value);
        }
    }

}
