package com.network.telecom.Repository;

import com.network.telecom.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails,Integer> {


}
