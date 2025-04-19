package org.example.structural.composite;

import java.util.List;

public class Composite {
    public static void main(String[] args) {
        Task compositeTask = new TaskList("Complex Task", List.of(
                new SimpleTask("Simple Task 1"),
                new SimpleTask("Simple Task 2")
        ));

        display(new SimpleTask("Simple Task"));
        System.out.println("...........");
        display(compositeTask);


    }

    private static void display(Task task) {
        task.display();
    }
}

interface Task {
    String getTitle();
    void display();
}

class SimpleTask implements Task {
    private final String title;

    SimpleTask(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void display() {
        System.out.println(title);
    }
}

class TaskList implements Task {
    private final String title;
    private final List<Task> taskList;

    TaskList(String title, List<Task> taskList) {
        this.title = title;
        this.taskList = taskList;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void display() {
        System.out.println("Task List: " + title);
        for (var task : taskList) {
            task.display();
        }
    }
}
