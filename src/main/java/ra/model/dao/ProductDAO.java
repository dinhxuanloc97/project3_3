package ra.model.dao;

import java.util.List;

public interface ProductDAO <T,V> extends IShop<T,V>{
    List<T> searchByName(String name);
    List<T> getSpecialProduct();
    List<T> getProductlogId(String id);
}
