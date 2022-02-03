package com.network.telecom.Service;

import com.network.telecom.Model.ApiResponse;
import com.network.telecom.Model.CustomerDetails;
import com.network.telecom.Model.TelecomBrands;
import com.network.telecom.Repository.CustomerDetailsRepository;
import com.network.telecom.Repository.TelecomBrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class CustomerDetailService {

@Autowired
private CustomerDetailsRepository customerDetailsRepository;


    public List<CustomerDetails> customerDetailsList(){
        customerDetailsRepository.findAll();
        return    customerDetailsRepository.findAll();

    }
    public ResponseEntity<ApiResponse> SaveCustomerDetails( List<CustomerDetails> customerDetails){
      customerDetailsRepository.saveAll(customerDetails);
      return ResponseEntity.ok(new ApiResponse(200, "Success", new Date().toString()));
    }

    public ResponseEntity<ApiResponse> deactivateCustomerDetails(int id){
        customerDetailsRepository.deleteById(id);
        return ResponseEntity.ok(new ApiResponse(200, "Success", new Date().toString()));
    }
}
