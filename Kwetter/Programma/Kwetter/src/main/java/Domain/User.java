package Domain;

/**
 * Created by Joris on 3-3-2017.
 */
public class User {

    private int id;
    private String photo;
    private String name;
    private String bio;
    private String web;
    private String location;
    private Group group;
    private String password;

    public User() {
        this.group = new Group();
    }

    public User(int id, String photo, String name, String bio, String web, String location, String password) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.bio = bio;
        this.web = web;
        this.location = location;
        this.group = new Group();
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
