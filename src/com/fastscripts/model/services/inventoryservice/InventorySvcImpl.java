package com.fastscripts.model.services.inventoryservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import com.fastscripts.model.domain.Inventory;
import com.fastscripts.model.services.exceptions.InventoryException;

public class InventorySvcImpl implements IInventorySvc {

	/**
	 * Store medication in to the inventory text file, returns if stored correctly
	 * 
	 * @param Inventory
	 */
	public boolean storeInventory(Inventory medication) throws InventoryException {

		ObjectOutputStream output = null;
		ObjectInputStream input = null;
		boolean hasStored = false;

		try {
			output = new ObjectOutputStream(new FileOutputStream("C:\\FastScripts_HuynhKelvin\\Inventory.txt"));
			Hashtable<Integer, Inventory> inventoryHashtable = new Hashtable<Integer, Inventory>();

			inventoryHashtable.put(1, medication);

			output.writeObject(inventoryHashtable);
			output.close();

			input = new ObjectInputStream(new FileInputStream("Inventory.txt"));
			@SuppressWarnings("unchecked")
			Hashtable<Integer, Inventory> inventoryCheck = (Hashtable<Integer, Inventory>) input.readObject();
			Inventory testInventory = (Inventory) inventoryCheck.get(1);

			if (testInventory != null) {
				if (medication.equals(testInventory))
					hasStored = true;
				else
					hasStored = false;
			} else {
				throw new InventoryException("Null Inventory passed to InventorySvc::inventory");
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("File 'Inventory.txt' is not found");
			throw new InventoryException("File 'Inventory.txt' is not found", fnfe);
		} catch (IOException ioe) {
			System.out.println("IOException while accessing 'Inventory.txt'");
			throw new InventoryException("IOException while accessing 'Inventory.txt'", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException while reading file 'Inventory.txt'");
			throw new InventoryException("ClassNotFoundException while reading file 'Inventory.txt'", cnfe);
		} finally {
			if (medication != null) {
				try {
					input.close();
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return hasStored;
	}

	/**
	 * @param Inventory
	 *            used to check if the medication is still available return
	 *            Inventory if available
	 */
	public Inventory getInventory(Inventory medication) throws InventoryException {

		boolean inInventory = false;
		ObjectInputStream input = null;

		try {
			input = new ObjectInputStream(new FileInputStream("Inventory.txt"));
			@SuppressWarnings("unchecked")
			Hashtable<Integer, Inventory> inventoryCheck = (Hashtable<Integer, Inventory>) input.readObject();
			inInventory = inventoryCheck.contains(medication);

		} catch (FileNotFoundException fnfe) {
			System.out.println("File 'Inventory.txt' is not found");
			throw new InventoryException("File 'Inventory.txt' is not found", fnfe);
		} catch (IOException ioe) {
			System.out.println("IOException while accessing 'Inventory.txt'");
			System.out.println("General I/O exception: " + ioe.getMessage());
			throw new InventoryException("IOException while accessing 'Inventory.txt'", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException while reading file 'Inventory.txt'");
			throw new InventoryException("ClassNotFoundException while reading file 'Inventory.txt'", cnfe);
		} finally {
			if (medication != null) {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (inInventory) {
			return medication;
		} else {
			return null;
		}
	}

}
