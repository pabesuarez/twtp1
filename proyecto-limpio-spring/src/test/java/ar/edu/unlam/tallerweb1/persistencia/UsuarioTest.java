package ar.edu.unlam.tallerweb1.persistencia;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import static org.assertj.core.api.Assertions.*;
public class UsuarioTest extends SpringTest{

	
	@Test
	@Transactional
public void guardarUsuario(){
		Usuario seba = new Usuario();
		seba.setEmail("dasdasd");
		Session session=getSession();
		session.save(seba);
		
		//estoy obteniendo el id del usuario seba,lo estoy buscando ya en la base para ver si se inserto
		Usuario buscado=session.get(Usuario.class,seba.getId());//lo busca por su id
		
	assertThat(buscado).isNotNull();
	}
	
	@Test
	@Transactional
public void eliminarUsuario(){
		
		Usuario juan = new Usuario();
		Session session=getSession();
		
		session.save(juan);
		session.delete(juan);
		
Usuario buscado=session.get(Usuario.class,juan.getId());
    assertThat(buscado).isNull();
	}

	@Test
	@Transactional
public void actualizarUsuario(){
		
		Usuario pepe = new Usuario();
		Session session=getSession();
		
		session.save(pepe);
		session.delete(pepe);
		
Usuario buscado=session.get(Usuario.class,pepe.getId());
    assertThat(buscado).isNull();
	}
	
	
}
