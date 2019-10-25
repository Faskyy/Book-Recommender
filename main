import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BookRecommender {
	public static void main(String[] args) throws IOException {
		
		String[] bookNames = new String[20];
		int[][] ratings = new int[30][20];
		Scanner sc = new Scanner(new File("books.txt"));
		for(int i = 0 ;i <bookNames.length; i ++) {
			bookNames[i] = sc.nextLine();
		}
		sc = new Scanner(new File("ratings.txt"));
		for(int i = 0 ; i < 30; i++) {
			for(int j = 0; j < 20; j++) {
				int rating = sc.nextInt();
				ratings[i][j] = rating;
			}
		}
		sc = new Scanner(System.in);
		int[] ratingsForUser = new int[20];
		for(int i = 0 ; i < 20; i++) {
			System.out.println("Enter the rating for book " + bookNames[i]);
			int rating = sc.nextInt();
			while(!(rating >= 1 && rating <= 5) && rating != -1) {
				System.out.println("Invalid input. Try again.");
				rating = sc.nextInt();
			}
			ratingsForUser[i] = rating;
		}
		//calculating similarity index
		double[] similarityScores = getSimilarityScore(ratingsForUser, ratings);
		double[] recommendedRatings = getRecommendedRatings(similarityScores, ratings);
		
		double maxRec = -1;
		int maxRecIndex = -1;
		for(int i = 0 ;i < 20; i++) {
			if(ratingsForUser[i] == -1) {
				if(recommendedRatings[i] > maxRec) {
					maxRec = recommendedRatings[i];
					maxRecIndex = i;
				}
			}
		}
		if(maxRecIndex == -1) {
			System.out.println("User has read all the books.");
		}		
		else {
			System.out.println("Highly recommended book: " + bookNames[maxRecIndex]);
		}
	}
	
	public static double[] getRecommendedRatings(double[] similarityScores,int[][] ratings) {
		double[] recScore = new double[20];
		double total = 0;
		for(int i = 0 ; i < 20 ; i++) {
			double ans = 0;
			total = 0;
			for(int j = 0; j < 30; j++) {
				ans += ratings[j][i]*similarityScores[j];
				total += similarityScores[j];
				
			}
			ans /= total;
			recScore[i] = ans;

		}
		return recScore;
	}
	
	public static double[] getSimilarityScore(int[] ratingsForUser,int[][] ratings) {
		double[] simScore = new double[30];
		double maxScore = -1;
		for(int i = 0 ; i < 30 ; i++) {
			double ans = 0;
			for(int j = 0; j < 20; j++) {
				ans += Math.pow((ratings[i][j] - ratingsForUser[j]), 2);
				
				/*ans is equal to ans + the value in the nested array ratings at position [i][j]
				taken away from the value in the array ratingsforuser at position j squared */
				
			}
			ans = Math.sqrt(ans);
			simScore[i] = ans;
			if(maxScore < ans) {
				maxScore = ans;
			}
		}
		for(int i = 0 ;i < simScore.length ; i ++ ) {
			simScore[i] /= maxScore;
			simScore[i] = 1 - simScore[i];
		}
		return simScore;
	}
}
