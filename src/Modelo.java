import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;



public class Modelo {
	private String ruta;
	private String directorio;
	private String nombreArchivo;
	
	
	public Modelo() {
		ruta=null;
		directorio=null;
		nombreArchivo=null;
	}
	private void actualizarDirectorio() {
		StringTokenizer st = new StringTokenizer(ruta, "/");
		StringBuilder sb = new StringBuilder("");
		String token;
		while(st.hasMoreTokens()) {
			token = st.nextToken("/");
			if (!(token.equals(nombreArchivo))) {
				sb.append("/"+token);
			}
		}
		directorio=sb.toString();
	}
	
	public String AbrirArchivo() {
		JFileChooser archivo=new JFileChooser();
		archivo.showOpenDialog(null);
		File archivoFile = archivo.getSelectedFile();
		Scanner sc = null;
		try {
			sc = new Scanner(archivoFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder texto = new StringBuilder("");
		while (sc.hasNextLine()) {
			texto.append(sc.nextLine()+"\n");
		}
		ruta=archivoFile.getPath();
		nombreArchivo=archivoFile.getName();
		actualizarDirectorio();
		return texto.toString();
	}
	public void GuardarArchivo(String texto) throws FileNotFoundException {
		JFileChooser archivo=new JFileChooser();
		archivo.showSaveDialog(null);
		try (PrintWriter pw = new PrintWriter(archivo.getSelectedFile())){
			pw.println(texto);
		}
		ruta=archivo.getSelectedFile().getPath();
		nombreArchivo=archivo.getSelectedFile().getName();
		actualizarDirectorio();
		System.out.println(this.directorio);
		
	}
	
	public void Compilar() throws IOException {
		/*String comandos[] = new String[4];
		comandos[0]="cd "+ this.directorio;
		comandos[1]="arm-none-eabi-as -o "+ this.directorio+"/tmp.o "+ this.ruta;
		comandos[2]="arm-none-eabi-ld -e 0 -Ttext=0x8000 tmp.o";
		comandos[3]="arm-none-eabi-objcopy a.out -O binary kernel.img";
		comandos[4]="rm -f a.out tmp.o";
		
		for (int i=1; i<2; i++) {
			try {
				Runtime.getRuntime().exec(comandos[i]);
			} catch (IOException ioe){
				System.out.println(ioe);
			}
		}*/
	//	System.out.println("cd");
	//	Runtime.getRuntime().exec("cd");
//		Runtime.getRuntime().exec();
	}

	public String getRuta() {
		return this.ruta;
	}
	public String getNombreArchivo() {
		return this.nombreArchivo;
	}
	public String getDirectorio() {
		return this.directorio;
	}
}
