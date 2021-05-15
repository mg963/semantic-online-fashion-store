package Clothes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import places.HomeScreen;
import places.SearchPeople;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setPreferredSize(new Dimension(800, 800));
		setMaximumSize(new Dimension(800, 800));
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1100, 820);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearchBrand = new JButton("Search Brand");
		btnSearchBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Brands().setVisible(true);
				dispose();
			}
		});
		btnSearchBrand.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearchBrand.setBackground(Color.ORANGE);
		Image img2 = new ImageIcon (this.getClass().getResource("/b.png")).getImage();
		btnSearchBrand.setIcon(new ImageIcon(img2));
		btnSearchBrand.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnSearchBrand.setBounds(496, 286, 447, 110);
		contentPane.add(btnSearchBrand);
		
		JButton btnSearchEmployee = new JButton("Employee List");
		btnSearchEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearchEmployee.setBackground(Color.ORANGE);
		Image img3 = new ImageIcon (this.getClass().getResource("/em.png")).getImage();
		btnSearchEmployee.setIcon(new ImageIcon(img3));
		btnSearchEmployee.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnSearchEmployee.setBounds(496, 29, 447, 110);
		contentPane.add(btnSearchEmployee);
		btnSearchEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchEmployee().setVisible(true);
				dispose();
			}
		});
		
		JButton btnSearchCustomer = new JButton("Search Customer");
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Customers().setVisible(true);
				dispose();
			}
		});
		btnSearchCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearchCustomer.setBackground(Color.ORANGE);
		Image img4 = new ImageIcon (this.getClass().getResource("/cu.png")).getImage();
		btnSearchCustomer.setIcon(new ImageIcon(img4));
		btnSearchCustomer.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnSearchCustomer.setBounds(496, 162, 447, 96);
		contentPane.add(btnSearchCustomer);
		
		JButton btnCategory = new JButton("Accessories");
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Accessories().setVisible(true);
				dispose();
			}
		});
		btnCategory.setHorizontalAlignment(SwingConstants.LEFT);
		btnCategory.setBackground(Color.ORANGE);
		Image img5 = new ImageIcon (this.getClass().getResource("/c.png")).getImage();
		btnCategory.setIcon(new ImageIcon(img5));
		btnCategory.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnCategory.setBounds(496, 427, 447, 105);
		contentPane.add(btnCategory);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource("/bb.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(29, -13, 427, 753);
		contentPane.add(label);
		
		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutUs().setVisible(true);
				dispose();
			}
		});
		btnAboutUs.setBackground(Color.ORANGE);
		btnAboutUs.setHorizontalAlignment(SwingConstants.LEFT);
		Image img1 = new ImageIcon (this.getClass().getResource("/s.png")).getImage();
		btnAboutUs.setIcon(new ImageIcon(img1));
		btnAboutUs.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnAboutUs.setBounds(496, 567, 447, 110);
		contentPane.add(btnAboutUs);
		
		JButton btnLO = new JButton("Logout");
		btnLO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				lp.setVisible(true);
				dispose();
			}
		});
		btnLO.setBackground(Color.WHITE);
		btnLO.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLO.setHorizontalAlignment(SwingConstants.LEFT);
		Image img6 = new ImageIcon (this.getClass().getResource("/lo.png")).getImage();
		btnLO.setIcon(new ImageIcon(img6));
		btnLO.setBounds(665, 712, 122, 36);
		contentPane.add(btnLO);
	}

}
