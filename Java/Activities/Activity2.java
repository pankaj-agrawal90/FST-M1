package activities;

public class Activity2 {

	public static void main(String[] args) {
		int[] numberArray = {10, 77, 10, 54, -11, 10};
		int sum = 0;
		for(int i = 0; i <= numberArray.length-1; i++) {
			if (numberArray[i] == 10){
			sum += numberArray[i];
			}
		}
		System.out.println("Sum of 10's of all the digits is: " + sum);
		
		if (sum == 30) {
			System.out.println("True");
		}
		else System.out.println("False");
	}
}
