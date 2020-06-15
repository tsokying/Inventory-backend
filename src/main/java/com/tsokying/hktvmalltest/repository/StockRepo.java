package com.tsokying.hktvmalltest.repository;

import com.tsokying.hktvmalltest.repository.DTO.StockInfo;
import com.tsokying.hktvmalltest.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepo extends JpaRepository<Stock, Long> {
    Stock findByStockId(Long stockId);

    @Query("SELECT new com.tsokying.hktvmalltest.repository.DTO.StockInfo (s.stockId, s.locationId, s.productId, l.locationCode, l.locationName, p.code, p.name, p.weight, s.stockQty) FROM Stock s JOIN Product p ON s.productId = p.productId JOIN Location l ON s.locationId = l.locationId ORDER BY s.stockId asc")
    List<StockInfo>  getAllInfo();
}
