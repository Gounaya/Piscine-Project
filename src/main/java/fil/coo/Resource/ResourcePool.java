package fil.coo.Resource;

import java.util.ArrayList;

import fil.coo.Exceptions.NoSuchElementException;

/**
 * Resource manager that provides a resource from its pool.
 * Return a resource to the pool to free it and make it available again
 * 
 * @author gounaya & errami
 *
 * @param <R> type of the resource
 */
public abstract class ResourcePool <R extends Resource> {
		
	public abstract R createResource();
	private ArrayList<R> busyResources = new ArrayList<R>();	
	private ArrayList<R> freeResources = new ArrayList<R>();

	
	public ResourcePool(int nbrResource) {
		for(int i = 0; i<nbrResource; i++) {
			freeResources.add(createResource());
		}
	}
	
	
	/**
	 * To obtain one of the pool resources
	 * @throws NoSuchElementException: trigger when there is more resource to use
	 */
	public R provideResource() throws NoSuchElementException{
		if(freeResources.isEmpty()) {
			throw new NoSuchElementException("There are no resources available ! ");
		}
		/**
		 *  resource: who takes the first resource from the list of free resources
		 */
		R resource = freeResources.get(0);
		freeResources.remove(resource);
		busyResources.add(resource);
		
		return resource;
	}
	
	/**
	 * this method recover a resource to the pool
	 * @param resource : the resource we wanted to release
	 * @throws lifted if the resource is not a resource previously created
by the manager
	 */
	public void recoverResource(R resource) throws IllegalArgumentException{
		
		/**
		 * Contains returns either true or false
		 * exception is raised if the resource is already free
		 */
		if(freeResources.contains(resource)) {
			throw new IllegalArgumentException();
		}
		
		busyResources.remove(resource);
		freeResources.add(resource);
	}
	
	public ArrayList<R> getFreeResources() {
		return freeResources;
	}
	
	public ArrayList<R> getBusyResources() {
		return busyResources;
	}
	
}
