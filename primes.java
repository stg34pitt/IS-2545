
public class primes {

	public static void main(String[] args) {
		
	      int limit = 10000;
	      int max = 100000;
	    
	      //printing primer numbers till the steps (2 to n)
	      System.out.println("Printing prime numbers from 2 to " + limit);
	      
	      	  long time = System.nanoTime();
		      for(int i = 2; i<=max; i++){
		          //print prime numbers only
		          if(isPrime(i)){
		              System.out.println(i);
		          }
		      }
		      
		      System.out.println(time);
	    }

	    /*
	     * Prime number is not divisible by any number other than 1 and itself
	     * @return true if number is prime
	     */
	    public static boolean isPrime(int number){
	        for(int i=2; i<number; i++){
	           if(number%i == 0){
	               return false; //number is divisible so its not prime
	           }
	        }
	        return true; //number is prime now
	    }

}


