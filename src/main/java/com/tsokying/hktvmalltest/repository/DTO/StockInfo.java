package com.tsokying.hktvmalltest.repository.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class StockInfo {
    private long stockId;
    private long locationId;
    private long productId;
    private String locationCode;
    private String locationName;
    private String code;
    private String name;
    private double weight;
    private int stockQty;
}
