package com.network.telecom.service;

import com.network.telecom.model.ApiResponse;
import com.network.telecom.model.Comment;
import com.network.telecom.model.CustomerDetails;
import com.network.telecom.model.MessageResponse;
import com.network.telecom.repository.CommentRepository;
import com.network.telecom.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CustomerDetailService {

@Autowired
private CustomerDetailsRepository customerDetailsRepository;

@Autowired
private  CommentRepository commentRepository;

    public List<CustomerDetails> customerDetailsList(){
        return    customerDetailsRepository.findAll();

    }
    public ResponseEntity<ApiResponse> SaveCustomerDetails( List<CustomerDetails> customerDetails){
      customerDetailsRepository.saveAll(customerDetails);
      return ResponseEntity.ok(new ApiResponse(200, "Success", new Date().toString()));
    }

    public ResponseEntity<MessageResponse> deactivateCustomerDetails(long phoneno){
        customerDetailsRepository.deleteByPhoneNo(phoneno);
        return ResponseEntity.ok(new MessageResponse("customer deleted successfully"));
    }

    public ResponseEntity<MessageResponse> updateCustomerDetails( long phoneNo,CustomerDetails customerDetails){
        CustomerDetails customerDetails1 = customerDetailsRepository.findByPhoneNo(phoneNo) ;
        customerDetails1.setAddress(customerDetails.getAddress());
        customerDetails1.setEmailId(customerDetails.getEmailId());
        customerDetails1.setGender(customerDetails.getGender());
        customerDetails1.setName(customerDetails.getName());
        customerDetails1.setAlternatePhoneNo(customerDetails.getAlternatePhoneNo());
//        customerDetails1.setId(customerDetails.);
        customerDetailsRepository.save(customerDetails1);
        return ResponseEntity.ok(new MessageResponse("updated successfully"));
    }
public  ResponseEntity<ApiResponse> addComment(Comment comment) {

    commentRepository.save(comment);
    return ResponseEntity.ok(new ApiResponse(200, "Success", new Date().toString()));
}

    public  List<Comment> getComment() {

        return   commentRepository.findAll();

    }
}

