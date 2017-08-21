package uz.marina.tables.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Marina on 14.08.2017.
 */

@Entity
@Table(name = "affiliation")
public class Affiliation implements Serializable, Element{

    @Id
    @Column(name = "type")
    private int type;

    @Id
    @Column(name = "attribute")
    private int attribute;

    @Override
    public String toString() {
        return "Affiliation{" +
                "type=" + type +
                ", attribute=" + attribute +
                '}';
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }
}
