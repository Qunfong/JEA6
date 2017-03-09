package DAO;

/**
 * Created by Joris on 8-3-2017.
 */
public class DAOManager {

    public static KweetDAO kweetDAO = new KweetDAO();
    public static UserDAO userDAO = new UserDAO();
    public static RelationDAO relationDAO = new RelationDAO();

    public static void clearDAOs(){
        kweetDAO = new KweetDAO();
        userDAO = new UserDAO();
        relationDAO = new RelationDAO();
    }
}
