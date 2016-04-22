package Observer;
import java.text.DecimalFormat;

public class GetTheStock implements Runnable{

	private int startTime;
	private String stock;
	private double price;
	
	private Subject stockGrabber;
	
	public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice){
		
		this.stockGrabber = stockGrabber;
		startTime = newStartTime;
		stock = newStock;
		price = newPrice;
		
	}
	
	public void run() {
		
		//the ticker will tick 20 times
		for(int i=1; i<=20;i++){
			try{
				
				Thread.sleep(2000);
				double randNum = (Math.random() * (0.06))-0.03;
				
				DecimalFormat df = new DecimalFormat("#.##");
				price = Double.valueOf(df.format((price + randNum)));
				
				//you need to cast stockGrabber to use setIBMPrice method
				//that method only exists in the StockGrabber class
				//and stockGrabber is defined as a subject not a StockGrabber
				if(stock.equals("IBM")) ((StockGrabber)stockGrabber).setIBMPrice(price);
				if(stock.equals("AAPL")) ((StockGrabber)stockGrabber).setAAPLPrice(price);
				if(stock.equals("GOOG")) ((StockGrabber)stockGrabber).setGOOGPrice(price);
				
				System.out.println(stock + ": "+df.format((price + randNum)) + " " + df.format(randNum));
				System.out.println();
			}catch(InterruptedException e){}
		}
		
		
	}

}
