import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Caro {
	int countx=0,counto=0;
	static final int SIZE=16;
	JLabel[] jl=new JLabel[SIZE*SIZE];
	int[][] matrix=new int[SIZE][SIZE];
	public void Create() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				jl[i*SIZE+j]=new JLabel(" ");
				jl[i*SIZE+j].setHorizontalAlignment(JLabel.CENTER);
				jl[i*SIZE+j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
				jl[i*SIZE+j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						super.mouseReleased(e);
						JLabel jlb=(JLabel)e.getSource();
						int i = 0,j=0;
						for (int j2 = 0; j2 < SIZE; j2++) {
							for (int j3 = 0; j3 < SIZE; j3++) {
								if (jl[j2*SIZE+j3]==jlb) {
									i=j2;j=j3;
									break;
								}
							}
							
						}
						
						if (countx==counto) {
							jlb.setForeground(Color.RED);
							jlb.setText("X");
							jlb.removeMouseListener(this);
							matrix[i][j]=1;
							countx++;
							Check(matrix, 1);
							
						}else if(countx>counto){
							jlb.setForeground(Color.BLUE);
							jlb.setText("O");
							jlb.removeMouseListener(this);
							matrix[i][j]=2;
							counto++;
							Check(matrix, 2);
						}
					}
				});
				Main_Activity.panel.add(jl[i*SIZE+j]);
			}
		}
		Main_Activity.panel.validate();
	}
	
	///Check
	public void Check(int[][] matrix, int x){
		if (CheckLineX(matrix, x)|
				CheckLineXY(matrix, x)|
				CheckLineY(matrix, x)) {
			if (x==1) {
				JOptionPane.showMessageDialog(null, "*****Ben X Win*****");
			}else{
				JOptionPane.showMessageDialog(null, "*****Ben O Win*****");
			}
		}
	}
	public boolean CheckLineX(int[][] matrix,int x){
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE-4; j++) {
				if (matrix[i][j]==x&&matrix[i][j]==matrix[i][j+1]&&matrix[i][j+1]==matrix[i][j+2]&&matrix[i][j+2]==matrix[i][j+3]&&matrix[i][j+3]==matrix[i][j+4]) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean CheckLineY(int[][] matrix,int x){
		for (int j = 0; j < SIZE; j++) {
			for (int i = 0; i < SIZE-4; i++) {
				if (matrix[i][j]==x&&matrix[i][j]==matrix[i+1][j]&&matrix[i+1][j]==matrix[i+2][j]&&matrix[i+2][j]==matrix[i+3][j]&&matrix[i+3][j]==matrix[i+4][j]) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean CheckLineXY(int[][] matrix, int x){
		for (int i = 0; i < SIZE-4; i++) {
			for (int j = 0; j < SIZE-4; j++) {
				if (matrix[i][j]==x&&matrix[i][j]==matrix[i+1][j+1]&&matrix[i+1][j+1]==matrix[i+2][j+2]&&matrix[i+2][j+2]==matrix[i+3][j+3]&&matrix[i+3][j+3]==matrix[i+4][j+4]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
