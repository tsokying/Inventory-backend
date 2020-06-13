package com.tsokying.hktvmalltest.controller;

import com.tsokying.hktvmalltest.model.DTO.StockInfo;
import com.tsokying.hktvmalltest.model.Stock;
import com.tsokying.hktvmalltest.service.StockService;
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
@RequestMapping("/api/stock")
@CrossOrigin
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("")
    public ResponseEntity<?> addStock(@Valid @RequestBody Stock stock, BindingResult result) {
        ResponseEntity<?> errorMap = getResponseEntity(result);
        if (errorMap != null) return errorMap;
        Stock newStock = stockService.addOrUpdateStock(stock);
        return new ResponseEntity<>(newStock, HttpStatus.CREATED);
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException {
        stockService.saveAllStock(CsvUtils.read(Stock.class, file.getInputStream()));
    }

    @GetMapping("/all")
    public Iterable<StockInfo> getAllProduct(){
        return stockService.findAllStock();
    }

    @GetMapping("/{stock_id}")
    public ResponseEntity<?> getById(@PathVariable Long stock_id) {
        Stock newStock = stockService.findStockById(stock_id);
        return new ResponseEntity<>(newStock, HttpStatus.OK);
    }

    @DeleteMapping("/{stock_id}")
    public ResponseEntity<?> deleteStock(@PathVariable Long stock_id) {
        stockService.deleteStock(stock_id);
        return new ResponseEntity<>("Stock deleted", HttpStatus.OK);
    }

}
