package com.network.telecom.controller;

import com.network.telecom.model.*;
import com.network.telecom.service.CustomerDetailService;
import com.network.telecom.service.TelecomBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1")
@Slf4j
public class CustomerDetailsController {

    @Autowired
    private CustomerDetailService customerDetailsService;

    @Autowired
    private TelecomBrandService telecomBrandService;

    /**
     * @param customerDetails
     * @return
     */
    @PostMapping(value = "/addCustomerInformation")
    public ResponseEntity<ApiResponse> addCustomerInformation(@RequestBody List<CustomerDetails> customerDetails) {
        return customerDetailsService.SaveCustomerDetails(customerDetails);
    }


    /**
     * @return
     */
    @GetMapping("/getListOfCustomerInformation")
    public List<CustomerDetails> getListOfCustomerInformation() {
        return customerDetailsService.customerDetailsList();
    }

    /**
     * @param telecomBrands
     * @return
     */
    @PostMapping("/addListOfNetworks")
    public ResponseEntity<ApiResponse> addListOfNetworks(@RequestBody List<TelecomBrands> telecomBrands) {
        return telecomBrandService.addingNetworks(telecomBrands);
    }

    /**
     * @param telecomBrands
     * @return
     */
    @GetMapping("/getListOfNetworks")
    public ResponseEntity<ApiResponse> getListOfNetworks(@RequestBody List<TelecomBrands> telecomBrands) {
        return telecomBrandService.addingNetworks(telecomBrands);
    }


    /**
     * @param complaints
     * @return
     */
    @PostMapping("/createcase")
    public ResponseEntity<MessageResponse> addCase(@RequestBody Complaints complaints) {
        return telecomBrandService.complaint(complaints);
    }

    @GetMapping("/listOfCase")
    public List<Complaints> getComplaintsList() {

        return telecomBrandService.getComplaintsList();

    }

    /**
     *
     * @param phoneNo
     * @param customerDetails
     * @return
     */
    @PatchMapping("/updateCustomerInfo/{phoneNo}")
    public ResponseEntity<MessageResponse> update(
            @PathVariable long phoneNo, @RequestBody CustomerDetails customerDetails) {
        return customerDetailsService.updateCustomerDetails(phoneNo, customerDetails);
    }

    /**
     * @param
     * @return
     */
    @DeleteMapping("deactivateCustomer/{phoneNo}")
    public ResponseEntity<MessageResponse> deactivateCustomerDetails(@PathVariable long phoneNo) {
        return customerDetailsService.deactivateCustomerDetails(phoneNo);
    }

    /**
     *
     * @param brandName
     * @param telecomBrands
     * @return
     */
    @PatchMapping("/updateNetworkInfo/{brandName}")
    public ResponseEntity<MessageResponse> update(@PathVariable String brandName, @RequestBody TelecomBrands telecomBrands) {
        return telecomBrandService.updateNetworkInfo(brandName, telecomBrands);
    }

    /**
     *
     * @param networkName
     * @return
     */
    @DeleteMapping("deleteNetwork/{networkName}")
    public ResponseEntity<MessageResponse> deleteNetwork(@PathVariable String networkName) {
   return telecomBrandService.deleteNetwork(networkName);
    }

    /**
     *
     * @param comment
     * @return
     */
    @PostMapping("/addComments")
    public ResponseEntity<ApiResponse> addComment(@RequestBody  Comment comment){
        return   customerDetailsService.addComment(comment);

    }

    /**
     *
     * @return
     */
    @GetMapping("/getListOfComments")
    public List<Comment> getComment(){
        return   customerDetailsService.getComment();

    }
}
