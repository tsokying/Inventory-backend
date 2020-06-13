package com.tsokying.hktvmalltest.repository;

import com.tsokying.hktvmalltest.model.DTO.StockInfo;
import com.tsokying.hktvmalltest.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepo extends JpaRepository<Stock, Long> {
    Stock findByStockId(Long stockId);
    List<Stock> findByProductId(Long productId);
    List<Stock> findByLocationId(Long locationId);

    @Query("SELECT new com.tsokying.hktvmalltest.model.DTO.StockInfo (s.stockId, s.locationId, l.locationCode, l.locationName, s.productId, p.name, s.stockQty) FROM Stock s JOIN Product p ON s.productId = p.productId JOIN Location l ON s.locationId = l.locationId")
    List<StockInfo>  getAllInfo();
}
