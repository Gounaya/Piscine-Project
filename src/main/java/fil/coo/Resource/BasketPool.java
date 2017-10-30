package fil.coo.Resource;

/**
 * Resource manager that provides Basket-type resources
 * @author gounaya & errami
 *
 */
public class BasketPool extends ResourcePool<Basket>{
	/**
	 * 
	 * @param nbrResource number of Basket resource
	 */
	public BasketPool(int nbrResource) {
		super(nbrResource);
	}

	@Override
	public Basket createResource() {
		return new Basket();
	}
	public String toString() {
		return "basket pool";
	}
	

}
