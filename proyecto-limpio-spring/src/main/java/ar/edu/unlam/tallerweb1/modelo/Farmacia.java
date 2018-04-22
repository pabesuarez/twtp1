package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Farmacia {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String nombre;
	 private String telefono;
	 private String diaDeTurno;
	 @OneToOne
	 private DireccionTP1 direccionTP1;
	 @OneToOne
	 private PuntoGeolocalizacion puntogeolocalizacion;
	 
	public Long getId() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDiaDeTurno() {
		return diaDeTurno;
	}
	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}
	 
	public DireccionTP1 getDireccionTP1() {
		return direccionTP1;
	}
	public void setDireccionTP1(DireccionTP1 direccionTP1) {
		this.direccionTP1 = direccionTP1;
	}
	
	public PuntoGeolocalizacion getPuntoGeolocalizacion() {
		return puntogeolocalizacion;
	}
	public void setPuntoGeolocalizacion(PuntoGeolocalizacion puntoGeolocalizacion) {
		this.puntogeolocalizacion = puntoGeolocalizacion;
	}

}
