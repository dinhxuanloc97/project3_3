package ra.model.service;

import java.util.List;

public interface ProductSevice <T,V> extends AppService<T,V>{
    List<T> searchByName(String name);
    List<T> getSpecialProduct();
    List<T> getProductlogId(String id);
}
