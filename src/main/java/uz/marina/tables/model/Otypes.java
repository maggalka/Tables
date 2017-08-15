package uz.marina.tables.model;

import javax.persistence.*;

/**
 * Created by Marina on 14.08.2017.
 */

@Entity
@Table(name = "otypes")
public class Otypes implements ElementWithId {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent")
    private int parent;

    @Override
    public String toString() {
        return "Otypes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
