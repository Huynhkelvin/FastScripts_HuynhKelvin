package com.fastscripts.model.business.manager;

import com.fastscripts.model.business.exception.ServiceLoadException;
import com.fastscripts.model.domain.Inventory;
import com.fastscripts.model.services.exceptions.InventoryException;
import com.fastscripts.model.services.factory.ServiceFactory;
import com.fastscripts.model.services.inventoryservice.IInventorySvc;

public class InventoryManager extends PaymentSupertype {

	private static InventoryManager _instance;

	/**
	 * Private constructor so it can not be called outside, and a default is not
	 * made
	 */
	private InventoryManager() {
	}

	/**
	 * Confirms that only one instance of InventoryManager is created
	 * 
	 * @return InventoryManager instance
	 */
	public static synchronized InventoryManager getInstance() {
		if (_instance == null) {
			_instance = new InventoryManager();
		}
		return _instance;
	}

	/**
	 * @param serviceName
	 *            Holds the service name (string) so that it can be called
	 * 
	 * @param patient
	 *            Holds inventory information to be processed in the services
	 * 
	 * @return action Returns true if action is completed correctly
	 */
	@Override
	public boolean performAction(String serviceName, Inventory inventory) {
		boolean action = false;
		Inventory medicineInventory = null;
		if (serviceName.equals("StoreInventory")) {
			action = storeInventory(IInventorySvc.NAME, inventory);
		} else if (serviceName.equals("GetInventory")) {
			medicineInventory = getInventory(IInventorySvc.NAME, inventory);
			if (medicineInventory != null) {
				action = true;
			}
		}
		return action;
	}

	/**
	 * 
	 * @param serviceName
	 *            Holds the service name (string) so that it can be called
	 * @param inventory
	 *            Holds inventory information to be processed in the services
	 * @return filled Returns true if inventory is correctly stored.
	 */
	public boolean storeInventory(String serviceName, Inventory inventory) {
		boolean filled = false;
		ServiceFactory factory = ServiceFactory.getInstance();
		IInventorySvc iInventorySvc;
		try {
			iInventorySvc = (IInventorySvc) factory.getService(serviceName);
			filled = iInventorySvc.storeInventory(inventory);
		} catch (ServiceLoadException e1) {
			System.out.println("InventoryManager::storeInventory failed");
			return filled;
		} catch (InventoryException e) {
			System.out.println("InventoryManager::storeInventory failed");
			return filled;
		}

		return filled;
	}

	/**
	 * 
	 * @param serviceName
	 *            Holds the service name (string) so that it can be called
	 * @param inventory
	 *            Holds inventory information to be processed in the services
	 * @return medicineInventory Returns inventory if retrieved correctly.
	 */
	public Inventory getInventory(String serviceName, Inventory inventory) {

		Inventory medicineInventory = null;
		ServiceFactory factory = ServiceFactory.getInstance();
		IInventorySvc iInventorySvc;
		try {
			iInventorySvc = (IInventorySvc) factory.getService(serviceName);
			medicineInventory = iInventorySvc.getInventory(inventory);
		} catch (ServiceLoadException e1) {
			System.out.println("InventoryManager::storeInventory failed");
			return medicineInventory;
		} catch (InventoryException e) {
			System.out.println("InventoryManager::storeInventory failed");
			return medicineInventory;
		}

		return medicineInventory;
	}
}
