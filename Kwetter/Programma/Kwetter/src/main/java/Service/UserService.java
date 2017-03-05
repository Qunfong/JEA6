package Service;

import Domain.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by Joris on 4-3-2017.
 */
public class UserService {

    /**
     * Creates a user of Kwetter in the system.
     *
     * @param user the user that will be created
     */
    public void createUser(User user) {
        throw new NotImplementedException();
    }

    /**
     * Updates a user of Kwetter in the system.
     *
     * @param user the updated user
     */
    public void updateUser(User user) {
        throw new NotImplementedException();
    }

    /**
     * Searches for a user with the given name
     * Returns null if no user can be found
     *
     * @param name the name of the requested user
     * @return the found user based on the given name
     */
    public User getUser(String name) {
        throw new NotImplementedException();
    }

    /**
     * Searches for a user with the given id
     * Returns null if no user can be found
     *
     * @param id the id of the requested user
     * @return the found user based on the given id
     */
    public User getUser(int id) {
        throw new NotImplementedException();
    }

    /**
     * Makes a relation where one user follows another
     *
     * @param follower  the id of the user that is the follower
     * @param following the id of the user that gets followed
     */
    public void follow(int follower, int following) {
        throw new NotImplementedException();
    }

    /**
     * Returns a list of users that follow the given user
     *
     * @param following the id of the user that is being followed
     * @return the list of followers
     */
    public List<User> getFollowers(int following) {
        throw new NotImplementedException();
    }

    /**
     * Returns a list of users that the given user follows
     *
     * @param follower the id of the user that follows
     * @return the list of following users
     */
    public List<User> getFollowing(int follower) {
        throw new NotImplementedException();
    }
}
