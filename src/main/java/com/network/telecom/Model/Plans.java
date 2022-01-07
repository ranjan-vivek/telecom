package com.network.telecom.Model;

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

public class Plans {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String brandName;
        private String bandWidth;
        private double plan;
        private String validity;
        private String calls;
        private String sms;

    }

