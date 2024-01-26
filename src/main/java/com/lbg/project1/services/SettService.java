package com.lbg.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.project1.domain.Sett;
import com.lbg.project1.repos.SettRepo;

@Service
public class SettService {

	private SettRepo repo;

	public SettService(SettRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Sett> createSett(Sett newSett) {
		Sett created = this.repo.save(newSett);

		return new ResponseEntity<Sett>(created, HttpStatus.CREATED);
	}

	public List<Sett> getSetts() {
		return this.repo.findAll();
	}

	public ResponseEntity<Sett> getSett(int id) {

		Optional<Sett> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a badger
			return new ResponseEntity<Sett>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the badger out of the box
		Sett body = found.get();

		return ResponseEntity.ok(body);

	}

//	patch
	public ResponseEntity<Sett> patchSett(int id, Sett updatedSett) {

		// returns a box that might have a badger in it
		Optional<Sett> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a badger
			return new ResponseEntity<Sett>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Sett existing = found.get();

		if (updatedSett.getLocation() != null) {
			existing.setLocation(updatedSett.getLocation());
		}

		if (updatedSett.getMaterial() != null) {
			existing.setMaterial(updatedSett.getMaterial());
		}

		Sett updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

	public boolean deleteSett(int id) {

		this.repo.deleteById(id);

		return !this.repo.existsById(id);

	}

//	@PutMapping("/put/{id}")
	public ResponseEntity<Sett> updateSett(int id, Sett newSett) {

		// returns a box that might have a badger in it
		Optional<Sett> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a badger
			return new ResponseEntity<Sett>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Sett existing = found.get();

		existing.setLocation(newSett.getLocation());

		existing.setMaterial(newSett.getMaterial());

		Sett updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

}
