package Service;

import DAO.DAOManager;
import Domain.Relation;
import Domain.User;

import java.util.ArrayList;
import java.util.Collections;
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
        if (user.getName().equals(null))
            throw new NullPointerException("Username can't be null!");
        if (DAOManager.userDAO.get(user.getName()) != null || DAOManager.userDAO.get(user.getId()) != null)
            throw new IllegalArgumentException("User already exists!");

        DAOManager.userDAO.create(user);
    }

    /**
     * Updates a user of Kwetter in the system.
     *
     * @param user the updated user
     */
    public void updateUser(User user) {
        User userToUpdate = DAOManager.userDAO.get(user.getId());
        if (userToUpdate.equals(null))
            throw new NullPointerException("Can't find the requested user to update.");

        if (!userToUpdate.getName().equals(user.getName()))
            if (DAOManager.userDAO.get(user.getName()) != null)
                throw new IllegalArgumentException("Username already exists!");

        DAOManager.userDAO.update(user);
    }

    /**
     * Searches for a user with the given name
     * Returns null if no user can be found
     *
     * @param name the name of the requested user
     * @return the found user based on the given name
     */
    public User getUser(String name) {
        return DAOManager.userDAO.get(name);
    }

    /**
     * Searches for a user with the given id
     * Returns null if no user can be found
     *
     * @param id the id of the requested user
     * @return the found user based on the given id
     */
    public User getUser(int id) {
        return DAOManager.userDAO.get(id);
    }

    /**
     * Makes a relation where one user follows another
     *
     * @param follower  the id of the user that is the follower
     * @param following the id of the user that gets followed
     */
    public void follow(int follower, int following) throws Exception {
        User followerUser = DAOManager.userDAO.get(follower);
        if (followerUser == null)
            throw new NullPointerException("Can't find the user that is the follower!");

        User followingUser = DAOManager.userDAO.get(following);
        if (followingUser == null)
            throw new NullPointerException("Can't find the user that is the following!");

        Relation relation = new Relation(followerUser, followingUser);
        DAOManager.relationDAO.follow(relation);
    }

    /**
     * Returns a list of users that follow the given user
     *
     * @param following the id of the user that is being followed
     * @return the list of followers
     */
    public List<User> getFollowers(int following) {
        User followingUser = DAOManager.userDAO.get(following);
        ArrayList<User> followers = new ArrayList<>();

        for (Relation relation : DAOManager.relationDAO.getFollowers(followingUser))
            followers.add(relation.getFollower());

        return Collections.unmodifiableList(followers);
    }

    /**
     * Returns a list of users that the given user follows
     *
     * @param follower the id of the user that follows
     * @return the list of following users
     */
    public List<User> getFollowing(int follower) {
        User followerUser = DAOManager.userDAO.get(follower);
        ArrayList<User> following = new ArrayList<>();

        for (Relation relation : DAOManager.relationDAO.getFollowing(followerUser))
            following.add(relation.getFollowing());

        return Collections.unmodifiableList(following);
    }
}
