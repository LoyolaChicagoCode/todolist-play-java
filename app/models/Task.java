package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Task extends Model {

    @Id
    public Long id;

    @Required
    public String label;

    /**
     * Repository for Java Persistence API (JPA).
     */
    public static Finder<Long, Task> find = new Finder(
            Long.class, Task.class
    );

    public static List<Task> all() {
        return find.all();
    }

    public static void create(final Task task) {
        task.save();
    }

    public static void delete(final Long id) {
        find.ref(id).delete();
    }
}
