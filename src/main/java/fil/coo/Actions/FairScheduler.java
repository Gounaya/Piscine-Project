package fil.coo.Actions;

/**
 * The progression of the actions is done in parallel
 * Execute the actions following the order 
 * @author gounaya
 *
 */
public class FairScheduler extends Scheduler{

	
	
	public FairScheduler() {
		this.currentIndex=0;
	}
	
	@Override
	public int nextAction() {
		int index = this.currentIndex;
		this.currentIndex++;
		if(this.currentIndex==this.ActionList.size()) {
			this.currentIndex=0;
		}
		return index;
	}

	
}
