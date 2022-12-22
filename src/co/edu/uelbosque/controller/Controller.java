package co.edu.uelbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.uelbosque.model.Vehiculo;
import co.edu.uelbosque.model.persistence.Archivo;
import co.edu.uelbosque.view.Ventana;
import co.edu.uelbosque.model.persistence.*;

public class Controller implements ActionListener {

	private ArrayList<Vehiculo> vehiculos;
	private Archivo archivo;
	private VehiculoDAO vehiculoDAO;
	public Ventana ventana;
	private File file = new File("./datos/basedatos.dat");

	public Controller() {


			ventana = new Ventana();
			vehiculos = new ArrayList<Vehiculo>();
			actionListener(this);
			archivo = new Archivo(file);
			vehiculoDAO = new VehiculoDAO(archivo);
			vehiculos = archivo.leerArchivo(file);
		


	}

	private void actionListener(ActionListener controlador) {
		ventana.getPanel().getBoton_agregar().addActionListener(controlador);
		ventana.getPanel().getBoton_buscar().addActionListener(controlador);
		ventana.getPanel().getBoton_comparar().addActionListener(controlador);
		ventana.getPanel().getBoton_eliminar().addActionListener(controlador);
		ventana.getPanel().getBoton_vender().addActionListener(controlador);
		ventana.getPanel_comparar().getBoton_volver().addActionListener(controlador);
	
	}

