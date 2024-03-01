package com.company.repository;


import com.company.entity.Empolyee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpolyeeRepository extends JpaRepository<Empolyee, Long>{
}