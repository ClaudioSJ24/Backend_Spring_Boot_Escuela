package com.claudio.escuela;

import com.claudio.escuela.modelo.entidad.Alumno;
import com.claudio.escuela.modelo.entidad.Direccion;
import com.claudio.escuela.modelo.entidad.Persona;
import com.claudio.escuela.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

@SpringBootApplication
public class EscuelaApplication {

	@Autowired
	private AlumnoDAO alumnoDAOServicio;
	public static void main(String[] args) {
		String[] beanDefinitionNames= SpringApplication.run(EscuelaApplication.class, args).getBeanDefinitionNames();
		/*for (String str: beanDefinitionNames
			 ) {
			System.out.println(str);
			
		}*/
		
	}

	//forma alternativa para ejecutar el programa mediante un bean en especifico

	@Bean
	public CommandLineRunner runner(){
		return args -> {
			//Codigo para insertar un alumno
			/*Persona alumno = new Alumno(null, "Aldo","Lopez","12345234",new Direccion("7 poniente","45","23478","","","Tlacotepec"));
			Persona save = alumnoDAOServicio.save(alumno);
			System.out.println(save.toString());*/

			//Codigo para vizualizar los dos alumnos persistidos en la base de dtos

			List<Persona> alumnos = (List<Persona>) alumnoDAOServicio.findAll();
			alumnos.forEach(System.out::println);
		};
	}





}
