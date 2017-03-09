package Domain;

import org.eclipse.persistence.annotations.PrimaryKey;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by Joris on 3-3-2017.
 */
@Entity
public class Relation {
    @ManyToOne
    @PrimaryKeyJoinColumn
    private User follower;
    @ManyToOne
    @PrimaryKeyJoinColumn
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
