package co.edu.uelbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import co.edu.uelbosque.model.Vehiculo;

public class VehiculoDAO {

	private Archivo archivo;

	public VehiculoDAO(Archivo archivo) {
		this.archivo = archivo;
	}

	public String mostrarInformacion(Vehiculo aux, ArrayList<Vehiculo> vehiculos) {
		String marca,placa,tipo,modelo_anio,estado,mostrar="";
		int num_puertas,capacidad;
		if(aux!=null ) {
		//MUESTRA LOS VEHICULOS
		 marca = aux.getMarca();
		 placa = aux.getPlaca();
		 num_puertas = aux.getNum_puertas();
		 capacidad = aux.getCapacidad();
		 tipo = aux.getTipo();
		 modelo_anio = aux.getModelo_anio();
		 estado = aux.getEstado();
		 

		 mostrar= "PLACA:  " + placa + "\n" + "MARCA:  " + marca + "\n" + "NUMERO DE PUERTAS:  " + num_puertas
				+ "\n" + "CAPACIDAD:  " + capacidad + "\n" + "TIPO:  " + tipo + "\n" + "MODELO :  "
				+ modelo_anio + "\n"+ estado +"\n" ;
		}
		
		return mostrar;
	}

	public Vehiculo buscarVehiculo(String placa, ArrayList<Vehiculo> vehiculos) {
		Vehiculo encontrado = null;
		if (!vehiculos.isEmpty()) {
			for (int i = 0; i < vehiculos.size(); i++) {
				if (vehiculos.get(i).getPlaca().equalsIgnoreCase(placa)) {
					encontrado = vehiculos.get(i);
				}
			}
		}
		return encontrado;
	}


	public boolean agregarVehiculo(String marca, String placa, int puertas,
									int capacidad, String tipo, String modelo,
									String estado,ArrayList<Vehiculo> vehiculos, File file) {
		Vehiculo nuevo = new Vehiculo(marca, placa, puertas, capacidad, tipo, modelo,estado);
		if (buscarVehiculo(placa, vehiculos) == null) {
			vehiculos.add(nuevo);
			archivo.escribirEnArchivo(vehiculos);
			return true;
		} else {
			return false;
		}

	}

	public boolean eliminarVehiculo(String placa, ArrayList<Vehiculo> vehiculos, File file) {
		boolean resp = false;
		try {

			Vehiculo e = buscarVehiculo(placa, vehiculos);
			if (e != null) {
				vehiculos.remove(e);
				archivo.getArchivo().delete();
				archivo.getArchivo().createNewFile();
				archivo.escribirEnArchivo(vehiculos);
				resp = true;
			}

			return resp;
		} catch (IOException e1) {

			e1.printStackTrace();

		}
		return resp;
	}

}
