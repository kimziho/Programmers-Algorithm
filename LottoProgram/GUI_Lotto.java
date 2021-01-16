package Lottto;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.SystemColor;


public class GUI_Lotto {

	private JFrame frmLotto;
	TextArea textArea = new TextArea();
	String a = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Lotto window = new GUI_Lotto();
					window.frmLotto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Lotto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLotto = new JFrame();
		frmLotto.setTitle("Lotto");
		frmLotto.setBackground(Color.GRAY);
		frmLotto.setBounds(100, 100, 609, 393);
		frmLotto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton Reset_button = new JButton("Reset");
		Reset_button.setBounds(59, 280, 91, 23);
		Reset_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = "";
				textArea.setText(a);
			}
		});
		
		JButton Start_button = new JButton("Lotto");
		Start_button.setBounds(246, 280, 91, 23);
		Start_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a += makeLotto();
				textArea.setText(a);
			}
		});

		JButton Cancle_button = new JButton("Cancle");
		Cancle_button.setBounds(435, 280, 91, 23);
		Cancle_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		frmLotto.getContentPane().setLayout(null);
		frmLotto.getContentPane().add(Reset_button);
		frmLotto.getContentPane().add(Start_button);
		frmLotto.getContentPane().add(Cancle_button);
		
		JLabel lblNewLabel = new JLabel("Lotto Program");
		lblNewLabel.setBounds(246, 10, 91, 29);
		frmLotto.getContentPane().add(lblNewLabel);
		textArea.setBackground(new Color(255, 255, 255));
		
		
		textArea.setBounds(40, 45, 500, 216);
		frmLotto.getContentPane().add(textArea);
	}
	
	public static String makeLotto() {
		String lotto = "";
		Random rand = new Random();
		HashMap<Integer,Integer> check = new HashMap<Integer,Integer>();
		int[] temp = new int[6];
		int bonus = 0;
		for(int i = 0 ; i < 7 ; i++) {
			
			int lotto_num = rand.nextInt(45)+1;
			if(!check.containsValue(lotto_num)){
				if(i == 6) {
					bonus = rand.nextInt(45)+1;
					break;
				}
				temp[i] = lotto_num; 
				check.put(i, lotto_num);
			}else {
				i--;
			}
		}
		Arrays.sort(temp);
		for(int i = 0; i < temp.length ; i++) {
			lotto += temp[i]+"	" ;
		}
		lotto += "보너스 번호 :"+bonus+"\n";
		return lotto;
		
	}
}
