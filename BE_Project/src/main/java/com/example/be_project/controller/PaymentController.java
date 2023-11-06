package com.example.be_project.controller;

import com.example.be_project.Config.Config;
import com.example.be_project.DTO.PaymentResDTO;
import com.example.be_project.DTO.PaymentInfoResDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @PostMapping("/create_payment")
    public ResponseEntity<?> createPayment(@RequestParam float amount, @RequestParam String vnp_IpAddr) throws UnsupportedEncodingException {
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
//        long amount = Integer.parseInt(req.getParameter("amount"))*100;
//        long amount = 10000*100;
//        String bankCode = req.getParameter("bankCode");
        String bankCode = "NCB";
        String vnp_TxnRef = Config.getRandomNumber(8);
//        String vnp_IpAddr = Config.getIpAddress(req);
        String vnp_TmnCode = Config.vnp_TmnCode;

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(Math.round(amount* 100)));
        vnp_Params.put("vnp_CurrCode", "VND");

        if (bankCode != null && !bankCode.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bankCode);
        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", orderType);

//        String locate = req.getParameter("language");
//        if (locate != null && !locate.isEmpty()) {
//            vnp_Params.put("vnp_Locale", locate);
//        } else {
            vnp_Params.put("vnp_Locale", "vn");
//        }
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
//        com.google.gson.JsonObject job = new JsonObject();
//        job.addProperty("code", "00");
//        job.addProperty("message", "success");
//        job.addProperty("data", paymentUrl);
//        Gson gson = new Gson();
//        resp.getWriter().write(gson.toJson(job));

        PaymentResDTO paymentResDTO = new PaymentResDTO();
        paymentResDTO.setStatus("Ok");
        paymentResDTO.setMessage("Successfully");
        paymentResDTO.setUrlpayment(paymentUrl);
        System.out.println("URL: " + paymentUrl);
        System.out.println("SET_URL: " + paymentResDTO.getUrlpayment());
        System.out.println("paymentResDTO: " + paymentResDTO.toString());
        return ResponseEntity.status(HttpStatus.OK).body(paymentResDTO);

//        return new ResponseEntity<>(order, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/payment_information")
    public ResponseEntity<?> transaction(
            @RequestParam(value = "vnp_Amount") String amount,
            @RequestParam (value = "vnp_BankCode") String bankCode,
            @RequestParam (value = "vnp_OrderInfo") String orderInfo,
            @RequestParam (value = "vnp_ResponseCode") String responseCode) throws UnsupportedEncodingException
    {
        PaymentInfoResDTO transactionStatusDTO = new PaymentInfoResDTO();
        System.out.println("PaymentInfor: " + amount);
        if(responseCode.equals("00")){
            transactionStatusDTO.setStatus("Ok");
            transactionStatusDTO.setMessage("Successfully");
            transactionStatusDTO.setAmount(amount);
            transactionStatusDTO.setBankCode(bankCode);
            transactionStatusDTO.setOrderInfo(orderInfo);
            transactionStatusDTO.setResponseCode(responseCode);
            System.out.println("SUCCESS");
        }
        else{
            transactionStatusDTO.setStatus("No");
            transactionStatusDTO.setMessage("Failed");
            transactionStatusDTO.setAmount(amount);
            transactionStatusDTO.setBankCode(bankCode);
            transactionStatusDTO.setOrderInfo(orderInfo);
            transactionStatusDTO.setResponseCode(responseCode);
            System.out.println("FAILED");
        }
        //truyen cho client
        return ResponseEntity.status(HttpStatus.OK).body((transactionStatusDTO));
    }
    }
