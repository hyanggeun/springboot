package com.example.study.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ItemApiRequest {
    private Long id;
    private String status;
    private String name;
    private String title;
    private String content;
    private BigDecimal price;
    private String brandName;
    private Long partnerId;
}
