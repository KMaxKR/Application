package ms.kx.Application.controller;

import ms.kx.Application.entity.Product;
import ms.kx.Application.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String products(Model model){
        Product product = new Product();
        model.addAttribute("addProduct", product);
        return "products";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAllProducts(){
        List<Product> list = productService.findAllProducts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Product>> findProductById(@PathVariable("id") Long product_id){
        Optional<Product> product = productService.findProductById(product_id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id){
        product.setProduct_id(id);
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long user_id){
        productService.deleteProduct(user_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
