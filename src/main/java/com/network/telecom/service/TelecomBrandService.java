package com.network.telecom.service;

import com.network.telecom.model.*;
import com.network.telecom.repository.ComplaintRepository;
import com.network.telecom.repository.PlansRepository;
import com.network.telecom.repository.TelecomBrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TelecomBrandService {

    @Autowired
    private TelecomBrandsRepository telecomBrandsRepository;
@Autowired
private PlansRepository plansRepository;
@Autowired
private ComplaintRepository complaintRepository;
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

    public ResponseEntity<MessageResponse> complaint(Complaints complaints) {
        complaintRepository.save(complaints);
        return ResponseEntity.ok(new MessageResponse("your complaint registered successfully"));
    }
    public  List<Complaints> getComplaintsList() {

        return  complaintRepository.findAll();
    }
    public ResponseEntity<MessageResponse> updateNetworkInfo( String brandName,TelecomBrands telecomBrands){
        TelecomBrands telecomBrandsUpdate = telecomBrandsRepository.findByBrandName(brandName) ;
//        telecomBrandsUpdate.setBrandName(telecomBrands.getBrandName());
        telecomBrandsUpdate.setBandWidth(telecomBrands.getBandWidth());
        telecomBrandsUpdate.setPrice(telecomBrands.getPrice());

        telecomBrandsRepository.save(telecomBrandsUpdate);
        return ResponseEntity.ok(new MessageResponse("updated successfully"));
    }
    public ResponseEntity<MessageResponse> deleteNetwork( String networkName) {
        telecomBrandsRepository.deleteByBrandName(networkName);
        return ResponseEntity.ok(new MessageResponse("Network Removed"));
}

}