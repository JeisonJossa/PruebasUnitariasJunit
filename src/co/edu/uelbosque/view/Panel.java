package co.edu.uelbosque.view;

import java.awt.*;

import javax.swing.*;

public class Panel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel etiqueta_marca, etiqueta_modelo, etiqueta_placa, etiqueta_puertas, etiqueta_capacidad, etiqueta_tipo;
	private JTextField campo_marca, campo_modelo, campo_placa, campo_puertas, campo_capacidad, campo_tipo;
	private JButton boton_agregar, boton_eliminar, boton_buscar, boton_comprar, boton_vender;
	private ImageIcon imagen;
	private String nombre;
	
	public Panel(String nombre) {
		this.nombre = nombre;
		
		setLayout(null);
		setBackground(Color.white);
		setVisible(true);
		setBounds(0, 0, 600, 500);
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
		etiqueta_placa = new JLabel("PLACA:");
		etiqueta_placa.setBounds(70,185,50,50);
		etiqueta_placa.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(etiqueta_placa);
		
		campo_placa = new JTextField();
		campo_placa.setBounds(150,200,230,20);
		campo_placa.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(campo_placa);
		
		etiqueta_modelo = new JLabel("MODELO:");
		etiqueta_modelo.setBounds(70,215,60,50);
		etiqueta_modelo.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(etiqueta_modelo);
		
		campo_modelo = new JTextField();
		campo_modelo.setBounds(150,230,230,20);
		campo_modelo.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(campo_modelo);
		
		etiqueta_marca = new JLabel("MARCA:");
		etiqueta_marca.setBounds(70,245,50,50);
		etiqueta_marca.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(etiqueta_marca);
		
		campo_marca = new JTextField();
		campo_marca.setBounds(150,260,230,20);
		campo_marca.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(campo_marca);
		
		etiqueta_puertas = new JLabel("NUMERO DE PUERTAS:");
		etiqueta_puertas.setBounds(10,280,125,50);
		etiqueta_puertas.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		add(etiqueta_puertas);
		
		campo_puertas = new JTextField();
		campo_puertas.setBounds(150,295,230,20);
		campo_puertas.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(campo_puertas);
		
		etiqueta_capacidad = new JLabel("CAPACIDAD GALONES:");
		etiqueta_capacidad.setBounds(10,315,150,50);
		etiqueta_capacidad.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(etiqueta_capacidad);
		
		campo_capacidad = new JTextField();
		campo_capacidad.setBounds(150,330,230,20);
		campo_capacidad.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(campo_capacidad);
		
		etiqueta_tipo = new JLabel("TIPO:");
		etiqueta_tipo.setBounds(70,350,250,50);
		etiqueta_tipo.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(etiqueta_tipo);
		
		campo_tipo = new JTextField();
		campo_tipo.setBounds(150,365,230,20);
		campo_tipo.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(campo_tipo);
		
		boton_agregar = new JButton("AGREGAR");
		boton_agregar.setBounds(450,175,100,25);
		boton_agregar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(boton_agregar);
		
		boton_buscar = new JButton ("BUSCAR");
		boton_buscar.setBounds(450,220,100,25);
		boton_buscar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(boton_buscar);
		
		boton_comprar = new JButton("COMPARAR");
		boton_comprar.setBounds(450,265,100,25);
		boton_comprar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(boton_comprar);
		
		boton_eliminar = new JButton("ELIMINAR");
		boton_eliminar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		boton_eliminar.setBounds(450,315,100,25);
		add(boton_eliminar);
		
		boton_vender = new JButton("VENDER");
		boton_vender.setBounds(450,365,100,25);
		boton_vender.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		add(boton_vender);
		
	}
	
	public void limmpiarCampos() {
		 campo_capacidad.setText(null);
		 campo_marca.setText(null);
		 campo_modelo.setText(null);
		 campo_placa.setText(null);
		 campo_puertas.setText(null);
		 campo_tipo.setText(null);
	}

	public JTextField getCampo_marca() {
		return campo_marca;
	}

	public void setCampo_marca(JTextField campo_marca) {
		this.campo_marca = campo_marca;
	}

	public JTextField getCampo_modelo() {
		return campo_modelo;
	}

	public void setCampo_modelo(JTextField campo_modelo) {
		this.campo_modelo = campo_modelo;
	}

	public JTextField getCampo_placa() {
		return campo_placa;
	}

	public void setCampo_placa(JTextField campo_placa) {
		this.campo_placa = campo_placa;
	}

	public JTextField getCampo_puertas() {
		return campo_puertas;
	}

	public void setCampo_puertas(JTextField campo_puertas) {
		this.campo_puertas = campo_puertas;
	}

	public JTextField getCampo_capacidad() {
		return campo_capacidad;
	}

	public void setCampo_capacidad(JTextField campo_capacidad) {
		this.campo_capacidad = campo_capacidad;
	}

	public JTextField getCampo_tipo() {
		return campo_tipo;
	}

	public void setCampo_tipo(JTextField campo_tipo) {
		this.campo_tipo = campo_tipo;
	}

	public JButton getBoton_agregar() {
		return boton_agregar;
	}

	public void setBoton_agregar(JButton boton_agregar) {
		this.boton_agregar = boton_agregar;
	}

	public JButton getBoton_eliminar() {
		return boton_eliminar;
	}

	public void setBoton_eliminar(JButton boton_eliminar) {
		this.boton_eliminar = boton_eliminar;
	}

	public JButton getBoton_buscar() {
		return boton_buscar;
	}

	public void setBoton_buscar(JButton boton_buscar) {
		this.boton_buscar = boton_buscar;
	}

	public JButton getBoton_comparar() {
		return boton_comprar;
	}

	public void setBoton_comparar(JButton boton_comparar) {
		this.boton_comprar = boton_comparar;
	}
	public JButton getBoton_vender() {
		return boton_vender;
	}
	public void setBoton_vender(JButton boton_vender) {
		this.boton_vender = boton_vender;
	}
	

	
}
