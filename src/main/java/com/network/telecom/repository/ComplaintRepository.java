package com.network.telecom.repository;

import com.network.telecom.model.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaints,Integer> {
}
