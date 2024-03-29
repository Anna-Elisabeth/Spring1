package com.lbg.project1.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.project1.domain.Badger;
import com.lbg.project1.services.BadgerService;

@RequestMapping("/badger")
@RestController
public class BadgerController {

	@Autowired
	private BadgerService service;

	@PostMapping("/create")
	public ResponseEntity<Badger> createBadger(@RequestBody Badger newBadger) {
		return this.service.createBadger(newBadger);
	}

	@GetMapping("/get")
	public List<Badger> getBadgers() {
		return this.service.getBadgers();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Badger> getBadger(@PathVariable int id) {
		return this.service.getBadger(id);

	}

	@PatchMapping("/patch/{id}")
	public ResponseEntity<Badger> patchBadger(@PathVariable int id, @RequestBody Badger updatedBadger) {

		return this.service.patchBadger(id, updatedBadger);

	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteBadger(@PathVariable int id)

	{
		return this.service.deleteBadger(id);

	}

	@PutMapping("/put/{id}")
	public ResponseEntity<Badger> updateBadger(@PathVariable int id, @RequestBody Badger newBadger) {
		return this.service.updateBadger(id, newBadger);

	}

}
