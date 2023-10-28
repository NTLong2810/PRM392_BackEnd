package com.example.be_project.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDetailDTO {
    private int customerId;
    private int bookId;
    private String bookTitle;
    private String bookImage;
    private double bookPrice;
    private int amount;
}
