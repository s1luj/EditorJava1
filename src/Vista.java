/*
Funciones ok:
	Abrir (boton): hay un bug, al abrir el dialogo del filechoosser, si se selecciona un archivo y luego se pulsa cancelar el archivo se abre igualmente XD
	Guardar(boton, guarda como en realidad)
	guardar como
	cerrar(pone el area de texto a "") <= Super cutre
	salir del programa (hace un system.exit(0)) <= habria que mostrar un dialogo de guardar cambios antes, por si las moscas
	acerca de <= hecho en plan chapucero
	copiar, cortar y pegar 
*/
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultEditorKit;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.SystemColor;
import java.awt.TextArea;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Vista extends JFrame {
	/**
	 * 
	 */
	
	static JTextArea textArea;
	
	private static final long serialVersionUID = 1L;

	Modelo modelo = new Modelo();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					JScrollPane scroll = new JScrollPane(textArea);
					frame.getContentPane().add(scroll);
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
	public Vista() {
		setTitle("CompiladorBareMetalRaspberry");
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 418);
		
		textArea = new JTextArea(25,80);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
/*		textArea.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
			}
		});*/
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
/*		textArea.setAutoscrolls(false);*/
/*		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
*/		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);

////////// Guardar como....///////////////////////////
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mnArchivo.add(mntmGuardarComo);
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					modelo.GuardarArchivo(textArea.getText());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
///////////////////////////////////////////////////

/////// Cerrar documento /////////////
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnArchivo.add(mntmCerrar);
		mntmCerrar.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");				
			}
		});
///////////////////////////////////////////////////
		
///////Salir del programa///////////////		
		JMenuItem mntmSalirDelPrograma = new JMenuItem("Salir del programa");
		mnArchivo.add(mntmSalirDelPrograma);
		mntmSalirDelPrograma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
//////////////////////////////////////////////

////acciones copiar,cortar y pegar////
		ActionMap acciones = textArea.getActionMap();
		Action accionCopiar = acciones.get(DefaultEditorKit.copyAction);
		Action accionPegar = acciones.get(DefaultEditorKit.pasteAction);
		Action accionCortar = acciones.get(DefaultEditorKit.cutAction);
//		Action accionDeshacer = acciones.get(DefaultEditorKit.)
		
		accionCopiar.putValue(Action.NAME, "Copiar");
		accionCopiar.putValue(
		   Action.ACCELERATOR_KEY,
		   KeyStroke.getAWTKeyStroke('C', Event.CTRL_MASK));
		
		accionCortar.putValue(Action.NAME, "Cortar");
		accionCortar.putValue(
		   Action.ACCELERATOR_KEY,
		   KeyStroke.getAWTKeyStroke('X', Event.CTRL_MASK));
		
		accionPegar.putValue(Action.NAME, "Pegar");
		accionPegar.putValue(
		   Action.ACCELERATOR_KEY,
		   KeyStroke.getAWTKeyStroke('V', Event.CTRL_MASK)); 
		
///////////////////////////////////////////////
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mntmCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnEditar.add(mntmCopiar);
		mntmCopiar.addActionListener(accionCopiar);;
		
		JMenuItem mntmCortar = new JMenuItem("Cortar");
		mntmCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnEditar.add(mntmCortar);
		mntmCortar.addActionListener(accionCortar);
		
		JMenuItem mntmPegar = new JMenuItem("Pegar");
		mntmPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnEditar.add(mntmPegar);
		mntmPegar.addActionListener(accionPegar);
		
		JMenuItem mntmDeshacer = new JMenuItem("Deshacer");
		mnEditar.add(mntmDeshacer);
		
		JMenuItem mntmRehacer = new JMenuItem("Rehacer");
		mnEditar.add(mntmRehacer);
		
		JMenu mnConstruir = new JMenu("Construir");
		menuBar.add(mnConstruir);
		
		JMenuItem mntmCompilar = new JMenuItem("Compilar");
		mnConstruir.add(mntmCompilar);
		mntmCompilar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					modelo.Compilar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem mntmCompilarYEnviar = new JMenuItem("Compilar y Enviar");
		mnConstruir.add(mntmCompilarYEnviar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mnAyuda.add(mntmManual);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);
		mntmAcercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercade = new AcercaDe();
				acercade.showAcercaDe();
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

//////// textArea (aquí estaba)		
		
		
		JButton btnCompilarYEnviar = new JButton("Compilar y Enviar");
		btnCompilarYEnviar.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCompilarYEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnCompilar = new JButton("Compilar");
		btnCompilar.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCompilar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					modelo.Compilar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					modelo.GuardarArchivo(textArea.getText());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 10));

// Abrir documento
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(modelo.AbrirArchivo());
				System.out.println(modelo.getRuta());
				System.out.println(modelo.getNombreArchivo());
				System.out.println(modelo.getDirectorio());
			}
		});
		
//		JScrollPane scroll = new JScrollPane(textArea);
		
		
		btnAbrir.setFont(new Font("Dialog", Font.BOLD, 10));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAbrir)
							.addGap(5)
							.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCompilar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCompilarYEnviar, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(178, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 562, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(21, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbrir)
						.addComponent(btnGuardar)
						.addComponent(btnCompilar)
						.addComponent(btnCompilarYEnviar))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
