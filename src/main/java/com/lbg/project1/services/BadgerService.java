package com.lbg.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.project1.domain.Badger;
import com.lbg.project1.repos.BadgerRepo;

@Service
public class BadgerService {

	private BadgerRepo repo;

	public BadgerService(BadgerRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Badger> createBadger(Badger newBadger) {
		Badger created = this.repo.save(newBadger);

		return new ResponseEntity<Badger>(created, HttpStatus.CREATED);
	}

	public List<Badger> getBadgers() {
		return this.repo.findAll();
	}

	public ResponseEntity<Badger> getBadger(int id) {

		Optional<Badger> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a badger
			return new ResponseEntity<Badger>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the badger out of the box
		Badger body = found.get();

		return ResponseEntity.ok(body);

	}

//	@PatchMapping("/patch/{id}")
	public ResponseEntity<Badger> patchBadger(int id, Badger updatedBadger) {

		// returns a box that might have a badger in it
		Optional<Badger> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a badger
			return new ResponseEntity<Badger>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Badger existing = found.get();

		if (updatedBadger.getType() != null) {
			existing.setType(updatedBadger.getType());
		}

		if (updatedBadger.getSkill() != null) {
			existing.setSkill(updatedBadger.getSkill());
		}

		Badger updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

	public boolean deleteBadger(int id) {

		this.repo.deleteById(id);

		return !this.repo.existsById(id);

	}

//	@PutMapping("/put/{id}")
	public ResponseEntity<Badger> updateBadger(int id, Badger newBadger) {

		// returns a box that might have a badger in it
		Optional<Badger> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a badger
			return new ResponseEntity<Badger>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Badger existing = found.get();

		existing.setType(newBadger.getType());

		existing.setSkill(newBadger.getSkill());

		Badger updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

}
