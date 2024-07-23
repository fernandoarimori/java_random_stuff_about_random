package com.example.poerapotty.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRespository extends JpaRepository<Person, Long> {
    @Query(value = """
            SELECT * FROM tb_person WHERE tb_person.consumed=0 ORDER BY RAND() LIMIT 3                        
            """,nativeQuery = true)
    List<Person> findRandom();
}
