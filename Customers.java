package Clothes;


import java.awt.EventQueue;

import javax.swing.DefaultListModel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
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

import java.awt.Color;
import javax.swing.JLabel;


import java.awt.Font;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Customers extends JFrame {
	
    public static final String SOURCE = "./src/main/java/Clothes/";
    
    public static final String CUSTOMER = "http://www.semanticweb.org/aishw/ontologies/2021/4/untitled-ontology-5#";

	private JPanel contentPane;
	
	DefaultListModel listModel = new DefaultListModel();
	
	private JScrollPane sp=new JScrollPane();
	
	public static Customers frame = new Customers();
	private JTextField txtByName;

	/**
	 * Launch the application.
	 */
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
	public Customers() {
		setTitle("Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchCustomerBy = new JLabel("Search Customer By Address");
		lblSearchCustomerBy.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSearchCustomerBy.setBounds(134, 31, 371, 52);
		contentPane.add(lblSearchCustomerBy);
		
		        
		txtByName = new JTextField();
		txtByName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtByName.setBounds(104, 112, 366, 32);
		contentPane.add(txtByName);
		txtByName.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String add = txtByName.getText().toString().toLowerCase();
				
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "FashionStore.owl" );
				
				String prefix = "prefix fs: <" + CUSTOMER + ">\n" +     
								"prefix rdfs: <" + RDFS.getURI() + ">\n" +
								"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?Fname ?Lname ?address ?purchased_item where { ?f  a fs:customer. ?f fs:Fname ?Fname." + 
					"?f fs:Lname  ?Lname. ?f fs:address ?address. ?f fs:total_number_accessories_purchased ?purchased_item. \n\r"; 

				if(add != null && !add.isEmpty()) {
					query_text += "FILTER(regex(str(?address),\""+add+"\",\"i\")) ";
				}
				query_text +="}" ; 
				System.out.println(query_text);
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("First Name");
		        columns.add("Last Name");
		        columns.add("Address");
		        columns.add("Items Purchased"); 
		        
		          try {
					ResultSet results = qexec.execSelect();
				    int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				        values.add(new String[] {qs.get("?Fname").toString(), qs.get("?Lname").toString(), qs.get("?address").toString(), qs.get("?purchased_item").toString()});
				        System.out.println(qs.get("?address"));
				        i++;
				    }
				    if(i == 0) {
			        	  listModel.addElement("There was no match found for '"+add+"'");
			          }
				   
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(60, 200, 570, 317);
				    contentPane.add(sp);
				    contentPane.repaint();
		        }
		        finally {
		            qexec.close();
		        }
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(469, 112, 97, 32);
		contentPane.add(btnSearch);    
	        
	        JButton btnBack = new JButton("BACK");
	        btnBack.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	    				HomePage hp = new HomePage();
	    				hp.setVisible(true);
	    				dispose();
	        	}
	        });
	        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        btnBack.setBounds(519, 572, 97, 32);
	        contentPane.add(btnBack);
	        
	        
	}
}
