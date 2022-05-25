package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIPM implements ProductService{
    List<Product> products;

    public ProductServiceIPM() {
        products =new ArrayList<>();
        products.add(new Product(1,"asd",300));
        products.add(new Product(3,"asdwa",899));
        products.add(new Product(2,"xe may",323));

    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);

    }

    @Override
    public int findIndexProductId(int id) {
       int indexOf=-1;
        for (int i = 0; i < products.size(); i++) {
            if (id==products.get(i).getId()){
                indexOf=i;
            }
        }
        return indexOf;
    }

    @Override
    public Product findById(int id) {
        for(Product product : products
        ) {
            if (product.getId()==id)return product;
        }

        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public void update(int id, Product product) {
        int indexOf=findIndexProductId(id);
        products.set(indexOf,product);

    }

    @Override
    public void delete(int id) {

    }
}//bai lam ca ngay hom qua
