package Actividad;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String args[]){
		int n=0,m=0;
		String nombre="", apellido="";
			
		JOptionPane.showMessageDialog(null, "Bienvenido, ingrese la información solicitada a continuación:");
		
		while(n<=0 || m<=0) {
			try {

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
				if(n == 0 || m== 0) {
					JOptionPane.showMessageDialog(null, "Ha insertado un valor inválido o ha presionado cancelar, el sistema se detendrá", "ERROR - DATOS INVALIDOS", JOptionPane.ERROR_MESSAGE);
					return;
				}								
			}
		}
		
		Actividad estudiantes[]=new Actividad[n];
				
		for (int i=0; i<n; i++){
			try {
								
			while(nombre.equals("") || apellido.equals("")) {
				
				nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante", "Estudiante: Nº" + (i+1), JOptionPane.INFORMATION_MESSAGE);
					
				if(nombre.equals("")) {
					JOptionPane.showMessageDialog(null, "No ha ingresado un nombre, intente de nuevo", "ERROR - DATOS INVALIDOS", JOptionPane.ERROR_MESSAGE);
				} else {
				
					apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del estudiante", "Estudiante: Nº" + (i+1), JOptionPane.INFORMATION_MESSAGE);
				
					if(apellido.equals("")) {
						JOptionPane.showMessageDialog(null, "No ha ingresado un apellido, intente de nuevo", "ERROR - DATOS INVALIDOS", JOptionPane.ERROR_MESSAGE);
					}
				}						
			}
							
			estudiantes[i]=new Actividad(nombre,apellido);
			estudiantes[i].setNotas(m);
			estudiantes[i].setPromedio(estudiantes[i].PromedioNotas(m));
			nombre ="";
			apellido = "";
			}catch(Exception exception) {
				//System.out.println(exception);
				JOptionPane.showMessageDialog(null, "Ha cancelado la operación el sistema se cerarrá", "CANCELAR OPERACIÓN", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		Interfaces app = new Interfaces(n,m,estudiantes);
		app.showApp();
     }	
}