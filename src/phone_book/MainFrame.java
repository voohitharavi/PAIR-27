/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
   BUTTONS ADDED.
 */
package phone_book;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author comqsjb
 */
public class MainFrame extends JFrame
{
	JTextField srchField = new JTextField(15);
	JButton srchBtn = new JButton("SEARCH");
        
	
	JButton addBtn = new JButton("ADD");
	JRadioButton rbtn1 = new JRadioButton("General");
	JRadioButton rbtn2 = new JRadioButton("University");
	JRadioButton rbtn3 = new JRadioButton("Company");
	ButtonGroup buttonGroup = new ButtonGroup();
	
	JLabel nameLabel = new JLabel("NAME");
	JTextField nameField = new JTextField(15);
	JLabel phoneLabel = new JLabel("PHONE NUMBER");
	JTextField phoneField = new JTextField(15);
	JLabel majorLabel = new JLabel("MAJOR");
	JTextField majorField = new JTextField(15);
	JLabel yearLabel = new JLabel("YEAR");
	JTextField yearField = new JTextField(15);
		
	JTextField delField = new JTextField(15);
	JButton delBtn = new JButton("DEL");
        
        
        /////ADDED
        JButton changeNumber = new JButton("Change Number");
        JButton upperCase = new JButton("Upper Case");
        JButton delAllbtn = new JButton("Delete All");
        JButton srchNumberBtn = new JButton("SearchNum");
        
        /////new buttons
	
	JTextArea textArea = new JTextArea(10, 25);
        

	public MainFrame(String title)
	{
		super(title);
		setBounds(150, 300, 400, 500);
		setSize(800,400);
		setLayout(new GridLayout(0,2,0,0));
		Border border = BorderFactory.createEtchedBorder();
		
		Border srchBorder = BorderFactory.createTitledBorder(border, "Search");
		JPanel srchPanel = new JPanel();
		srchPanel.setBorder(srchBorder);
		srchPanel.setLayout(new FlowLayout());
		srchPanel.add(srchField);
		srchPanel.add(srchBtn);
                srchPanel.add(srchNumberBtn);
		
		Border addBorder=BorderFactory.createTitledBorder(border, "Add");
		JPanel addPanel = new JPanel();
		addPanel.setBorder(addBorder);
		addPanel.setLayout(new FlowLayout());
		
		JPanel addInputPanel = new JPanel();
		addInputPanel.setLayout(new GridLayout(0,2,5,5));
		
		buttonGroup.add(rbtn1);
		buttonGroup.add(rbtn2);
		buttonGroup.add(rbtn3);
		
		addPanel.add(rbtn1);
		addPanel.add(rbtn2);
		addPanel.add(rbtn3);
		addPanel.add(addBtn);
                addPanel.add(changeNumber);
                addPanel.add(upperCase);
		
		addInputPanel.add(nameLabel);
		addInputPanel.add(nameField);
		addInputPanel.add(phoneLabel);
		addInputPanel.add(phoneField);
		addInputPanel.add(majorLabel);
		addInputPanel.add(majorField);
		addInputPanel.add(yearLabel);
		addInputPanel.add(yearField);
		
		majorLabel.setVisible(false);
		majorField.setVisible(false);
		yearLabel.setVisible(false);
		yearField.setVisible(false);
		
		rbtn1.setSelected(true);
		addPanel.add(addInputPanel);
                
                textArea.setLineWrap(true);
		
		rbtn1.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
						if(e.getStateChange() == ItemEvent.SELECTED)
						{
							majorLabel.setVisible(false);
							majorField.setVisible(false);
							yearLabel.setVisible(false);
							yearField.setVisible(false);			
							majorField.setText("");
							yearField.setText("");
						}
					}
				}
		);
		
		rbtn2.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
						if(e.getStateChange() == ItemEvent.SELECTED)
						{
							majorLabel.setVisible(true);
							majorLabel.setText("MAJOR");
							majorField.setVisible(true);
							yearLabel.setVisible(true);
							yearField.setVisible(true);
						}
					}
				}
		);
		
		rbtn3.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
						if(e.getStateChange() == ItemEvent.SELECTED)
						{
							majorLabel.setVisible(true);
							majorLabel.setText("COMPANY");
							majorField.setVisible(true);
							yearLabel.setVisible(false);
							yearField.setVisible(false);
							yearField.setText("");
						}
					}
				}
		);
		
		Border delBorder = BorderFactory.createTitledBorder(border, "Delete");
		JPanel delPanel = new JPanel();
		delPanel.setBorder(delBorder);
		delPanel.setLayout(new FlowLayout());
		delPanel.add(delField);
		delPanel.add(delBtn);
                delPanel.add(delAllbtn); //extraBtn2
		
		JScrollPane scrollTextArea = new JScrollPane(textArea);	
		Border textBorder=BorderFactory.createTitledBorder(border, "Infomation Board");
		scrollTextArea.setBorder(textBorder);
		
		JPanel actionPanel = new JPanel();
		actionPanel.setLayout(new BorderLayout());
		actionPanel.add(srchPanel, BorderLayout.NORTH);
		actionPanel.add(addPanel, BorderLayout.CENTER);
		actionPanel.add(delPanel, BorderLayout.SOUTH);
		
		add(actionPanel);
		add(scrollTextArea);
		
		srchBtn.addActionListener(new SearchEventHandler(srchField, textArea));
                srchNumberBtn.addActionListener(new SearchNumberEventHandler(srchField, textArea));
		addBtn.addActionListener(new AddEventHandler(nameField, phoneField, majorField, yearField, textArea));
		delBtn.addActionListener(new DeleteEventHandler(delField, textArea));
                changeNumber.addActionListener(new ChangeHandlers(nameField, phoneField, majorField, yearField, textArea));
                upperCase.addActionListener(new ConvertUpperCaseHandler(nameField));
                delAllbtn.addActionListener(new ExtraHandler(delField, textArea));
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);	
	}
}