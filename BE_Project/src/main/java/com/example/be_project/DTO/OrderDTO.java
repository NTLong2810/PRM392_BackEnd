package com.example.be_project.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private int paymentMethodId;
    private int customerId;
    private int shippingMethodId;
    private String address;

    private List<OrderDetailDTO> detailDTOList;
}
