package com.tsokying.hktvmalltest.repository;

import com.tsokying.hktvmalltest.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepo extends JpaRepository<Stock, Long> {
    Stock findByStockId(Long stockId);
    List<Stock> findByProductId(Long productId);
    List<Stock> findByLocationId(Long locationId);
}
