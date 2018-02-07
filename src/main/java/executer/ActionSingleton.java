package executer;

public class ActionSingleton {
	private ActionFacade actionFacade;
	private static ActionSingleton instance;

	private ActionSingleton() {
		this.actionFacade = new ActionFacadeClass();
	}

	public static ActionSingleton getInstance() {
		if (instance == null)
			instance = new ActionSingleton();
		return instance;
	}

	public ActionFacade getActionFacade() {
		return actionFacade;
	}
}
