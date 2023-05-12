import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class KirjautumisIkkuna extends JFrame {

	private JPanel contentPane;
	private JLabel lblKayttajatunnus_noedit;
	private JLabel lblsalasana_noedit;
	private JTextField textFieldKayttajatunnus;
	private JTextField textFieldSalasana;
	private JButton btnKirjautumispainike;

	public TankkienTilavuus tankkientilavuus=new TankkienTilavuus();
	
	String filename = "src/Resources/kirjoitettutunnukset.txt";
	private JLabel lblNewLabel;

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
	 * 
	 * 
	 */
	
	public KirjautumisIkkuna() {
		setTitle("KIRJAUTUMINEN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblKayttajatunnus_noedit = new JLabel("Kayttajatunnus");
		lblKayttajatunnus_noedit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblKayttajatunnus_noedit.setBackground(Color.BLACK);
		lblKayttajatunnus_noedit.setBounds(10, 51, 141, 26);
		contentPane.add(lblKayttajatunnus_noedit);
		
		lblsalasana_noedit = new JLabel("Salasana");
		lblsalasana_noedit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblsalasana_noedit.setBounds(10, 105, 141, 26);
		contentPane.add(lblsalasana_noedit);
		
		textFieldKayttajatunnus = new JTextField();
		textFieldKayttajatunnus.setBounds(122, 54, 141, 23);
		contentPane.add(textFieldKayttajatunnus);
		textFieldKayttajatunnus.setColumns(10);
		
		textFieldSalasana = new JTextField();
		textFieldSalasana.setColumns(10);
		textFieldSalasana.setBounds(122, 108, 141, 23);
		contentPane.add(textFieldSalasana);
		
		btnKirjautumispainike = new JButton("Kirjaudu");
		btnKirjautumispainike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String oikea_kayttajatunnus = lueTiedostosta(filename);
				String oikea_salasana = lueTiedostosta1(filename);
				
//				System.out.println (oikea_salasana);
				
				String salasana_crypted= crypt(oikea_salasana);
				
					
				try {
					salasana_crypted = crypt(textFieldSalasana.getText());
					
				}
				catch (Exception e1) {
				}
				if(textFieldKayttajatunnus.getText().equals(oikea_kayttajatunnus) && oikea_salasana.equals(salasana_crypted)) {
					KirjautumisIkkuna.this.setVisible(false);
//					tankkientilavuus=new TankkienTilavuus();
					tankkientilavuus.setVisible(true);
						// else if myös 98 ja diesel
					if(Integer.parseInt(tankkientilavuus.lbltankki95Maara.getText()) < 200) {
						JOptionPane.showMessageDialog(null, "Polttoaine 95 lopussa, tilaa lisää");
						tankkientilavuus.progressBarTankki95.setForeground(Color.RED);
					}else if(Integer.parseInt(tankkientilavuus.lbltankki98Maara.getText()) < 200) {
						JOptionPane.showMessageDialog(null, "Polttoaine 98 lopussa, tilaa lisää");
						tankkientilavuus.progressBarTankki98.setForeground(Color.RED);
					}else if(Integer.parseInt(tankkientilavuus.lbltankkiDieselMaara.getText()) < 200) {
						JOptionPane.showMessageDialog(null, "Polttoaine Diesel lopussa, tilaa lisää");
						tankkientilavuus.progressBarTankkiDiesel.setForeground(Color.RED);
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Salasana väärin!");
				}
		}});
		btnKirjautumispainike.setBounds(122, 173, 141, 26);
		contentPane.add(btnKirjautumispainike);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sirpa\\eclipse-workspace\\Bensatankit\\src\\Images\\petrol-996617_640.jpg"));
		lblNewLabel.setBounds(279, -14, 155, 237);
		contentPane.add(lblNewLabel);
	
}

		public String lueTiedostosta(String filename) {
			String alltext = "";
		
			try {
				FileReader freader = new FileReader(filename);
				BufferedReader br = new BufferedReader(freader);
				String line;
//				while ((line = br.readLine()) != null) {
					alltext = br.readLine();
		
			} catch (Exception e) {
				e.printStackTrace();
				alltext = "";
			}
		
			return alltext;
		}
		public String lueTiedostosta1(String filename) {
			String alltext = "";
		
			try {
				FileReader freader = new FileReader(filename);
				BufferedReader br = new BufferedReader(freader);
				String line;
				while ((line = br.readLine())!= null) {
					alltext = line;
				}
			} catch (Exception e) {
				e.printStackTrace();
				alltext = "";
			}
		
			return alltext;
		
		}
		public void kirjoitaTiedostoon(String txt, String filename) {
			try {
				
				FileWriter fwriter = new FileWriter(filename);
				fwriter.write(txt + "\n");
				fwriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
				public static String crypt(String str) {
					if (str == null || str.length() == 0) {
						throw new IllegalArgumentException("String to encript cannot be null or zero length");
		    }
		
					MessageDigest digester;
					try {
						digester = MessageDigest.getInstance("MD5");
		
						digester.update(str.getBytes());
						byte[] hash = digester.digest();
						StringBuffer hexString = new StringBuffer();
						for (int i = 0; i < hash.length; i++) {
		            if ((0xff & hash[i]) < 0x10) {
		                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
		            } else {
		                hexString.append(Integer.toHexString(0xFF & hash[i]));
		            }
		        }
						return hexString.toString();
		    } 			catch (NoSuchAlgorithmException e) {
		        	e.printStackTrace();
		        	
			    }
						return "";
				
				}
			}