package Domain;

import java.util.Calendar;
import java.util.HashSet;

/**
 * Created by Joris on 3-3-2017.
 */
public class Kweet {
    private int id;
    private String message;
    private User user;
    private Calendar date;
    private HashSet<User> likers;

    public Kweet() {
        date = Calendar.getInstance();
        likers = new HashSet<>();
    }

    public Kweet(int id, String message, User user) {
        this.id = id;
        this.message = message;
        this.user = user;
        date = Calendar.getInstance();
        likers = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public Calendar getDate() {
        return date;
    }

    public HashSet<User> getLikers() {
        return likers;
    }

    public void addLiker(User user) throws Exception {
        if(!likers.add(user))
            throw new Exception("The user already liked this kweet.");
    }
}
