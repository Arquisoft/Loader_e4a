package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Agent")
public class Agent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(unique=true)
	private String id;
	private String nombre;
	private String email;
	private String localizacion;
	private String username;
	private String password;
	private int type;

	public Agent(String nombre, String email, String localizacion, int type, String id) {
		setNombre(nombre);
		setEmail(email);
		setLocalizacion(localizacion);
		setType(type);
		setID(id);
		setUsername(email);
		generarPassword();
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getLocalizacion() {
		return this.localizacion;
	}
	
	private void setLocalizacion(String direccionPostal) {
		this.localizacion = direccionPostal;
	}

	public int getType() {
		return type;
	}

	private void setType(int type) {
		this.type = type;
	}

	Agent() {
	}

	public String getID() {
		return this.id;
	}

	private void setID(String id) {
		this.id = id;
	}

	private void generarPassword() {
		StringBuffer pass = new StringBuffer();
		int low = 65;
		int top = 90;
		for (int i = 0; i < 9; i++) {
			int numAleatorio = (int) Math.floor(Math.random() * (top - low) + low);
			pass.append((char) numAleatorio);
		}
		for (int i = 0; i < 3; i++) {
			int numAleatorio = (int) Math.floor(Math.random() * (9 - 0) + 0);
			pass.append(numAleatorio);
		}
		setPassword(pass.toString());
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agent [nombre=" + nombre + ", email=" + email + ", localizacion=" + localizacion + ", nif=" + id
				+ ", type=" + type + "]";
	}
	
}
