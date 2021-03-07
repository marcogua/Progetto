package GUI;

import Controllore.Controllore;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErroreGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Controllore controll;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			ErroreGUI dialog = new ErroreGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

	/**
	 * Create the dialog.
	 */
	public ErroreGUI(Controllore ctrl) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		controll = ctrl;
		setBounds(380, 190, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel labelAttenzione = new JLabel("Attenzione: Per modificare occorre selezionare il cliente");
			labelAttenzione.setHorizontalAlignment(SwingConstants.CENTER);
			labelAttenzione.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanel.add(labelAttenzione);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setBackground(new Color(204, 204, 204));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
