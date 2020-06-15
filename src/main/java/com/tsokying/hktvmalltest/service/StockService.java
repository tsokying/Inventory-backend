package com.tsokying.hktvmalltest.service;

import com.tsokying.hktvmalltest.model.Stock;
import com.tsokying.hktvmalltest.repository.DTO.StockInfo;
import com.tsokying.hktvmalltest.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepo stockRepo;

    public Stock addOrUpdateStock(Stock stock) {
        return stockRepo.save(stock);
    }

    public void saveAll (List stockList) {
        stockRepo.saveAll(stockList);
    };

    public Iterable<StockInfo> findAllStock() {
        return stockRepo.getAllInfo();
    }

    public Stock findStockById(Long stockId) {
        return stockRepo.findByStockId(stockId);
    }

    public void deleteStock(Long stockId) {
        Stock stock = stockRepo.findByStockId(stockId);
        stockRepo.delete(stock);
    }
}
