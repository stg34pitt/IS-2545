package billyGoat;

public class BillifyMain {

	public static void main(String[] args) {
		Billify bill = new Billify();
		
		int[][] inputs = initializeInputs();
		int[][] answers = initializeAnswers();
		
		for(int ii = 0; ii < inputs.length && ii < answers.length; ii++){
			
			int[] billifiedArray = bill.billify(inputs[ii]);
			
			printMatch(Integer.toString(ii + 1), answers[ii], billifiedArray);
		}
	}
	
	public static boolean arraysMatch(int[] x, int[] y){
		if(x.length != y.length){
			return false;
		}
		
		for(int ii = 0; ii < x.length && ii < y.length; ii++){
			if(x[ii] != y[ii]){
				return false;
			}
		}
		
		return true;
	}
	
	public static void printMatch(String position, int[] x, int[] y){
		boolean matches = arraysMatch(x, y);
		
		System.out.println(
				position
				+ " matches? "
				+ Boolean.toString(matches));
	}
	
	public static int[][] initializeInputs(){
		int[][] inputs = new int[5][];
		int[] firstInput = {1, 2, 3};
		int[] secondInput = {4};
		int[] thirdInput = {10, 10, 10};
		int[] fourthInput = {1, 1, 2, 2, 3, 3};
		int[] fifthInput = {5, 3, 9};
		
		inputs[0] = firstInput;
		inputs[1] = secondInput;
		inputs[2] = thirdInput;
		inputs[3] = fourthInput;
		inputs[4] = fifthInput;
		
		return inputs;
	}
	
	public static int[][] initializeAnswers(){
		int[][] answers = new int[5][];
		int[] firstAnswer = {1, 4, 9, 14};
		int[] secondAnswer = {16, 16};
		int[] thirdAnswer = {100, 100, 100, 300};
		int[] fourthAnswer = {1, 1, 4, 4, 9, 9, 28};
		int[] fifthAnswer = {25, 9, 81, 115};
		
		answers[0] = firstAnswer;
		answers[1] = secondAnswer;
		answers[2] = thirdAnswer;
		answers[3] = fourthAnswer;
		answers[4] = fifthAnswer;
		
		return answers;
	}

}