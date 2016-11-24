package com.galaxy.project.model;

import javax.persistence.Embeddable;

@Embeddable
public class Position {
	
	protected int rah;
	protected int ram;
	protected float ras;
	protected char dasign;
	protected int dad;
	protected int dam;
	protected float das;
	
	public Position(int rah, int ram, float ras, char dasign, int dad, int dam,
			float das) {
		super();
		this.rah = rah;
		this.ram = ram;
		this.ras = ras;
		this.dasign = dasign;
		this.dad = dad;
		this.dam = dam;
		this.das = das;
	}

	public int getRah() {
		return rah;
	}

	public void setRah(int rah) {
		this.rah = rah;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public float getRas() {
		return ras;
	}

	public void setRas(float ras) {
		this.ras = ras;
	}

	public char getDasign() {
		return dasign;
	}

	public void setDasign(char dasign) {
		this.dasign = dasign;
	}

	public int getDad() {
		return dad;
	}

	public void setDad(int dad) {
		this.dad = dad;
	}

	public int getDam() {
		return dam;
	}

	public void setDam(int dam) {
		this.dam = dam;
	}

	public float getDas() {
		return das;
	}

	public void setDas(float das) {
		this.das = das;
	}
	
	
}
