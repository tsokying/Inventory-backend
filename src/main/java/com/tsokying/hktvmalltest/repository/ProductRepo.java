package com.tsokying.hktvmalltest.repository;

import com.tsokying.hktvmalltest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    public List<Product> findAllByOrderByProductIdAsc();
    Product getByProductId(Long id);
}
