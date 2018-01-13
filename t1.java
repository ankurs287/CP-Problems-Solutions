import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.border.MatteBorder;

class t1 extends JFrame {

	private JPanel contentPane;
	private JTextField ai;
	private JTextField mi;
	private JTextField oi;
	private JTextField pi;
	private JTextField bi;
	private JTextField ti;
	private JTextField au;
	private JTextField mu;
	private JTextField ou;
	private JTextField pu;
	private JTextField bu;
	private JTextField tu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t1 frame = new t1();
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
	public t1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("IIITD Fruit Stall", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 30));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBorder(null);
		lblNewLabel.setBackground(new Color(204, 0, 0));
		lblNewLabel.setBounds(0, 0, 684, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblInventory = new JLabel("Inventory", SwingConstants.CENTER);
		lblInventory.setForeground(new Color(255, 255, 255));
		lblInventory.setOpaque(true);
		lblInventory.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblInventory.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblInventory.setBackground(new Color(0, 102, 153));
		lblInventory.setBounds(0, 50, 342, 50);
		contentPane.add(lblInventory);
		
		JLabel lblUser = new JLabel("User", SwingConstants.CENTER);
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setOpaque(true);
		lblUser.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblUser.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblUser.setBackground(new Color(0, 102, 153));
		lblUser.setBounds(342, 50, 342, 50);
		contentPane.add(lblUser);
		
		JLabel lblItems = new JLabel("Items");
		lblItems.setForeground(new Color(255, 255, 255));
		lblItems.setOpaque(true);
		lblItems.setBounds(new Rectangle(0, 0, 0, 40));
		lblItems.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblItems.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblItems.setBackground(new Color(0, 102, 153));
		lblItems.setBounds(0, 100, 171, 40);
		contentPane.add(lblItems);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(255, 255, 255));
		lblQuantity.setOpaque(true);
		lblQuantity.setBounds(new Rectangle(0, 0, 0, 40));
		lblQuantity.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblQuantity.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblQuantity.setBackground(new Color(0, 102, 153));
		lblQuantity.setBounds(171, 100, 171, 40);
		contentPane.add(lblQuantity);
		
		JLabel lblItems_1 = new JLabel("Items");
		lblItems_1.setForeground(new Color(255, 255, 255));
		lblItems_1.setOpaque(true);
		lblItems_1.setBounds(new Rectangle(0, 0, 0, 40));
		lblItems_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblItems_1.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblItems_1.setBackground(new Color(0, 102, 153));
		lblItems_1.setBounds(2*171, 100, 171, 40);
		contentPane.add(lblItems_1);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setForeground(new Color(255, 255, 255));
		lblQuantity_1.setOpaque(true);
		lblQuantity_1.setBounds(new Rectangle(0, 0, 0, 40));
		lblQuantity_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblQuantity_1.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblQuantity_1.setBackground(new Color(0, 102, 153));
		lblQuantity_1.setBounds(3*171, 100, 171, 40);
		contentPane.add(lblQuantity_1);
		
		JLabel lblApple = new JLabel("Apple");
		lblApple.setOpaque(true);
		lblApple.setBounds(new Rectangle(0, 0, 0, 40));
		lblApple.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblApple.setAlignmentY(Component.TOP_ALIGNMENT);
		lblApple.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblApple.setBorder(null);
		lblApple.setBackground(new Color(220, 20, 60));
		lblApple.setBounds(0, 140, 171, 40);
		contentPane.add(lblApple);
		
		JLabel lblMango = new JLabel("Mango");
		lblMango.setOpaque(true);
		lblMango.setBounds(new Rectangle(0, 0, 0, 40));
		lblMango.setAlignmentY(Component.TOP_ALIGNMENT);
		lblMango.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblMango.setBorder(null);
		lblMango.setBackground(new Color(255, 255, 0));
		lblMango.setBounds(0, 180, 171, 40);
		contentPane.add(lblMango);
		
		JLabel lblOrange = new JLabel("Orange");
		lblOrange.setOpaque(true);
		lblOrange.setBounds(new Rectangle(0, 0, 0, 40));
		lblOrange.setAlignmentY(Component.TOP_ALIGNMENT);
		lblOrange.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblOrange.setBorder(null);
		lblOrange.setBackground(new Color(255, 153, 0));
		lblOrange.setBounds(0, 220, 171, 40);
		contentPane.add(lblOrange);
		
		JLabel lblPineapple = new JLabel("Pineapple");
		lblPineapple.setOpaque(true);
		lblPineapple.setBounds(new Rectangle(0, 0, 0, 40));
		lblPineapple.setAlignmentY(Component.TOP_ALIGNMENT);
		lblPineapple.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblPineapple.setBorder(null);
		lblPineapple.setBackground(new Color(102, 153, 102));
		lblPineapple.setBounds(0, 260, 171, 40);
		contentPane.add(lblPineapple);
		
		JLabel lblBanana = new JLabel("Banana");
		lblBanana.setOpaque(true);
		lblBanana.setBounds(new Rectangle(0, 0, 0, 40));
		lblBanana.setAlignmentY(Component.TOP_ALIGNMENT);
		lblBanana.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblBanana.setBorder(null);
		lblBanana.setBackground(Color.YELLOW);
		lblBanana.setBounds(0, 300, 171, 40);
		contentPane.add(lblBanana);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setOpaque(true);
		lblTotal.setBounds(new Rectangle(0, 0, 0, 40));
		lblTotal.setAlignmentY(Component.TOP_ALIGNMENT);
		lblTotal.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblTotal.setBorder(null);
		lblTotal.setBackground(Color.LIGHT_GRAY);
		lblTotal.setBounds(0, 340, 171, 40);
		contentPane.add(lblTotal);
		
		JLabel lblApple_1 = new JLabel("Apple");
		lblApple_1.setOpaque(true);
		lblApple_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblApple_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblApple_1.setBorder(null);
		lblApple_1.setBackground(new Color(220, 20, 60));
		lblApple_1.setBounds(342, 140, 171, 40);
		contentPane.add(lblApple_1);
		
		JLabel lblMango_1 = new JLabel("Mango");
		lblMango_1.setOpaque(true);
		lblMango_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblMango_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblMango_1.setBorder(null);
		lblMango_1.setBackground(new Color(255, 255, 0));
		lblMango_1.setBounds(342, 180, 171, 40);
		contentPane.add(lblMango_1);
		
		JLabel lblOrange_1 = new JLabel("Orange");
		lblOrange_1.setOpaque(true);
		lblOrange_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblOrange_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblOrange_1.setBorder(null);
		lblOrange_1.setBackground(new Color(255, 153, 0));
		lblOrange_1.setBounds(342, 220, 171, 40);
		contentPane.add(lblOrange_1);
		
		JLabel lblPineapple_1 = new JLabel("Pineapple");
		lblPineapple_1.setOpaque(true);
		lblPineapple_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblPineapple_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblPineapple_1.setBorder(null);
		lblPineapple_1.setBackground(new Color(102, 153, 102));
		lblPineapple_1.setBounds(342, 260, 171, 40);
		contentPane.add(lblPineapple_1);
		
		JLabel lblBanana_1 = new JLabel("Banana");
		lblBanana_1.setOpaque(true);
		lblBanana_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblBanana_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblBanana_1.setBorder(null);
		lblBanana_1.setBackground(Color.YELLOW);
		lblBanana_1.setBounds(342, 300, 171, 40);
		contentPane.add(lblBanana_1);
		
		JLabel lblTotal_1 = new JLabel("Total");
		lblTotal_1.setOpaque(true);
		lblTotal_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblTotal_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		lblTotal_1.setBorder(null);
		lblTotal_1.setBackground(Color.LIGHT_GRAY);
		lblTotal_1.setBounds(342, 340, 171, 40);
		contentPane.add(lblTotal_1);
		
		ai = new JTextField();
		ai.setBackground(new Color(255, 255, 255));
		ai.setText("10");
		ai.setEditable(false);
		ai.setBounds(171, 140, 171, 40);
		contentPane.add(ai);
		ai.setColumns(10);
		
		mi = new JTextField();
		mi.setBackground(new Color(255, 255, 255));
		mi.setText("6");
		mi.setEditable(false);
		mi.setColumns(10);
		mi.setBounds(171, 180, 171, 40);
		contentPane.add(mi);
		
		oi = new JTextField();
		oi.setBackground(new Color(255, 255, 255));
		oi.setText("8");
		oi.setEditable(false);
		oi.setColumns(10);
		oi.setBounds(171, 220, 171, 40);
		contentPane.add(oi);
		
		pi = new JTextField();
		pi.setBackground(new Color(255, 255, 255));
		pi.setText("4");
		pi.setEditable(false);
		pi.setColumns(10);
		pi.setBounds(171, 260, 171, 40);
		contentPane.add(pi);
		
		bi = new JTextField();
		bi.setBackground(new Color(255, 255, 255));
		bi.setText("2");
		bi.setEditable(false);
		bi.setColumns(10);
		bi.setBounds(171, 300, 171, 40);
		contentPane.add(bi);
		
		ti = new JTextField();
		ti.setBackground(new Color(255, 255, 255));
		ti.setText("30");
		ti.setEditable(false);
		ti.setColumns(10);
		ti.setBounds(171, 340, 171, 40);
		contentPane.add(ti);
		
		au = new JTextField();
		au.setBackground(new Color(255, 255, 255));
		au.setText("0");
		au.setColumns(10);
		au.setBounds(513, 140, 171, 40);
		contentPane.add(au);
		
		mu = new JTextField();
		mu.setBackground(new Color(255, 255, 255));
		mu.setText("0");
		mu.setColumns(10);
		mu.setBounds(513, 180, 171, 40);
		contentPane.add(mu);
		
		ou = new JTextField();
		ou.setBackground(new Color(255, 255, 255));
		ou.setText("0");
		ou.setColumns(10);
		ou.setBounds(513, 220, 171, 40);
		contentPane.add(ou);
		
		pu = new JTextField();
		pu.setBackground(new Color(255, 255, 255));
		pu.setText("0");
		pu.setColumns(10);
		pu.setBounds(513, 260, 171, 40);
		contentPane.add(pu);
		
		bu = new JTextField();
		bu.setBackground(new Color(255, 255, 255));
		bu.setText("0");
		bu.setColumns(10);
		bu.setBounds(513, 300, 171, 40);
		contentPane.add(bu);
		
		tu = new JTextField();
		tu.setBackground(new Color(255, 255, 255));
		tu.setText("0");
		tu.setEditable(false);
		tu.setColumns(10);
		tu.setBounds(513, 340, 171, 40);
		contentPane.add(tu);
		
		JButton submit = new JButton("Submit");
		submit.setBackground(new Color(102, 153, 102));
		submit.setForeground(new Color(255, 255, 255));
		submit.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 18));
		submit.setBounds(513, 380, 171, 50);
		contentPane.add(submit);

		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(".\\fruit.jpeg"));
		label.setOpaque(true);
		label.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		label.setBounds(new Rectangle(0, 0, 0, 40));
		label.setBorder(null);
		label.setBackground(Color.WHITE);
		label.setAlignmentY(0.0f);
		label.setBounds(0, 380, 171, 50);
		contentPane.add(label);
		
		JButton clear = new JButton("Clear");
		clear.setBackground(new Color(204, 255, 0));
		clear.setForeground(new Color(255, 255, 255));
		clear.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 18));
		clear.setBounds(342, 380, 171, 50);
		contentPane.add(clear);
		clear.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  au.setText("0");
	    	  mu.setText("0");
	    	  pu.setText("0");
	    	  ou.setText("0");
	    	  bu.setText("0");
	    	  tu.setText("0");
	      }
	    });
		
		JButton close = new JButton("Close");
		close.setBackground(new Color(255, 0, 51));
		close.setForeground(new Color(255, 255, 255));
		close.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 18));
		close.setBounds(171, 380, 171, 50);
		contentPane.add(close);
		
		close.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  System.exit(0);
	      }
	    });
		 submit.addActionListener(new ActionListener()
		    {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  int Au=Integer.parseInt(au.getText());
		    	  int Mu=Integer.parseInt(mu.getText());
		    	  int Ou=Integer.parseInt(ou.getText());
		    	  int Pu=Integer.parseInt(pu.getText());
		    	  int Bu=Integer.parseInt(bu.getText());
		    	  
		    	  int Ai=Integer.parseInt(ai.getText());
		    	  int Mi=Integer.parseInt(mi.getText());
		    	  int Oi=Integer.parseInt(oi.getText());
		    	  int Pi=Integer.parseInt(pi.getText());
		    	  int Bi=Integer.parseInt(bi.getText());
		    	  
		    	  int Tu=0;
		    	  if(Au > Ai) au.setText("0");
		    	  else
		    	  {
		    	  	if(Au==Ai)
		    			  au.setEditable(false);
		    		  ai.setText(""+(Ai-=Au));
		    		  Tu+=Au;
		    		  		    			  
		    	  }
		    	  if(Mu > Mi) mu.setText("0");
		    	  else
		    	  {
					if(Mu==Mi)
						mu.setEditable(false);
					mi.setText(""+(Mi-=Mu));
					Tu+=Mu;
		    		  
		    	  }
		    	  if(Ou > Oi) ou.setText("0");
		    	  else
		    	  {
		    	  	if(Ou==Oi)
		    			  ou.setEditable(false);
		    		  oi.setText(""+(Oi-=Ou));
		    		  Tu+=Ou;
		    		  
		    	  }
		    	  if(Pu > Pi) pu.setText("0");
		    	  else
		    	  {
		    	  	if(Pu==Pi)
		    			  pu.setEditable(false);
		    		  pi.setText(""+(Pi-=Pu));
		    		  Tu+=Pu;
		    		  
		    	  }
		    	  if(Bu > Bi) bu.setText("0");
		    	  else
		    	  {
		    	  	if(Bu==Bi)
		    			  bu.setEditable(false);
		    		  bi.setText(""+(Bi-=Bu));
		    		  Tu+=Bu;
		    		  
		    	  }
		    	  
		    	  tu.setText(""+Tu);
		    	  ti.setText(""+(Ai+Mi+Oi+Pi+Bi));
		    	  
		    	  
		    	  
		      }
		    });
		
	}
}
