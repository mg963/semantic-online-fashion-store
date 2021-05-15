package Clothes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutUs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		setTitle("About Us");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 25, 1100, 820);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOnlineFashionStore = new JLabel("ONLINE FASHION STORE");
		lblOnlineFashionStore.setForeground(Color.RED);
		lblOnlineFashionStore.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblOnlineFashionStore.setBounds(50, 512, 392, 63);
		contentPane.add(lblOnlineFashionStore);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource("/ST.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(90, 344, 192, 184);
		contentPane.add(label);
		
		JLabel lblStoreNo = new JLabel("STORE NO. 1");
		lblStoreNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStoreNo.setBounds(132, 326, 107, 16);
		contentPane.add(lblStoreNo);
		
		JLabel lblCyprusRoad = new JLabel("3 Cyprus road, Cambridge");
		lblCyprusRoad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCyprusRoad.setBounds(111, 559, 254, 37);
		contentPane.add(lblCyprusRoad);
		
		JLabel lblmail = new JLabel("onlinefashionstore@gmail.com");
		lblmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Image img1 = new ImageIcon (this.getClass().getResource("/mail.png")).getImage();
		lblmail.setIcon(new ImageIcon(img1));
		lblmail.setBounds(90, 627, 261, 24);
		contentPane.add(lblmail);
		
		JLabel lblweb = new JLabel("www.onlinefashionstore.com");
		lblweb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Image img2 = new ImageIcon (this.getClass().getResource("/web.png")).getImage();
		lblweb.setIcon(new ImageIcon(img2));
		lblweb.setBounds(101, 654, 261, 24);
		contentPane.add(lblweb);
		
		JLabel label_1 = new JLabel("+44 1234 56789");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Image img3 = new ImageIcon (this.getClass().getResource("/phone.png")).getImage();
		label_1.setIcon(new ImageIcon(img3));
		label_1.setBounds(123, 682, 261, 24);
		contentPane.add(label_1);
		
		JLabel lblAboutUs = new JLabel("ABOUT US");
		lblAboutUs.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblAboutUs.setBounds(478, 23, 157, 29);
		contentPane.add(lblAboutUs);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 304, 1058, 10);
		contentPane.add(separator);
		
		JLabel label_2 = new JLabel("");
		Image img4 = new ImageIcon (this.getClass().getResource("/on.png")).getImage();
		label_2.setIcon(new ImageIcon(img4));
		label_2.setBounds(24, 82, 197, 209);
		contentPane.add(label_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(233, 82, 50, 209);
		contentPane.add(separator_1);
		
		JLabel lblMrunknown = new JLabel("MR. UNKNOWN");
		lblMrunknown.setForeground(Color.RED);
		lblMrunknown.setFont(new Font("Arial", Font.BOLD, 19));
		lblMrunknown.setBounds(257, 82, 142, 29);
		contentPane.add(lblMrunknown);
		
		JLabel lblFounderDirector = new JLabel("Founder");
		lblFounderDirector.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFounderDirector.setBounds(257, 112, 116, 16);
		contentPane.add(lblFounderDirector);
		
		JLabel lblNewLabel = new JLabel("If you would like to experience the best of online shopping for men, women and kids in UK, you are at the right place. ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(257, 143, 760, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblItIsTime = new JLabel("It is time to redefine your style statement with our treasure-trove of trendy items. Our online store brings you the latest in ");
		lblItIsTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItIsTime.setBounds(257, 180, 760, 16);
		contentPane.add(lblItIsTime);
		
		JLabel lblDesignerProductsStraight = new JLabel("designer products straight out of fashion houses.");
		lblDesignerProductsStraight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesignerProductsStraight.setBounds(257, 209, 378, 24);
		contentPane.add(lblDesignerProductsStraight);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(531, 304, 14, 456);
		contentPane.add(separator_2);
		
		JLabel lblStoreNo_1 = new JLabel("STORE NO. 2");
		lblStoreNo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStoreNo_1.setBounds(746, 326, 107, 16);
		contentPane.add(lblStoreNo_1);
		
		JLabel label_4 = new JLabel("");
		Image img6 = new ImageIcon (this.getClass().getResource("/ST.png")).getImage();
		label_4.setIcon(new ImageIcon(img6));
		label_4.setBounds(704, 344, 192, 184);
		contentPane.add(label_4);
		
		JLabel lblFashionMania = new JLabel("FASHION MANIA");
		lblFashionMania.setForeground(Color.RED);
		lblFashionMania.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblFashionMania.setBounds(680, 512, 261, 63);
		contentPane.add(lblFashionMania);
		
		JLabel lblQueenStOxford = new JLabel("Queen St, Oxford OX1 1TR, United Kingdom");
		lblQueenStOxford.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQueenStOxford.setBounds(640, 559, 365, 37);
		contentPane.add(lblQueenStOxford);
		
		JLabel lblFashionmaniagmailcom = new JLabel("fashionmania@gmail.com");
		Image img7 = new ImageIcon (this.getClass().getResource("/mail.png")).getImage();
		lblFashionmaniagmailcom.setIcon(new ImageIcon(img7));
		lblFashionmaniagmailcom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFashionmaniagmailcom.setBounds(693, 627, 261, 24);
		contentPane.add(lblFashionmaniagmailcom);
		
		JLabel lblWwwfashionmaniacom = new JLabel("www.fashionmania.com");
		lblweb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Image img8 = new ImageIcon (this.getClass().getResource("/web.png")).getImage();
		lblWwwfashionmaniacom.setIcon(new ImageIcon(img8));
		lblWwwfashionmaniacom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWwwfashionmaniacom.setBounds(703, 654, 261, 24);
		contentPane.add(lblWwwfashionmaniacom);
		
		JLabel label_9 = new JLabel("+44 9876 54321");
		Image img0 = new ImageIcon (this.getClass().getResource("/phone.png")).getImage();
		label_9.setIcon(new ImageIcon(img0));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(725, 682, 261, 24);
		contentPane.add(label_9);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(39, 67, 1031, 2);
		contentPane.add(separator_3);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(973, 731, 97, 29);
		contentPane.add(btnBack);
	}
}
