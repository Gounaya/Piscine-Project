package fil.coo.Resource;


import fil.coo.Resource.Cubicle;
import fil.coo.Resource.ResourcePool;

	public class MockResourcePool extends ResourcePool<Cubicle> {
				
		public MockResourcePool(int nombre){
			super(nombre);
			
		}

		public Cubicle createResource() {
			return new Cubicle();
		}


}

