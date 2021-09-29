package com.claudio.escuela.servicios.implementaciones;

import com.claudio.escuela.Repositorios.AlumnoRepository;
import com.claudio.escuela.Repositorios.PersonaRepository;
import com.claudio.escuela.modelo.entidad.Alumno;
import com.claudio.escuela.modelo.entidad.Persona;
import com.claudio.escuela.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service//Es nesesario

//Linea para utilizar la herencia de Clase GenericoDAOImpl
//public class AlumnoDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements AlumnoDAO {
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {
    //Crear instancia alumno repository para acceder a los metodos de CrudRepository
    @Autowired//indica la inyeccion de la dependencia de AlumnoRepository

    /**
     * //PersonaRepository no es un bean como tal,
     * por lo tanto agregar el bean establecido en interfaz  AlumnoRepository de interfaz (@Repository("repositorioAlumnos"))
     */


    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarAlumnoCarrera(String carreraA) {
        //Es nesesario hacer el castero a AlunmoRepository para poder tener acceso al metodo buscarAlumnoCarrera
        return ((AlumnoRepository)repository).buscarAlumnoCarrera(carreraA);
    }
}
