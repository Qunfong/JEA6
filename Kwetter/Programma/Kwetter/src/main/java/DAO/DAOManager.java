package DAO;

/**
 * Created by Joris on 8-3-2017.
 */
public class DAOManager {

    public static UserDAO userDAO = new UserDAO();
    public static RelationDAO relationDAO = new RelationDAO();

    public static void clearDAOs(){
        userDAO = new UserDAO();
        relationDAO = new RelationDAO();
    }
}
