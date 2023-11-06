package com.example.be_project.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PaymentInfoResDTO implements Serializable {
    private String status;
    private String message;
    private String amount;
    private String bankCode;
    private String orderInfo;
    private String responseCode;
}
