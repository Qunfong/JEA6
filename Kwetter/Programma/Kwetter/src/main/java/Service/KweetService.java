package Service;

import Domain.Kweet;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by Joris on 4-3-2017.
 */
public class KweetService {

    /**
     * Creates a new kweet in the system.
     *
     * @param kweet to be created.
     */
    public void createKweet(Kweet kweet) {
        throw new NotImplementedException();
    }

    /**
     * Makes the given user like the given kweet.
     *
     * @param kweet  the kweet to be liked
     * @param userId the id of the user that likes the kweet
     */
    public void likeKweet(Kweet kweet, int userId) {
        throw new NotImplementedException();
    }

    /**
     * Gives a list of kweets of the given user itself
     * and of the users that the given user follows
     *
     * @param userId the id of the user where the timeline
     *               will be generated for
     * @return the generated timeline based on a list of kweets
     */
    public List<Kweet> getTimeline(int userId) {
        throw new NotImplementedException();
    }

    /**
     * Gives a list of the latest kweets of the given user
     * The list is limited to the amount
     * If the amount is smaller or equal to 0, the list is unlimited
     *
     * @param userId the id of the user where the latest kweets are requested for
     * @param amount the amount of kweets that are requested
     * @return the latest amount kweets of the given user
     */
    public List<Kweet> latestKweets(int userId, int amount) {
        throw new NotImplementedException();
    }

    /**
     * Gives a list of kweets that match the given keyword
     *
     * @param keyword the word that must be in the message of the kweets
     * @return the kweets where the message match the keyword
     */
    public List<Kweet> searchKweet(String keyword){
        throw new NotImplementedException();
    }
}
