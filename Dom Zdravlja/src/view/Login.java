package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Router;

public class Login {

	private JFrame frmLoginWindow;
	private JTextField textField;
	private JPasswordField textField_1;
	private JLabel lblPogresanLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	public Login(String poruka) {
		initialize();
		lblPogresanLogin.setText(poruka);
		lblPogresanLogin.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginWindow = new JFrame();
		frmLoginWindow.setTitle("Login Window");
		frmLoginWindow.setResizable(false);
		frmLoginWindow.setAlwaysOnTop(true);
		frmLoginWindow.setBounds(100, 100, 450, 300);
		frmLoginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginWindow.setVisible(true);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Router.userRoute(textField.getText(), new String(textField_1.getPassword()));
				frmLoginWindow.dispose();
			}
		});
		frmLoginWindow.getContentPane().add(btnLogin, BorderLayout.SOUTH);
		frmLoginWindow.getRootPane().setDefaultButton(btnLogin);
		
		JPanel panel_3 = new JPanel();
		frmLoginWindow.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_3.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblUsername = new JLabel("Username: ");
		panel.add(lblUsername);
		
		textField = new JTextField();
		lblUsername.setLabelFor(textField);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		panel.add(lblPassword);
		
		textField_1 = new JPasswordField();
		lblPassword.setLabelFor(textField_1);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setVgap(15);
		panel_3.add(panel_4, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_5, BorderLayout.SOUTH);
		
		lblPogresanLogin = new JLabel("Pogresan login");
		lblPogresanLogin.setVisible(false);
		panel_5.add(lblPogresanLogin);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setHgap(15);
		panel_3.add(panel_6, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setHgap(15);
		panel_3.add(panel_7, BorderLayout.EAST);
		
		
	}

}
