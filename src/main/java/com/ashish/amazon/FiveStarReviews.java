package com.ashish.amazon;

public class FiveStarReviews {

	public static void main(String[] args) {
		
		//int [][] a = {{4,4}, {1,2}, {3, 6}};
		//int [][] a = {{4,4}, {3,4}, {4, 6}};
		int [][] a = {{1,2},{4,4}, {3, 6}};
		FiveStarReviews at = new FiveStarReviews();
		
		System.out.println(at.fiveStarReviews(a, 77));
		
	}

	private int fiveStarReviews(int [][] productRatings, int ratingThreshold) {
		int targetThreshhold = ratingThreshold * productRatings.length;
		double maxDelta =0;
		int identifier =0;
		double sum = 0;
		int counter =0;


		while(sum*100<targetThreshhold) {
			sum=0;
			maxDelta = 0;
			for (int i=0; i<productRatings.length; i++) {
				double avg = calculateAvg(productRatings[i][0], productRatings[i][1]);
				double delta = calculateDelta(productRatings[i][0], productRatings[i][1]);
				if(maxDelta<delta) {
					maxDelta = delta;
					identifier = i;
				}
				sum+=avg;
			}
			if(sum*100<targetThreshhold) {
				counter++;
				productRatings[identifier][0] = productRatings[identifier][0] +1;
				productRatings[identifier][1] = productRatings[identifier][1] +1;
				sum = sum+maxDelta;
			}
		}

		return counter;
	}

	private double calculateDelta(int rating, int number) {
		double delta = ( (double) (rating+1)/(number+1))-calculateAvg(rating, number);
		return delta;
		
	}

	private double calculateAvg(int rating, int number) {
		return (double) rating/number;
		
	}

}
