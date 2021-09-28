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
			Persona alumno = new Alumno(null, "Claudio","Sanchez","1234567",new Direccion("5 poniente","24","234567","","","San Marcos"));
			Persona save = alumnoDAOServicio.save(alumno);
			System.out.println(save.toString());
		};
	}





}
