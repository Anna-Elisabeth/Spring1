package com.lbg.project1.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.project1.domain.Badger;

@RestController
public class BadgerController {

	private List<Badger> badgers = new ArrayList<>();

	@PostMapping("/create")
	public ResponseEntity<Badger> createBadger(@RequestBody Badger newBadger) {
		this.badgers.add(newBadger);

		// returns the last element in the list
		Badger body = this.badgers.get(this.badgers.size() - 1);
		return new ResponseEntity<Badger>(body, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public List<Badger> getBadgers() {
		return badgers;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Badger> getBadger(@PathVariable int id) {
		if (id < 0 || id >= this.badgers.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Badger found = this.badgers.get(id);
		return ResponseEntity.ok(found);
	}

	@PatchMapping("/patch/{id}")
	public Badger patchBadger(@PathVariable int id, @RequestBody Badger updatedBadger) {

		Badger badger = this.badgers.get(id);

		badger.setType(updatedBadger.getType());

		badger.setSkill(updatedBadger.getSkill());

		return badger;

	}

	@DeleteMapping("/delete/{id}")
	public Badger deleteBadger(@PathVariable int id)

	{
		Badger badger = this.badgers.remove(id);

		return badger;

	}

	@PutMapping("/update/{id}")
	public Badger updateBadger(@PathVariable int id, @RequestBody Badger newBadger) {
		return this.badgers.set(id, newBadger);
	}

}
