package ar.edu.unlam.tallerweb1.autos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Marca;
import ar.edu.unlam.tallerweb1.modelo.Modelo;

public class ClioTest extends SpringTest{
    @Test
    @Transactional @Rollback(true)
    public void pruebaClio(){
       
    	Marca marca1 = new Marca();
    	marca1.setNombre("Fiat");
    	getSession().save(marca1);
    	
    	Modelo modelo1 = new Modelo();
    	modelo1.setNombre("Clio");
    	modelo1.setMarca(marca1);
    	getSession().save(modelo1);
    	
    	Modelo modelo2 = new Modelo();
    	modelo1.setNombre("Sierra");
    	modelo1.setMarca(marca1);
    	getSession().save(modelo2);
    	
    	Auto auto1 = new Auto();
    	auto1.setPatente("AAA 222");
    	auto1.setColor("Azul");
    	getSession().save(auto1);
    	
    	Auto auto2 = new Auto();
    	auto2.setPatente("AAA 111");
    	auto2.setColor("Rojo");
    	getSession().save(auto2);
    	
    	List<Auto> Resultado =
    	getSession().createCriteria(Auto.class).list();
    	
    	for (Auto busqueda: Resultado){
    		assertThat(busqueda.getModelo().getNombre()).isEqualTo("Clio");
    	}
    	

    	
    }
}
