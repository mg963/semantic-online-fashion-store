package Clothes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Brands extends JFrame {
	
	public static final String SOURCE = "./src/main/java/Clothes/";
    
    public static final String BRANDS = "http://www.semanticweb.org/aishw/ontologies/2021/4/untitled-ontology-5#";

	private JPanel contentPane;
	
	private JScrollPane sp=new JScrollPane();
	
	DefaultListModel listModel = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Brands frame = new Brands();
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
	public Brands() {
		setTitle("Brands");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 50, 600, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchBrands = new JLabel("Search Brands");
		lblSearchBrands.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSearchBrands.setBounds(199, 37, 188, 25);
		contentPane.add(lblSearchBrands);
		
		JButton btnMen = new JButton("MEN");
		btnMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Out Of Stock","Stock Error",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnMen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMen.setBounds(95, 99, 97, 33);
		contentPane.add(btnMen);
		
		JButton btnWomen = new JButton("WOMEN");
		btnWomen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Stocks coming soon....","out of stock",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnWomen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWomen.setBounds(228, 99, 109, 33);
		contentPane.add(btnWomen);
		
		JButton btnKids = new JButton("KIDS");
		btnKids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				FileManager.get().readModel( m, SOURCE + "FashionStore.owl" );
				
				String prefix = "prefix fs: <" + BRANDS + ">\n" +     
								"prefix rdfs: <" + RDFS.getURI() + ">\n" +
								"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
						"select ?brand_name \n\r"
						+ "where{?brand_name fs:has_brand ?kids_wear. \n\r }" ;
				//	" #?size fs:has_sizes ?size \n\r }";
				//	"group by ?brand_name \n\r" ;
				
				query_text += "GROUP BY ?brand_name " +
							" ORDER BY ASC (?brand_name)"; 
				System.out.println(query_text);
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		        
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("Brand Name");
		        
		        try {
					ResultSet results = qexec.execSelect();
				    int i = 0;
				    while ( results.hasNext() ) {
				    	QuerySolution qs = results.next();
				               //arr.add(qs.get("name").toString());
				    	  values.add(new String[] {qs.get("brand_name").toString()});
				        System.out.println(qs.get("?brand_name"));
				        i++;
				    }
				    
				    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
				    JTable table = new JTable(tableModel);
				    table.setForeground(Color.DARK_GRAY);
				    table.setBackground(Color.WHITE);
				    table.setRowHeight(35);		
				    sp.setViewportView(table);		           
				    sp.setBounds(60, 300, 500, 317);
				    contentPane.add(sp);
				    contentPane.repaint();
				}
				finally {
					qexec.close();
				}
			}
		});
		btnKids.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKids.setBounds(374, 99, 97, 33);
		contentPane.add(btnKids);
        
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HomePage hp = new HomePage();
				hp.setVisible(true);
				dispose();
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBack.setBounds(395, 633, 97, 25);
        contentPane.add(btnBack);
        
        JLabel label = new JLabel("");
    	Image img = new ImageIcon (this.getClass().getResource("/brand.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
        label.setBounds(84, 159, 408, 133);
        contentPane.add(label);
	}
}
