package uz.marina.tables.service;

import uz.marina.tables.model.Element;
import uz.marina.tables.model.ElementWithId;

/**
 * Created by Marina on 16.08.2017.
 */
public interface ElementWithIdService<T extends Element> extends ElementService<T> {
    ElementWithId getElementById(String className, int id);
    void removeElementById(String className, int id);
}
