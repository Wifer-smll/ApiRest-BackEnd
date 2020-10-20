//Interface para implementar la logica de nuestro crud

package com.ecodeup.api.apirest.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecodeup.api.apirest.model.Estudiante;


@Repository //Para que Framework la reconozca
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
//EstudianteRepository Interface para acceder a la DB para realizar los metodos Cruds
//extends JpaRepository para acceder a metodos Crud
//<Estudiante, Integer> Parametros modelo el cual se va a afectar Estudiante.java Integer el tipo de dato para el acceso Crud
	
}
