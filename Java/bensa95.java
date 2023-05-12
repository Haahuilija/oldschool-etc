import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;

import javax.swing.JTextField;

public class Tilaus95Ikkuna extends JDialog {

	
	private final JPanel contentPanel = new JPanel();
	public JLabel lbltankki95Maara;
	private JTextField textFieldTilattava95Maara;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	
	public Tilaus95Ikkuna() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				TankkienTilavuus.lbltankki95Maara.setText(lbltankki95Maara.getText());
			}
		});
		setTitle("95 OKTAANISEN TILAUS");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("95 OKTAANINEN TANKKI/l");
			lblNewLabel.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
			lblNewLabel.setBounds(23, 23, 217, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnTilaaPainike = new JButton("Tilaa");
			btnTilaaPainike.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						
						// lisää muuttujat
						String tmp_tilaus;
						tmp_tilaus = "" + (Integer.parseInt(textFieldTilattava95Maara.getText()) + Integer.parseInt(lbltankki95Maara.getText()));
						String tilaus;
						tilaus = "" + Integer.parseInt(textFieldTilattava95Maara.getText());
						
						int result = JOptionPane.showConfirmDialog(null, "Tilataanko varmasti?","Varmistus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if( result == JOptionPane.OK_OPTION ) {
							lbltankki95Maara.setText(tmp_tilaus);
							
							// turha, korjattu alla
					//		TankkienTilavuus.lbltankki95Maara.setText((Integer.parseInt(TankkienTilavuus.lbltankki95Maara.getText())+Integer.parseInt(tmp_tilaus))+"");
							TankkienTilavuus.lbltankki95Maara.setText(tmp_tilaus);
							TankkienTilavuus.progressBarTankki95.setValue(Integer.parseInt(TankkienTilavuus.lbltankki95Maara.getText()));
								// muista lisätä 2. metodi kirjoittamiseen , korjata metodi 1 kirjoitus
							textFieldTilattava95Maara.setText("");
							// korjaa myös muihin tämä
										tulostaTiedostoon("Bensiiniä 95 tilattu " + tilaus + " litraa");
										kirjoitaTiedostoon2(tmp_tilaus);
						}
						if( result == JOptionPane.NO_OPTION ) {
						textFieldTilattava95Maara.setText("");
						}
						
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Väärä syöte");
						textFieldTilattava95Maara.setText("");
						
					
				}
				}});
			
			btnTilaaPainike.setBounds(279, 160, 89, 23);
			contentPanel.add(btnTilaaPainike);
		}
		{
			JLabel lblTilattavaMaara95_noedit = new JLabel("TILATTAVA M\u00C4\u00C4R\u00C4");
			lblTilattavaMaara95_noedit.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 14));
			lblTilattavaMaara95_noedit.setBounds(23, 100, 217, 20);
			contentPanel.add(lblTilattavaMaara95_noedit);
		}
		
		lbltankki95Maara = new JLabel("New label");
		lbltankki95Maara.setBounds(274, 23, 89, 23);
		contentPanel.add(lbltankki95Maara);
		
		textFieldTilattava95Maara = new JTextField();
		textFieldTilattava95Maara.setBounds(279, 101, 86, 20);
		contentPanel.add(textFieldTilattava95Maara);
		textFieldTilattava95Maara.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton suljeButton = new JButton("Sulje");
				suljeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						// lisää sulje buttonille muille
						TankkienTilavuus.lbltankki95Maara.setText(lbltankki95Maara.getText());
						Tilaus95Ikkuna.this.dispose();

					}
				});
				suljeButton.setActionCommand("Sulje");
				buttonPane.add(suljeButton);
				getRootPane().setDefaultButton(suljeButton);
			}
		}}	
	
	public void tulostaTiedostoon(String txt) {
		String filename = "src/Resources/tilaukset.txt";

		try {
			java.util.Date date = new java.util.Date();
			FileWriter filewriter = new FileWriter(filename, true);
			filewriter.write(date.toString() + " = ");
			filewriter.write(txt + "\n");
			filewriter.close();
}

		catch (Exception e) {
			e.printStackTrace();			
}}
	
		// lisää muihin
	public void kirjoitaTiedostoon2(String txt) {
		
		String filename3 = "src/Resources/bensaa95.txt";
		try {
			FileWriter fwriter = new FileWriter(filename3, false);
			fwriter.write(txt);
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
