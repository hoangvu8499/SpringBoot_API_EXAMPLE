package com.example.practice.repository;

import com.example.practice.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

//    Page<Person> findAll(Pageable pageable);
//    List<Person> findAll(Pageable pageable);


}
