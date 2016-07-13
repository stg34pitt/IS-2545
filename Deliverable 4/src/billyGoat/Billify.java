package billyGoat;

public class Billify {
	public Billify() {};
	
	public int[] billify(int[] x) throws IllegalArgumentException {
		int minArrayLength = 1;
		
		if(x.length < minArrayLength){
			String message = 
					"Array length is \""
					+ Integer.toString(x.length)
					+ "\" when it should be \""
					+ Integer.toString(minArrayLength)
					+ "\" or greater.";
			
			throw new IllegalArgumentException(message);
		}
		
		int[] billifiedArray = new int[x.length + 1];
		int exponent = 2;
		int total = 0;
		
		for(int ii = 0; ii < x.length; ii++){
			int newNumber = (int) Math.pow(x[ii], exponent);
			
			billifiedArray[ii] = newNumber;
			
			total += newNumber;
		}
		
		billifiedArray[x.length] = total;
		
		return billifiedArray;
	}
}