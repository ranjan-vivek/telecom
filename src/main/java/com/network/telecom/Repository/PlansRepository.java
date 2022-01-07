package com.network.telecom.Repository;

import com.network.telecom.Model.Plans;
import com.network.telecom.Model.TelecomBrands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlansRepository extends JpaRepository<Plans,Integer> {

}
