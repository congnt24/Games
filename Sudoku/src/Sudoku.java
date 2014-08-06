import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;


public class Sudoku {
	JTextField[] jt;
	String chest="527319846813465729496278135354896271762153984981742653178934562245681397639527418";
	String hidden="101101010111011100101101001010001111001010100111100010100101101001110111010101101";
	static int[] result=new int[81];
//	  public static void main(String[] args) {
		  
//			int[][] matrix = parseProblem(chest, hidden);
//			writeMatrix(matrix);
//			if (solve(0,0,matrix))    // solves in place
//			    writeMatrix(matrix);
//			else 
//			    System.out.println("NONE");
//	  }

	public void create() {
		int[][] matrix= parseProblem(chest, hidden);
		jt=new JTextField[81];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				jt[i*9+j]=new JTextField(matrix[i][j]==0?" ":Integer.toString(matrix[i][j]));
				if(matrix[i][j]!=0)
					jt[i*9+j].setForeground(Color.RED);
				jt[i*9+j].setHorizontalAlignment(JTextField.CENTER);
				jt[i*9+j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
				if (j%3==2) {
					jt[i*9+j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 3, Color.BLUE));
					if (i%3==2) {
						jt[i*9+j].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, Color.BLUE));
					}
				}else{
					if (i%3==2) {
						jt[i*9+j].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, Color.BLUE));
					}
				}
				Main_Activity.panel_2.add(jt[i*9+j]);
			}
			
		}
	}
//	private static boolean solve(int i, int j, int[][] matrix) {
//		if (i==9) {	//
//			i=0;
//			if (++j==9) {
//				return true;
//			}
//		}
//		//Skip fill
//		if (matrix[i][j]!=0) {
//			return solve(i+1,j,matrix);
//		}
//		for (int k = 1; k <= 9; k++) {
//			if (legal(i,j,k,matrix)) {
//				matrix[i][j]=k;
//				if (solve(i+1,j,matrix)) {	//Backtracking
//					return true;
//				}
//			}
//			
//		}
//		matrix[i][j]=0;
//		return false;
//	}
//
//
//	private static boolean legal(int i, int j, int k, int[][] matrix) {
//		for (int l = 0; l < 9; l++) {	//Row
//			if (k==matrix[l][j]) {
//				return false;
//			}
//		}
//		for (int l = 0; l < 9; l++) {	//coll
//			if (k==matrix[i][l]) {
//				return false;
//			}
//		}
//		int boxrow=(i/3)*3;
//		int boxcol=(j/3)*3;
//		for (int l = 0; l < 3; l++) {	//box
//			for (int l2 = 0; l2 < 3; l2++) {
//				if (matrix[boxrow+l][boxcol+l2]==k) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}


	private static int[][] parseProblem(String chest, String hidden) {
		int[][] problem=new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				result[i*9+j]=Integer.parseInt(chest.substring(i*9+j, i*9+j+1));
				if (Integer.parseInt(hidden.substring(i*9+j, i*9+j+1))==0) {
					problem[i][j]=result[i*9+j];
				}
			}
		}
		return problem;
	}


//	private static void writeMatrix(int[][] matrix) {
//		for (int i = 0; i < 9; i++) {
//			if (i%3==0) {
//				System.out.println("-----------------------");
//				
//			}
//			for (int j = 0; j < 9; j++) {
//				if (j%3==0) {
//					System.out.print("|");
//				}
//				System.out.print(matrix[i][j]==0?" ":matrix[i][j]);
//				System.out.print(' ');
//			}
//			System.out.println("|");
//		}
//		System.out.println("-----------------------");
//	}

		  
}
