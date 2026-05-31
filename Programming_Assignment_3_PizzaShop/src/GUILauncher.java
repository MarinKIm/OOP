package pizza;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import pizza.Pepperoni;
import pizza.Cheese;
import pizza.DeepPanPizza;
import pizza.Bacon;
import pizza.Mushroom;
import pizza.Observer;
import pizza.OriginalPizza;
import pizza.Pineapple;
import pizza.PizzaOrTopping;
import pizza.PizzaShop;

import javax.swing.ListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class GUILauncher {

	private JFrame frmLauncher;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILauncher launcher = new GUILauncher();
					launcher.frmLauncher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		
	public GUILauncher(){	
		initialize();
	}
		
	public void initialize(){
		frmLauncher = new JFrame();
		frmLauncher.setTitle("Pizzorama");
		frmLauncher.setBounds(100, 100, 311, 156);
		frmLauncher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_1 = new JButton("Open PizzaShop");
		btnNewButton_1.setBounds(21, 14, 267, 101);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainApp mainWindow = new MainApp();
				mainWindow.frmPizzorama.setVisible(true);
			}
		});
		frmLauncher.getContentPane().setLayout(null);
		frmLauncher.getContentPane().add(btnNewButton_1);
	}
	
	
	private class MainApp{
		
		private JFrame frmPizzorama;
		private PizzaShop myPizzaShop;
		private PizzaListModel listModel;
	/**
	 * Create the application.
	 */
	public MainApp() {
		myPizzaShop = PizzaShop.getInstance();
		listModel = new PizzaListModel();
		myPizzaShop.getPizzaOven().registerObserver(listModel);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPizzorama = new JFrame();
		frmPizzorama.setTitle("Pizzorama");
		frmPizzorama.setBounds(100, 100, 579, 473);
		frmPizzorama.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmPizzorama.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(16, 16, 547, 339);
		frmPizzorama.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(213, 6, 323, 323);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(6, 6, 310, 311);
		panel_4.add(scrollPane);
		
		
		
		JList list = new JList(listModel); //TODO
		scrollPane.setViewportView(list);
		list.setCellRenderer(new PizzaRenderer());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(6, 6, 195, 324);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Pizza Options");
		lblName.setBounds(18, 18, 86, 16);
		panel_1.add(lblName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(18, 38, 159, 83);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Pizza Type", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(22, 34, 115, 27);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Original", "Deep pan"}));
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(18, 125, 159, 187);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Pizza toppings", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Extra cheese");
		chckbxNewCheckBox.setBounds(22, 34, 111, 23);
		panel_3.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Bacon");
		chckbxNewCheckBox_1.setBounds(22, 61, 69, 23);
		panel_3.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Mushrooms");
		chckbxNewCheckBox_2.setBounds(22, 88, 106, 23);
		panel_3.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Pineapples");
		chckbxNewCheckBox_3.setBounds(22, 115, 99, 23);
		panel_3.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxBulgogi = new JCheckBox("Pepperoni");
		chckbxBulgogi.setBounds(22, 142, 94, 23);
		panel_3.add(chckbxBulgogi);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(16, 359, 547, 76);
		frmPizzorama.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnNewButton = new JButton("Place Order");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PizzaOrTopping myPizza;
				if (comboBox.getSelectedItem() == "Original")
					 myPizza = new OriginalPizza(myPizzaShop.getOrderCounter());
				else
					 myPizza = new DeepPanPizza(myPizzaShop.getOrderCounter());

				if (chckbxNewCheckBox.isSelected())	myPizza = new Cheese(myPizza);
				if (chckbxNewCheckBox_1.isSelected())	myPizza = new Bacon(myPizza);
				if (chckbxNewCheckBox_2.isSelected())	myPizza = new Mushroom(myPizza);
				if (chckbxNewCheckBox_3.isSelected())	myPizza = new Pineapple(myPizza);
				if (chckbxBulgogi.isSelected())	myPizza = new Pepperoni(myPizza);
				
				myPizzaShop.placeOrder(myPizza);
				
				listModel.addElement(myPizza);
			}
		});
		btnNewButton.setBounds(40, 11, 102, 58);
		panel_5.add(btnNewButton);
	}
	
	private class PizzaListModel extends DefaultListModel<PizzaOrTopping> implements Observer{
		
		private static final long serialVersionUID = 1L;

		public PizzaListModel(){
			super();
		}

		@Override
		public void update(PizzaOrTopping pizza) {
			this.fireContentsChanged(pizza, 0, this.size());
		}		
	}
	
	private class PizzaRenderer extends JPanel implements ListCellRenderer<PizzaOrTopping> {
		private JLabel lbOrder = new JLabel();
	    private JTextArea taName = new JTextArea();
	    private final JLabel lblTimeLabel = new JLabel("Cooking time:");
	    private final JLabel lblOrderLabel = new JLabel("Order #:");
	    private final JLabel lblTimeVal = new JLabel("");
	    private final JLabel lblOrderVal = new JLabel("");
	    private final JLabel lblDescLabel = new JLabel("Description: ");
	    private final JTextArea textArea = new JTextArea();
	    private final JLabel lblPriceLabel = new JLabel("Price: $");
	    private final JLabel lblPriceVal = new JLabel("");
	    private final JLabel label = new JLabel("");
	 
	    public PizzaRenderer() {
	    	setBorder(new LineBorder(Color.LIGHT_GRAY));
	    	setSize(new Dimension(307, 81));
	    	GridBagLayout gridBagLayout = new GridBagLayout();
	    	gridBagLayout.columnWidths = new int[]{76, 51, 76, 96, 0};
	    	gridBagLayout.rowHeights = new int[]{26, 26, 26, 0};
	    	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
	    	setLayout(gridBagLayout);
	    	lblOrderLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	GridBagConstraints gbc_lblOrderLabel = new GridBagConstraints();
	    	gbc_lblOrderLabel.fill = GridBagConstraints.BOTH;
	    	gbc_lblOrderLabel.insets = new Insets(0, 0, 5, 5);
	    	gbc_lblOrderLabel.gridx = 0;
	    	gbc_lblOrderLabel.gridy = 0;
	    	add(lblOrderLabel, gbc_lblOrderLabel);
	    	lblOrderVal.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	GridBagConstraints gbc_lblOrderVal = new GridBagConstraints();
	    	gbc_lblOrderVal.fill = GridBagConstraints.BOTH;
	    	gbc_lblOrderVal.insets = new Insets(0, 0, 5, 5);
	    	gbc_lblOrderVal.gridx = 1;
	    	gbc_lblOrderVal.gridy = 0;
	    	add(lblOrderVal, gbc_lblOrderVal);
	    	lblDescLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	GridBagConstraints gbc_lblDescLabel = new GridBagConstraints();
	    	gbc_lblDescLabel.fill = GridBagConstraints.BOTH;
	    	gbc_lblDescLabel.insets = new Insets(0, 0, 5, 5);
	    	gbc_lblDescLabel.gridx = 2;
	    	gbc_lblDescLabel.gridy = 0;
	    	add(lblDescLabel, gbc_lblDescLabel);
	    	
	    	GridBagConstraints gbc_label = new GridBagConstraints();
	    	gbc_label.fill = GridBagConstraints.BOTH;
	    	gbc_label.insets = new Insets(0, 0, 5, 0);
	    	gbc_label.gridx = 3;
	    	gbc_label.gridy = 0;
	    	add(label, gbc_label);
	    	lblPriceLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	GridBagConstraints gbc_lblPriceLabel = new GridBagConstraints();
	    	gbc_lblPriceLabel.fill = GridBagConstraints.BOTH;
	    	gbc_lblPriceLabel.insets = new Insets(0, 0, 5, 5);
	    	gbc_lblPriceLabel.gridx = 0;
	    	gbc_lblPriceLabel.gridy = 1;
	    	add(lblPriceLabel, gbc_lblPriceLabel);
	    	lblPriceVal.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	GridBagConstraints gbc_lblPriceVal = new GridBagConstraints();
	    	gbc_lblPriceVal.fill = GridBagConstraints.BOTH;
	    	gbc_lblPriceVal.insets = new Insets(0, 0, 5, 5);
	    	gbc_lblPriceVal.gridx = 1;
	    	gbc_lblPriceVal.gridy = 1;
	    	add(lblPriceVal, gbc_lblPriceVal);
	    	textArea.setTabSize(5);
	    	textArea.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	GridBagConstraints gbc_textArea = new GridBagConstraints();
	    	gbc_textArea.gridwidth = 2;
	    	gbc_textArea.gridheight = 2;
	    	gbc_textArea.fill = GridBagConstraints.BOTH;
	    	gbc_textArea.insets = new Insets(0, 0, 5, 5);
	    	gbc_textArea.gridx = 2;
	    	gbc_textArea.gridy = 1;
	    	add(textArea, gbc_textArea);
	    	lblTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	GridBagConstraints gbc_lblTimeLabel = new GridBagConstraints();
	    	gbc_lblTimeLabel.anchor = GridBagConstraints.NORTH;
	    	gbc_lblTimeLabel.fill = GridBagConstraints.HORIZONTAL;
	    	gbc_lblTimeLabel.insets = new Insets(0, 0, 0, 5);
	    	gbc_lblTimeLabel.gridx = 0;
	    	gbc_lblTimeLabel.gridy = 2;
	    	add(lblTimeLabel, gbc_lblTimeLabel);
	    	lblTimeVal.setFont(new Font("Calibri", Font.PLAIN, 12));
	    	GridBagConstraints gbc_lblTimeVal = new GridBagConstraints();
	    	gbc_lblTimeVal.anchor = GridBagConstraints.NORTH;
	    	gbc_lblTimeVal.fill = GridBagConstraints.HORIZONTAL;
	    	gbc_lblTimeVal.insets = new Insets(0, 0, 0, 5);
	    	gbc_lblTimeVal.gridx = 1;
	    	gbc_lblTimeVal.gridy = 2;
	    	add(lblTimeVal, gbc_lblTimeVal);
	    }
	 
	 
	    @Override
	    public Component getListCellRendererComponent(JList<? extends PizzaOrTopping> list,
	    		PizzaOrTopping pizza, int index, boolean isSelected, boolean cellHasFocus) {
	 
	    	lblTimeVal.setText(pizza.getCookingTime()+"");
	    	lblOrderVal.setText(pizza.getOrderNum()+"");
	    	textArea.setText(pizza.getDescription());
	    	lblPriceVal.setText(pizza.cost()+"");
	    	setSize(new Dimension(310, 96));
	    	// when select item
	        if (isSelected) {
	        	lblTimeLabel.setBackground(list.getSelectionBackground());
		    	lblTimeVal.setBackground(list.getSelectionBackground());
		    	lblOrderLabel.setBackground(list.getSelectionBackground());
		    	lblOrderVal.setBackground(list.getSelectionBackground());
		    	lblDescLabel.setBackground(list.getSelectionBackground());
		    	textArea.setBackground(list.getSelectionBackground());
		    	lblPriceLabel.setBackground(list.getSelectionBackground());
		    	lblPriceVal.setBackground(list.getSelectionBackground());
		    	setBackground(list.getSelectionBackground());
	        } else { // when don't select
	        	lblTimeLabel.setBackground(list.getBackground());
		    	lblTimeVal.setBackground(list.getBackground());
		    	lblOrderLabel.setBackground(list.getBackground());
		    	lblOrderVal.setBackground(list.getBackground());
		    	lblDescLabel.setBackground(list.getBackground());
		    	textArea.setBackground(list.getBackground());
		    	lblPriceLabel.setBackground(list.getBackground());
		    	lblPriceVal.setBackground(list.getBackground());
	            setBackground(list.getBackground());
	        }
	        // when pizza changed
	        if (pizza.getIsFinished()){
	        	this.setBorder(new LineBorder(Color.GREEN));
	        }else
	        	this.setBorder(new LineBorder(Color.LIGHT_GRAY));
	    	
	        return this;
	    }
	}



	}
	
}
