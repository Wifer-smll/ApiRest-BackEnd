package com.ecodeup.api.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecodeup.api.apirest.model.Estudiante;

@RestController //Anotacion le dice al framework que esta clase esta definida como un controlador
				//y que por ende todos los metodos que esten alli van a mapear peticiones desde el cliente 

@CrossOrigin(origins = "http://localhost:6060") // Anotacion para conectar las peticiones del front - Define la interacción entre cliente - servidor

public class EstudianteController {
	
	//Objeto que se instancie de la clase Service
	@Autowired //Atributo para Inyeccion de dependencias El Framework lo reconoce
	private EstudianteService estudianteServices;
	
	@GetMapping("api/estudiante")//Anotación de Spring Framework que nos permite simplificar el manejo de los diferentes métodos de Spring MVC
					//La ultima pablara hace referencia a lo que voy a obtener Todo api/estudiante es el endPoint
	public List<Estudiante> obtenerEstudiantes(){
		   List<Estudiante> listaEstudiantes = new ArrayList<>(); //Cargar en Array
		   
		   //Guardar en la DB de Mysql
		   
		   Estudiante e = new Estudiante(); //Objeto Estudiante
		   e.setId(1);
		   e.setNombres("Joel");
		   e.setApellidos("Miller");
		   e.setEmail("Joelmile@tlofu2.com");
		   e.setNota(5D);
		   
		   Estudiante e1 = new Estudiante(); //Objeto Estudiante2
		   e.setId(2);
		   e.setNombres("Ellie");
		   e.setApellidos("Miller");
		   e.setEmail("Elliemile@tlofu2.com");
		   e.setNota(5D);
		   
		   listaEstudiantes.add(e);
		   listaEstudiantes.add(e1);
		   
		return listaEstudiantes;
	}
	
	//@PostMapping es una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.POST).
	@PostMapping ("api/estudiantes")//@PostMapping Anotacion que permite definir que tipo de peticion estamos haciendo
	//Metodo para implementar nuevo EndPoint //Lleva por PARMETROS Objeto Estudiante tipo estudiante
	public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante) {
								//@RequestBody Anotacion indica que un parámetro del método debe estar unido a un parámetro de petición web 
							//Para este caso se esta diciendo que va a ver una peticion que viene en formato Json y debe trasformala al formato de nuestra clase java	
		System.out.println(estudiante);//Imprimir estudiante que viene desde el cliente para ver si llega correctamente
		estudianteServices.guardarEstudiante(estudiante);
		return estudiante;//Se retorna estudiante para verlo despues de la peticion
	}
	
	@GetMapping("api/estudiantes") //Permite recibir todas las peticiones que vengan desde el cliente
	//Recurso para obtener todos los estudiantes desde base de datos
	public List<Estudiante> obtenerTodos (){
		return estudianteServices.obtenerTodos();
		}
	
	@GetMapping("api/estudiantes/{id}")//EndPoint + parametro id para poder buscar el estudiante y devolverlo
	//Recurso para obtener un estudiante desde base de datos
	public Estudiante obtenerEstudiante(@PathVariable ("id")Integer id) {//@PathVariable anotacion para indicar que se recibe un parametro desde el cliente y convertilo a tipo Integer
		return estudianteServices.obtenerEstudiante(id);
	}
	
	@PutMapping("api/estudiantes") //@PutMapping Anotacion para actualizar recurso para este caso el EndPoint de nuestra DB
	//Recurso para actualizar un estudiante desde base de datos
	public void actualizarEstudiante(@RequestBody Estudiante estudiante) {//@RequestBody para indicar que viene un objeto desde el cliente
		estudianteServices.actualizarEstudiante(estudiante); //Se llama estudianteServices Y se llama al metodo actualizar
	}
	
	@DeleteMapping("api/estudiantes/{id}")//@DeleteMapping Anotacion para eliminar recurso para este caso el EndPoint de nuestra DB por id
	//Recurso para eliminar 1 estudiante desde base de datos Parametros los que se va recibir desde el cliente
	public void eliminarEstudiante(@PathVariable ("id")Integer id) {//@PathVariable anotacion para indicar que se recibe un parametro desde el cliente y convertilo a tipo Integer	
		estudianteServices.eliminarEstudiante(id);//Se llama estudianteServices Y se llama al metodo eliminar
	}
	
	}

