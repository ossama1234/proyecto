package Actividad;

import javax.swing.JOptionPane;

public class Actividad {

	String nombre;	
	String apellido;
	double promedio;
	double array [];

	//constructor para el nombre y apellido
	public Actividad (String nombre, String apellido){
		this.nombre=nombre;
		this.apellido=apellido;
	}
	
	public void setPromedio(double promedio){
		this.promedio=promedio;	
	}
	
	public String getName() {
		return nombre; 
	}
	
	public String getLastName() {
		return apellido; 
	}
	
	public double getPromedio() {
		return this.promedio;
	}

	// ingresar las notas de cada alumno		
	public void setNotas(int m){
		array=new double [m];
	
		for(int i=0;i<m;i++){
			do{
				try {
					array[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la nota del estudiante", "Materia Nº" + (i+1), JOptionPane.INFORMATION_MESSAGE));
				
					if(array[i] < 0 || array[i]>20) {
						JOptionPane.showMessageDialog(null, "El numero ingresado no está en el rango permitido [de 0 a 20]", "ERROR - DATOS INVALIDOS", JOptionPane.ERROR_MESSAGE);
					}
				}catch(Exception exception){
					JOptionPane.showMessageDialog(null, "No ha ingresado un valor válido, vuelvalo a intentar", "ERROR - DATOS INVALIDOS", JOptionPane.ERROR_MESSAGE);
					
				}
			}while(array[i] < 0 || array[i]>20);
			
			
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
