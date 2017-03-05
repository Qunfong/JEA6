package Service;

import Domain.Kweet;
import Domain.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by Joris on 4-3-2017.
 */
public class ModService {

    /**
     * Lets a mod or admin to change the role of a user
     *
     * @param userId the id of the user where the role will be changed of
     * @param role   the role the user get
     */
    public void changeRole(int userId, String role) {
        throw new NotImplementedException();
    }

    /**
     * Gives a list of all users with its roles for a mod or admin
     *
     * @return the list of all users with its roles
     */
    public List<User> getAllUsers() {
        throw new NotImplementedException();
    }

    /**
     * Gives a list of all kweets for a mod or admin
     *
     * @return the list of all kweets
     */
    public List<Kweet> getAllKweets() {
        throw new NotImplementedException();
    }

    /**
     * Lets a mod delete a kweet
     *
     * @param kweet the kweet that has to be deleted
     */
    public void deleteKweet(Kweet kweet){
        throw new NotImplementedException();
    }
}
