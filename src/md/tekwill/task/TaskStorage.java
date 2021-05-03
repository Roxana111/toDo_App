package md.tekwill.task;

import java.util.Arrays;

class TaskStorage {
    private Task[] allTasks;

    public TaskStorage() {
        allTasks = new Task[0];
    }

    public Task[] findAll() {
        return allTasks;
    }

    public Task findById(int id) {
        Task task = null;
        for (int i = 0; i < allTasks.length; i++) {
            Task temp = allTasks[i];
            if (temp.getId() == id) {
                task = temp;
                break;
            }
        }
        return task;
    }

    public void create(Task task) {
        Task[] extendedArray = Arrays.copyOf(allTasks, allTasks.length + 1);
        extendedArray[extendedArray.length - 1] = task;
        allTasks= extendedArray;
    }
    public void removeById(int index){
        for (int i = 0; i < allTasks.length; i++) {
            Task task=allTasks[i];
            if(task.getId()==index){
                allTasks[i]=allTasks[allTasks.length-1];
            }
            allTasks=Arrays.copyOf(allTasks,allTasks.length-1);
        }
    }
    private void removeFromAllTasksByIndex(int index){

    }
}
