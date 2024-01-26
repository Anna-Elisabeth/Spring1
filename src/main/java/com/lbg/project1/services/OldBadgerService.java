//package com.lbg.project1.services;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.lbg.project1.domain.Badger;
//
//@Service
//public class OldBadgerService {
//
//	private List<Badger> badgers = new ArrayList<>();
//
//	public ResponseEntity<Badger> createBadger(Badger newBadger) {
//		this.badgers.add(newBadger);
//
//		// returns the last element in the list
//		Badger body = this.badgers.get(this.badgers.size() - 1);
//		return new ResponseEntity<Badger>(body, HttpStatus.CREATED);
//	}
//
//	public List<Badger> getBadgers() {
//		return badgers;
//	}
//
//	public ResponseEntity<Badger> getBadger(int id) {
//		if (id < 0 || id >= this.badgers.size()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		Badger found = this.badgers.get(id);
//		return ResponseEntity.ok(found);
//	}
//
//	public Badger patchBadger(int id, Badger updatedBadger) {
//
//		Badger badger = this.badgers.get(id);
//
//		badger.setType(updatedBadger.getType());
//
//		badger.setSkill(updatedBadger.getSkill());
//
//		return badger;
//
//	}
//
//	public Badger deleteBadger(int id)
//
//	{
//		Badger badger = this.badgers.remove(id);
//
//		return badger;
//
//	}
//
//	public Badger updateBadger(int id, Badger newBadger) {
//		return this.badgers.set(id, newBadger);
//	}
//
//}
