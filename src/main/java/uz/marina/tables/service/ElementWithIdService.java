package uz.marina.tables.service;

import uz.marina.tables.model.Element;

/**
 * Created by Marina on 16.08.2017.
 */
public interface ElementWithIdService {
    Element getElementById(Class<? extends Element> elementClass, int id);
    void removeElementById(Class<? extends Element> elementClass, int id);
}
