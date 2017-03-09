package DAO;

import Domain.Relation;
import Domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joris on 7-3-2017.
 */
public class RelationDAOTest {
    User user1;
    User user2;
    User user3;
    Relation relation1;
    Relation relation2;

    @Before
    public void setUp() throws Exception {
        user1 = new User(1, null, "user1", null, null, null, null);
        user2 = new User(2, null, "user2", null, null, null, null);
        user3 = new User(3, null, "user3", null, null, null, null);
        relation1 = new Relation(user1, user2);
        relation2 = new Relation(user2, user1);
        DAOManager.relationDAO.follow(relation1);
        DAOManager.relationDAO.follow(relation2);
    }

    @After
    public void tearDown() throws Exception {
        DAOManager.clearDAOs();
    }

    @Test
    public void follow() throws Exception {
        Relation relation3 = new Relation(user1, user3);
        DAOManager.relationDAO.follow(relation3);
    }

    @Test
    public void getFollowers() throws Exception {
        Assert.assertEquals("Received the wrong relation and wrong follower", user1, DAOManager.relationDAO.getFollowers(user2).get(0).getFollower());
        Assert.assertEquals("Received the wrong relation and wrong follower", user2, DAOManager.relationDAO.getFollowers(user1).get(0).getFollower());
    }

    @Test
    public void getFollowing() throws Exception {
        Assert.assertEquals("Received the wrong relation and wrong following", user2, DAOManager.relationDAO.getFollowing(user1).get(0).getFollowing());
        Assert.assertEquals("Received the wrong relation and wrong following", user1, DAOManager.relationDAO.getFollowing(user2).get(0).getFollowing());
    }

}