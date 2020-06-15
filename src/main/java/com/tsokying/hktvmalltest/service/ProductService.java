package com.tsokying.hktvmalltest.service;

import com.tsokying.hktvmalltest.model.Product;
import com.tsokying.hktvmalltest.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product addOrUpdateProduct(Product product) {
        return productRepo.save(product);
    }

    public void saveAll (List prodcutList) {
        productRepo.saveAll(prodcutList);
    };


    public Iterable<Product> findAllProduct() {
        return productRepo.findAll();
    }

    public Product findProductById(Long id) {
        return productRepo.getByProductId(id);
    }

    public void deleteProduct(Long id) {
        Product product = productRepo.getByProductId(id);
        productRepo.delete(product);
    }

}
