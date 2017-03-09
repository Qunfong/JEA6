package Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Joris on 3-3-2017.
 */
@Entity
public class Group {
    @Id
    private String groupName;

    /**
     * Constructor for group, groupName is automatically "User"
     */
    public Group() {
        this.groupName = "User";
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
