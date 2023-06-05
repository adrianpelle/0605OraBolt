package orabolt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OraBoltMain {

	private JFrame frmrabolt;
	private JTextField txtMegnevezes;
	private JList listOrak;
	private List<Ora> orak;
	private DefaultListModel<Ora> listModel;
	private JComboBox cmbTipus;
	private JSpinner spinner;
	private JCheckBox ckbVizallo;
	private Ora ora;
	private JButton btnFelvitel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OraBoltMain window = new OraBoltMain();
					window.frmrabolt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OraBoltMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AdatBazisKezelo.csatlakozas();
		frmrabolt = new JFrame();
		frmrabolt.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				if (JOptionPane.showOptionDialog(frmrabolt, "Biztos ki akar lépni?", "Kilépés", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						null, null, e)==(JOptionPane.YES_OPTION)) {
					System.exit(0);
					//frmFoAblak.disable();
				}
			}
		});

		frmrabolt.setTitle("Órabolt");
		frmrabolt.setBounds(100, 100, 600, 700);
		frmrabolt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmrabolt.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Típus:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(23, 91, 90, 14);
		frmrabolt.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aktuális készlet");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(303, 18, 242, 14);
		frmrabolt.getContentPane().add(lblNewLabel_1);
		
		JLabel lblr = new JLabel("Ár:");
		lblr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblr.setBounds(23, 139, 90, 14);
		frmrabolt.getContentPane().add(lblr);
		
		txtMegnevezes = new JTextField();
		txtMegnevezes.setBounds(135, 41, 118, 20);
		frmrabolt.getContentPane().add(txtMegnevezes);
		txtMegnevezes.setColumns(10);
		
		cmbTipus = new JComboBox();
		cmbTipus.setModel(new DefaultComboBoxModel(OraTipusok.values()));

		cmbTipus.setBounds(135, 87, 118, 22);
		frmrabolt.getContentPane().add(cmbTipus);
		

		
		

		
		spinner = new JSpinner();
		spinner.setBounds(135, 136, 118, 20);
		frmrabolt.getContentPane().add(spinner);
		
		JLabel lblVzll = new JLabel("Vízálló:");
		lblVzll.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVzll.setBounds(23, 194, 90, 14);
		frmrabolt.getContentPane().add(lblVzll);
		
		ckbVizallo = new JCheckBox("vízálló");
		ckbVizallo.setBounds(135, 190, 97, 23);
		frmrabolt.getContentPane().add(ckbVizallo);
		
		orak = new ArrayList<Ora>();
		listModel = new DefaultListModel<Ora>();
		
		listOrak = new JList();
		listOrak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (listOrak.getSelectedIndex() != -1) {
					String vizAllo;
					if (((Ora) listOrak.getSelectedValue()).isVizallo()) {
						vizAllo="vízálló";
					} else {
						vizAllo="nem vízálló";
					}
					JOptionPane.showMessageDialog(frmrabolt, ((Ora) listOrak.getSelectedValue()).getMegnevezes()+" "+((Ora) listOrak.getSelectedValue()).getTipus()
							+" "+((Ora) listOrak.getSelectedValue()).getAr()+" "+vizAllo, "Óra adatai", JOptionPane.INFORMATION_MESSAGE);
					//			JOptionPane.showMessageDialog(frmrabolt, "Megnevezés nem lehet üres", "Figyelmeztetés", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		listOrak.setBounds(303, 43, 242, 300);
		frmrabolt.getContentPane().add(listOrak);
		listOrak.setModel(listModel);

		
		/*
		 * 		betegsegek = new ArrayList<Betegseg>();
		listModel = new DefaultListModel<Betegseg>();

		
		listBetegsegek = new JList();
//??		listBetegsegek.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listBetegsegek.setBounds(22, 11, 421, 365);
		frmFoAblak.getContentPane().add(listBetegsegek);
		listBetegsegek.setModel(listModel);
		 */
		
		JLabel lblNewLabel_1_1 = new JLabel("Megnevezés:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(23, 44, 90, 14);
		frmrabolt.getContentPane().add(lblNewLabel_1_1);
		
		btnFelvitel = new JButton("Új termék felvitele");
		btnFelvitel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ellenorzes();

			}


		});
		btnFelvitel.setBounds(79, 234, 174, 23);
		frmrabolt.getContentPane().add(btnFelvitel);
		
		JButton btnKilepes = new JButton("KILÉPÉS");
		btnKilepes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmrabolt.dispatchEvent(new WindowEvent(frmrabolt, WindowEvent.WINDOW_CLOSING));

			}
		});
		btnKilepes.setBounds(339, 359, 174, 23);
		frmrabolt.getContentPane().add(btnKilepes);
	}
	
	
	private void ellenorzes() {

		if (!txtMegnevezes.getText().isBlank()) {
			
		//	betegseg = new Betegseg(txtMegnevezes.getText(), (BetegsegLefolyas)cmbLefolyas.getSelectedItem(), (BetegsegTipus)cmbTipus.getSelectedItem());
			ora = new Ora(txtMegnevezes.getText(), (OraTipusok)cmbTipus.getSelectedItem(), (int) spinner.getValue(), ckbVizallo.isSelected());

			
			orak.add(ora);
			listModel.addElement(ora);

			AdatBazisKezelo.ujOra(ora);
			
			/*
			listModel.addElement(new Ora(txtMegnevezes.getText(), (OraTipusok)cmbTipus.getSelectedItem()));

			 * 		FelvitelModositAblak sajatablak = new FelvitelModositAblak(); //létrejön a példány de nem jelenik meg
		sajatablak.setVisible(true); //na most megjelenik
		
		if (sajatablak.getDialogusBezarasEredmeny() == DialogResult.OK) {
			betegsegek.add(sajatablak.getBetegseg());
			listModel.addElement(sajatablak.getBetegseg());

			 */
			
		} else {
			JOptionPane.showMessageDialog(frmrabolt, "Megnevezés nem lehet üres", "Figyelmeztetés", JOptionPane.WARNING_MESSAGE);
		}


	}
	
	
}
