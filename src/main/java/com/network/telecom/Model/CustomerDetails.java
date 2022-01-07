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
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String name;
    private String address;
    private long phoneNo;
    private String gender;
    private String emailId;
    private long alternatePhoneNo;
    private String postOrPrepaid;
}
