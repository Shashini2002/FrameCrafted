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
    private String frameName;
    private String size;
    private String material;
    private String emailAddress;
    private String address;
    private String phoneNumber;
    private String photoUrl;
    private String comment;
    private String orderState;
}
