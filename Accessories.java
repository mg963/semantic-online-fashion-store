package Clothes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Accessories extends JFrame {
	
	public static final String SOURCE = "./src/main/java/Clothes/";
	
	public static final String ACCESS = "http://www.semanticweb.org/aishw/ontologies/2021/4/untitled-ontology-5#";

	private JScrollPane sp=new JScrollPane();
	
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accessories frame = new Accessories();
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
	public Accessories() {
		setTitle("Accessories");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchAccessories = new JLabel("Search Accessories");
		lblSearchAccessories.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblSearchAccessories.setBounds(217, 33, 297, 60);
		contentPane.add(lblSearchAccessories);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(157, 106, 319, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		        
        JLabel lblL = new JLabel("");
        Image img = new ImageIcon (this.getClass().getResource("/acc.jpg")).getImage();
		lblL.setIcon(new ImageIcon(img));
        lblL.setBounds(167, 151, 434, 84);
        contentPane.add(lblL);
        
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HomePage hp = new HomePage();
				hp.setVisible(true);
				dispose();
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBack.setBounds(519, 607, 97, 33);
        contentPane.add(btnBack);
        
        JButton btnNewButton = new JButton("SEARCH");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cat = textField.getText().toString().toLowerCase();
				
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "FashionStore.owl" );
				
				String prefix = "prefix fs: <" +  ACCESS + ">\n" +
                				"prefix rdfs: <" + RDFS.getURI() + ">\n" +
                				"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						" select ?brand_name ?size ?category where{?x a fs:brands. " + 
						"?a fs:brand_name ?brand_name. ?a fs:category ?category. ?a fs:size ?size \n\r" +
						"FILTER (str(?category)= 'shoes') \n\r"; 
					
				query_text += "} ORDER BY ASC (?brand_name)";
				System.out.println(query_text);
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("Brand Name");
		        columns.add("Category");
		        columns.add("Size"); 
		
		        try {
					ResultSet results = qexec.execSelect();
				    int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				    	values.add(new String[] {qs.get("?brand_name").toString(), qs.get("?category").toString(), qs.get("?size").toString()});
				        System.out.println(qs.get("?category"));
				        i++;
				    }
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(60, 250, 570, 317);
				    contentPane.add(sp);
				    contentPane.repaint();
		        }
		        finally {
		            qexec.close();
		        }
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(479, 103, 97, 36);
        contentPane.add(btnNewButton);
	}

}
