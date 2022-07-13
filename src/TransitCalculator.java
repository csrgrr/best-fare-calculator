

/**
 * 
 * @author cesar.guerra
 *
 */
public class TransitCalculator {
	
	public int nDays;
	public int nRides;
	
	
	public TransitCalculator(int nDays, int nRides) {
		this.nDays = nDays;
		this.nRides = nRides;
		
	}
	
	public static String[] options = {"Pay-per-ride", "7-day Unlimited Rides", "30-day Unlimited Rides"};
	public static double[] prices = {2.75, 33.00, 127.00};

	
	public double unlimited7Price() {
		int days = nDays;
		int weeks=0;
		double overallPrice;
		double pricePerRide;
	
		while (days > 0) {
			days = days -7;
			weeks++;
			
		}
		
		overallPrice = weeks*prices[1];
		pricePerRide = overallPrice / nRides;	
		
		
		return pricePerRide;
		
	}

	public String getRidePrices(String option) {
		int days = nDays;
		int weeks = 1;
		int months = 1;
		int contador = 0;

		while (days > 0) {
			days = days-7;
			weeks++;
			contador++;
			if(contador == 4) {
			months++;	
			contador = 0;
			}
		}
		
		
		double option1 = prices[0];
		double option2 = unlimited7Price();
		double option3 = (prices[2]*months)/nRides;
		
		
		if (option == "Pay-per-ride")
			return "["+ options[0] +" -> " + option1 +", "+ nDays+"]";
		else if (option == "7-day Unlimited Rides")
			return "["+ options[1] +" -> " + option2 +", "+ weeks+"]";
		else if (option == "30-day Unlimited Rides")
			return "["+ options[2] +" -> " + option3 +", "+ months+"]";
		else
		return "Option not allowed";
	}
	
	public String getBestFare() {
		int days = nDays;
		int weeks = 0;
		int months = 1;

		while (days > 0) {
			days = days-7;
			weeks++;
			if(weeks == 4) {
			months++;	
			weeks = 0;
			}
		}
		
		
		double option1 = prices[0];
		double option2 = unlimited7Price();
		double option3 = (prices[2]*months)/nRides;
		
		double[] options1 = {option1, option2, option3};
		
		double saver = option1;
		String message;
		
		for (int i = 0; i < options1.length; i++) {
			System.out.println( "-> "+options1[i]);
			if(saver > options1[i]) {
				saver = options1[i];
			}				
		}
		if(saver == options1[0]) {
			message = options[0];
		} else if(saver == options1[1]) {
			message = options[1];
		} else if(saver == options1[2]) {
			message = options[2];
		} else {
			message= "'option not found'";
		}
		return "You should get the " +  message + " option at " + saver + " per ride.";
		
		
	
	}
	
	
public static void main(String[] args) {
	TransitCalculator cliente1 = new TransitCalculator(19, 20);
	System.out.println(cliente1.unlimited7Price());
	TransitCalculator cliente2 = new TransitCalculator(22, 50);
	System.out.println(cliente2.unlimited7Price());
	TransitCalculator cliente3 = new TransitCalculator(6, 14);
	System.out.println(cliente3.unlimited7Price());
	
	System.out.println(cliente1.getRidePrices(options[0]));
	System.out.println(cliente1.getRidePrices(options[1]));
	System.out.println(cliente1.getRidePrices(options[2]));
	
	System.out.println(cliente1.getBestFare());
	
}	

}
