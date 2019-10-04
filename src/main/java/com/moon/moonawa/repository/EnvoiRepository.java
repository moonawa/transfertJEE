package com.moon.moonawa.repository;

import com.moon.moonawa.model.Envoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvoiRepository extends JpaRepository<Envoi, Integer> {

}