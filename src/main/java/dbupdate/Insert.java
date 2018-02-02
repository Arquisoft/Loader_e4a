package dbupdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;

import model.User;

/**
 * 
 * @author Ignacio Escribano Burgos
 * Gestiona la conexión con la base de datos
 *
 */
public interface Insert {
	User save(User user) throws FileNotFoundException, DocumentException, IOException;

	List<User> findByDNI(String dni);

	List<User> findByEmail(String email);
}
