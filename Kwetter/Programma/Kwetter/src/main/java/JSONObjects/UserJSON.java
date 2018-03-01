package JSONObjects;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Qun on 28-2-2018.
 */
public class UserJSON {
    @XmlElement public int id;
    @XmlElement public String username;
    @XmlElement public String password;
    @XmlElement public String photo;
    @XmlElement public String bio;
    @XmlElement public String web;
    @XmlElement public String location;
}
