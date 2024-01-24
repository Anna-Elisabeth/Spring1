package com.lbg.project1.domain;

public class Badger {

	private String type;

	private String skill;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Badger [type=" + type + ", Skill=" + skill + "]";
	}

}
