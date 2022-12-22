package co.edu.uelbosque.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.uelbosque.model.Vehiculo;
import co.edu.uelbosque.model.persistence.Archivo;
import co.edu.uelbosque.model.persistence.VehiculoDAO;
import junit.framework.TestCase;

public class VehiculoDAOTest extends TestCase{


	VehiculoDAO vehiculo;
	Archivo archivo;
	File file = new File("dataTest/basedatosTest.dat");
	ArrayList<Vehiculo> lista;
	Vehiculo vehiculo_1;
	Vehiculo vehiculo_2;
	Vehiculo vehiculo_3;
	Vehiculo vehiculo_4;


	private void setupEscenario() {
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		archivo = new Archivo(file);	
		lista=archivo.leerArchivo(file);
		vehiculo =  new VehiculoDAO(archivo);
		
		vehiculo_1 = new Vehiculo("MAZDA1", "ddx631", 1, 1, "pull", "2015", "Normal");
		vehiculo_2 = new Vehiculo("MAZDA2", "ddx632", 2, 2, "pell2", "2016","Vendido");
		vehiculo_3 = new Vehiculo("MAZDA3", "ddx633", 3, 3, "pull3", "2017", "Vendido");
		vehiculo_4 = new Vehiculo("MAZDA4", "ddx632", 4, 4, "pull4", "2018","Vendido");
		
		
		
		
		lista.add(vehiculo_1);
		lista.add(vehiculo_2);
		
	}
		public void testVehiculoDAO() {
			setupEscenario();
			assertEquals("La cant debe ser 2", 2, lista.size());
		
		
	}
		
		public void testAgregarVehiculo() {
			setupEscenario();
			
			assertTrue("Se debió agregar el vehiculo", vehiculo.agregarVehiculo(vehiculo_3.getMarca(), vehiculo_3.getPlaca(), vehiculo_3.getNum_puertas(), vehiculo_3.getCapacidad(), vehiculo_3.getTipo(),vehiculo_3.getModelo_anio(),vehiculo_3.getEstado(), lista, file));
			assertFalse("No se debió agregar el vehiculo", vehiculo.agregarVehiculo(vehiculo_4.getMarca(), vehiculo_4.getPlaca(), vehiculo_4.getNum_puertas(), vehiculo_4.getCapacidad(), vehiculo_4.getTipo(),vehiculo_4.getModelo_anio(), vehiculo_3.getEstado(), lista, file));
		}
		
		
		
		public void testBuscarEmpleado() {
			setupEscenario();
			assertNull("No debió encontrar un vehiculo con placa NO existente en el sistema", vehiculo.buscarVehiculo("ddx637", lista));
			assertNotNull("Debió encontrarse el vehiculo", vehiculo.buscarVehiculo(vehiculo_1.getPlaca(), lista));
		}
		
		
		public void testEliminarEmpleado() {
			setupEscenario();
			assertEquals("Se elimino el vehículo", true, vehiculo.eliminarVehiculo(vehiculo_1.getPlaca(), lista, file));
			assertEquals("no se  elimino el vehculo, dado que el vehiculo no existe", false, vehiculo.eliminarVehiculo("ddx333", lista, file));
			
		}
		
		
		
		
}
