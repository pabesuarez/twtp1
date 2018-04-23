package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Marca;
import ar.edu.unlam.tallerweb1.modelo.Modelo;


public class BuscarAutoPorColor extends SpringTest{
	
	@Test
	@Transactional @Rollback(true)
	public void BuscarAutoAzul(){
		
		Marca miMarca1 = new Marca();
		miMarca1.setNombre("Fiat");
		getSession().save(miMarca1);
		
		
		Modelo miModelo1 = new Modelo();
		miModelo1.setNombre("Uno");
		miModelo1.setMarca(miMarca1);
		getSession().save(miModelo1);
		
		
		Auto miAuto1 = new Auto();
		miAuto1 .setColor("Azul");
		miAuto1 .setPatente("AAA 111");
		miAuto1 .setModelo(miModelo1);
		getSession().save(miAuto1 );
	
			Marca miMarca2 = new Marca();
			miMarca2.setNombre("Renault");
			getSession().save(miMarca2);
			
			
			Modelo miModelo2 = new Modelo();
			miModelo2.setNombre("Clio");
			miModelo2.setMarca(miMarca2);
			getSession().save(miModelo2);
			
			
			Auto miAuto2 = new Auto();
			miAuto2.setColor("Rojo");
			miAuto2.setPatente("BBB 222");
			miAuto2.setModelo(miModelo2);
			getSession().save(miAuto2);
			
			
				
				Marca miMarca3 = new Marca();
				miMarca3.setNombre("Peugueot");
				getSession().save(miMarca3);
				
				
				Modelo miModelo3 = new Modelo();
				miModelo3.setNombre("408");
				miModelo3.setMarca(miMarca3);
				getSession().save(miModelo3);
				
				
				Auto miAuto3 = new Auto();
				miAuto3.setColor("Negro");
				miAuto3.setPatente("CCC 333");
				miAuto3.setModelo(miModelo3);
				getSession().save(miAuto3);
			
				
				
				Modelo miModelo4 = new Modelo();
				miModelo4.setNombre("206");
				miModelo4.setMarca(miMarca3);
				getSession().save(miModelo4);
				
				
				Auto miAuto4 = new Auto();
				miAuto4.setColor("Azul");
				miAuto4.setPatente("DDD 333");
				miAuto4.setModelo(miModelo4);
				getSession().save(miAuto4);
				
				
			
				
				
				Auto miAuto5 = new Auto();
				miAuto5.setColor("Negro");
				miAuto5.setPatente("EEE 555");
				miAuto5.setModelo(miModelo3);
				getSession().save(miAuto5);
		
	
	
	
    	List<Auto> Resultado =getSession().createCriteria(Auto.class).add(Restrictions.eq("color", "Azul")).list();
    	
    	for (Auto busqueda: Resultado){
    		assertThat(busqueda.getColor()).isEqualTo("Azul");
    		
    	}   	
    	
    	}    	

}
