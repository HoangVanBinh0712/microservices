package demo.sale.service.impl;

import demo.sale.entity.Product;
import demo.sale.repository.ProductRepository;
import demo.sale.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@EnableCaching
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    @CachePut(value = "products")
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @CachePut(value = "products", key = "#id")
    public Product updateProduct(Product product, Long id) {
        return null;
    }

    @Override
    @CacheEvict(value = "products", key = "#id")
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("product Not Found"));
        productRepository.delete(product);
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public Product getOneProduct(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("product Not Found"));
    }

    @Override
    @Cacheable(value = "products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
