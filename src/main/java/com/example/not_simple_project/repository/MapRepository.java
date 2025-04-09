package com.example.not_simple_project.repository;

import com.example.not_simple_project.entity.EntityKeyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends JpaRepository<EntityKeyValue, Long> {

}
