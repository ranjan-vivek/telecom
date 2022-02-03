package com.network.telecom.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TelecomBrands {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String brandName;
    private String bandWidth;
    private double price;

}
