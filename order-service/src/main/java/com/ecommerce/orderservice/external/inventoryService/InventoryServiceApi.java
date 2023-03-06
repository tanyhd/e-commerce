package com.ecommerce.orderservice.external.inventoryService;

import com.ecommerce.orderservice.dto.InventoryResponse;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

public interface InventoryServiceApi {

    @RequestLine("GET /api/inventory")
    List<InventoryResponse> getInventoryList(
            @QueryMap Map<String, List<String>> queryParams
    );
}
