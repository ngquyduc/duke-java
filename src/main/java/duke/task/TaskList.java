package duke.task;

import java.util.ArrayList;

import duke.DukeException;

/**
 * A list to store tasks.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Constructor for <code>TaskList</code>.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructor for <code>TaskList</code>.
     * @param tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Add a task to the task list.
     * @param task
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Get a task with specific index from the task list.
     * @param index
     * @return
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Mark a task with the given index as done.
     * @param index
     */
    public void markDone(int index) throws DukeException {
        try {
            tasks.get(index).markDone();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Baa! I need a valid task number.");
        }
    }

    /**
     * Unmark a task with the given index.
     * @param index
     */
    public void unmarkDone(int index) throws DukeException{
        try {
            tasks.get(index).unmarkDone();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Baa! I need a valid task number.");
        }
    }

    /**
     * Delete a task with the given index from the task list.
     * @param index
     * @return
     */
    public Task removeTask(int index) throws DukeException{
        try {
            return tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Baa! I need a valid task number.");
        }
    }

    /**
     * Count the number of tasks in the task list.
     * @return
     */
    public int getNumberOfTasks() {
        return tasks.size();
    }

    /**
     * Find all the tasks having the given keyword in their descriptions.
     * @param keyword
     * @return TaskList containing all matched tasks.
     */
    public TaskList findTasks(String keyword) {
        TaskList matches = new TaskList();
        for (int i = 0; i < getNumberOfTasks(); i++) {
            Task currentTask = getTask(i);
            if (currentTask.match(keyword)) {
                matches.addTask(currentTask);
            }
        }
        return matches;
    }

    /**
     * Convert a task with given index to a String to store with Storage.
     * @param index
     * @return
     */
    public String convertTaskToMemoryString(int index) {
        return tasks.get(index).toMemoryString();
    }

    /**
     * String representative of TaskList.
     * @return
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < getNumberOfTasks(); i++) {
            String count = (i + 1) + ". ";
            if (i == 0) {
                str += count + tasks.get(i).toString();
            } else {
                str += "\n" + count + tasks.get(i).toString();
            }
        }
        return str;
    }
}
