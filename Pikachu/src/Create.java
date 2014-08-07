import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Create implements ActionListener {
	
	public static Random random=new Random();
	public static int[] A;
	public static JButton btnImg[];
	public  ImageIcon img=new ImageIcon(getClass().getResource("images/h0.jpg"));
	public int x=img.getIconWidth();
	public int y=img.getIconHeight();
	protected int map=1, score, counter=0, source, click=0;
	private Border border=new LineBorder(Color.DARK_GRAY, 3);
	protected JButton b1,b2;
	protected boolean selected=false;
	protected Timer timeCounter;
	protected JLabel lblMap,lblScore, lblTime;
	int p1;
	int hightscore=0;
	File dir=new File("C:\\Pikachu");
	File f= new File(dir,"top.txt");
	PrintWriter writer;
	boolean started=false;
	@SuppressWarnings("unchecked")
	ArrayList<Integer>[] B = new ArrayList[41];
	
	int hintnum[]=new int[2];
	
	 int SO_COT=16;
	 int SO_HANG=8;
	 int SO_PT=SO_COT*SO_HANG;
	///
	int time=120;
	public ActionListener changegame=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < SO_PT; i++) {
				if(A[i]<40){
					int r=random.nextInt(36);
					A[i]=r;
				}
			}
			for (int i = 0; i < 37; i++) {
				if (kiemtra(i)%2!=0) {
					change(i);
				}
			}
			makeButton();
		}
	};
	
	public Create(){
		timeCounter=new Timer(1000, new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTime.setText("Time = "+--time);
				if(time==0){
					JDialog jd=new JDialog();
					JPanel tmpp=new JPanel(){
						private static final long serialVersionUID = 1L;

						@Override
						protected void paintComponent(Graphics g) {
							super.paintComponent(g);
							try {
								Image img=ImageIO.read(ClassLoader.getSystemResourceAsStream("images/img1.jpg"));
								g.drawImage(img, 0, 0, null);
							} catch (IOException e) {
							}
						}
						
					};
					tmpp.add(new JButton("YOU LOSE!!!!!"));
					jd.add(tmpp);
					jd.setTitle("YOU LOSE");
					jd.setBounds(500, 100, 400, 200);
					jd.show();
					((Timer)e.getSource()).stop();
					Main_Activity.panel.removeAll();
				}
			}
		});
		BufferedReader br = null;
		try {
			br=new BufferedReader(new FileReader(f));
			String line;
			if((line=br.readLine())!=null){
				hightscore=Integer.parseInt(line);
			}else{
				hightscore=0;
			}
			br.close();
		} catch (IOException e1) {
			try {
				dir.mkdir();
				f.createNewFile();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	public void makeButton(){
		timeCounter.start();
		btnImg=new JButton[SO_PT];
		Main_Activity.panel.removeAll();
		Dimension dim=new Dimension(x,y);
		for (int i = 0; i < SO_PT; i++) {
			btnImg[i]=new JButton();
			btnImg[i].setPreferredSize(dim);
			switch (A[i]) {
			case 0:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h0.jpg")));
				break;
			case 1:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h1.jpg")));
				break;
			case 2:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h2.jpg")));
				break;
			case 3:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h3.jpg")));
				break;
			case 4:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h4.jpg")));
				break;
			case 5:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h5.jpg")));
				break;
			case 6:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h6.jpg")));
				break;
			case 7:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h7.jpg")));
				break;
			case 8:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h8.jpg")));
				break;
			case 9:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h9.jpg")));
				break;
			case 10:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h10.jpg")));
				break;
			case 11:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h11.jpg")));
				break;
			case 12:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h12.jpg")));
				break;
			case 13:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h13.jpg")));
				break;
			case 14:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h14.jpg")));
				break;
			case 15:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h15.jpg")));
				break;
			case 16:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h16.jpg")));
				break;
			case 17:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h17.jpg")));
				break;
			case 18:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h18.jpg")));
				break;
			case 19:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h19.jpg")));
				break;
			case 20:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h20.jpg")));
				break;
			case 21:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h21.jpg")));
				break;
			case 22:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h22.jpg")));
				break;
			case 23:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h23.jpg")));
				break;
			case 24:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h24.jpg")));
				break;
			case 25:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h25.jpg")));
				break;
			case 26:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h26.jpg")));
				break;
			case 27:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h27.jpg")));
				break;
			case 28:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h28.jpg")));
				break;
			case 29:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h29.jpg")));
				break;
			case 30:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h30.jpg")));
				break;
			case 31:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h31.jpg")));
				break;
			case 32:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h32.jpg")));
				break;
			case 33:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h33.jpg")));
				break;
			case 34:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h34.jpg")));
				break;
			case 35:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h35.jpg")));
				break;
			case 36:
				btnImg[i].setIcon(new ImageIcon(getClass().getResource("images/h36.jpg")));
				break;
			default:
				btnImg[i].setVisible(false);
				break;
			}
			Main_Activity.panel.add(btnImg[i]);
			Main_Activity.panel.setVisible(true);
			btnImg[i].addActionListener(this);
			started=true;
			
		}
	}
	public void New(){
		A=new int[SO_PT];
		counter=0;
		Random();
		makeButton();
		checkAll();
	}
	protected void Random() {
		// TODO Auto-generated method stub
		for (int i = 0; i < SO_PT; i++) {
			int r= random.nextInt(36);
			A[i]=r;
		}
		for (int i = 0; i < 37; i++) {
			if (kiemtra(i)%2!=0) {
				change(i);
			}
		}
		
	}

	private void change(int i) {
		for (int j = 0; j < SO_PT; j++) {
			if (A[j]==i) {
				A[j]++;
				return;
			}
		}
	}

	private int kiemtra(int i) {
		int tmp=0;
		for (int j = 0; j < SO_PT; j++) {
			if (A[j]==i) {
				tmp++;
			}
		}
		return tmp;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int j = 0; j < SO_PT; j++) {
			if (arg0.getSource()==btnImg[j]) {
				if(!selected){
					b1=btnImg[j];
					b1.setBorder(border);
					source=A[j];
					p1=j;
					selected=true;
				}else{
					b2=btnImg[j];
					b2.setBorder(border);
					
					if (A[j]==source) {
						if (checkpath(p1,j)) {
							if (b1==b2) {
								b1.setBorder(null);
								b2.setBorder(null);
								b1=null;
								b2=null;
								selected=false;
							}else {
								b1.setVisible(false);
								b2.setVisible(false);
								b1.setBorder(null);
								b2.setBorder(null);
								b1=null;
								b2=null;
								selected=false;
								A[p1]=40;
								A[j]=40;
								score+=100;
								lblScore.setText("Score = "+score);
								counter++;
								checkAll();
								if (counter==SO_PT/2) {
									if (timeCounter.isRunning()) {
										timeCounter.stop();
									}
									score+=time*10+500;
									if (map==3) {
										JDialog jd=new JDialog();
										JPanel tmpp=new JPanel(){
											private static final long serialVersionUID = 1L;

											@Override
											protected void paintComponent(Graphics g) {
												super.paintComponent(g);
												try {
													Image img=ImageIO.read(ClassLoader.getSystemResourceAsStream("images/img2.jpg"));
													g.drawImage(img, 0, 0, null);
												} catch (IOException e) {
												}
											}
											
										};
										
										if(score>hightscore){
											hightscore=score;
											try {
												writer= new PrintWriter(f);
												writer.write(Integer.toString(score));
												tmpp.add(new JButton("Chuc Mung Ban Da Dat ky luc voi: "+score+" diem."));
												writer.close();
											} catch (IOException e) {
											}
										}
										tmpp.add(new JButton("****You Win****"));
										jd.add(tmpp);
										jd.setTitle("Congratulation");
										jd.setBounds(500, 100, 400, 200);
										jd.show();
										Main_Activity.panel.removeAll();
										
									}else {
										map++;
										time=120-20*map;
										counter=0;
										New();
									}
									lblMap.setText("Map: "+map);
									lblScore.setText("Score: "+score);
								}
								
							}
						}else {
							b1.setBorder(null);
							b2.setBorder(null);
							b1=null;
							b2=null;
							selected=false;
						}
						
					}else {
						b1.setBorder(null);
						b2.setBorder(null);
						b1=null;
						b2=null;
						selected=false;
					}
				}
				break;
			}
		}
	}
	
	//////////////////////////////////////////
	private boolean checkpath(int a, int b) {
		int source=A[a];
		A[a]=40;
		A[b]=40;
		//Phan tich
		int xa=a%SO_COT;
		int ya=a/SO_COT;
		int xb=b%SO_COT;
		int yb=b/SO_COT;
		if (xa==xb) {
			if(checkLineY(ya, yb, xa)){
				A[a]=source;
				A[b]=source;
				return true;
			}
		}
		if(ya==yb){
			if(checkLineX(xa, xb, ya)){
				A[a]=source;
				A[b]=source;
				return true;
			}
		}
		if (checkRectX(xa, ya, xb, yb)!=-1 || checkRectY(xa, ya, xb, yb)!=-1) {
			A[a]=source;
			A[b]=source;
			return true;
		}
		A[a]=source;
		A[b]=source;
		return false;
	}
	private boolean checkLineX(int x1, int x2, int y){//theo truc Ox
		int min=x1,max=x2;
		if (x1>x2){
			min=x2;
			max=x1;
		}
		for (int x = min; x <= max; x++) {
			if(A[SO_COT*y+x]!=40){
				return false;
			}
		}
		return true;
	}
	private boolean checkLineY(int y1, int y2, int x){
		int min=y1,max=y2;
		if (y1>y2){
			min=y2;
			max=y1;
		}
		for (int y = min; y <= max; y++) {
			if(A[SO_COT*y+x]!=40){
				return false;
			}
		}
		return true;
	}
	
	//Xet theo hinh chu Z
	private int checkRectX(int x1,int y1,int x2, int y2){
		for (int x = 1; x < SO_COT-1; x++) {
			if (checkLineX(x1, x, y1) &&
					checkLineY(y1, y2, x)&&
					checkLineX(x, x2, y2)) {
				return x;
			}
		}
		for (int x = 0; x < SO_COT; x+=(SO_COT-1)) { 
			if (checkLineX(x1, x, y1) &&
					checkLineX(x, x2, y2)) {
				return x;
			}
		}
		return -1;
	}
	private int checkRectY(int x1,int y1,int x2, int y2){
		for (int y = 1; y < SO_HANG-1; y++) {//Xet cac column 
			if (checkLineY(y1, y, x1) &&
					checkLineX(x1, x2, y)&&
					checkLineY(y, y2, x2)) {
				return y;
			}
		}
		
		for (int y = 0; y < SO_HANG; y+=(SO_HANG-1)) {
			if (checkLineY(y1, y, x1) &&
					checkLineY(y, y2, x2)) {
				return y;
			}
		}
		return -1;
	}
	public boolean checkAll(){
		if(!started)return false;
		for (int i = 0; i < B.length; i++) {
			B[i]=new ArrayList<Integer>();
		}
		for (int i = 0; i < SO_PT; i++) {
				B[A[i]].add(i);
		}
		for (int i = 0; i < 37; i++) {
			for (int j = 0; j < B[i].size(); j++) {
				for (int j2 = j+1; j2 < B[i].size(); j2++) {
					if (checkpath(B[i].get(j), B[i].get(j2))) {
						hintnum[0]=B[i].get(j);
						hintnum[1]=B[i].get(j2);
						return true;
					}
				}
			}
		}
		if (counter<SO_PT/2) {
			for (int i = 0; i < SO_PT; i++) {
				if(A[i]<40){
					int r=random.nextInt(36);
					A[i]=r;
				}
			}
			for (int i = 0; i < 37; i++) {
				if (kiemtra(i)%2!=0) {
					change(i);
				}
			}
			makeButton();
			if (checkAll()) {
				return true;
			}
		}
		return false;
	}
}
