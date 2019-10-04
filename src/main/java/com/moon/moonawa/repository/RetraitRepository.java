package com.moon.moonawa.repository;

import com.moon.moonawa.model.Retrait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetraitRepository extends JpaRepository<Retrait, Integer> {

}