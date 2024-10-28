package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CarModel;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Integer> {

}
