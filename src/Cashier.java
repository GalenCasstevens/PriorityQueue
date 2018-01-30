import java.util.Random;

public class Cashier {
	public static void main(String[] args) {
		int minutes = 0;
		PriorityQueue line = new PriorityQueue();
		
		while(minutes < 60) {
			int r = new Random().nextInt(100) + 1;
			
			if(line.isEmpty() == false) {
				line.serviceCustomer();
			}
			
			if(r < 26) {
				line.add(new PriorityCustomer());
			}

			System.out.println("------------------------------------------"
			+ "-----------------------------------------");
			
			minutes++;
		}
		
		System.out.println("\n\n"+ line.getNumServiced() + " customers were"
		+ " serviced in the last hour.\nThe maximum number of customers in "
		+ "the queue at one time: " + line.getSize());
	}
}