package uz.marina.tables.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Marina on 14.08.2017.
 */

@Entity
@Table(name = "records")
public class Records implements Serializable, Element {

    @Id
    @Column(name = "object")
    private int object;

    @Id
    @Column(name = "attribute")
    private int attribute;

    @Column(name = "value")
    private String value;

    @Override
    public String toString() {
        return "Records{" +
                "object=" + object +
                ", attribute=" + attribute +
                ", value='" + value + '\'' +
                '}';
    }

    public int getObject() {
        return object;
    }

    public void setObject(int object) {
        this.object = object;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
