//Clase para crear metodos y logica del Crud

package com.ecodeup.api.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecodeup.api.apirest.model.Estudiante;

@Service //Anotacion para clase de servicio
public class EstudianteService {
	
	@Autowired //Atributo para Inyeccion de dependencias El Framework lo reconoce
	
	//Objeto que se instancie de la interface creada EstudianteRepository
	private EstudianteRepository estudianteRepository;
	
	public void guardarEstudiante (Estudiante estudiante) { //Objeto Estudiante de tipo estudiante
		estudianteRepository.save(estudiante);
	}
	
	public List<Estudiante>obtenerTodos(){ //Metodo para obtener todos estudiantes desde base de datos
		return estudianteRepository.findAll(); //findAll metodo para obtener todos los registros de la DB
	}
	
	public Estudiante obtenerEstudiante(Integer id) {//Metodo para obtener 1 estudiante desde base de datos
		return estudianteRepository.getOne(id);//getOne () devuelve una referencia a la entidad con el identificador dado
	}
	
	public void actualizarEstudiante (Estudiante estudiante) {//Metodo para actualizar 1 estudiante en la base de datos
		estudianteRepository.save(estudiante);//.save() Guardar datos en la DB
	}
	
	public void eliminarEstudiante (Integer id) {//Metodo para eliminar 1 estudiante en la base de datos
		estudianteRepository.deleteById(id);//deleteById(id) Eliminar por el id que viene desde el cliente
	}
}
