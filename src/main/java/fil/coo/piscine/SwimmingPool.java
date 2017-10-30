package fil.coo.piscine;

import fil.coo.Actions.FairScheduler;
import fil.coo.Exceptions.ActionFinishedException;
import fil.coo.Exceptions.SchedulerStartedException;
import fil.coo.Resource.BasketPool;
import fil.coo.Resource.CubiclePool;
/**
 * 
 * @author gounaya
 *
 */
public class SwimmingPool {
	public static void main(String[] args) throws ActionFinishedException, SchedulerStartedException{
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		FairScheduler s = new FairScheduler();

		/*swimmer(nom, panier, cabinet, temps-deshabiller, temps-baigner, temps-rhabiller)*/
		s.addAction(new Swimmer("Camille", baskets, cubicles, 6, 4, 8));
		s.addAction(new Swimmer("Lois", baskets, cubicles, 2, 10, 4));
		s.addAction(new Swimmer("Mae", baskets, cubicles, 10, 18, 10));
		s.addAction(new Swimmer("Ange", baskets, cubicles, 3, 7, 5));
		s.addAction(new Swimmer("Luison", baskets, cubicles, 18, 3, 3));
		s.addAction(new Swimmer("Charlie", baskets, cubicles, 3, 6, 10));
		s.addAction(new Swimmer("Alexis", baskets, cubicles, 6, 5, 7));
		
		int nbSteps= 0; 
		while(!s.isFinished()) {
			nbSteps++;
			s.doStep();
		}
		System.out.println("Finished in "+nbSteps+" steps");
	}
}
