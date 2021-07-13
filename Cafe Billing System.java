import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

class GUI2 extends JFrame
{
	
	private JRadioButton res, par;	
	private ButtonGroup group;
	private JLabel logo_name, delivery_type, date_time, table_no, name, address, contact, t_label, quantity_label;
	private ImageIcon logo;
	private JTextField table_no_tf, name_tf, address_tf, contact_tf;
	private JPanel input_panel, delivery_panel, t1_panel, t2_panel, quantity_panel, initial_panel, buttons_panel;
	private JPanel top1_panel, top2_panel;
	private JCheckBox tea, coffee, juice, iceCream, sandwich, noodles;
	private JComboBox quantity_box;
	String date;
	public float rate = 0;		//base rate

	private JLabel quantity_op_label, quantity_op, rate_label, rate_op_label;
	private JButton print, clear, calculate;
	private ImageIcon print_icon, clear_icon;
	private JLabel table_no_op, name_op, address_op, contact_op;
	String table_no_str, name_str, address_str, contact_str;
	private JLabel table_no2, name2, address2, contact2;
	private JLabel date_time2;
	private JLabel logo_name2;

	
	public GUI2() 
	{
		super("Cafe Management System");
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

		var label = new JLabel("Cafe Management System");
		label.setFont(new Font("Serif", Font.PLAIN, 25));

		logo = new ImageIcon("cafe.jpg");

		logo_name = new JLabel("", logo, 0);
		initial_panel = new JPanel();
		initial_panel.setLayout(new GridLayout(2, 0,0,0));
		
		JOptionPane.showMessageDialog(new JFrame(), "Welcome to Cafe Management System!", "Cafe Management System", JOptionPane.PLAIN_MESSAGE, logo);
		
		//Logo Icon and Name
		initial_panel.add(logo_name);
		initial_panel.add(label);

		//Date and Time
//		date = new SimpleDateFormat("EEEE yyyy-MM-dd   hh:mm:ss a zzz").format(new Date());
//		date_time = new JLabel(date);
//		initial_panel.add(date_time);
			
		add(initial_panel);	
	}
	
	
	public void Input()
	{		
		input_panel = new JPanel();
		input_panel.setLayout(new GridLayout(5, 2, 5, 10));
					
		delivery_panel = new JPanel();
		delivery_panel.setLayout(new GridLayout(1, 3));			
		
		//Delivery Type
		delivery_type = new JLabel("Delivery Type:");
	//	delivery_panel.add(delivery_type);		
		res = new JRadioButton("in-Restaurant");
		res.setActionCommand("res");
		par = new JRadioButton("Parcel");
		par.setActionCommand("par");
		
				
		group = new ButtonGroup();
		group.add(res);
		group.add(par);
		delivery_panel.add(res);
		delivery_panel.add(par);
		
	//	add(delivery_panel);
		
		input_panel.add(delivery_type);					
		input_panel.add(delivery_panel);		
		
		//Table Number
		table_no = new JLabel("Table Number");		
		table_no_tf = new JTextField("", 5);
		input_panel.add(table_no);
		input_panel.add(table_no_tf);						
		
		//Parcel Details
		name = new JLabel("Name");
		address = new JLabel("Address");
		contact = new JLabel("Contact Number");
		name_tf = new JTextField("", 10);
		address_tf = new JTextField("", 20);
		contact_tf = new JTextField("", 10);
		input_panel.add(name);
		input_panel.add(name_tf);					
		input_panel.add(address);
		input_panel.add(address_tf);
		input_panel.add(contact);
		input_panel.add(contact_tf);
				
		add(input_panel);
		
	
		
		// Disable Extra Labels & TextFields depending on RadioButton Selected
		res.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				if(res.isSelected())
				{
					name.setEnabled(false);
					address.setEnabled(false);
					contact.setEnabled(false); 
					name_tf.setEditable(false);
					address_tf.setEditable(false);
					contact_tf.setEditable(false);	
					name_tf.setEnabled(false);
					address_tf.setEnabled(false);
					contact_tf.setEnabled(false);
					table_no.setEnabled(true);
					table_no_tf.setEnabled(true);					
					table_no_tf.setEditable(true);		
				}
			}
		});
		
		par.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				if(par.isSelected())
				{
					table_no.setEnabled(false);
					table_no_tf.setEnabled(false);					
					table_no_tf.setEditable(false);
					name.setEnabled(true);
					address.setEnabled(true);
					contact.setEnabled(true); 
					name_tf.setEditable(true);
					address_tf.setEditable(true);
					contact_tf.setEditable(true);	
					name_tf.setEnabled(true);
					address_tf.setEnabled(true);
					contact_tf.setEnabled(true);				
				}
			}
		});								
	
	}
	
	public void Menu()
	{
		top1_panel = new JPanel();
		top1_panel.setLayout(new GridLayout(1, 3));
		
		top2_panel = new JPanel();
		top2_panel.setLayout(new GridLayout(1, 3));
		
		t1_panel = new JPanel();
		t1_panel.setLayout(new GridLayout(2, 1));
		
		t2_panel = new JPanel();
		t2_panel.setLayout(new GridLayout(2, 1));
		
		t_label = new JLabel("Menu:");
		
		tea = new JCheckBox("Tea", false);
		coffee = new JCheckBox("Coffee", false);
		juice = new JCheckBox("Juice", false);
		iceCream = new JCheckBox("Ice Cream", false);
		sandwich = new JCheckBox("Sandwich", false);
		noodles = new JCheckBox("Noodles", false);
		
		
	/*	ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected)
					rate = rate + 15;
			}
		};
		
		
		
		tea.addActionListener(actionListener);
		coffee.addActionListener(actionListener);
		juice.addActionListener(actionListener);
		iceCream.addActionListener(actionListener);
		sandwich.addActionListener(actionListener);
		noodles.addActionListener(actionListener);
		*/
		
		ItemListener itemListener = new ItemListener()
		{
			public void itemStateChanged(ItemEvent itemEvent)
			{
				AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED)
				{
					rate = rate + 50;
				}
			}
		};
			
		tea.addItemListener(itemListener);
		coffee.addItemListener(itemListener);
		juice.addItemListener(itemListener);
		iceCream.addItemListener(itemListener);
		sandwich.addItemListener(itemListener);
		noodles.addItemListener(itemListener);
		
		top1_panel.add(tea);
		top1_panel.add(coffee);
		top1_panel.add(juice);
		top2_panel.add(iceCream);
		top2_panel.add(sandwich);
		top2_panel.add(noodles);
	
		t1_panel.add(top1_panel);
		t1_panel.add(top2_panel);
					
		t2_panel.add(t_label);
		t2_panel.add(t1_panel);
		add(t2_panel);
		
	
	}
	
	public void Quantity() 
	{
		quantity_label = new JLabel("Quantity: ");
		quantity_op_label = new JLabel("Quantity: ");
		quantity_op = new JLabel();
		quantity_panel = new JPanel();
		quantity_panel.setLayout(new GridLayout(1, 1,10,10));
		String[] quantity = {"1", "2", "3", "4", "5"};
		
		JComboBox<String>quantity_box = new JComboBox<String>();
		for(int i = 0; i < quantity.length; i++)		
			quantity_box.addItem(quantity[i]);
		
		quantity_box.setSelectedIndex(0);
						
		quantity_panel.add(quantity_label);
		quantity_panel.add(quantity_box);
		
		
		quantity_box.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				quantity_op.setText((String)((JComboBox)e.getSource()).getSelectedItem());
			}	
		});
		

		add(quantity_panel);
	} 
	
	


	
	public void Output()
	{	
		print_icon = new ImageIcon("print.png");
		clear_icon = new ImageIcon("clear.png");
		
		buttons_panel = new JPanel();
		buttons_panel.setLayout(new GridLayout(1, 0, 80, 10));
					
		table_no2 = new JLabel("Table No.: ");
		name2 = new JLabel("Name: ");
		address2 = new JLabel("Address: ");
		contact2= new JLabel("Contact Number: ");
		
				
				
		String rate_str;
		rate_str = Float.toString(rate);
		rate_label = new JLabel("Rate: ");
		rate_op_label = new JLabel(rate_str);	
		
		
		print = new JButton("Print");
		print.setRolloverIcon(print_icon);
		print.setRolloverEnabled(true);
		clear = new JButton("Clear");
	
		
		buttons_panel.add(print);
		buttons_panel.add(clear);
			
		add(buttons_panel);
						
				
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				table_no_tf.setText("");
				name_tf.setText("");
				address_tf.setText("");
				contact_tf.setText("");
				group.clearSelection();
				name.setEnabled(true);
				address.setEnabled(true);
				contact.setEnabled(true); 
					
				name_tf.setEditable(true);
				address_tf.setEditable(true);
				contact_tf.setEditable(true);	
				name_tf.setEnabled(true);
				address_tf.setEnabled(true);
				contact_tf.setEnabled(true);
				table_no.setEnabled(true);
				table_no_tf.setEnabled(true);					
				table_no_tf.setEditable(true);
				
				juice.setSelected(false);
				sandwich.setSelected(false);
				noodles.setSelected(false);
				iceCream.setSelected(false);
				coffee.setSelected(false);
				tea.setSelected(false);
				
					
			}
		});
		
		print.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFrame output = new JFrame();
				output.setLayout(new GridLayout(9, 2,20, 0));

				String rate_str;
				rate_str = Float.toString(rate);
				rate_label = new JLabel("Rate: ");
				rate_op_label = new JLabel(rate_str);

				var label = new JLabel("Cafe Management System");
				label.setFont(new Font("Serif", Font.BOLD, 12));

				logo_name2 = new JLabel("", logo,SwingConstants.CENTER);

				date = new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss").format(new Date());
				date_time2 = new JLabel(date,SwingConstants.CENTER);

				JLabel temp = new JLabel("");
				JLabel temp2 = new JLabel("");

				output.add(logo_name2);
				output.add(temp);
				output.add(label);
				output.add(temp2);

				table_no_str = table_no_tf.getText();
				name_str = name_tf.getText();
				address_str = address_tf.getText();
				contact_str = contact_tf.getText();
				
				table_no_op = new JLabel(table_no_str,SwingConstants.CENTER);
				name_op = new JLabel(name_str,SwingConstants.CENTER);
				address_op = new JLabel(address_str,SwingConstants.CENTER);
				contact_op = new JLabel(contact_str,SwingConstants.CENTER);
				
				output.add(table_no2);
				output.add(table_no_op);
				output.add(name2);
				output.add(name_op);
				output.add(address2);
				output.add(address_op);
				output.add(contact2);
				output.add(contact_op);	
				
				output.add(rate_label);
				output.add(rate_op_label);
				output.add(quantity_op_label);				
				output.add(quantity_op);
				output.add(date_time2);

				output.pack();
				output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				output.setLocationRelativeTo(null);
				output.setSize(350 ,400);
				output.setVisible(true);



				JOptionPane.showMessageDialog(null, "Your Order Has Been Placed!");
			}
		});
		
	}
			
}


class GUI
{
	public static void main(String[] args) 
	{
		GUI2 gui_obj = new GUI2();	
		gui_obj.Input();		
		gui_obj.Menu();
		gui_obj.Quantity();			
		gui_obj.Output();	
				
		gui_obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui_obj.setLocationByPlatform(true);
		gui_obj.setSize(575,550);
		gui_obj.setVisible(true);
		
	}
}