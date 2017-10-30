package fil.coo.Resource;


/**
 * User who use the resource
 * @author gounaya
 *
 * @param <R> type of the resource
 */
public class ResourceUser <R extends Resource>{
	
	protected R resource;
	
	
	public R getResource() {
		return resource;
	}
	
	public void setResource(R resource) {
		this.resource= resource; 
	}
	
	public void resetResource() {
		this.resource= null;
	}
	
	
}
