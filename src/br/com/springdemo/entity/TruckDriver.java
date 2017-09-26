package br.com.springdemo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "truck_driver")
public class TruckDriver {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@NotNull(message="campo obrigat�rio")
	@Size(min=1, message="campo obrigat�rio")
	private String name;
	
	@Column(name = "document_id")
	@NotNull(message="campo obrigat�rio")
	@Size(min=1, message="campo obrigat�rio")
	@Pattern(regexp="[0-9]{11}", message="CPF inv�lido")
	private String documentID; // CPF
	
	@Column(name = "email")
	@NotNull(message="campo obrigat�rio")
	@Size(min=1, message="campo obrigat�rio")
	@Pattern(regexp=".+@.+\\..+", message="e-mail inv�lido")
	private String email;

	@Column(name = "licence_plate")
	@NotNull(message="campo obrigat�rio")
	@Size(min=1, message="campo obrigat�rio")
	@Pattern(regexp="\\w{3}\\d{4}", message="placa do ve�culo inv�lida")
	private String licencePlate;

	@Column(name = "phone")
	@NotNull(message="campo obrigat�rio")
	@Size(min=1, message="campo obrigat�rio")
	private String phoneNumber;

	@Column(name = "modified")
	private Timestamp modified;

	public TruckDriver() {

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "TruckDriver [id=" + id + ", name=" + name + ", documentID=" + documentID + ", email=" + email
				+ ", licencePlate=" + licencePlate + ", phoneNumber=" + phoneNumber + ", modified=" + modified + "]";
	}

}
