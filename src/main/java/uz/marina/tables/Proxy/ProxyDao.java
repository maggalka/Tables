package uz.marina.tables.Proxy;

import uz.marina.tables.model.Element;
import uz.marina.tables.model.Objects;

import java.util.List;

/**
 * Created by Vladimir on 23.08.2017.
 */
public interface ProxyDao {

    void addProxy(Proxy proxy);

    void updateProxy(Proxy proxy);

    void getProxyByObject(Objects object);

    void deleteProxyByObject(Objects object);

    void deleteProxy(Proxy proxy);

    List<Proxy> listProxies();

}
