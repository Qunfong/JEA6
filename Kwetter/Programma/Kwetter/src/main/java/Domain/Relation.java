package Domain;

/**
 * Created by Joris on 3-3-2017.
 */
public class Relation {
    private User follower;
    private User following;

    public Relation(){

    }

    public Relation(User follower, User following) throws Exception{
        if(follower.equals(following))
            throw new IllegalArgumentException("Follower was equal to following");
        this.follower = follower;
        this.following = following;
    }

    public User getFollower() {
        return follower;
    }

    public User getFollowing() {
        return following;
    }
}
