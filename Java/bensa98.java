import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class Tilaus98Ikkuna extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldTilattava98Maara;
	public JLabel lbltankki98Maara;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public Tilaus98Ikkuna() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				TankkienTilavuus.lbltankki98Maara.setText(lbltankki98Maara.getText());
			}
		});
		setTitle("98 OKTAANISEN TILAUS");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbltankki98maara_noedit = new JLabel("98 OKTAANINEN TANKKI/l");
			lbltankki98maara_noedit.setBounds(10, 27, 168, 33);
			contentPanel.add(lbltankki98maara_noedit);
		}
		{
			JLabel lblTilattavaMaara98_noedit = new JLabel("TILATTAVA M\u00C4\u00C4R\u00C4");
			lblTilattavaMaara98_noedit.setBounds(10, 91, 168, 33);
			contentPanel.add(lblTilattavaMaara98_noedit);
		}
		{
			textFieldTilattava98Maara = new JTextField();
			textFieldTilattava98Maara.setBounds(258, 97, 86, 20);
			contentPanel.add(textFieldTilattava98Maara);
			textFieldTilattava98Maara.setColumns(10);
		}
		{
			JButton btnTilaaPainike = new JButton("TILAA");
			btnTilaaPainike.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String tmp_tilaus;
						tmp_tilaus = "" + (Integer.parseInt(textFieldTilattava98Maara.getText()) + Integer.parseInt(lbltankki98Maara.getText()));
						String tilaus;
						tilaus = "" + Integer.parseInt(textFieldTilattava98Maara.getText());
						
						int result = JOptionPane.showConfirmDialog(null, "Tilataanko varmasti?","Varmistus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if( result == JOptionPane.OK_OPTION ) {
							lbltankki98Maara.setText(tmp_tilaus);
							
							// turha, korjattu alla
					//		TankkienTilavuus.lbltankki95Maara.setText((Integer.parseInt(TankkienTilavuus.lbltankki95Maara.getText())+Integer.parseInt(tmp_tilaus))+"");
							TankkienTilavuus.lbltankki98Maara.setText(tmp_tilaus);
							TankkienTilavuus.progressBarTankki98.setValue(Integer.parseInt(TankkienTilavuus.lbltankki98Maara.getText()));
								// muista lisätä 2. metodi kirjoittamiseen , korjata metodi 1 kirjoitus
							textFieldTilattava98Maara.setText("");
							// korjaa myös muihin tämä
										tulostaTiedostoon("Bensiiniä 98 tilattu " + tilaus + "litraa");
										kirjoitaTiedostoon2(tmp_tilaus);
						}
						if( result == JOptionPane.NO_OPTION ) {
						textFieldTilattava98Maara.setText("");
						}
						
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Väärä syöte");
						textFieldTilattava98Maara.setText("");

//						String tmp_tilaus;
//						tmp_tilaus = "" + (Integer.parseInt(textFieldTilattava98Maara.getText()) + Integer.parseInt(lbltankki98Maara.getText()));
//						String tilaus;
//						tilaus = "" + Integer.parseInt(textFieldTilattava98Maara.getText());
//
//						
//						int result = JOptionPane.showConfirmDialog(null, "Tilataanko varmasti?","Varmistus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
//						if( result == JOptionPane.OK_OPTION ) {
////							TankkienTilavuus.lbltankki98Maara.setText((Integer.parseInt(TankkienTilavuus.lbltankki98Maara.getText())+Integer.parseInt(tmp_tilaus))+"");
//
//							lbltankki98Maara.setText(tmp_tilaus);
//							TankkienTilavuus.lbltankki95Maara.setText(tmp_tilaus);
//
//							TankkienTilavuus.progressBarTankki98.setValue(Integer.parseInt(TankkienTilavuus.lbltankki98Maara.getText()));
//										textFieldTilattava98Maara.setText("");
//						}
//							tulostaTiedostoon("Bensiiniä 98 tilattu " + tilaus + "litraa");
//							kirjoitaTiedostoon2(tmp_tilaus);
//
//						}
//						if( result == JOptionPane.NO_OPTION ) {
//						textFieldTilattava98Maara.setText("");
//						}
//						
//					} catch (NumberFormatException e1) {
//						JOptionPane.showMessageDialog(null, "Väärä syöte");
//						textFieldTilattava98Maara.setText("");
				}					
					
				}
			});
			btnTilaaPainike.setBounds(258, 165, 89, 23);
			contentPanel.add(btnTilaaPainike);
		}
		
		lbltankki98Maara = new JLabel("New label");
		lbltankki98Maara.setBounds(258, 36, 86, 24);
		contentPanel.add(lbltankki98Maara);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Sulje");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						TankkienTilavuus.lbltankki98Maara.setText(lbltankki98Maara.getText());
						Tilaus98Ikkuna.this.dispose();

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}

}
			public void tulostaTiedostoon(String txt) {
				String filename1 = "src/Resources/tilaukset.txt";

				try {
					java.util.Date date = new java.util.Date();
					FileWriter filewriter = new FileWriter(filename1, true);
					filewriter.write(date.toString() +  " = ");
					filewriter.write(txt + "\n");
					filewriter.close();
			}
				catch (Exception e) {
					e.printStackTrace();
	}}	

			public void kirjoitaTiedostoon2(String txt) {
				
				String filename3 = "src/Resources/bensaa98.txt";
				try {
					FileWriter fwriter = new FileWriter(filename3, false);
					fwriter.write(txt);
					fwriter.close();
				} catch (Exception e) {
					e.printStackTrace();
	}
}

}
