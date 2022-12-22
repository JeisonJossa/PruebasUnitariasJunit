
package co.edu.uelbosque.view;

import java.awt.*;
import javax.swing.*;


public class PanelComparar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> combo_primera_eleccion; 
							
	private JButton boton_comparar, boton_volver;
	private JTextArea area_uno, area_dos;
	private JTextField campo_uno, campo_dos;
	private JLabel placa1, placa2;
	private ImageIcon imagen;
	private String nombre;

	
	public PanelComparar(String nombre) {
		this.nombre = nombre;
		
		setLayout(null);
		setBackground(Color.white);
		setVisible(false);
		setBounds(0, 0, 600, 480);
		inicializarComponentes();
		
	}
	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(),0,0, tamano.width , tamano.height , null);
		setOpaque(false);
		super.paint(g);
		
	}
	public void inicializarComponentes() {
		  
		combo_primera_eleccion = new JComboBox<String>();
		combo_primera_eleccion.addItem("Seleccione");
		combo_primera_eleccion.addItem("TODO");
		combo_primera_eleccion.addItem("MODELO");
		combo_primera_eleccion.addItem("MARCA");
		combo_primera_eleccion.addItem("CAPACIDAD TANQUE");
		combo_primera_eleccion.addItem("NUMERO DE PUERTAS");
		combo_primera_eleccion.setBounds(220,75,150,20);
		combo_primera_eleccion.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		combo_primera_eleccion.setVisible(false);
		add(combo_primera_eleccion);
		
		campo_uno = new JTextField();
		campo_uno.setBounds(55,128,150,20);
		campo_uno.setVisible(true);
		add(campo_uno);
		
		campo_dos = new JTextField();
		campo_dos.setBounds(380,128,150,20);
		campo_dos.setVisible(true);
		add(campo_dos);
		
		placa1 = new JLabel("PLACA 1");
		placa1.setBounds(100,107,150,20);
		placa1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(placa1);
		placa2 = new JLabel("PLACA 2");
		placa2.setBounds(430,107,150,20);
		placa2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(placa2);
		
		area_uno = new JTextArea();
		area_uno.setBounds(35,160,200,220);
		area_uno.setEditable(false);
		add(area_uno);
		
		area_dos = new JTextArea();
		area_dos.setEditable(false);
		area_dos.setBounds(350,160,200,220);
		add(area_dos);
		
		boton_comparar = new JButton("Comparar");
		boton_comparar.setBounds(180,430,100,20);
		boton_comparar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(boton_comparar);
		
		boton_volver = new JButton("Volver");
		boton_volver.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		boton_volver.setBounds(320,430,100,20);
		add(boton_volver);
		
	}
	
	public void limpiarCampos() {
		area_uno.setText(null);
		area_dos.setText(null);
		campo_uno.setText(null);
		campo_dos.setText(null);
	}
	
	
	public JComboBox<String> getCombo_primera_eleccion() {
		return combo_primera_eleccion;
	}
	public void setCombo_primera_eleccion(JComboBox<String> combo_primera_eleccion) {
		this.combo_primera_eleccion = combo_primera_eleccion;
	}
	
	public JButton getBoton_comparar() {
		return boton_comparar;
	}
	public void setBoton_comparar(JButton boton_comparar) {
		this.boton_comparar = boton_comparar;
	}
	public JButton getBoton_volver() {
		return boton_volver;
	}
	public void setBoton_volver(JButton boton_volver) {
		this.boton_volver = boton_volver;
	}
	public JTextArea getArea_uno() {
		return area_uno;
	}
	public void setArea_uno(JTextArea area_uno) {
		this.area_uno = area_uno;
	}
	public JTextArea getArea_dos() {
		return area_dos;
	}
	public void setArea_dos(JTextArea area_dos) {
		this.area_dos = area_dos;
	}
	public JTextField getCampo_uno() {
		return campo_uno;
	}
	public void setCampo_uno(JTextField campo_uno) {
		this.campo_uno = campo_uno;
	}
	public JTextField getCampo_dos() {
		return campo_dos;
	}
	public void setCampo_dos(JTextField campo_dos) {
		this.campo_dos = campo_dos;
	}
	
	
	
		
	}

