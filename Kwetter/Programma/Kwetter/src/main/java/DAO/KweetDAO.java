package DAO;

import Domain.Kweet;
import Domain.Relation;
import Domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Joris on 7-3-2017.
 */
public class KweetDAO {

    private ArrayList<Kweet> kweets;

    public KweetDAO() {
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
        ArrayList<User> followingUsers = new ArrayList<>();
        for(Relation relation: DAOManager.relationDAO.getFollowing(user)){
            followingUsers.add(relation.getFollowing());
        }

        for (Kweet kweet : kweets) {
            if (kweet.getUser().equals(user) || followingUsers.contains(kweet.getUser()))
                timelineKweets.add(kweet);
        }
        return Collections.unmodifiableList(timelineKweets);
    }

    public List<Kweet> latest(User user, int amount){
        ArrayList<Kweet> userKweets = new ArrayList<>();

        for (Kweet kweet: kweets){
            if (kweet.getUser().equals(user))
                userKweets.add(kweet);
        }

        Collections.sort(userKweets, new Comparator<Kweet>() {
            @Override
            public int compare(Kweet o1, Kweet o2) {
                if (o1.getDate() == null || o2.getDate() == null)
                    return 0;
                return o2.getDate().compareTo(o1.getDate());
            }
        });

        if(amount <= 0 || userKweets.size() <= amount)
            return Collections.unmodifiableList(userKweets);

        return Collections.unmodifiableList(userKweets.subList(0, amount));
    }

    public List<Kweet> search(String keyword) {
        ArrayList<Kweet> foundKweets = new ArrayList<>();
        for (Kweet kweet : kweets) {
            if (kweet.getMessage().toLowerCase().contains(keyword.toLowerCase()))
                foundKweets.add(kweet);
        }
        return Collections.unmodifiableList(foundKweets);
    }

    public List<Kweet> getAll() {
        return Collections.unmodifiableList(kweets);
    }

    public void delete(Kweet kweet) {
        kweets.remove(kweet);
    }
}
