package management.product.repository.impl;

import management.product.model.Product;
import management.product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer,Product> products = new HashMap<>();

    static {
        products.put(1,new Product(1,"Iphone 5",300.0,"Điện thoại","Iphone"));
        products.put(2,new Product(2,"Iphone 6",500.0,"Điện thoại","Iphone"));
        products.put(3,new Product(3,"Iphone 7",100.0,"Điện thoại","Iphone"));
        products.put(4,new Product(4,"Iphone X",2.0,"Điện thoại","Iphone"));
        products.put(5,new Product(5,"Iphone XS",25.0,"Điện thoại","Iphone"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        for (Product product : products.values())
            if (product.getName().contains(name)) {
                list.add(product);
            }
        return list;
    }
}
