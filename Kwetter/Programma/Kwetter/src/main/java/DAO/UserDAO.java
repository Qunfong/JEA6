package DAO;

import Domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Joris on 7-3-2017.
 */
public class UserDAO {

    private ArrayList<User> users;

    public UserDAO() {
        users = new ArrayList<>();
    }

    public void create(User user) {
        users.add(user);
    }

    public void update(User user) {
        for (User usersUser: users){
            if (user.getId() == usersUser.getId()){
                usersUser = user;
            }
        }
    }

    public User get(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public User get(String name) {
        for (User user : users) {
            if (user.getName().equals(name))
                return user;
        }
        return null;
    }

    public List<User> getAll(){
            return Collections.unmodifiableList(users);
    }
}
