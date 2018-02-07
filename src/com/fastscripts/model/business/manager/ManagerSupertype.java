package com.fastscripts.model.business.manager;

import com.fastscripts.model.business.exception.PropertyFileNotFoundException;
import com.fastscripts.model.domain.Patient;
import com.fastscripts.model.services.manager.PropertyManager;

public abstract class ManagerSupertype {

	/**
	 * Load application properties file
	 */
	static {
		try {
			ManagerSupertype.loadProperties();
		} catch (PropertyFileNotFoundException propertyFileNotFoundException) {
			System.out.println("Application Properties failed to be loaded - Application exiting...");
			System.exit(1); // since we can't load the properties and this being crucial we'll exit the
							// application!
		}
	}

	/**
	 * 
	 * @param serviceName
	 *            Holds the service name (string) so that it can be called
	 * @param patient
	 *            Holds patient information to be processed in the services
	 * @return patient if action is performed correctly.
	 */
	public abstract Patient performActions(String serviceName, Patient patient);

	/**
	 * 
	 * @param serviceName
	 *            Holds the service name (string) so that it can be called
	 * @param patient
	 *            Holds patient information to be processed in the services
	 * @return True if action is performed correctly, False if it was not performed
	 *         correctly
	 */
	public abstract boolean performAction(String serviceName, Patient patient);

	/**
	 * Loads property file so it can be used.
	 * 
	 * @throws PropertyFileNotFoundException
	 *             If property file is not loaded
	 */
	public static void loadProperties() throws PropertyFileNotFoundException {

		String propertyFileLocation = "config\\application.properties";
		// String propertyFileLocation = System.getProperty("prop_location");

		if (propertyFileLocation != null) {
			PropertyManager.loadProperties(propertyFileLocation);
		}
	}
}
