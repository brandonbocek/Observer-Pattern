package Observer;

public class GrabStocks {

	public static void main(String[] args){
		
		StockGrabber stockGrabber = new StockGrabber();
		
		StockObserver bob = new StockObserver(stockGrabber);
		
		stockGrabber.setIBMPrice(197.00);
		stockGrabber.setAAPLPrice(256.00);
		stockGrabber.setGOOGPrice(671.00);
		
		StockObserver jim = new StockObserver(stockGrabber);
		
		stockGrabber.setIBMPrice(197.00);
		stockGrabber.setAAPLPrice(256.00);
		stockGrabber.setGOOGPrice(671.00);
		
		//stockGrabber.unregister(bob);
		
		Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
		Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 256.00);
		Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 671.00);
		
		new Thread(getIBM).start();
		new Thread(getAAPL).start();
		new Thread(getGOOG).start();
		
	}
	
}
