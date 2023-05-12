import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankkienTilavuus extends JFrame {

	private JPanel contentPane;
	private JButton Bensa98_pi_noedit;
	private JButton Diesel_pi_noedit;
	private JButton Bensa95_pi_noedit;
	private JLabel lblNewLabel;

	private JTextField txtTankienTilanne;
	public static JProgressBar progressBarTankki95;
	public static JProgressBar progressBarTankki98;
	public static JProgressBar progressBarTankkiDiesel;

	public static JLabel lbltankki95Maara;
	public static JLabel lbltankki98Maara;
	public static JLabel lbltankkiDieselMaara;

	private JButton btnLisaaPainike95;
	private JButton btnLisaaPainike98;
	private JButton btnLisaaPainikeDiesel;

	private Tilaus95Ikkuna tilaus95ikkuna = new Tilaus95Ikkuna();
	private Tilaus98Ikkuna tilaus98ikkuna = new Tilaus98Ikkuna();
	private TilausDieselIkkuna tilausdieselikkuna = new TilausDieselIkkuna();
	private JLabel lblNewLabel_1;

	String tankki95Maara;
	String tankki98Maara;
	String tankkiDieselMaara;

	String filenameBensaa95 = "src/Resources/bensaa95.txt";
	String filenameBensaa98 = "src/Resources/bensaa98.txt";
	String filenameDiesel = "src/Resources/diesel.txt";
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KirjautumisIkkuna kirjautumisikkuna = new KirjautumisIkkuna();
					kirjautumisikkuna.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public TankkienTilavuus() {

		setTitle("GasolineGroup");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\sirpa\\eclipse-workspace\\Bensatankit\\src\\Images\\fuel-1596622_640.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Bensa98_pi_noedit = new JButton("Bensiini 98");
		Bensa98_pi_noedit.setForeground(new Color(0, 0, 0));
		Bensa98_pi_noedit.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
		Bensa98_pi_noedit.setBounds(20, 130, 130, 49);
		contentPane.add(Bensa98_pi_noedit);

		Diesel_pi_noedit = new JButton("Diesel");
		Diesel_pi_noedit.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
		Diesel_pi_noedit.setBounds(20, 201, 130, 49);
		contentPane.add(Diesel_pi_noedit);

		Bensa95_pi_noedit = new JButton("Bensiini 95");
		Bensa95_pi_noedit.setForeground(Color.BLACK);
		Bensa95_pi_noedit.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
		Bensa95_pi_noedit.setBounds(20, 58, 130, 49);
		contentPane.add(Bensa95_pi_noedit);

		lblNewLabel = new JLabel("Tankkien kapasiteetti on 1000 l");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setBounds(10, 0, 414, 34);
		contentPane.add(lblNewLabel);

		txtTankienTilanne = new JTextField();
		txtTankienTilanne.setHorizontalAlignment(SwingConstants.CENTER);
		txtTankienTilanne.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
		txtTankienTilanne.setText("Tankkien t\u00E4ytt\u00F6aste");
		txtTankienTilanne.setBounds(445, 25, 253, 20);
		contentPane.add(txtTankienTilanne);
		txtTankienTilanne.setColumns(10);

		

		lbltankki95Maara = new JLabel("New label");
		lbltankki95Maara.setBounds(179, 73, 80, 20);
		lbltankki95Maara.setText(lueTiedostosta(filenameBensaa95));
		contentPane.add(lbltankki95Maara);

		btnLisaaPainike95 = new JButton("Tilaa lis\u00E4\u00E4");
		btnLisaaPainike95.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tilaus95ikkuna.dispose();
				tilaus95ikkuna = new Tilaus95Ikkuna();
// kommentoitu turhat piiloon, korjattu muuttujat
				String vanha = lbltankki95Maara.getText();
			//	String tilaus = tilaus95ikkuna.lbltankki95Maara.getText();
			//	String uusi = laskeUusiMaara(tilaus, vanha);
				tilaus95ikkuna.lbltankki95Maara.setText(vanha);

				tilaus95ikkuna.setModal(true);
				tilaus95ikkuna.setVisible(true);
			}
		});
		btnLisaaPainike95.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
		btnLisaaPainike95.setBounds(269, 58, 128, 45);
		contentPane.add(btnLisaaPainike95);

		lbltankki98Maara = new JLabel("New label");
		lbltankki98Maara.setBounds(179, 148, 80, 20);
		lbltankki98Maara.setText(lueTiedostosta(filenameBensaa98));

		contentPane.add(lbltankki98Maara);

		lbltankkiDieselMaara = new JLabel("New label");
		lbltankkiDieselMaara.setBounds(179, 219, 80, 20);
		lbltankkiDieselMaara.setText(lueTiedostosta(filenameDiesel));

		contentPane.add(lbltankkiDieselMaara);

		btnLisaaPainike98 = new JButton("Tilaa lis\u00E4\u00E4");
		btnLisaaPainike98.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tilaus98ikkuna.dispose();
				tilaus98ikkuna = new Tilaus98Ikkuna();

