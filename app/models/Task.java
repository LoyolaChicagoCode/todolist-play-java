package models;

import java.util.*;

import play.data.validation.Constraints.*;

public class Task {

    public Long id;

    @Required
    public String label;

    /**
     * Simple in-memory store for Task objects.
     */
    private final static List<Task> tasks = new LinkedList<Task>();

    //
    private static long currId = 0;

    /**
     * Simple unique ID generator for Task objects.
     * @return the unique ID
     */
    private static long nextId() {
        return ++currId;
    }

    public static List<Task> all() {
        return tasks;
    }

    public static void create(final Task task) {
        task.id = nextId();
        tasks.add(task);
    }

    public static void delete(final Long id) {
        final Iterator<Task> i = tasks.iterator();
        while (i.hasNext()) {
            if (i.next().id == id) {
                i.remove();
            }
        }
    }

}