package uz.marina.tables.Proxy;

import uz.marina.tables.model.Attributes;
import uz.marina.tables.model.Objects;

import java.util.Map;

/**
 * Created by Vladimir on 23.08.2017.
 */
public class Proxy {

    private Objects object;

    private Map<Attributes,String> values;

    private Map<Attributes, Objects> references;

    public Objects getObject() {
        return object;
    }

    public void setObject(Objects object) {
        this.object = object;
    }

    public Map<Attributes, String> getValues() {
        return values;
    }

    public void setValues(Map<Attributes, String> values) {
        this.values = values;
    }

    public Map<Attributes, Objects> getReferences() {
        return references;
    }

    public void setReferences(Map<Attributes, Objects> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "Proxy{" +
                "object=" + object +
                ", values=" + values +
                ", references=" + references +
                '}';
    }
}
