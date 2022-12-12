package ra.model.service;

import ra.model.entity.Catalog;

import java.util.List;

public interface CatalogService <T,V> extends AppService<T,V>{
    List<T> searchByName(String Name);
}
