package Actividad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*; 

public class Interfaces extends JFrame implements ActionListener{

	public Interfaces(int n,int m, Actividad estudiantes[]) {
			
		this.n = n;
		this.m = m;
		this.estudiantes = estudiantes;
		
		
		setSize(900,500);
		setTitle("PANEL DE INFORMACIÓN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        principalPanel = new JPanel();
        principalPanel.setSize(900,500);
        principalPanel.setVisible(true);
        
        fillStudentTable();
           
		materiasButton = new JButton("Lista de Materias");
		materiasButton.setBounds(600, 300, 100,50);
		materiasButton.addActionListener(this);
		principalPanel.add(materiasButton);
		
		volverButton = new JButton("Volver");
		volverButton.setBounds(500, 500, 75, 50);
		volverButton.addActionListener(this);
		estudiantesPanel.add(volverButton);
		
		estudiantesButton = new JButton("Lista de Estudiantes");
		estudiantesButton.setBounds(300, 300,100,50);
		estudiantesButton.addActionListener(this);
		principalPanel.add(estudiantesButton);
		
        add(principalPanel);
        add(estudiantesPanel);
                   
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == estudiantesButton){
            
           estudiantesPanel.setVisible(true);
           principalPanel.setVisible(false);
        }
		
		if(e.getSource() == volverButton){
            
	           estudiantesPanel.setVisible(false);
	           principalPanel.setVisible(true);
	    }
	}
	
	public void fillStudentTable() {
		   estudiantesPanel = new JPanel();
	       estudiantesPanel.setSize(900,500);
	       estudiantesPanel.setVisible(false);
	       estudiantesPanel.setLayout(null);
	        
	       JScrollPane scrollPane = new JScrollPane();
	       scrollPane.setBounds(0,0, 500, 300);
	       estudiantesPanel.add(scrollPane);

	       System.out.println(n);
	       String[] columnas = { "Nombre", "Apellido", "Promedio" };
	        
	       ModeloDatosEstudiante = new DefaultTableModel(null, columnas);

	       EstudiantesTable = new JTable(ModeloDatosEstudiante);
	        
	       scrollPane.setViewportView(EstudiantesTable);
	      
	       for (int i = 0; i < n; i++) {
	            
	            Object[] aux = { estudiantes[i].getName(), estudiantes[i].getLastName(), estudiantes[i].getPromedio() };
	            ModeloDatosEstudiante.addRow(aux);
	       }
	        
	}
	
	private int n, m;
	private Actividad[] estudiantes;
    private JButton estudiantesButton,materiasButton, volverButton; 
    private JPanel principalPanel,estudiantesPanel,materiasPanel;
    private JTable EstudiantesTable;
    private DefaultTableModel ModeloDatosEstudiante;
    
}
