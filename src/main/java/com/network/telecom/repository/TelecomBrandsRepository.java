package com.network.telecom.repository;

import com.network.telecom.model.TelecomBrands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelecomBrandsRepository extends JpaRepository<TelecomBrands,Integer> {
    TelecomBrands findByBrandName(String brandName);
    long deleteByBrandName (String brandName);
}
