package com.tsokying.hktvmalltest.repository;

import com.tsokying.hktvmalltest.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
    Product getByProductId(Long id);
}
