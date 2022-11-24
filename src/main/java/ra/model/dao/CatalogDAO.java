package ra.model.dao;

import ra.model.entity.Catalog;

import java.util.List;

public interface CatalogDAO <T,V> extends IShop<T,V>{
    List<T> searchByName(String name);

}
