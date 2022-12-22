package co.edu.uelbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String marca, placa,  tipo, modelo_anio, estado;
	private int num_puertas,capacidad;
	
	protected ArrayList<Vehiculo> vehiculo = new ArrayList<Vehiculo>();

	public Vehiculo(String marca, String placa, int num_puertas, int capacidad, String tipo, String modelo_anio, String estado) {
		
		this.marca = marca;
		this.placa = placa;
		this.num_puertas = num_puertas;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.modelo_anio = modelo_anio;
		this.estado= estado;
		
	}
	
	@SuppressWarnings("unused")
	private void verificarInvariante() {
		assert marca != null: "La marca no puede ser null";
		assert placa != null: "La placa no puede ser null";
		assert num_puertas != 0: "El número de puertas no puede ser cero";
		assert capacidad != 0: "La capacidad no puede ser 0";
		assert tipo != null: "El tipo no puede ser null";
		assert modelo_anio != null: "El modelo no puede ser null";
	}
	
	@Override
	public String toString() {
		return "Vehiculo Marca=" + getMarca() +
				" Placa="  + getPlaca() +
				" Numero de puertas=" + getNum_puertas() 
				+ " Capacidad=" + getCapacidad()  + 
				" Tipo=" + getTipo()+ 
				" Modelo/año="  + getModelo_anio() + 
				" Estado" + getEstado();
	}


	public String getEstado() {
		return estado;
	}

	public String setEstado(String estado) {
		return this.estado = estado;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getNum_puertas() {
		return num_puertas;
	}

	public void setNum_puertas(int num_puertas) {
		this.num_puertas = num_puertas;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo_anio() {
		return modelo_anio;
	}

	public void setModelo_anio(String modelo_anio) {
		this.modelo_anio = modelo_anio;
	}

	public ArrayList<Vehiculo> getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(ArrayList<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}
	

	

}
