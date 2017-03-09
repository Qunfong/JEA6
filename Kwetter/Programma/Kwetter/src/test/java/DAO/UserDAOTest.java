package DAO;

import Domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joris on 7-3-2017.
 */
public class UserDAOTest {
    User user1;

    @Before
    public void setUp() throws Exception {
        user1 = new User(1, "http://photo.com/1.jpg", "Harry", "Hey", "http://www.harry.nl/","Home", "heyhey");
        DAOManager.userDAO.create(user1);
    }

    @After
    public void tearDown() throws Exception {
        DAOManager.clearDAOs();
    }

    @Test
    public void create() throws Exception {
        User user2 = new User(2, "http://photo.com/2.jpg", "Harryz", "Hey2", "http://www.harryz.nl/","Homez", "heyheyz");
        DAOManager.userDAO.create(user2);
        Assert.assertEquals("User2 wasn't created.", 2, DAOManager.userDAO.getAll().size());
    }

    @Test
    public void update() throws Exception {
        user1.setName("Harry2");
        DAOManager.userDAO.update(user1);
        Assert.assertEquals("The name of user1 isn't changed.", "Harry2", DAOManager.userDAO.get(user1.getId()).getName());
    }

    @Test
    public void getById() throws Exception {
        Assert.assertEquals("User1 isn't found.", user1, DAOManager.userDAO.get(1));
        Assert.assertNull("User unexpectedly found.", DAOManager.userDAO.get(-4));
    }

    @Test
    public void getByName() throws Exception {
        Assert.assertEquals("User1 isn't found.", user1, DAOManager.userDAO.get("Harry"));
        Assert.assertNull("User unexpectedly found.", DAOManager.userDAO.get("niemand"));
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals("The expected amount of users did not match the actual amount.", 1, DAOManager.userDAO.getAll().size());
    }

}