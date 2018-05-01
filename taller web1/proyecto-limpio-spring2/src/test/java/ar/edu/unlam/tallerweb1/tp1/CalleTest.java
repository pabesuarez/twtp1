package ar.edu.unlam.tallerweb1.tp1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Comuna;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class CalleTest extends SpringTest{

	@Test
	@Transactional @Rollback(true)
	public void BuscarPorCalle(){
		Comuna comuna1 = new Comuna();
		comuna1.setNombre("Comuna1");
		
		Comuna comuna2 = new Comuna();
		comuna1.setNombre("Comuna2");
		
		Barrio barrio1 = new Barrio();
		barrio1.setNombre("barrio1");
		barrio1.setComuna(comuna1);
		comuna1.getBarrios().add(barrio1);
		
		Barrio barrio2 = new Barrio();
		barrio2.setNombre("barrio2");
		barrio2.setComuna(comuna1);
		comuna1.getBarrios().add(barrio2);
		
		Barrio barrio3 = new Barrio();
		barrio3.setNombre("barrio3");
		barrio3.setComuna(comuna2);
		comuna2.getBarrios().add(barrio3);
		
		Direccion direccion1 = new Direccion();
		direccion1.setCalle("aaaa");
		direccion1.setNumero(123);
		direccion1.setBarrio(barrio1);
		
		Direccion direccion2 = new Direccion();
		direccion2.setCalle("aaaa");
		direccion2.setNumero(123);
		direccion2.setBarrio(barrio1);
		
		Direccion direccion3 = new Direccion();
		direccion3.setCalle("aaaa");
		direccion3.setNumero(123);
		direccion3.setBarrio(barrio2);
		
		Direccion direccion4 = new Direccion();
		direccion4.setCalle("aaaa");
		direccion4.setNumero(123);
		direccion4.setBarrio(barrio3);
		
		Farmacia farmacia1 = new Farmacia();
		farmacia1.setDiaDeTurno("martes");
		farmacia1.setNombre("farmacia1");
		farmacia1.setTelefono("1111");
		farmacia1.setDireccion(direccion1);
		getSession().save(farmacia1);
		
		Farmacia farmacia2 = new Farmacia();
		farmacia1.setDiaDeTurno("martes");
		farmacia1.setNombre("farmacia1");
		farmacia1.setTelefono("1111");
		farmacia1.setDireccion(direccion2);
		getSession().save(farmacia2);
		
		Farmacia farmacia3 = new Farmacia();
		farmacia1.setDiaDeTurno("martes");
		farmacia1.setNombre("farmacia1");
		farmacia1.setTelefono("1111");
		farmacia1.setDireccion(direccion3);
		getSession().save(farmacia3);
		
		List<Farmacia> Resultado = getSession().createCriteria(Farmacia.class).add(Restrictions.eq("diaDeTurno", "martes")).list();
    	for (Farmacia busqueda: Resultado){
    		assertThat(busqueda.getDiaDeTurno()).isEqualTo("martes");
    		
    	}  
	}
	
}
