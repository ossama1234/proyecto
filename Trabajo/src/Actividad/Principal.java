package Actividad;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String args[]){
		int n=0,m=0;
		double promedioMateria[];
		double promedioSeccion = 0;
		Scanner entrada= new Scanner(System.in);
	
		//Test variables
		n=3;
		m=3;
		
		while(n<=0 || m<=0) {
			try {
				JOptionPane.showMessageDialog(null, "Bienvenido, ingrese la información solicitada a continuación:");
				if(n<=0) {
					n = Integer.parseInt( JOptionPane.showInputDialog(null, "Ingrese la cantidad de estudiantes", "Sistema", JOptionPane.INFORMATION_MESSAGE));
				}
		
				if(n<=0) {
				
					JOptionPane.showMessageDialog(null, "El número de estudiantes tiene que ser positivo y mayor a cero, vuelva a intentarlo", "ERROR - DATOS INVALIDOS", JOptionPane.ERROR_MESSAGE);
				} else{
					
					m = Integer.parseInt( JOptionPane.showInputDialog(null, "Ingrese el numero de materias", "Sistema", JOptionPane.INFORMATION_MESSAGE));
					
					if(m<=0) {
						JOptionPane.showMessageDialog(null, "El número de materias tiene que ser positivo y mayor a cero, vuelva a intentarlo", "ERROR - DATOS INVALIDOS", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}catch(Exception exception) {
				JOptionPane.showMessageDialog(null, "No ha ingresado un número, se reiniciará la operación", "ERROR - DATOS INVALIDOS", JOptionPane.ERROR_MESSAGE);
				System.out.println();
				n=0;
				m=0;
			}
		}
		
		Actividad estudiantes[]=new Actividad[n];
		
		
		for (int i=0; i<n; i++){
			String nombre, apellido;

			nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante", "Estudiante: Nº" + (i+1), JOptionPane.INFORMATION_MESSAGE);

			apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del estudiante", "Estudiante: Nº" + (i+1), JOptionPane.INFORMATION_MESSAGE);
			
			estudiantes[i]=new Actividad(nombre,apellido);
			estudiantes[i].setNotas(m);
			estudiantes[i].setPromedio(estudiantes[i].PromedioNotas(m));
			
			//JOptionPane.showMessageDialog(null, "El promedio del estudiante es:" +estudiantes[i].PromedioNotas(m), "Sistema - Estudiante: Nº" + (i+1), JOptionPane.INFORMATION_MESSAGE);
		}
		
		Interfaces app = new Interfaces(n,m,estudiantes);
		app.setVisible(true);

		
		
		
  	   //promedio de la Seccion
		for(int i=0;i<n;i++){
			promedioSeccion+=estudiantes[i].promedio;
		}
		
	//System.out.println("\nPromedio seccion :"+ (promedioSeccion/n));
		
		//determinar el orden de los estudiantes segun el promedio (incompleto)
		//double orden[]= new double[n];
		for(int i=0;i<n-1;i++){
			if(estudiantes[i].promedio<estudiantes[i].promedio){	
				
			 }	
		 }
		entrada.close();
		
     }	
}