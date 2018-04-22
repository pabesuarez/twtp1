package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Empresa;

public class OneToOneTest extends SpringTest{
	
	@Test
	@Transactional
	public void EmpresaTest() {
		Direccion miDireccion = new Direccion();
		miDireccion.setId(1);
		miDireccion.setCalle("Calle 1");
		miDireccion.setNumero(2000);
		Session session=getSession();
		session.save(miDireccion);
		
		Empresa miEmpresa = new Empresa();
		miEmpresa.setId(1);
		miEmpresa.setNombre("Empresa1");
		miEmpresa.setDireccion(miDireccion);
		
		
		session.save(miEmpresa);
		
		Empresa buscada=session.get(Empresa.class,miEmpresa.getId());//lo busca por su id
		
		assertThat(buscada).isNotNull();
		assertThat(buscada.getDireccion().getNumero()).isEqualTo(2000);
		
		
	}

}
