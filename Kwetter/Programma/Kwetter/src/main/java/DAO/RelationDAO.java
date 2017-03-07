package DAO;

import Domain.Relation;
import Domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Joris on 7-3-2017.
 */
public class RelationDAO {

    ArrayList<Relation> relations;

    public RelationDAO() {
        relations = new ArrayList<>();
    }

    public void follow(Relation relation) {
        relations.add(relation);
    }

    public List<Relation> getFollowers(User user) {
        ArrayList<Relation> followerRelations = new ArrayList<>();
        for (Relation relation : relations) {
            if (relation.getFollowing().getId() == user.getId())
                followerRelations.add(relation);

        }
        return Collections.unmodifiableList(followerRelations);
    }

    public List<Relation> getFollowing(User user){
        ArrayList<Relation> followingRelations = new ArrayList<>();
        for (Relation relation : relations) {
            if (relation.getFollower().getId() == user.getId())
                followingRelations.add(relation);

        }
        return Collections.unmodifiableList(followingRelations);
    }
}
