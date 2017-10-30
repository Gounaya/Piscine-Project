package fil.coo.Schedulers;

import fil.coo.Actions.Action;

public class MockStepAction extends Action{
		
		private int nStep = 0 ;

		protected void realStep() {
			this.nStep++;
		}

		@Override
		protected boolean StopCondition() {
			return this.nStep == 2 ;
		}
		
}

