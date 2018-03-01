package JSONObjects;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Qun on 28-2-2018.
 */
public class KweetJSON {
    @XmlElement public int id;
    @XmlElement public String message;
    @XmlElement public int userId;
}
