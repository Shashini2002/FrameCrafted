package edu.icet.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders") // Changed from "order" to "orders"
public class OrderEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false)
        private String frameName;

        @Column(nullable = false)
        private String size;

        @Column(nullable = false)
        private String material;

        @Column(nullable = false, unique = true)
        private String emailAddress;

        @Column(nullable = false)
        private String address;

        @Column(nullable = false, length = 15)
        private String phoneNumber;

        @Column(nullable = false)
        private String photoUrl;

        @Column(nullable = true)
        private String comment;

        @Column(nullable = false)
        private String orderState;
}
