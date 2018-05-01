package ar.edu.unlam.tallerweb1.tp1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class TurnoTest extends SpringTest {

	@Test
	@Transactional @Rollback(true)
	public void BuscarPorTurno(){
		Farmacia farmacia1 = new Farmacia();
		farmacia1.setDiaDeTurno("martes");
		farmacia1.setNombre("farmacia1");
		farmacia1.setTelefono("1111");
		getSession().save(farmacia1);
		
		Farmacia farmacia2 = new Farmacia();
		farmacia2.setDiaDeTurno("lunes");
		farmacia2.setNombre("farmacia2");
		farmacia2.setTelefono("1111");
		getSession().save(farmacia2);
		
		List<Farmacia> Resultado = getSession().createCriteria(Farmacia.class).add(Restrictions.eq("diaDeTurno", "martes")).list();
    	for (Farmacia busqueda: Resultado){
    		assertThat(busqueda.getDiaDeTurno()).isEqualTo("martes");
    		
    	}  
	}
	
}
