package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Empleado;
import ar.edu.unlam.tallerweb1.modelo.Empresa;

public class ManyToOneTest extends SpringTest{
	
	@Test
	@Transactional
	public void EmpleadoTest() {
		Direccion miDireccion = new Direccion();
		miDireccion.setId(2);
	    miDireccion.setCalle("Calle 2");
		miDireccion.setNumero(3000);
		Session session=getSession();
		session.save(miDireccion);
		
		Empresa miEmpresa = new Empresa();
		miEmpresa.setId(2);
		miEmpresa.setNombre("Empresa2");
		miEmpresa.setDireccion(miDireccion);
		
		session.save(miEmpresa);
		
		Empleado miEmpleado1 = new Empleado();
		miEmpleado1.setNombre("Juan");
		miEmpleado1.setApellido("Perez");
		miEmpleado1.setEmpresa(miEmpresa);
		
		session.save(miEmpleado1);
		
Empleado buscado=session.get(Empleado.class,miEmpleado1.getId());//lo busca por su id
		
		assertThat(buscado).isNotNull();
		assertThat(buscado.getEmpresa().getNombre()).isEqualTo("Empresa2");
		
		
		
	}

}
