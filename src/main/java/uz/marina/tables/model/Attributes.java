package uz.marina.tables.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Marina on 14.08.2017.
 */

@Entity
@Table(name = "attributes")
public class Attributes implements ElementWithId{

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(name = "isobject")
    private Boolean isObject;

    @Override
    public String toString() {
        return "Attributes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isObject=" + isObject +
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

    public Boolean getIsObject() {
        return isObject;
    }

    public void setIsObject(Boolean isObject) {
        this.isObject = isObject;
    }
}
