package Service;

import DAO.DAOManager;
import Domain.Kweet;
import Domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joris on 9-3-2017.
 */
public class KweetServiceTest {
    User user1;
    User user2;
    Kweet kweet1;
    KweetService kweetService;

    @Before
    public void setUp() throws Exception {
        user1 = new User(1, null, "user1", null, null, null, "hoi");
        user2 = new User(2, null, "user2", null, null, null, "hoi");
        kweet1 = new Kweet(1, "Hey people!", user1);
        DAOManager.userDAO.create(user1);
        DAOManager.kweetDAO.create(kweet1);
        kweetService = new KweetService();
    }

    @After
    public void tearDown() throws Exception {
        DAOManager.clearDAOs();
    }

    @Test
    public void createKweet() throws Exception {
        Kweet kweet2 = new Kweet(2, "Hey all!", user1);
        kweetService.createKweet(kweet2);
    }

    @Test
    public void likeKweet() throws Exception {
        kweetService.likeKweet(1, 1);
    }

    @Test(expected = Exception.class)
    public void likeKweetAlreadyLikes() throws Exception {
        kweetService.likeKweet(1, 1);
        kweetService.likeKweet(1, 1);
    }

    @Test(expected = NullPointerException.class)
    public void likeKweetNonExistingUserException() throws Exception {
        kweetService.likeKweet(1, 20);
    }

    @Test(expected = NullPointerException.class)
    public void likeKweetNonExistingKweetException() throws Exception {
        kweetService.likeKweet(20, 1);
    }

    @Test
    public void getTimeline() throws Exception {
        Assert.assertEquals("Received a different amount of kweets than expected.", 1, kweetService.getTimeline(1).size());
    }

    @Test(expected = NullPointerException.class)
    public void getTimelineNonExistingUserException() throws Exception {
        kweetService.getTimeline(20);
    }

    @Test
    public void latestKweets() throws Exception {
        Assert.assertEquals("Received a different amount of kweets than expected.",1, kweetService.latestKweets(1, 1).size());
    }

    @Test(expected = NullPointerException.class)
    public void latestKweetsNonExistingUserException() throws Exception {
        kweetService.latestKweets(20, 20);
    }

    @Test
    public void searchKweet() throws Exception {
        Assert.assertEquals("Received a different kweet than expected.", kweet1, kweetService.searchKweet("PEOPLE").get(0));
    }

}