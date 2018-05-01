package com.org.model;

public class DealStatusPercentage {

	private String name;
	private Double y;

	public DealStatusPercentage() {
	}

	public DealStatusPercentage(String name, Double y) {
		this.name = name;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

}
