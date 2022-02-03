package com.network.telecom.repository;

import com.network.telecom.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails,Integer> {
CustomerDetails findByPhoneNo(long phoneNo);
long deleteByPhoneNo(long phoneNo);

}
