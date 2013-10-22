package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

import play.data.validation.Constraints.*;

@Entity
public class Task extends Model {

    @Id
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

    /**
     * Repository for Java Persistence API (JPA).
     */
    public static Finder<Long, Task> find = new Finder(
            Long.class, Task.class
    );

    public static List<Task> all() {
//        return tasks;
        return find.all();
    }

    public static void create(final Task task) {
//        task.id = nextId();
//        tasks.add(task);
        task.save();
    }

    public static void delete(final Long id) {
//        final Iterator<Task> i = tasks.iterator();
//        while (i.hasNext()) {
//            if (i.next().id == id) {
//                i.remove();
//            }
//        }
        find.ref(id).delete();
    }

}