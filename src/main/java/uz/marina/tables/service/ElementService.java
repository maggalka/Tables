package uz.marina.tables.service;

import uz.marina.tables.model.Element;

import java.util.List;

/**
 * Created by Marina on 16.08.2017.
 */
public interface ElementService {
    void addElement(Element element);
    void updateElement(Element element);

    List<Element> listElementsByColumnValue(Class<? extends Element> elementClass, String columnName, int value);
    void removeElementsByColumnValue(Class<? extends Element> elementClass, String columnName, int value);

    List<Element> listElements(String className, Long page);
}
