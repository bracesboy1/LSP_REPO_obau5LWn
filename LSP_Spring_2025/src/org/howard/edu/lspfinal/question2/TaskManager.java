package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages a collection of tasks, supports adding, retrieving,
 * updating, and printing tasks grouped by their status.
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task. Task names must be unique.
     *
     * @param name     Task name
     * @param priority Task priority (lower = higher)
     * @param status   Task status ("TODO", "IN_PROGRESS", "DONE")
     * @throws DuplicateTaskException if a task with the same name exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     *
     * @param name Task name
     * @return the corresponding Task
     * @throws TaskNotFoundException if the task is not found
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!tasks.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return tasks.get(name);
    }

    /**
     * Updates the status of a task.
     *
     * @param name   Task name
     * @param status New status
     * @throws TaskNotFoundException if the task is not found
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(status);
    }

    /**
     * Prints all tasks grouped by their status.
     */
    public void printTasksGroupedByStatus() {
        Map<String, List<Task>> grouped = new HashMap<>();
        grouped.put("TODO", new ArrayList<>());
        grouped.put("IN_PROGRESS", new ArrayList<>());
        grouped.put("DONE", new ArrayList<>());

        for (Task task : tasks.values()) {
            grouped.get(task.getStatus()).add(task);
        }

        System.out.println("Tasks grouped by status:");
        for (String status : grouped.keySet()) {
            System.out.println(status + ":");
            for (Task task : grouped.get(status)) {
                System.out.println("  " + task);
            }
        }
    }
}

