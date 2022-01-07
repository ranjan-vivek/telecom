package com.network.telecom.Service;

import com.network.telecom.Model.ApiResponse;
import com.network.telecom.Model.Plans;
import com.network.telecom.Model.TelecomBrands;
import com.network.telecom.Repository.PlansRepository;
import com.network.telecom.Repository.TelecomBrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Service
public class TelecomBrandService {

    @Autowired
    private TelecomBrandsRepository telecomBrandsRepository;
@Autowired
private PlansRepository plansRepository;

    public ResponseEntity<ApiResponse> addingNetworks(List<TelecomBrands> telecomBrands){
        telecomBrandsRepository.saveAll(telecomBrands);
        return ResponseEntity.ok(new ApiResponse(200, "Success", new Date().toString()));
    }
    public ResponseEntity<ApiResponse> addPlan(List<Plans> Plans) {
        plansRepository.saveAll(Plans);
        return ResponseEntity.ok(new ApiResponse(200, "Success", new Date().toString()));
    }

    public List<Plans>  getplan() {
        return plansRepository.findAll();

    }

}

