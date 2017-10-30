package fil.coo.piscine;

/**
 * Class creating a swimmer 
 * @author gounaya & errami
 *
 */
import fil.coo.Actions.FreeResourceAction;
import fil.coo.Actions.SequentialScheduler;
import fil.coo.Actions.TakeResourceAction;
import fil.coo.Actions.foreseeableAction;
import fil.coo.Resource.Basket;
import fil.coo.Resource.BasketPool;
import fil.coo.Resource.Cubicle;
import fil.coo.Resource.CubiclePool;
import fil.coo.Resource.ResourceUser;


public class Swimmer extends SequentialScheduler{

	private String name;
	private ResourceUser<Cubicle> rUserCubicle;
	private ResourceUser<Basket> rUserBasket;
	
	/*swimmer(nom,panier,deshabiller,baigner,rhabiller)*/
	public Swimmer(String name,BasketPool basket ,CubiclePool cub,int undressTime, int swimmingTime, int dressTime){
		this.name=name;
		rUserBasket= new ResourceUser<Basket>();
		rUserCubicle= new ResourceUser<Cubicle>();
		this.addAction(new TakeResourceAction<Basket>(basket,rUserBasket,name));
		this.addAction(new TakeResourceAction<Cubicle>(cub,rUserCubicle,name));
		this.addAction(new foreseeableAction(undressTime, "Undressing"));
		this.addAction(new FreeResourceAction<Cubicle>(cub,rUserCubicle,name));
		this.addAction(new foreseeableAction(swimmingTime, "Swimming"));
		this.addAction(new TakeResourceAction<Cubicle>(cub,rUserCubicle,name));
		
		this.addAction(new foreseeableAction(dressTime,"Dressing"));
		this.addAction(new FreeResourceAction<Cubicle>(cub,rUserCubicle,name));
		this.addAction(new FreeResourceAction<Basket>(basket,rUserBasket,name));
		
	}


	public String getName() {
		return name;
	}

	@Override
	public void realStep() {
		System.out.println(getName()+"'s turn");
		super.realStep();		
	}
	
	public String toString() {
		return "";
	}
	
}
	
