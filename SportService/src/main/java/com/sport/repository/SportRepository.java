package com.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sport.entity.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer>{

}
