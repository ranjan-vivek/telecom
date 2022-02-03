package com.network.telecom.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class AgraMHagra {
    private String Agra;
    private String HAgra;
    private String Sashi;
}
