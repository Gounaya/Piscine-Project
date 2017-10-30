package fil.coo.Actions;


import fil.coo.Resource.Resource;
import fil.coo.Resource.ResourcePool;
import fil.coo.Resource.ResourceUser;

/**
 * Freeing resource from resource pool
 * @author gounaya
 *
 * @param <R> The type of resource 
 */
public class FreeResourceAction <R extends Resource> extends ResourceAction<R>{

	
	public FreeResourceAction (ResourcePool<R> pool, ResourceUser<R> user, String Name) {
		super(pool, user, Name);
	}
	
	
	@Override
	public void realStep(){
		
		this.state = ActionState.FINISHED;

		this.pool.recoverResource(this.user.getResource());			
		System.out.println("\n");
	}


	@Override
	public boolean StopCondition() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return this.getNameSwimmer()+" freeing resource from "+this.pool;
	}
}
