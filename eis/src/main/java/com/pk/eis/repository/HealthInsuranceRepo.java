package com.pk.eis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pk.eis.model.HealthInsurance;

@Repository
public interface HealthInsuranceRepo extends JpaRepository<HealthInsurance, Integer>{

}
