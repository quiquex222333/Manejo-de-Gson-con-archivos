
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub.
		
		
		//Inciso a
		//Creamos 3 estudiantes
		Estudiante estudiante1 = new Estudiante();
		Estudiante estudiante2 = new Estudiante();
		Estudiante estudiante3 = new Estudiante();
		
		//Instanciamos al estudiante1
		estudiante1.setNombre("Juan");
		estudiante1.setApellido("Rivera");
		estudiante1.setCodigo("rqj-1993");
		
		nota []notas = new nota[3];
		for (int i = 0; i < notas.length; i++) {
			notas[i] = new nota();
		}
		notas[1].setCodigo("rqj-1993");
		notas[1].setSigla_mat("INF-111");
		notas[1].setNota(90);
		notas[2].setCodigo("rqj-1993");
		notas[2].setSigla_mat("INF-112");
		notas[2].setNota(80);
		notas[0].setCodigo("rqj-1993");
		notas[0].setSigla_mat("INF-113");
		notas[0].setNota(70);
		estudiante1.setNotas(notas);
		
		//Instanciamos al estudiante2
		estudiante2.setNombre("Koko");
		estudiante2.setApellido("Mancilla");
		estudiante2.setCodigo("xxx-1994");
				
		nota []notas2 = new nota[4];
		for (int i = 0; i < notas2.length; i++) {
			notas2[i] = new nota();
		}
		notas2[1].setCodigo("xxx-1994");
		notas2[1].setSigla_mat("INF-121");
		notas2[1].setNota(91);
		notas2[2].setCodigo("xxx-1994");
		notas2[2].setSigla_mat("INF-122");
		notas2[2].setNota(88);
		notas2[0].setCodigo("xxx-1994");
		notas2[0].setSigla_mat("INF-123");
		notas2[0].setNota(65);
		notas2[3].setCodigo("xxx-1994");
		notas2[3].setSigla_mat("INF-124");
		notas2[3].setNota(55);
		estudiante2.setNotas(notas2);
		
		//Instanciamos al estudiante3
		estudiante3.setNombre("Mary");
		estudiante3.setApellido("Prado");
		estudiante3.setCodigo("asd-1991");
						
		nota []notas3 = new nota[5];
		for (int i = 0; i < notas3.length; i++) {
			notas3[i] = new nota();
		}
		notas3[1].setCodigo("asd-1991");
		notas3[1].setSigla_mat("INF-131");
		notas3[1].setNota(50);
		notas3[2].setCodigo("asd-1991");
		notas3[2].setSigla_mat("INF-132");
		notas3[2].setNota(70);
		notas3[0].setCodigo("asd-1991");
		notas3[0].setSigla_mat("INF-133");
		notas3[0].setNota(55);
		notas3[3].setCodigo("asd-1991");
		notas3[3].setSigla_mat("INF-134");
		notas3[3].setNota(45);
		notas3[4].setCodigo("asd-1991");
		notas3[4].setSigla_mat("INF-135");
		notas3[4].setNota(78);
		estudiante3.setNotas(notas3);
		
		//Creamos un gson que forme un PrettyPrint
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		//creamos el archivo y escribimos la informacion
		//para esto el contenido de estudiante se transforma a gson
		//Para estudiante1
		escribir(gson.toJson(estudiante1), estudiante1.getCodigo());
		
		//Para el estudiante2
		escribir(gson.toJson(estudiante2), estudiante2.getCodigo());
		
		//Para el estudiante2
		escribir(gson.toJson(estudiante3), estudiante3.getCodigo());
		
		
		//-----------------------------------------------------------------------------------------
		//Inciso b
		//Extrae la informacion de los archivos y muestra promedios de estudiante
		System.out.println("Estudiante 1: ");
		SacaPromediosDeLosArchivos(estudiante1.getCodigo());
		System.out.println("\n\n\nEstudiante 2: ");
		SacaPromediosDeLosArchivos(estudiante2.getCodigo());
		System.out.println("\n\n\nEstudiante 3: ");
		SacaPromediosDeLosArchivos(estudiante3.getCodigo());
		
		
		//-----------------------------------------------------------------------------------------
		//Inciso c
		//Imprime en forma intentada 
		
		ImprimeDeFormaIntentada(estudiante1.getCodigo(), estudiante2.getCodigo(), estudiante3.getCodigo());
	}
	
	
	
	
	//Metodo para la escritura de archivos
	public static void escribir(String json,String nombreArchivo){
		
		File file = new File("/home/usuario/Documentos/"+nombreArchivo);
		
		try {
			
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(bufferedWriter);
			printWriter.write(json);
			
			printWriter.close();
			bufferedWriter.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	//metodo para imprimir de forma intentada
	public static void imprimir(String nombreArchivo){
		File file = new File("/home/usuario/Documentos/"+nombreArchivo);
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String string;
			while ((string=bufferedReader.readLine())!=null) {
				System.out.println(string);
			}
			bufferedReader.close();			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void ImprimeDeFormaIntentada(String e1, String e2, String e3) {
		//Imprime en forma intentada estudiante1
		System.out.println("Primer estudiante:");
		imprimir(e1);
		
		//Imprime en forma intentada estudiante2
		System.out.println("\n\n\nSegundo estudiante");
		imprimir(e2);
		
		//Imprime en forma intentada estudiante3
		System.out.println("\n\n\nTercer estudiante");
		imprimir(e3);
	}
	
	
	public static void SacaPromediosDeLosArchivos(String nombreArchivo) {
		File file = new File("/home/usuario/Documentos/"+nombreArchivo);
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String string;
			float fin = 0;
			int contador = 0;
			String nombre = "", apellido = "";
			while ((string=bufferedReader.readLine())!=null) {
				if(string.contains("\"nota\"")) {
					contador++;
					fin = fin + Integer.parseInt(string.substring(string.length()-2, string.length()));
				}
				if(string.contains("nombre"))
					nombre = string.substring(string.indexOf(":")+3, string.length()-2);
				if(string.contains("apellido"))
					apellido = string.substring(string.indexOf(":")+3, string.length()-2);
			}
			System.out.println("Apellido: "+apellido+"\nNombre: "+nombre+"\nPromedio: "+(fin/contador));
			bufferedReader.close();			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
