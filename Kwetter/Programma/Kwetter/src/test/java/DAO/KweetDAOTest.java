package DAO;

import Domain.Kweet;
import Domain.Relation;
import Domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Created by Joris on 7-3-2017.
 */
public class KweetDAOTest {
    User user1;
    User user2;
    Kweet kweet1;
    Kweet kweet2;
    Kweet kweet3;
    Relation relation1;

    @Inject
    KweetDAO kweetDAO;

    @Inject
    RelationDAO relationDAO;

    @Before
    public void setUp() throws Exception {
        user1 = new User(1, null, "user1", null, null, null, null);
        user2 = new User(2, null, "user2", null, null, null, null);
        kweet1 = new Kweet(1, "Hello everybody", user1);
        kweetDAO.create(kweet1);
        kweet2 = new Kweet(2, "Hey all!", user2);
        kweetDAO.create(kweet2);
        Thread.sleep(20);
        kweet3 = new Kweet(3, "Hey ho!", user2);
        kweetDAO.create(kweet3);
        relation1 = new Relation(user1, user2);
        relationDAO.follow(relation1);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create() throws Exception {
        Kweet kweet4 = new Kweet(3, "Hey user1!", user2);
        kweetDAO.create(kweet4);
    }

    @Test
    public void like() throws Exception {
        kweetDAO.like(kweet1, user1);
        kweetDAO.like(kweet1, user2);
        Assert.assertEquals("Not both users liked kweet1.", 2, kweetDAO.getAll().get(0).getLikers().size());
    }

    @Test
    public void timeline() throws Exception {
        Assert.assertEquals("Another amount of kweets received than expected.", 3, kweetDAO.timeline(user1).size());
    }

    @Test
    public void latest() throws Exception {
        Assert.assertEquals("Latest kweet wasn't kweet3.", kweet3, kweetDAO.latest(user2, 1).get(0));
        Assert.assertEquals("Second latest kweet wasn't kweet2.", kweet2, kweetDAO.latest(user2, 2).get(1));
    }

    @Test
    public void search() throws Exception {
        Assert.assertEquals("Didn't found kweet1.", kweet1, kweetDAO.search("ello").get(0));
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals("Received a different amount of kweets than expected.", 3, kweetDAO.getAll().size());
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals("Received the wrong kweet.", kweet1, kweetDAO.get(1));
        Assert.assertNull("Received a kweet.", kweetDAO.get(40));
    }

    @Test
    public void delete() throws Exception {
        kweetDAO.delete(kweet1);
        Assert.assertEquals("Kweet wasn't deleted!", 2, kweetDAO.getAll().size());
    }

}