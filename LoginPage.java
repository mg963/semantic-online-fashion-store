package Clothes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import junit.framework.Test;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setTitle("Login Page");
		setPreferredSize(new Dimension(800, 800));
		setMaximumSize(new Dimension(800, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 700,500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOnlineFashionStore = new JLabel("ONLINE FASHION STORE");
		lblOnlineFashionStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineFashionStore.setBounds(169, 51, 390, 37);
		lblOnlineFashionStore.setForeground(Color.RED);
		lblOnlineFashionStore.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblOnlineFashionStore);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(154, 192, 114, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(154, 252, 125, 16);
		contentPane.add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textUsername.setBounds(280, 185, 287, 31);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPassword.setBounds(280, 245, 287, 31);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password =txtPassword.getText();
				String username =textUsername.getText();
				
				if (password.contains("admin") && username.contains("admin")) {
					txtPassword.setText(null);
					textUsername.setText(null);	
					
					HomePage hp = new HomePage();
					hp.setVisible(true);
					
					dispose();

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Details","Login Error",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					textUsername.setText(null);
				}
			}
		});
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnLogin.setBounds(294, 316, 107, 31);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource("/bg.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 170, 443);
		contentPane.add(label);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnReset.setForeground(Color.DARK_GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(442, 316, 97, 31);
		contentPane.add(btnReset);
	}
}
