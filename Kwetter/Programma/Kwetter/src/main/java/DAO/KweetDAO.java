package DAO;

import Domain.Kweet;
import Domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Joris on 7-3-2017.
 */
public class KweetDAO {

    private ArrayList<Kweet> kweets;

    public KweetDAO(){
        kweets = new ArrayList<>();
    }

    public void create(Kweet kweet) {
        kweets.add(kweet);
    }

    public void like(Kweet kweet, User user) throws Exception {
        for (Kweet kweetListItem : kweets) {
            if (kweetListItem.getId() == kweet.getId())
                kweetListItem.addLiker(user);
        }
    }

    public List<Kweet> timeline(User user) {
        ArrayList<Kweet> timelineKweets = new ArrayList<>();
        for (Kweet kweet : kweets) {
            //TODO: add kweets from followings
            if(kweet.getUser().equals(user))
                timelineKweets.add(kweet);
        }
        return Collections.unmodifiableList(timelineKweets);
    }

    public List<Kweet> search(String keyword){
        ArrayList<Kweet> foundKweets = new ArrayList<>();
        for (Kweet kweet: kweets){
            if(kweet.getMessage().contains(keyword))
                foundKweets.add(kweet);
        }
        return Collections.unmodifiableList(foundKweets);
    }

    public List<Kweet> getAll(){
        return Collections.unmodifiableList(kweets);
    }

    public void delete(Kweet kweet){
        kweets.remove(kweet);
    }
}
