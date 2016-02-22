import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author carmen
 */
public class UAMI {
    //crea el archivo tupla y el archivo error
	public static File archivo_tpl, archivo_err;
	
	//variable de tipo PrintWriter para poder escribir sobre los archivos tupla y error
	public static PrintWriter wr1, wr2;
	
	//variable de tipo BufferedWriter para poder realizar la escritura sobre los archivos de escritura tupla y error
	public static BufferedWriter bw1, bw2;
	
	//Atributo estatico de tipo FileReader para poder leer el contenido del archivo fuente
	public static FileReader Archivo_fte;
	
	//contador de las lineas de codigo que tengan el archivo fuente
	public static int linea = 1;
	
	//Almacena el lexema formado en cada linea de codigo
	public static String tokenval = null;
	
	/*Met. que sera invocado desde el metodo compilador
	 *para generar los archivos tupla y el archivo de errores
	 *--Recibe la ruta completa del archivo fuente para que los archivos generados esten en las misma carpeta
	 *y compartan el mismo nombre del archivo fuente */
	public static void Crear_Archivos(String nombre_Archivo) throws IOException{
		int tam_N = nombre_Archivo.length();
		String Nombre_sin_Extension = nombre_Archivo.substring(0, (tam_N-3));
		
		//Creacion del Archivo tpl y err
		try{
			archivo_tpl = new File(Nombre_sin_Extension+"tpl");
			archivo_err = new File(Nombre_sin_Extension+"err");
			
			if(!archivo_tpl.exists() && !archivo_err.exists()){
				archivo_tpl.createNewFile();
				archivo_err.createNewFile();
				
				FileWriter w1 = new FileWriter(archivo_tpl);
				bw1 = new BufferedWriter(w1);
				wr1 = new PrintWriter(bw1);
				FileWriter w2 = new FileWriter(archivo_err);
				bw2 = new BufferedWriter(w2);
				wr1 = new PrintWriter(bw2);
			}else{
				archivo_tpl.delete();
				archivo_err.delete();
				Crear_Archivos(nombre_Archivo);
			}
			
		}catch(Exception e){
			System.out.println("No se pudieron crear los archivos *.tpl y *.err");
		}
		
	}
    
}
