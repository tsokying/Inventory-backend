package com.tsokying.hktvmalltest.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class StockInfo {
    private long stockId;
    private long locationId;
    private String locationCode;
    private String locationName;
    private long productId;
    private String productName;
    private int stockQty;
}
