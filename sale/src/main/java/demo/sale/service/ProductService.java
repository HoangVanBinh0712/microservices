package demo.sale.service;

import demo.sale.entity.Product;
import java.util.List;

public interface ProductService {

    Product saveProduct(Product inv);

    Product updateProduct(Product product, Long id);

    void deleteProduct(Long id);

    Product getOneProduct(Long id);

    List<Product> getAllProducts();

}
