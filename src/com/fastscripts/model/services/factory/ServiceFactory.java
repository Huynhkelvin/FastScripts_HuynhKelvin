package com.fastscripts.model.services.factory;
import com.fastscripts.model.business.exception.ServiceLoadException;
import com.fastscripts.model.services.IService;
import com.fastscripts.model.services.manager.PropertyManager;



public class ServiceFactory {
	
	
	private ServiceFactory(){
		//Private constructor to prevent a default constructor from being made 
	}
	
	private static ServiceFactory factory; 
	
	public static ServiceFactory getInstance(){
		if (factory == null)
			factory = new ServiceFactory();		
		return factory;
	}
	
	/**
	 * 
	 * @param name The name of the service's interface
	 * @return The implementation of the service interface
	 * @throws ServiceLoadException Thrown if the implementation of the service is not loaded
	 */
	public IService getService(String name) throws ServiceLoadException{
		try{
			Class<?> c = Class.forName(getImplName(name));
			return (IService) c.newInstance();
		}catch (Exception e){
			name = name + " not loaded";
			throw new ServiceLoadException(name,e);
		}
	}
	
	/**
	 * 
	 * @param name The name of the service's interface
	 * @return The name if the service interface as a String
	 */
	private String getImplName(String name){
		return PropertyManager.getPropertyValue(name);
	}
}
