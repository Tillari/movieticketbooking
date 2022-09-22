package com.movieticketbooking.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int C_id;

	@Column(nullable = false)
	@NotEmpty
	private String C_name;

	@NotEmpty
	private String C_pincode;

	@NotEmpty
	private String C_state;

	@OneToMany
	@JoinColumn(name = "T_id")
	private List<Theater> theater;

	public int getC_id() {
		return C_id;
	}

	public void setC_id(int c_id) {
		C_id = c_id;
	}

	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		C_name = c_name;
	}

	public String getC_pincode() {
		return C_pincode;
	}

	public void setC_pincode(String c_pincode) {
		C_pincode = c_pincode;
	}

	public String getC_state() {
		return C_state;
	}

	public void setC_state(String c_state) {
		C_state = c_state;
	}

	public List<Theater> getTheater() {
		return theater;
	}

	public void setTheater(List<Theater> theater) {
		this.theater = theater;
	}

	public City(int c_id, @NotEmpty String c_name, @NotEmpty String c_pincode, @NotEmpty String c_state) {
		super();
		C_id = c_id;
		C_name = c_name;
		C_pincode = c_pincode;
		C_state = c_state;
	}

}
