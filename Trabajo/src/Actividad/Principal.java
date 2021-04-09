package Actividad;
import java.util.Scanner;

public class Principal {
	


	public static void main(String args[]){
		int n,m;
		double matriz[][];
		double promedioMateria[];
		double promedioSeccion=0;
		Scanner entrada= new Scanner(System.in);
	
		System.out.println("\nIngrese el numero de estudiantes");
		n=entrada.nextInt();
		System.out.println("\nIngrese el numero de materias");
		m=entrada.nextInt();

		Actividad estudiantes[]=new Actividad[n];
	
		
		for (int i=0; i<n; i++){
			String nombre;
			String apellido;
			System.out.print("Estudiante: Nº"+(i+1)+"\n");
			System.out.print("Nombre");
			nombre= entrada.nextLine();
			System.out.print("Apellido");
			apellido= entrada.nextLine();
			System.out.println(" ");
			estudiantes[i]=new Actividad(nombre,apellido);
			estudiantes[i].setNotas(m);
			estudiantes[i].setPromedio(estudiantes[i].PromedioNotas(m));
			System.out.print("El promedio del estudiante es "+estudiantes[i].PromedioNotas(m));
			System.out.println("\n");
	     
		}
	

		//rellenar matriz 
		matriz = new double[n][m];
			for (int i=0; i<n; i++){
				for (int j=0; j<m; j++){
					matriz[i][j]=estudiantes[i].Notas(j);	    
				} 
		}
		
		//calcular promedio por materia
			System.out.println("Promedio por Materia");
		promedioMateria=new double [m];
		for(int i=0; i<m;i++){
			double suma=0;
			for (int j=0; j<n;j++){
				suma += matriz[j][i];
				} 
			suma/=n;	
			promedioMateria[i]=suma;
			
			System.out.println("Materia Nº"+(i+1)+" :" +promedioMateria[i]);
		}
	
  	   //promedio de la Seccion
		for(int i=0;i<n;i++){
			promedioSeccion+=estudiantes[i].promedio;
		}
		
	System.out.println("\nPromedio seccion :"+ (promedioSeccion/n));
		
		//determinar el orden de los estudiantes segun el promedio (incompleto)
		double orden[]= new double[n];
		for(int i=0;i<n-1;i++){
			if(estudiantes[i].promedio<estudiantes[i].promedio){	
				
			 }	
		 }
     }	
}