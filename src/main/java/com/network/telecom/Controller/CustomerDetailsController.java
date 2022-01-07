package com.network.telecom.Controller;

import com.network.telecom.Model.ApiResponse;
import com.network.telecom.Model.Plans;
import com.network.telecom.Model.TelecomBrands;
import com.network.telecom.Service.CustomerDetailService;
import com.network.telecom.Model.CustomerDetails;
import com.network.telecom.Service.TelecomBrandService;
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
    @PostMapping(value = "/customerDetails")
    public ResponseEntity<ApiResponse> SaveCustomerDetails(@RequestBody List<CustomerDetails> customerDetails) {
        return customerDetailsService.SaveCustomerDetails(customerDetails);
    }

    /**
     *
     * @return
     */
    @GetMapping("/customerList")
    public List<CustomerDetails> customerDetailsList() {
        return customerDetailsService.customerDetailsList();
    }

    /**
     *
     * @param telecomBrands
     * @return
     */
    @PostMapping("/listOfNetworks")
    public ResponseEntity<ApiResponse> addingNetworks(@RequestBody List<TelecomBrands> telecomBrands) {
        return telecomBrandService.addingNetworks(telecomBrands);
    }

    /**
     *
     * @param Plans
     * @return
     */
    @PostMapping("/listOfPlans")
    public ResponseEntity<ApiResponse> addPlan(@RequestBody List<Plans> Plans) {
        return telecomBrandService.addPlan(Plans);
    }

    /**
     *
     * @return
     */
    @GetMapping("/planslist")
    public List<Plans> getPlan() {
        return telecomBrandService.getplan();
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("deactivateCustomer/{id}")
    public ResponseEntity<ApiResponse> deactivateCustomerDetails(@PathVariable  int id){
        customerDetailsService.deactivateCustomerDetails(id);
        return ResponseEntity.ok(new ApiResponse(200, "Success", new Date().toString()));
    }
}