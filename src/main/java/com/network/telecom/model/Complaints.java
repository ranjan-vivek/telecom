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

public class Complaints {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id ;
    private String name;
    private long contactNo;
    private String complaint;
    private String emailId;
}
