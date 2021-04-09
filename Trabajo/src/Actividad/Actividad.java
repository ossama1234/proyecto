package Actividad;
import java.util.Scanner;

public class Actividad {

	String nombre;	
	String apellido;
	double promedio;
	double array [];

	Scanner entrada= new Scanner(System.in);

	//constructor para el nombre y apellido
	public Actividad (String nombre, String apellido){
		this.nombre=nombre;
		this.apellido=apellido;
	}
	
	public void setPromedio(double promedio){
		this.promedio=promedio;	
	}

	// ingresar las notas de cada alumno		
	public void setNotas(int m){
		array=new double [m];
		System.out.println("Ingrese las notas");
	
		for(int i=0;i<m;i++){
			System.out.print("Materia Nº"+(i+1)+" :");
			array[i]=entrada.nextDouble();
		}	
	}

	// devolver notas para rellenar matriz
	public double Notas(int l){
		double nota=0;
		nota= array[l];
		return nota;
	}

	// promedio notas por alumno
	public double PromedioNotas(int h) {
		double promedio=0; 
		for(int i=0;i<h;i++){
			promedio+= array[i];
			}
		promedio/=h;
		return promedio;
		}

}
