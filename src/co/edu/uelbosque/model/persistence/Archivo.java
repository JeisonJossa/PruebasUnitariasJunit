package co.edu.uelbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;

import co.edu.uelbosque.model.Vehiculo;

public class Archivo {
	
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo = new File("./datos/basedatos.dat");
	
	public Archivo(File archivo) {
		
	if (archivo.exists()) {
		//System.out.println("El archivo ya existe");
	}else {
		try {
			
			archivo.createNewFile();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	}
	
	public void escribirEnArchivo(ArrayList<Vehiculo> vehiculo) {
		try {
			
			salida= new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(vehiculo);
			salida.close();
			
		}catch ( FileNotFoundException e) {
			e.printStackTrace();
		}catch ( IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Vehiculo> leerArchivo(File archivo){
		
		ArrayList<Vehiculo> vehiculo = new ArrayList<Vehiculo>();
		if(archivo.length()!=0) {
			
			try {
				
				entrada = new ObjectInputStream(new FileInputStream(archivo));
				vehiculo = (ArrayList<Vehiculo>) entrada.readObject();
				
			}catch(FileNotFoundException e) {
				System.out.println("ERROR LEER ARCHIVO 1");
			}catch (IOException e) {
				System.out.println("ERROR LEER ARCHIVO 2");
			}catch (ClassNotFoundException e) {
				System.out.println("ERROR LEER ARCHIVO 3 ");
			}
			
		}
		return vehiculo;
		
	}

	public File getArchivo() {
		return archivo;
	}

	public ObjectInputStream getEntrada() {
		return entrada;
	}

	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}

	public ObjectOutputStream getSalida() {
		return salida;
	}

	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	
}
