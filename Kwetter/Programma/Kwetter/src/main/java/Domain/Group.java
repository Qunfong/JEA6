package Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by Qun on 28-2-2018.
 */
@Entity
@Table(name = "usergroup")
@NamedQuery(name = "group.all", query = "SELECT g FROM Group g")
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
