package JSONObjects;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Qun on 28-2-2018.
 */
public class RelationJSON {
    @XmlElement public int followerId;
    @XmlElement public int followingId;
}