	public int compararMarca(Vehiculo v1, Vehiculo v2) {
	
		if (v1.getMarca().equals(v2.getMarca()))  {
			return 1;
		}else {
			return -1;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ACCION AGREGAR VEHICULO
		if (ventana.getPanel().getBoton_agregar() == e.getSource()) {
			String marca, placa, tipo, modelo_anio,estado;
			int num_puertas, capacidad;
			marca = ventana.getPanel().getCampo_marca().getText();
			placa = ventana.getPanel().getCampo_placa().getText();
			tipo = ventana.getPanel().getCampo_tipo().getText();
			modelo_anio = ventana.getPanel().getCampo_modelo().getText();
			estado = "Normal";

			Vehiculo aux = vehiculoDAO.buscarVehiculo(placa, vehiculos);
			if (marca.isEmpty() || placa.isEmpty() || ventana.getPanel().getCampo_capacidad().getText().isEmpty()
					|| tipo.isEmpty() || modelo_anio.isEmpty()
					|| ventana.getPanel().getCampo_puertas().getText().isEmpty()) {
				ventana.mostrarMensajes1("CREAR_FALSEB");
			} else if (!ventana.getPanel().getCampo_puertas().getText().matches("[0-9]*")) {
				ventana.mostrarMensajes1("NUMPUERTAS_FALSE");
			} else if (!ventana.getPanel().getCampo_capacidad().getText().matches("[0-9]*")) {
				ventana.mostrarMensajes1("CAPACIDAD_FALSE");
			} else if (aux == null) {
				num_puertas = Integer.parseInt(ventana.getPanel().getCampo_puertas().getText());
				capacidad = Integer.parseInt(ventana.getPanel().getCampo_capacidad().getText());
				vehiculoDAO.agregarVehiculo(marca, placa, num_puertas, capacidad, tipo, modelo_anio, estado, vehiculos, file);
				ventana.mostrarMensajes1("CREAR_TRUE");

			} else {
				ventana.mostrarMensajes1("CREAR_FALSE");

			}
			ventana.getPanel().limmpiarCampos();
		}

		// ACCION ELIMINAR VEHICULO
		if (ventana.getPanel().getBoton_eliminar() == e.getSource()) {
			String placa = JOptionPane.showInputDialog("DIGITE LA PLACA DEL VEHICULO QUE DESEA ELIMINAR.");
			boolean existe = false;
			for (int i = 0; i < vehiculos.size(); i++) {
				if (vehiculos.get(i).getPlaca().equalsIgnoreCase(placa)) {
					existe = true;
				}
			}
			if (existe == true) {
				vehiculoDAO.eliminarVehiculo(placa, vehiculos, file);
				ventana.mostrarMensajes1("ELIMINAR_TRUE");
			} else {
				ventana.mostrarMensajes1("ELIMINAR_FALSE");
			}
			ventana.getPanel().limmpiarCampos();
		}
		
		
		if( ventana.getPanel().getBoton_vender()== e.getSource()) {
		
//				String VENDER_TRUE, marca, placa, tipo, modelo_anio, estado;
//				int num_puertas, capacidad;
//				placa = JOptionPane.showInputDialog("DIGITE LA PLACA DEL VEHICULO QUE DESEA VENDER.");
//				Vehiculo aux = vehiculoDAO.buscarVehiculo(placa, vehiculos);
//				if (aux == null) {
//
//					ventana.mostrarMensajes1("VENDER_FALSE");
//
//				} else {
//					marca = aux.getMarca();
//					placa = aux.getPlaca();
//					num_puertas = aux.getNum_puertas();
//					capacidad = aux.getCapacidad();
//					tipo = aux.getTipo();
//					modelo_anio = aux.getModelo_anio();
//					estado = aux.setEstado("Vendido");
//
//					VENDER_TRUE = "PLACA:  " + placa + "\n" + "MARCA:  " + marca + "\n" + "NUMERO DE PUERTAS:  " + num_puertas
//							+ "\n" + "CAPACIDAD:  " + capacidad + "\n" + "TIPO:  " + tipo + "\n" + "MODELO :  "
//							+ modelo_anio + "\n" + "ESTADO: " + estado +"\n";
//					ventana.mostrarMensajes1(VENDER_TRUE);
//				}
//
//			}
			String VENDER_TRUE, marca, placa, tipo, modelo_anio, estado;
			int num_puertas, capacidad;
			placa = JOptionPane.showInputDialog("DIGITE LA PLACA DEL VEHICULO QUE DESEA VENDER.");
			Vehiculo aux = vehiculoDAO.buscarVehiculo(placa, vehiculos);
			if (aux == null) {

				ventana.mostrarMensajes1("VENDER_FALSE");

			} else {
				marca = aux.getMarca();
				placa = aux.getPlaca();
				num_puertas = aux.getNum_puertas();
				capacidad = aux.getCapacidad();
				tipo = aux.getTipo();
				modelo_anio = aux.getModelo_anio();
				estado = aux.setEstado("Vendido");

				VENDER_TRUE = "PLACA:  " + placa + "\n" + "MARCA:  " + marca + "\n" + "NUMERO DE PUERTAS:  " + num_puertas
						+ "\n" + "CAPACIDAD:  " + capacidad + "\n" + "TIPO:  " + tipo + "\n" + "MODELO :  "
						+ modelo_anio + "\n" + "ESTADO: " + estado +"\n";
				ventana.mostrarMensajes1(VENDER_TRUE);
			}

		}

		
		// ACCION BUSCAR VEHICULO
		if (ventana.getPanel().getBoton_buscar() == e.getSource()) {
			String VER_TRUE, marca, placa, tipo, modelo_anio, estado;
			int num_puertas, capacidad;
			placa = JOptionPane.showInputDialog("DIGITE LA PLACA DEL VEHICULO QUE DESEA VER.");
			Vehiculo aux = vehiculoDAO.buscarVehiculo(placa, vehiculos);
			if (aux == null) {

				ventana.mostrarMensajes1("VER_FALSE");

			} else {
				marca = aux.getMarca();
				placa = aux.getPlaca();
				num_puertas = aux.getNum_puertas();
				capacidad = aux.getCapacidad();
				tipo = aux.getTipo();
				modelo_anio = aux.getModelo_anio();
				estado = aux.getEstado();

				VER_TRUE = "PLACA:  " + placa + "\n" + "MARCA:  " + marca + "\n" + "NUMERO DE PUERTAS:  " + num_puertas
						+ "\n" + "CAPACIDAD:  " + capacidad + "\n" + "TIPO:  " + tipo + "\n" + "MODELO :  "
						+ modelo_anio + "\n" + "ESTADO: " + estado +"\n";
				ventana.mostrarMensajes1(VER_TRUE);
			}

		}

		// ACCION IGRESAR AL PANEL MODIFICAR
		if (ventana.getPanel().getBoton_comparar() == e.getSource()) {
			ventana.getPanel().setVisible(false);
			ventana.getPanel_comparar().setVisible(true);
			ventana.getPanel_comparar().getCombo_primera_eleccion().setVisible(true);
			ventana.getPanel_comparar().limpiarCampos();

		}
		// ACCION VOLVER AL PANEL PRINCIPAL
		if (ventana.getPanel_comparar().getBoton_volver() == e.getSource()) {
			ventana.getPanel().setVisible(true);
			ventana.getPanel_comparar().setVisible(false);
		}
		

		// ACCION COMPARAR VEHICULO
		if (ventana.getPanel_comparar().getBoton_comparar() == e.getSource()) {
			String placa1 = "", placa2 = "", opcion = "";

			placa1 = ventana.getPanel_comparar().getCampo_uno().getText();
			placa2 = ventana.getPanel_comparar().getCampo_dos().getText();
			Vehiculo aux1 = null, aux2 = null;
			aux1 = vehiculoDAO.buscarVehiculo(placa1, vehiculos);
			aux2 = vehiculoDAO.buscarVehiculo(placa2, vehiculos);
			if (placa1.isEmpty() || placa2.isEmpty()) {
				ventana.mostrarMensajes1("PLACA_FALSE");
			} else if (aux1 != null && aux2 != null) {

				opcion = ventana.getPanel_comparar().getCombo_primera_eleccion().getSelectedItem().toString();
				int num;
				switch (opcion) {

				case "TODO":
					opcion = vehiculoDAO.mostrarInformacion(aux1, vehiculos);
					ventana.getPanel_comparar().getArea_uno().setText(opcion);
					opcion = vehiculoDAO.mostrarInformacion(aux2, vehiculos);
					ventana.getPanel_comparar().getArea_dos().setText(opcion);
					break;

				case "MODELO":
					opcion = aux1.getModelo_anio();
					ventana.getPanel_comparar().getArea_uno().setText("Modelo :  "+opcion);
					opcion = aux2.getModelo_anio();
					ventana.getPanel_comparar().getArea_dos().setText("Modelo :  "+opcion);
					break;
				case "MARCA":
					opcion = aux1.getMarca();
					ventana.getPanel_comparar().getArea_uno().setText("Marca :  "+opcion);
					opcion = aux2.getMarca();
					ventana.getPanel_comparar().getArea_dos().setText("Marca :  "+opcion);
					break;	
				case "CAPACIDAD TANQUE":
					num = aux1.getCapacidad();
					ventana.getPanel_comparar().getArea_uno().setText("Capacidad :  "+num);
					num = aux2.getCapacidad();
					ventana.getPanel_comparar().getArea_dos().setText("Capacidad :  "+num);
					break;	
				case "NUMERO DE PUERTAS":
					num = aux1.getNum_puertas();
					ventana.getPanel_comparar().getArea_uno().setText("Puertas :  "+num);
					num = aux2.getNum_puertas();
					ventana.getPanel_comparar().getArea_dos().setText("Puertas :  "+num);
					break;
					

				}

			} else {
				ventana.mostrarMensajes1("COMPARAR_FALSE");
				ventana.getPanel_comparar().limpiarCampos();
			}

		}
		
	

	}

}