package fil.coo.Actions;

import fil.coo.Resource.Resource;
import fil.coo.Resource.ResourcePool;
import fil.coo.Resource.ResourceUser;
/**
 * 
 * @author gounaya
 *
 * @param <R> Type of resource
 */
public abstract class ResourceAction<R extends Resource> extends Action{
	protected ResourcePool<R> pool;
	protected ResourceUser<R> user;
	public String Name;
	
	public ResourceAction(ResourcePool<R> pool, ResourceUser <R> user, String Name) {
		this.pool= pool;
		this.user= user;
		this.Name= Name;
	}
	
	public String getNameSwimmer() {
		return this.Name;
	}
}
