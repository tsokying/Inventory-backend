package com.tsokying.hktvmalltest.controller;

import com.tsokying.hktvmalltest.model.Product;
import com.tsokying.hktvmalltest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

import static com.tsokying.hktvmalltest.controller.ErrorController.getResponseEntity;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<?> addProduct(@Valid @RequestBody Product product, BindingResult result) {
        ResponseEntity<?> errorMap = getResponseEntity(result);
        if (errorMap != null) return errorMap;
        Product newProduct = productService.addOrUpdateProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadProductData(@RequestParam("file") MultipartFile file) throws IOException {
        productService.saveAll(CsvUtils.read(Product.class, file.getInputStream()));
    }

    @GetMapping("/all")
    public Iterable<Product> getAllProduct(){
        return productService.findAllProduct();
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<?> getById(@PathVariable Long product_id) {
        Product product = productService.findProductById(product_id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long product_id) {
        productService.deleteProduct(product_id);
        return new ResponseEntity<>("Product deleted", HttpStatus.OK);
    }

}
