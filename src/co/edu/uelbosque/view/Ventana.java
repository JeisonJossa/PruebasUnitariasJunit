package co.edu.uelbosque.view;

import javax.swing.*;


public class Ventana extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel panel = new Panel("/co/edu/uelbosque/imagenes/fondo.png");
	private PanelComparar panel_comparar = new PanelComparar("/co/edu/uelbosque/imagenes/fondo2.png");
		
		public Ventana() {
			
		setTitle (" CONCESIONARIO DE AUTOMOVILES");
		setLayout(null);
		setVisible(true);
		setSize(600,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
	
		add(panel);
		add(panel_comparar);
	}
	
	public void mostrarMensajes1(String mensaje) {
		if(mensaje.equalsIgnoreCase("VENDER_TRUE"))
		{
			JOptionPane.showMessageDialog(null, "SE VENDIÓ EL VEHICULO CORRECTAMENTE");
		}else if(mensaje.equalsIgnoreCase("VENDER_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "NO SE PUEDE VENDER EL VEHICULO CORRECTAMENTE YA QUE NO EXISTE");
		}else if(mensaje.equalsIgnoreCase("CREAR_TRUE"))
		{
			JOptionPane.showMessageDialog(null, "SE AGREGÓ EL VEHICULO CORRECTAMENTE");
		}
		else if(mensaje.equalsIgnoreCase("CREAR_FALSEB"))
		{
			JOptionPane.showMessageDialog(null, "DIGITE TODOS LOS CAMPOS");
		}
		else if(mensaje.equalsIgnoreCase("CREAR_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "NO SE LOGRO AGREGAR EL VEHICULO YA QUE LA PLACA YA EXISTE");
		}
		else if(mensaje.equalsIgnoreCase("ELIMINAR_TRUE"))
		{
			JOptionPane.showMessageDialog(null, "SE ELIMINO EL VEHICULO CORRECTAMENTE");
		}
		else if(mensaje.equalsIgnoreCase("ELIMINAR_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "NO SE LOGRO ELIMINAR EL VEHICULO YA QUE NO EXISTE");
		}
		else if(mensaje.equalsIgnoreCase("VER_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "NO SE LOGRO MOSTRAR EL VEHICULO YA QUE NO EXISTE");
		}else if(mensaje.equalsIgnoreCase("COMPARAR_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "EL VEHICULO NO EXISTE");
		}
		else if(mensaje.equalsIgnoreCase("NUMPUERTAS_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "NUMERO DE PUERTAS CONTENER SOLO NUMEROS");
		}else if(mensaje.equalsIgnoreCase("CAPACIDAD_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "CAPACIDAD DEBE CONTENER SOLO NUMEROS");
		}
		else if(mensaje.equalsIgnoreCase("PLACA_FALSE"))
		{
			JOptionPane.showMessageDialog(null, "DEBE DIGITAR AMBAS PLACAS");
		}
		else {
			JOptionPane.showMessageDialog(null, mensaje);
		}
		
	}
	
	

	public PanelComparar getPanel_comparar() {
		return panel_comparar;
	}

	public void setPanel_comparar(PanelComparar panel_comparar) {
		this.panel_comparar = panel_comparar;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}
	
	
}
