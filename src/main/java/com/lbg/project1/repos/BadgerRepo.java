package com.lbg.project1.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.project1.domain.Badger;

public interface BadgerRepo extends JpaRepository<Badger, Integer> {

}
