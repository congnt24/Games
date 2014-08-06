/*
 * http://www.websudoku.com/?level=1
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;


public class Main_Activity extends Sudoku{
	
	private JFrame frame;
	public static JPanel panel_2, panel_3;
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
		frame.setBounds(100, 100, 600, 500);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "1");
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create();
				CardLayout cardlayout=(CardLayout)panel.getLayout();
				cardlayout.show(panel, "2");
			}
		});
		
		JButton btnExit = new JButton("Exit");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(254, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnNewGame)
							.addGap(247))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnExit)
							.addGap(263))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(72)
					.addComponent(btnNewGame)
					.addGap(9)
					.addComponent(btnExit)
					.addContainerGap(266, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "2");
		panel_3.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_3.add(panel_2);
		panel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setPreferredSize(new Dimension(400,400));
		panel_2.setLayout(new GridLayout(9, 9, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(100,500));
		panel_3.add(panel_4, BorderLayout.EAST);
		
		JButton btnNewGame_1 = new JButton("New Game");
		btnNewGame_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_2.removeAll();
				create();
				panel_2.validate();
			}
		});
		
		JButton btnHint = new JButton("Hint");
		btnHint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 81; i++) {
					try {
						if (Integer.parseInt(jt[i].getText())!=result[i]) {
							jt[i].setForeground(Color.BLUE);
							jt[i].setText(Integer.toString(result[i]));
						}
					} catch (NumberFormatException e2) {
						jt[i].setForeground(Color.BLUE);
						jt[i].setText(Integer.toString(result[i]));
					}
				}
			}
		});
		btnHint.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean test=true;
				for (int i = 0; i < 81; i++) {
					try {
						if (Integer.parseInt(jt[i].getText())!=result[i]) {//False
							test=false;
							break;
						}
					} catch (NumberFormatException e) {
						test=false;
						break;
					}
				}
				if (test) {
					JOptionPane.showMessageDialog(null, "******You Win*****");
				}else{
					JOptionPane.showMessageDialog(null, "!!!!You Lose!!!!");
				}
				
			}
		});
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewGame_1)
						.addComponent(btnExit_1)
						.addComponent(btnCheck)
						.addComponent(btnHint)))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewGame_1)
					.addGap(5)
					.addComponent(btnHint)
					.addGap(5)
					.addComponent(btnCheck)
					.addGap(5)
					.addComponent(btnExit_1))
		);
		gl_panel_4.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnNewGame_1, btnHint, btnCheck, btnExit_1});
		panel_4.setLayout(gl_panel_4);
	}
}
