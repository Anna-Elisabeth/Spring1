package com.lbg.project1.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.project1.domain.Sett;

public interface SettRepo extends JpaRepository<Sett, Integer> {
}
