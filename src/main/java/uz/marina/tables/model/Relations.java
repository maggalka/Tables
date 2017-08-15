package uz.marina.tables.model;

import javax.persistence.*;

/**
 * Created by Marina on 14.08.2017.
 */

@Entity
@Table(name = "relations")
public class Relations implements Element {

    @Column(name = "object")
    private int object;

    @Column(name = "attribute")
    private int attribute;

    @Column(name = "refobject")
    private int refobject;

    @Override
    public String toString() {
        return "Relations{" +
                "object=" + object +
                ", attribute=" + attribute +
                ", refobject=" + refobject +
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

    public int getRefobject() {
        return refobject;
    }

    public void setRefobject(int refobject) {
        this.refobject = refobject;
    }
}
