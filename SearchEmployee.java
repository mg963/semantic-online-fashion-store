package Clothes;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
//import javax.swing.JList;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

//import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
//import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDFS;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SearchEmployee extends JFrame {
	
	// Directory where we've stored the local data files, such as aircraft.owl
    public static final String SOURCE = "./src/main/java/Clothes/";
    
    public static final String EMPLOYEE = "http://www.semanticweb.org/aishw/ontologies/2021/4/untitled-ontology-5#";
    
	private JPanel contentPane;
	
	private JScrollPane sp=new JScrollPane();
	

	/**
	 * Launch the application.
	 */
	public static SearchEmployee frame = new SearchEmployee();
	//private JTextField txtByName;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchEmployee() {
		setTitle("Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setPreferredSize(new Dimension(700, 700));
		contentPane.setMaximumSize(new Dimension(400, 400));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchEmployeeBy = new JLabel("List of Employees");
		lblSearchEmployeeBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchEmployeeBy.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSearchEmployeeBy.setBounds(143, 28, 386, 36);
		contentPane.add(lblSearchEmployeeBy);
				   
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		
		
		/*JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(img));
		label.setBounds(56, 126, 563, 300);
		contentPane.add(label);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(516, 685, 97, 25);
		contentPane.add(btnBack);*/
		
		JButton btnList = new JButton("LIST");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create instance of OntModel class
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "FashionStore.owl" );
				
				String prefix = "prefix fs: <" + EMPLOYEE + ">\n" +     
								"prefix rdfs: <" + RDFS.getURI() + ">\n" +
								"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
							"select ?EmployeeName ?jobrole ?BranchName \r\n" + 
						"where { ?f  a fs:employee. ?f fs:employee_name ?EmployeeName. ?f fs:job_role  ?jobrole. ?f fs:branchname ?BranchName.\n\r} "; 

				
				System.out.println(query_text);
				 
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		             
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("EmployeeName");
		        columns.add("jobrole");
		        columns.add("BranchName");
		        
				try {
					ResultSet results = qexec.execSelect();
				    int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				        values.add(new String[] {qs.get("EmployeeName").toString(), qs.get("?jobrole").toString(), qs.get("?BranchName").toString()});
				        System.out.println(qs.get("?EmployeeName"));
				        i++;
				    }
				
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(60, 150, 570, 317);
				    contentPane.add(sp);
				    contentPane.repaint();
				}
				finally {
					qexec.close();
				}
			}
		});
		btnList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnList.setBounds(274, 88, 97, 36);
		contentPane.setLayout(null);
		btnList.setPreferredSize(new Dimension(350, 45));
		contentPane.add(btnList);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(459, 487, 97, 36);
		contentPane.add(btnNewButton);
	}
}
