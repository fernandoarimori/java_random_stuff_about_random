package com.example.poerapotty.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends JpaRepository<ResultPortaPotty, Long> {
    @Query(value = """
            SELECT * FROM tb_result ORDER BY RAND() LIMIT 1                        
            """,nativeQuery = true)
    ResultPortaPotty findRandom();

//    @Query(value = """
//
//            """,nativeQuery = true)
//    void updatePerson(Long id);
}
