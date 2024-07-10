package demo.sale.controller;

import demo.sale.entity.Product;
import demo.sale.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.getOneProduct(id);
    }

    // create a Product
    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // update a book
    @PutMapping
    public Product update(@RequestBody Product product, Long id) {
        return productService.updateProduct(product, id);
    }

    // delete a book
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
