package fil.coo.Actions;


import fil.coo.Exceptions.NoSuchElementException;
import fil.coo.Resource.Resource;
import fil.coo.Resource.ResourcePool;
import fil.coo.Resource.ResourceUser;
/**
 * Give a resource to an user
 * @author gounaya & errami
 *
 * @param <R> type of the resource
 */
public class TakeResourceAction <R extends Resource> extends ResourceAction<R>{
	
	public TakeResourceAction(ResourcePool<R> pool, ResourceUser<R> user, String Name) {
		super(pool, user, Name);
	}


	@Override
	public void realStep(){
		try {
			
			this.user.setResource(pool.provideResource());
			
			this.user.getResource();
			this.state = fil.coo.Actions.ActionState.FINISHED;
			System.out.println("success\n");
			
			
		} catch (NoSuchElementException e) {
			this.state = fil.coo.Actions.ActionState.INPROGRESS;
			System.out.println("failed\n");
		}		
	}

	@Override
	public boolean StopCondition(){
		return false;
	}

	
	public String toString() {
		return this.getNameSwimmer()+" trying to take resource from "+this.pool+" ...";
	}
}