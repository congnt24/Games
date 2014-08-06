import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;


import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.io.IOException;
public class Main_Activity extends Create implements ActionListener{

	
	private JFrame frame;
	public static JPanel panel, panel_3;
	public static JButton btnNewGame,btnTop,btnSetting,btnExit;
	public static JMenuItem mntmNewGame,mntmTop,mntmSetting,mntmExit;
	
	ActionListener menu=new ActionListener() {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source=e.getSource();
			if(source==btnExit || source==mntmExit){
				System.exit(0);
			}else if( source==btnNewGame || source==mntmNewGame){
				panel_3.setVisible(false);
				map=1;
				score =0;
				time=120;
				lblMap.setText("Map: "+map);
				lblScore.setText("Score: "+score);
				lblTime.setText("Time = "+"120");
				New();
			}else if(source == btnTop || source == mntmTop){
//				JOptionPane.showMessageDialog(null, "Hight Score: "+hightscore);
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
				tmpp.add(new JButton("Hight Score: "+hightscore));
				jd.add(tmpp);
				jd.setTitle("Hight Score");
				jd.setBounds(500, 100, 400, 200);
				jd.show();
				
			}else if(source == btnSetting || source == mntmSetting){
				JDialog jd=new JDialog();
				JPanel diaPanel = new JPanel();
				jd.setContentPane(diaPanel);
				jd.setTitle("Difficult");
				jd.setBounds(500, 100, 400, 100);
				diaPanel.add(new JLabel("So hang: "));
				JTextField sohang=new JTextField("06");
				diaPanel.add(sohang);
				diaPanel.add(new JLabel("So cot: "));
				JTextField socot=new JTextField("10");
				diaPanel.add(socot);
				JButton diaOK=new JButton("OK");
				diaOK.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						jd.setVisible(false);
						if ((Integer.parseInt(sohang.getText()) * Integer.parseInt(socot.getText())) %2==0) {
							try {
								SO_HANG=Integer.parseInt(sohang.getText());
								SO_COT=Integer.parseInt(socot.getText());
							} catch (Exception e2) {
								SO_HANG=6;
								SO_COT=10;
							}finally {
								SO_PT=SO_HANG*SO_COT;
							}
							panel.removeAll();
							panel.setLayout(new GridLayout(SO_HANG, SO_COT, 0, 0));
						}else {
							JOptionPane.showMessageDialog(null, "Ban phai nhap so hang hoac so cot la 1 so chan.");
						}
						
					}
				});
				diaPanel.add(diaOK);
				jd.show();
			}
		}
	};
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Activity window = new Main_Activity();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Activity() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pikachu");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		 mntmNewGame = new JMenuItem("New Game");
		 mntmSetting = new JMenuItem("Difficult");
		 mntmTop = new JMenuItem("Hight Score");
		 mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmNewGame);
		mnFile.add(mntmTop);
		mnFile.add(mntmSetting);
		mnFile.add(mntmExit);
		
		JPanel panel_2 = new JPanel(){
			private static final long serialVersionUID = 1L;
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
//					Image img=ImageIO.read(new File("images/img3.jpg"));
					Image img=ImageIO.read(ClassLoader.getSystemResourceAsStream("images/img3.jpg"));
					g.drawImage(img, 0, 0, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		};
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panel_2.setBackground(Color.DARK_GRAY);
		
		
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_2.setLayout(fl_panel_2);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel_2.add(panel);
//		panel.setLayout(new GridLayout(SO_HANG, SO_COT, 0, 0));
		panel.setLayout(new GridLayout(8, 16, 0, 0));
		
		panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(150,200));
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnNewGame = new JButton("New Game");
		panel_3.add(btnNewGame);
		btnTop=new JButton("Hight Score");
		btnTop.addActionListener(menu);
		panel_3.add(btnTop);
		
		btnSetting=new JButton("Difficult");
		btnSetting.addActionListener(menu);
		panel_3.add(btnSetting);
		btnExit = new JButton("Exit");
		btnExit.addActionListener(menu);
		panel_3.add(btnExit);
		btnNewGame.addActionListener(menu);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		lblMap = new JLabel("Map");
		panel_1.add(lblMap);
		lblScore = new JLabel("Score");
		panel_1.add(lblScore);
		lblTime = new JLabel("Time = 120");
		panel_1.add(lblTime);
		JButton hint=new JButton("Hint");
		hint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkAll()){
					btnImg[hintnum[0]].setBorder(new LineBorder(Color.RED, 3));
					btnImg[hintnum[1]].setBorder(new LineBorder(Color.RED, 3));
				}
			}
		});
		panel_1.add(hint);
		JButton stop = new JButton("Stop/Resume");
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timeCounter.isRunning()) {
					timeCounter.stop();
					panel.setVisible(false);
				}else {
					timeCounter.start();
					panel.setVisible(true);
				}
			}
		});
		panel_1.add(stop);
		JButton change = new JButton("Change");
		change.addActionListener(changegame);
		panel_1.add(change);
		mntmNewGame.addActionListener(menu);
		mntmTop.addActionListener(menu);
		mntmSetting.addActionListener(menu);
		mntmExit.addActionListener(menu);
	}
}
