import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Paaikkuna extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmTyhjenna;
	private JMenu mnSammuta;
	private JTextField Ensimm‰inenLuku;
	private JTextField ToinenLuku;
	private JButton btnSumma;
	private JButton btnErotus;
	private JButton btnTulo;
	private JButton btnJako;
	private JTextField LaskutoimituksenTulos;
	private JLabel lblLuku1;
	private JLabel lblLuku2;
	private JLabel lblTulos;
	private JMenuItem mntmSuljetaan;
	private JCheckBoxMenuItem chckbxmntmNewCheckItem;

	
	  public void tulostaTiedostoon(String txt, String filename) {
	        try {
	            java.util.Date date = new java.util.Date();
	            FileWriter fwriter = new FileWriter(filename, true);// Valinta true -> ei ylikirjoita vaan lis‰‰ loppuun
	            fwriter.write(date.toString());
	            fwriter.write(txt + "\n");
	            fwriter.close();

	 

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paaikkuna frame = new Paaikkuna();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Paaikkuna() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Paaikkuna.class.getResource("/Image/calculator-168360_640 (1).jpg")));
		setTitle("Nelilaskin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 103, 20);
		contentPane.add(menuBar);
		
		mnNewMenu = new JMenu("Tyhjenn\u00E4/Sulje");
		menuBar.add(mnNewMenu);
		
		mntmTyhjenna = new JMenuItem("Tyhjenn\u00E4?");
		mnNewMenu.add(mntmTyhjenna);
		
		mnSammuta = new JMenu("Sammuta?");
		mnNewMenu.add(mnSammuta);
		
		mntmSuljetaan = new JMenuItem("Haluatko varmasti sulkea?");
		mnSammuta.add(mntmSuljetaan);
		
		Ensimm‰inenLuku = new JTextField();
		Ensimm‰inenLuku.setHorizontalAlignment(SwingConstants.LEFT);
		Ensimm‰inenLuku.setBounds(80, 48, 86, 20);
		contentPane.add(Ensimm‰inenLuku);
		Ensimm‰inenLuku.setColumns(10);
		
		ToinenLuku = new JTextField();
		ToinenLuku.setBounds(80, 90, 86, 20);
		contentPane.add(ToinenLuku);
		ToinenLuku.setColumns(10);
		
		btnSumma = new JButton("+");
		btnSumma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				int num1,num2,ans;
				num1=Integer.parseInt(Ensimm‰inenLuku.getText());
				num2=Integer.parseInt(ToinenLuku.getText());
				
				ans=num1+num2;
				//tulostaa tuloksen Tulos-ikkunaan
				LaskutoimituksenTulos.setText(Integer.toString(num1)+ "+" +Integer.toString(num2)+ "=" +Integer.toString(ans));
				
			}	
			catch(Exception e1) {
				
				JOptionPane.showMessageDialog(null,"Lis‰‰ numero");
			}
					
			}
		});
		btnSumma.setBounds(225, 48, 40, 40);
		contentPane.add(btnSumma);
		
		btnErotus = new JButton("-");
		btnErotus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				int num1,num2,ans;
				num1=Integer.parseInt(Ensimm‰inenLuku.getText());
				num2=Integer.parseInt(ToinenLuku.getText());
				
				ans=num1-num2;
				//tulostaa tuloksen Tulos-ikkunaan
				LaskutoimituksenTulos.setText(Integer.toString(num1)+ "-" +Integer.toString(num2)+ "=" +Integer.toString(ans));
				
			}	
			catch(Exception e1) {
				
				JOptionPane.showMessageDialog(null,"Lis‰‰ numero");
			}
					
			}
		});
		btnErotus.setBounds(307, 48, 40, 40);
		contentPane.add(btnErotus);
		
		btnTulo = new JButton("*");
		btnTulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				int num1,num2,ans;
				num1=Integer.parseInt(Ensimm‰inenLuku.getText());
				num2=Integer.parseInt(ToinenLuku.getText());
				
				ans=num1*num2;
				//tulostaa tuloksen Tulos-ikkunaan
				LaskutoimituksenTulos.setText(Integer.toString(num1)+ "*" +Integer.toString(num2)+ "=" +Integer.toString(ans));
				
			}	
			catch(Exception e1) {
				
				JOptionPane.showMessageDialog(null,"Lis‰‰ numero");
			}
					
			}
		});
		btnTulo.setBounds(225, 109, 40, 40);
		contentPane.add(btnTulo);
		
		btnJako = new JButton("/");
		btnJako.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				int num1,num2,ans;
				num1=Integer.parseInt(Ensimm‰inenLuku.getText());
				num2=Integer.parseInt(ToinenLuku.getText());
				
				ans=num1/num2;
				//tulostaa tuloksen Tulos-ikkunaan
				LaskutoimituksenTulos.setText(Integer.toString(num1)+ "/" +Integer.toString(num2)+ "=" +Integer.toString(ans));
				
			}	
			catch(Exception e1) {
				
				JOptionPane.showMessageDialog(null,"Lis‰‰ ikkunaan numero");
			}
					
			}

		});
		btnJako.setBounds(307, 109, 40, 40);
		contentPane.add(btnJako);
		
		LaskutoimituksenTulos = new JTextField();
		LaskutoimituksenTulos.setBounds(80, 155, 103, 21);
		contentPane.add(LaskutoimituksenTulos);
		LaskutoimituksenTulos.setColumns(10);
		
		try {
			int num1,num2,ans;

			num1 = Integer.parseInt(Ensimm‰inenLuku.getText());
			num2 = Integer.parseInt(ToinenLuku.getText());

			ans=num1+num2;
			LaskutoimituksenTulos.setText(Integer.toString(ans));

			}catch (Exception e) {

			}
		
		lblLuku1 = new JLabel("Luku 1");
		lblLuku1.setFont(new Font("Arial", Font.BOLD, 12));
		lblLuku1.setBounds(10, 51, 46, 14);
		contentPane.add(lblLuku1);
		
		lblLuku2 = new JLabel("Luku 2");
		lblLuku2.setFont(new Font("Arial", Font.BOLD, 12));
		lblLuku2.setBounds(10, 93, 46, 14);
		contentPane.add(lblLuku2);
		
		lblTulos = new JLabel("Tulos");
		lblTulos.setFont(new Font("Arial", Font.BOLD, 12));
		lblTulos.setBounds(10, 158, 46, 14);
		contentPane.add(lblTulos);
		
		chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Kirjoitetaan");
		chckbxmntmNewCheckItem.setBounds(232, 228, 129, 22);
		contentPane.add(chckbxmntmNewCheckItem);
		

	}
}
