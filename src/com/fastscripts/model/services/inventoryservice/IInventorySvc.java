package com.fastscripts.model.services.inventoryservice;

import com.fastscripts.model.domain.Inventory;
import com.fastscripts.model.services.IService;
import com.fastscripts.model.services.exceptions.InventoryException;

public interface IInventorySvc extends IService {

	public final String NAME = "IInventorySvc";

	/**
	 * 
	 * @param inventory
	 *            contains inventory information to be stored
	 * @return boolean returns true if stored correctly
	 * @throws InventoryException
	 *             if file is not found or, patient is null, or an error is
	 *             encountered while accessing file
	 */
	public boolean storeInventory(Inventory inventory) throws InventoryException;

	/**
	 * 
	 * @param medication
	 *            contains inventory data to check system if medication is available
	 * @return Inventory if the medication is in the system
	 * @throws InventoryException
	 *             if file is not found or, patient is null, or an error is
	 *             encountered while accessing file
	 */
	public Inventory getInventory(Inventory medication) throws InventoryException;

}
