package executer;

/**
 * 
 *  Patron singleton para permitir el acceso a la fachada {@link executer.ActionFacade} 
 *  
 *  @author Antonio Payá González(UO251065)
 *  @author Pablo Amorin Triana (UO237060)
 *  @author Hugo Perez Fernandez (UO250708)
 *  @author Ivan Casielles Alvarez (UO251063)
 *  @author Mirza Ojeda Vieira (UO251443)
 */
public class ActionSingleton {
	private ActionFacade actionFacade;
	private static ActionSingleton instance;
	
	/**
	 * 
	 */
	private ActionSingleton() {
		this.actionFacade = new ActionFacadeClass();
	}
	
	/**
	 * Método para permitir el acceso a la fachada
	 * @return instancia única de la fachada
	 */
	public static ActionSingleton getInstance() {
		if (instance == null)
			instance = new ActionSingleton();
		return instance;
	}
	
	public ActionFacade getActionFacade() {
		return actionFacade;
	}
}
