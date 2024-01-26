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

import com.lbg.project1.domain.Sett;
import com.lbg.project1.services.SettService;

@RequestMapping("/sett")
@RestController
public class SettController {

	@Autowired
	private SettService service;

	@PostMapping("/create")
	public ResponseEntity<Sett> createSett(@RequestBody Sett newSett) {
		return this.service.createSett(newSett);

	}

	@GetMapping("/get")
	public List<Sett> getSetts() {
		return this.service.getSetts();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Sett> getSett(@PathVariable int id) {
		return this.service.getSett(id);
	}

	@PatchMapping("/patch/{id}")
	public ResponseEntity<Sett> patchSett(@PathVariable int id, @RequestBody Sett updatedSett) {

		return this.service.patchSett(id, updatedSett);

	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteSett(@PathVariable int id)

	{
		return this.service.deleteSett(id);

	}

	@PutMapping("/put/{id}")
	public ResponseEntity<Sett> updateSett(@PathVariable int id, @RequestBody Sett newSett) {
		return this.service.updateSett(id, newSett);

	}

}
