package main;

import com.lowagie.text.DocumentException;

import parser.ReaderSingleton;

/**
 * 
 *  Aplicacion principal.
 *  
 *  @author Antonio Payá González(UO251065)
 *  @author Pablo Amorin Triana (UO237060)
 *  @author Hugo Perez Fernandez (UO250708)
 *  @author Ivan Casielles Alvarez (UO251063)
 *  @author Mirza Ojeda Vieira (UO251443)
 */
public class LoadAgents {

	/**
	 * 
	 * @param args Argumentos de entrada del programa. El primero sera la accion a realizar. Podra ser --help, info, o load
	 * @param args El segundo parametro, en el caso de usarse la opción load sera la localizacion del fichero a cargar.
	 *					
	 * @throws DocumentException
	 */
	public static void main(String... args) throws DocumentException {
		final LoadAgents runner = new LoadAgents();
		runner.run(args);
	}

	/**
	 * Ejecuta la aplicacion con los parametros introducidos por consola
	 * @param args, Parametros necesarios para ejecutar la aplicacion
	 * @throws DocumentException
	 */
	private void run(String... args) throws DocumentException {
		if (args.length == 0 || args[0].equals("--help"))
			showHelp();
		else if (args[0].equals("info"))
			showInfo();
		else if (args[0].equals("load")) {
			if (args.length < 3)
				System.err.println(
						"La operacion load necesita al menos otro " + "argumento con la ubicacion del fichero");
			else {
				ReaderSingleton.getInstance(args[1]);
				for (int i = 2; i <= args.length - 1; i++)
					ReaderSingleton.getInstance().loadFile(args[i]);
			}
		}
	}


	/**
	 * Muestra la informacion del proyecto
	 */
	private void showInfo() {
		System.out.println("Proyecto Loader 4A");
		System.out.println("El objetivo de este proyecto es actuar como modulo de carga de"
				+ "agentes para un sistema de incidencias");
		System.out.println("Realizado por el grupo 4A1 compuesto por: ");
		System.out.println("Pablo Amorin Triana (UO237060)");
		System.out.println("Ivan Casielles Alvarez (UO251063)");
		System.out.println("Antonio Payá González(UO251065)");
		System.out.println("Hugo Perez Fernandez (UO250708)");
		System.out.println("Mirza Ojeda Vieira (UO251443)");
		System.out.println("Para mas informacion consultar el repositorio en github con la url "
				+ "https://github.com/Arquisoft/Loader_e4a.git");

	}


	/**
	 * Muestra la ayuda del proyecto
	 */
	private void showHelp() {
		System.out.println("Manual de ayuda para el uso de la aplicacion");
		System.out.println("La aplicacion tiene implementadas las operaciones info, load y help");
		System.out.println("	info: Muestra informacion relacionada con el proyecto, como los autores");
		System.out.println(
				"	load[file]: Permite cargar un conjunto de ficheros excel con agentes " + "en la base de datos");
		System.out.println("	--help: Muestra este menu de ayuda. Si no se proporcionan parametros "
				+ "a la aplicacion se mostrara este menu");
	}
}
