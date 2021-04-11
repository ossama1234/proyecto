package Actividad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*; 

public class Interfaces extends JFrame implements ActionListener{

	public Interfaces(int n,int m, Actividad students[]) {
			
		this.n = n;
		this.m = m;
		this.students = students;		
                
		createPrincipalPanel();
		
		createCoursePanel();
        fillCourseTable();
		
		createStudentPanel();
        fillStudentTable();
                        		           	     			
		add(principalPanel);
        add(studentPanel);
        add(coursePanel);
        
	}
	
	private void createPrincipalPanel() {
		setSize(900,500);
		setTitle("PANEL DE INFORMACIÓN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        principalPanel = new JPanel();
        principalPanel.setSize(900,500);
        principalPanel.setVisible(true);
        
        courseButton = new JButton("Lista de Materias");
        courseButton.setBounds(600, 300, 100,50);
        courseButton.addActionListener(this);
		principalPanel.add(courseButton);
			
		studentButton = new JButton("Lista de Estudiantes");
		studentButton.setBounds(300, 300,100,50);
		studentButton.addActionListener(this);
		principalPanel.add(studentButton);
	}
	
	private void createStudentPanel() {
		studentPanel = new JPanel();
		studentPanel.setSize(900,500);
		studentPanel.setVisible(false);
		studentPanel.setLayout(null);
		
		backStudentButton = new JButton("Volver");
		backStudentButton.setBounds(100, 400, 100, 50);
		backStudentButton.addActionListener(this);
		studentPanel.add(backStudentButton);
		
		studentOrderButton = new JButton("Ordenar");
		studentOrderButton.setBounds(550, 400, 100, 50);
		studentOrderButton.addActionListener(this);
		studentPanel.add(studentOrderButton);
					   
        StudentScrollPane = new JScrollPane();
        StudentScrollPane.setBounds(0,0, 500, 300);
        studentPanel.add(StudentScrollPane);
	}
	
	private void fillStudentTable() {
			
	        
	       studentDataModel = new DefaultTableModel(null, studentColumn);

	       studentTable = new JTable(studentDataModel);
	        
	       StudentScrollPane.setViewportView(studentTable);
	      
	       for (int i = 0; i < n; i++) {
	            
	            Object[] aux = { students[i].getName(), students[i].getLastName(), students[i].getPromedio() };
	            studentDataModel.addRow(aux);
	       }
	        
	}
	
	private void studentOrder() {
		name = new String[n];
		lastname = new String[n];
		average= new double[n];
	     for(int i=0;i<n;i++){
	    	 name[i]= students[i].getName();
	    	 lastname[i] = students[i].getLastName();
	    	 average[i]= students[i].getPromedio();
		 }
	     
	     for(int i=0;i<n;i++){

	    	 int pos= i;
	    	 double aux= average[i];
	    	 String aux1= name[i];
	    	 String aux2 = lastname[i];
	    	 					
	    	 	while ((pos>0) && (average[pos-1]<aux)){
	    	 		average[pos]=average[pos-1];
	    	 		name[pos]=name[pos-1];
	    	 		lastname[pos]=lastname[pos-1];
	    	 		       pos--;
	    	 			}

	    	 	average[pos]=aux;
	    	 	name[pos]=aux1;
	    	 	lastname[pos]=aux2;
	    	 					    	 					
	    	 }
	     
	     for(int i=0;i<n;i++){
	    	 studentDataModel.removeRow(0);
	    	 
	    	 Object[] aux = { name[i], lastname[i], average[i] };
	          studentDataModel.addRow(aux);
	    	 
	    }
	}
	
	private void createCoursePanel() {
		coursePanel = new JPanel();
		coursePanel.setSize(900,500);
		coursePanel.setVisible(false);
		coursePanel.setLayout(null);
		
		backCourseButton = new JButton("Volver");
		backCourseButton.setBounds(100, 400, 100, 50);
		backCourseButton.addActionListener(this);
		coursePanel.add(backCourseButton);
			        
	    coursesScrollPane = new JScrollPane();
	    coursesScrollPane.setBounds(0,0, 500, 300);
	    coursePanel.add(coursesScrollPane);
	}
	
	private void fillCourseTable() {
		
		courses = new double[n][m];
		for (int i=0; i<n; i++){
			for (int j=0; j<m; j++){
				courses[i][j]=students[i].Notas(j);	    
			} 
		}
		
		promedioMateria=new double [m];
		for(int i=0; i<m;i++){
			double suma=0;
			for (int j=0; j<n;j++){
				suma += courses[j][i];
			} 
			suma   /=n;	
			promedioMateria[i]=suma;		
		}

	    String[] courseColumn = { "Materías", "Promedio"};
	        
	    courseDataModel = new DefaultTableModel(null, courseColumn);

	    courseTable = new JTable(courseDataModel);
	        
	    coursesScrollPane.setViewportView(courseTable);
	   	      
	    for (int i = 0; i < m; i++) {
	            
	         Object[] aux = { "Materia Nº"+(i+1) ,promedioMateria[i]};
	         courseDataModel.addRow(aux);
	    }
		
	} 

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == studentButton){
            
           studentPanel.setVisible(true);
           principalPanel.setVisible(false);
        }
		
		if(e.getSource() == courseButton){
            
			   coursePanel.setVisible(true);
	           principalPanel.setVisible(false);
	        }
		
		if(e.getSource() == backCourseButton){
            
			coursePanel.setVisible(false);
	        principalPanel.setVisible(true);
	    }
		
		if(e.getSource() == backStudentButton){
            
			studentPanel.setVisible(false);
	        principalPanel.setVisible(true);
	    }
		
		if(e.getSource() == studentOrderButton){
            
			studentOrder();
	    }
	}
	
	String[] studentColumn = { "Nombre", "Apellido", "Promedio" };
	private int n, m;
	private String[] name,lastname;
	private JScrollPane StudentScrollPane, coursesScrollPane;
	private Actividad[] students;
    private JButton studentButton,courseButton,backStudentButton,backCourseButton, studentOrderButton, courseOrderButton; 
    private JPanel principalPanel,studentPanel,coursePanel;
    private JTable studentTable, courseTable;
    private DefaultTableModel studentDataModel, courseDataModel;
    private double courses[][], average[];
    private double promedioMateria[];
    
}
