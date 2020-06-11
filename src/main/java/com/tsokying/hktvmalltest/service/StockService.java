package com.tsokying.hktvmalltest.service;

import com.tsokying.hktvmalltest.domain.Stock;
import com.tsokying.hktvmalltest.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepo stockRepo;

    public Stock addOrUpdateStock(Stock stock) {
        return stockRepo.save(stock);
    }

    public Iterable<Stock> saveAllStock(Iterable<Stock> stockIterable) {
        return stockRepo.saveAll(stockIterable);
    }

    public Iterable<Stock> findAllStock() {
        return stockRepo.findAll();
    }

    public Iterable<Stock> findStockByProduct(Long productId) {
        return stockRepo.findByProductId(productId);
    }

    public Iterable<Stock> findStockByLocation(Long locationId) {
        return stockRepo.findByLocationId(locationId);
    }

    public Stock findStockById(Long stockId) {
        return stockRepo.findByStockId(stockId);
    }

    public void deleteStock(Long stockId) {
        Stock stock = stockRepo.findByStockId(stockId);
        stockRepo.delete(stock);
    }
}