//				String tilaus = lbltankki98Maara.getText();
				String vanha = tilaus98ikkuna.lbltankki98Maara.getText();
//				String uusi = laskeUusiMaara(tilaus, vanha);
				tilaus98ikkuna.lbltankki98Maara.setText(vanha);

				tilaus98ikkuna.setModal(true);
				tilaus98ikkuna.setVisible(true);

			}
		});
		btnLisaaPainike98.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
		btnLisaaPainike98.setBounds(269, 132, 128, 45);
		contentPane.add(btnLisaaPainike98);

		btnLisaaPainikeDiesel = new JButton("Tilaa lis\u00E4\u00E4");
		btnLisaaPainikeDiesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tilausdieselikkuna.dispose();
				tilausdieselikkuna = new TilausDieselIkkuna();

//				String tilaus = lbltankkiDieselMaara.getText();
				String vanha = tilausdieselikkuna.lbltankkiDieselMaara.getText();
//				String uusi = laskeUusiMaara(tilaus, vanha);
				tilausdieselikkuna.lbltankkiDieselMaara.setText(vanha);

				tilausdieselikkuna.setModal(true);
				tilausdieselikkuna.setVisible(true);
			}
		});
		btnLisaaPainikeDiesel.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
		btnLisaaPainikeDiesel.setBounds(269, 203, 128, 45);
		contentPane.add(btnLisaaPainikeDiesel);

		// luetaan tiedostoissa oleva tankkien tämän hetkinen luku
		progressBarTankki95 = new JProgressBar(0, 1000);
		progressBarTankki95.setValue(Integer.parseInt(lbltankki95Maara.getText()));
		progressBarTankki95.setForeground(new Color(102, 153, 0));
		progressBarTankki95.setBackground(Color.WHITE);
		progressBarTankki95.setBounds(445, 69, 253, 34);
		contentPane.add(progressBarTankki95);
		
		progressBarTankki98 = new JProgressBar(0, 1000);
		progressBarTankki98.setValue(Integer.parseInt(lbltankki98Maara.getText()));
		progressBarTankki98.setForeground(new Color(102, 153, 0));
		progressBarTankki98.setBackground(Color.WHITE);
		progressBarTankki98.setBounds(445, 138, 253, 30);
		contentPane.add(progressBarTankki98);

		progressBarTankkiDiesel = new JProgressBar(0, 1000);
		progressBarTankkiDiesel.setValue(Integer.parseInt(lbltankkiDieselMaara.getText()));
		progressBarTankkiDiesel.setForeground(new Color(102, 153, 0));
		progressBarTankkiDiesel.setBackground(Color.WHITE);
		progressBarTankkiDiesel.setBounds(445, 209, 253, 30);
		contentPane.add(progressBarTankkiDiesel);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\sirpa\\eclipse-workspace\\Bensatankit\\src\\Images\\filling-station-1839760_640.jpg"));
		lblNewLabel_2.setBounds(236, -45, 796, 507);
		contentPane.add(lblNewLabel_2);


	}

	public void tarkastaMaara() {
	
	if(Integer.parseInt(lbltankki95Maara.getText()) < 200) {
		JOptionPane.showMessageDialog(null, "Polttoaine 95 lopussa, tilaa lisää");
		progressBarTankki95.setForeground(Color.RED);
	}else if(Integer.parseInt(lbltankki98Maara.getText()) < 200) {
		JOptionPane.showMessageDialog(null, "Polttoaine 98 lopussa, tilaa lisää");
		progressBarTankki98.setForeground(Color.RED);
	}else if(Integer.parseInt(lbltankkiDieselMaara.getText()) < 200) {
		JOptionPane.showMessageDialog(null, "Polttoaine Diesel lopussa, tilaa lisää");
		progressBarTankkiDiesel.setForeground(Color.RED);
	}else if(Integer.parseInt(lbltankki95Maara.getText()) > 200) {
		progressBarTankki98.setForeground(Color.GREEN);
	}else if(Integer.parseInt(lbltankki98Maara.getText()) > 200) {
		progressBarTankkiDiesel.setForeground(Color.GREEN);
	}else if(Integer.parseInt(lbltankkiDieselMaara.getText()) > 200) {
		progressBarTankkiDiesel.setForeground(Color.GREEN);
	}
	
}
	
	
	
	public void luetankinMaara(String filename) {
		String tankki = "";
		String labeli = "";
		String progressBari = "";
		
		if (filename.contains("95")) {
			tankki = "tankki95Maara";
			labeli = "lbltankki95Maara";
			progressBari = "progressBarTankki95";
			
		} else if (filename.contains("98")) {
			tankki = "tankki98Maara";
			labeli = "lbltankki98Maara";
			progressBari = "progressBarTankki98";

		} else if (filename.contains("diesel")) {
			tankki = "tankkiDieselMaara";
			labeli = "lbltankkiDieselMaara";
			progressBari = "progressBarTankkiDiesel";

		}

		try {
			FileReader freader = new FileReader(filename);
			BufferedReader br = new BufferedReader(freader);
			String line;

			tankki = br.readLine();
			tankki = kasitteleRivi(br.readLine());

//			lbltankki95Maara.setText(tankki);
//			progressBarTankki95.setValue(Integer.parseInt(tankki));
//			
//			if (Integer.parseInt(tankki) < 200) {
//				JOptionPane.showMessageDialog(null, "Polttoaine 95 lopussa, tilaa lisää");
//				progressBarTankki95.setForeground(Color.RED);
//				
//			} else if (Integer.parseInt(tankki) < 200) {
//				JOptionPane.showMessageDialog(null, "Polttoaine 98 lopussa, tilaa lisää");
//				progressBarTankki98.setForeground(Color.RED);
//				
//			} else if (Integer.parseInt(tankki) < 200) {
//				JOptionPane.showMessageDialog(null, "Polttoaine Diesel lopussa, tilaa lisää");
//				
//			}
			
		
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void tulostaTiedostoon(String txt) {
		String filename = "scr/Resources/tilaukset.txt";

		try {
			java.util.Date date = new java.util.Date();
			FileWriter filewriter = new FileWriter(filename, false);
//						filewriter.write(date.toString() +  " : ");
//						filewriter.write(txt + "\n");
			filewriter.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String lueTiedostosta(String filename) {
		try {
			FileReader freader = new FileReader(filename);
			BufferedReader br = new BufferedReader(freader);
			String line=br.readLine();
			freader.close();
			br.close();
			return line;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "testi";
	}

	public String kasitteleRivi(String txt) { // Saldo = 1000
		txt = txt.replace(" ", ""); // Saldo=1000
		String[] temp = txt.split("="); // temp[0] => Saldo, temp[1] => 1000

		return temp[1];
	}

	public String laskeUusiMaara(String tilaus, String vanha) {
		
		int c = 0;
		
		try {
			int a = Integer.parseInt(tilaus);
			int b = Integer.parseInt(vanha);
			c = a + b;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "" + c;

	}
}