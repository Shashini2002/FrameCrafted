package edu.icet.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Integer id;
    private String address;
    private String comment;
    private String emailAddress;
    private String phoneNumber;
    private String photoUrl;
    private String orderState;

    private String itemCode;
    private String price;
}






