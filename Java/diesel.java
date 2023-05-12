import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TilausDieselIkkuna extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel_noedit;
	public JLabel lbltankkiDieselMaara;
	private JLabel lblTilattavaDieselMaara_noedit;
	private JTextField textFieldTilattavaDieselMaara;
	private JButton btnTilaaPainike;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public TilausDieselIkkuna() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				TankkienTilavuus.lbltankkiDieselMaara.setText(lbltankkiDieselMaara.getText());
			}
		});
		setTitle("DIESELIN TILAUSIKKUNA");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNewLabel_noedit = new JLabel("DIESEL TANKKI/l");
		lblNewLabel_noedit.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_noedit.setBounds(10, 34, 154, 35);
		contentPanel.add(lblNewLabel_noedit);

		lbltankkiDieselMaara = new JLabel("New label");
		lbltankkiDieselMaara.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
		lbltankkiDieselMaara.setBounds(311, 44, 90, 25);
		contentPanel.add(lbltankkiDieselMaara);

		lblTilattavaDieselMaara_noedit = new JLabel("TILATTAVA M\u00C4\u00C4R\u00C4");
		lblTilattavaDieselMaara_noedit.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
		lblTilattavaDieselMaara_noedit.setBounds(10, 109, 154, 35);
		contentPanel.add(lblTilattavaDieselMaara_noedit);

		textFieldTilattavaDieselMaara = new JTextField();
		textFieldTilattavaDieselMaara.setBounds(299, 117, 86, 20);
		contentPanel.add(textFieldTilattavaDieselMaara);
		textFieldTilattavaDieselMaara.setColumns(10);

		btnTilaaPainike = new JButton("TILAA");
		btnTilaaPainike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {					
					// lisää muuttujat
					String tmp_tilaus;
					tmp_tilaus = "" + (Integer.parseInt(textFieldTilattavaDieselMaara.getText()) + Integer.parseInt(lbltankkiDieselMaara.getText()));
					String tilaus;
					tilaus = "" + Integer.parseInt(textFieldTilattavaDieselMaara.getText());
					
					int result = JOptionPane.showConfirmDialog(null, "Tilataanko varmasti?","Varmistus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if( result == JOptionPane.OK_OPTION ) {
						lbltankkiDieselMaara.setText(tmp_tilaus);
						
						// turha, korjattu alla
				//		TankkienTilavuus.lbltankki95Maara.setText((Integer.parseInt(TankkienTilavuus.lbltankki95Maara.getText())+Integer.parseInt(tmp_tilaus))+"");
						TankkienTilavuus.lbltankkiDieselMaara.setText(tmp_tilaus);
						TankkienTilavuus.progressBarTankkiDiesel.setValue(Integer.parseInt(TankkienTilavuus.lbltankkiDieselMaara.getText()));
							// muista lisätä 2. metodi kirjoittamiseen , korjata metodi 1 kirjoitus
						textFieldTilattavaDieselMaara.setText("");
						// korjaa myös muihin tämä
									tulostaTiedostoon("Dieseliä tilattu " + tilaus + "litraa");
									kirjoitaTiedostoon2(tmp_tilaus);
					}
					if( result == JOptionPane.NO_OPTION ) {
					textFieldTilattavaDieselMaara.setText("");
					}
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Väärä syöte");
					textFieldTilattavaDieselMaara.setText("");
//					String tmp_tilaus;
//					tmp_tilaus = "" + (Integer.parseInt(textFieldTilattavaDieselMaara.getText())
//							+ Integer.parseInt(lbltankkiDieselMaara.getText()));
//
//					int result = JOptionPane.showConfirmDialog(null, "Tilataanko varmasti?", "Varmistus",
//							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
//					if (result == JOptionPane.OK_OPTION) {
//						TankkienTilavuus.lbltankkiDieselMaara
//								.setText((Integer.parseInt(TankkienTilavuus.lbltankkiDieselMaara.getText())
//										+ Integer.parseInt(tmp_tilaus)) + "");
//
//						lbltankkiDieselMaara.setText(tmp_tilaus);
//						TankkienTilavuus.progressBarTankkiDiesel.setValue(Integer.parseInt(TankkienTilavuus.lbltankkiDieselMaara.getText()));
//						textFieldTilattavaDieselMaara.setText("");
//						
//						tulostaTiedostoon("Dieseliä tilattu " + tilaus + "litraa");
//						kirjoitaTiedostoon2(tmp_tilaus);
//
////						tulostaTiedostoon2(tmp_tilaus);
//					}
//					if (result == JOptionPane.NO_OPTION) {
//						textFieldTilattavaDieselMaara.setText("");
//					}
//				} catch (NumberFormatException e1) {
//					JOptionPane.showInternalMessageDialog(null, "väärä syöte");
//					textFieldTilattavaDieselMaara.setText("");
				}
			}
		});
		btnTilaaPainike.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
		btnTilaaPainike.setBounds(299, 175, 89, 23);
		contentPanel.add(btnTilaaPainike);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Sulje");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						TankkienTilavuus.lbltankkiDieselMaara.setText(lbltankkiDieselMaara.getText());
						TilausDieselIkkuna.this.dispose();
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	public void tulostaTiedostoon(String txt) {
		String filename2 = "src/Resources/tilaukset.txt";

		try {
			java.util.Date date = new java.util.Date();
			FileWriter filewriter = new FileWriter(filename2, true);
			filewriter.write(date.toString() + " = ");
			filewriter.write(txt + "\n");
			filewriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}}
	
		public void kirjoitaTiedostoon2(String txt) {
			
			String filename3 = "src/Resources/diesel.txt";
			try {
				FileWriter fwriter = new FileWriter(filename3, false);
				fwriter.write(txt);
				fwriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}