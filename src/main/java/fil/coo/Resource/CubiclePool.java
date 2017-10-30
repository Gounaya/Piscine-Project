package fil.coo.Resource;

/**
 * Resource manager that provides Cubicle-type resources
 * @author gounaya & errami
 *
 */
public class CubiclePool extends ResourcePool<Cubicle>{
	
	/**
	 * 
	 * @param nbrResource number of Cubicle resource
	 */
	public CubiclePool(int nbrResource) {
		super(nbrResource);
	}

	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}
	
	public String toString() {
		return "cubicle pool";
	}
	
}
