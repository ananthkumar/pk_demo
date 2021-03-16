package com.pk.eis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pk.eis.model.EmpDependent;

@Repository
public interface EmpDependentRepo extends JpaRepository<EmpDependent, Integer>{

}
