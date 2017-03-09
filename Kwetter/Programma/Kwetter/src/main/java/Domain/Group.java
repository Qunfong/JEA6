package Domain;

/**
 * Created by Joris on 3-3-2017.
 */
public class Group {
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
