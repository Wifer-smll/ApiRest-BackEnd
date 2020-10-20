package com.ecodeup.api.apirest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity //Para que la reconozca el framework
@Table(name="estudiantes") //Anotacion para acceder a la tabla de la DB
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})//Anotacion para ingnorar propiedades antes de que se cargue el objeto y se pueda serializar sin ningun problema
public class Estudiante {
	@Id //Clave primaria de la tabla
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Para generar columna autoincrementable
	private Integer id;
	private String nombres;
	private String apellidos;
	private String email;
	private Double nota;
	
	public Estudiante () {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	@Override //Para que aparezca en el debug la variables
	public String toString() {
		return "Estudiante [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email
				+ ", nota=" + nota + "]";
	}
	
	

}
