import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Window.Type;

public class AcercaDe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaDe frame = new AcercaDe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public void showAcercaDe() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaDe frame = new AcercaDe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AcercaDe() {
		setResizable(false);
		setTitle("Acerca de");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 308);
	//	setMaximizedBounds(getMaximizedBounds());
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombreprograma = new JLabel("Nombre del Programa");
		lblNombreprograma.setForeground(Color.GREEN);
		lblNombreprograma.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JTextArea txtrD = new JTextArea();
		txtrD.setEditable(false);
		txtrD.setForeground(Color.GREEN);
		txtrD.setBackground(Color.BLACK);
		txtrD.setWrapStyleWord(true);
		txtrD.setLineWrap(true);
		txtrD.setText("Este es un programa de prueba, hecho en java usando WindowBuilder.");
		
		JLabel lblAcercaDe = new JLabel("Acerca de");
		lblAcercaDe.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAcercaDe.setForeground(Color.GREEN);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(txtrD, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(94)
							.addComponent(lblNombreprograma))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(152)
							.addComponent(lblAcercaDe)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(lblAcercaDe)
					.addGap(18)
					.addComponent(lblNombreprograma)
					.addGap(34)
					.addComponent(txtrD, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
