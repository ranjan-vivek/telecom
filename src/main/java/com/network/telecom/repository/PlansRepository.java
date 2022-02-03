package com.network.telecom.repository;

import com.network.telecom.model.Plans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlansRepository extends JpaRepository<Plans,Integer> {

}
