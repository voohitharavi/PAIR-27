/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phone_book;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author comqsjb
 */
public class AddEventHandler implements ActionListener
{
	JTextField name;
	JTextField phone;
	JTextField major;
	JTextField year;
	JTextField company;
	JTextArea text;
	Vector<String> inputList = new Vector<String>();
	
	boolean isAdded;
	
	PhoneInfo info;
	public AddEventHandler(JTextField nameField, JTextField phoneField, JTextField majorField, JTextField yearField, JTextArea textArea)
	{
		name = nameField;
		phone = phoneField;
		major = majorField;
		year = yearField;
		text = textArea;
                company = majorField;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		if(major.getText().equals("") == false && year.getText().equals("") == true)
		{
			//company = major;
			//info = new PhoneCompanyInfo(name.getText(), phone.getText(), company.getText());
			//isAdded = manager.infoStorage.add(info);
                        isAdded = manager.addPhoneCompanyInfo(name.getText(), phone.getText(), company.getText());
		}		
		else if(major.getText().equals("") == false && year.getText().equals("") == false)
		{
			//info = new PhoneUnivInfo(name.getText(), phone.getText(), major.getText(), Integer.parseInt(year.getText()));
			//isAdded = manager.infoStorage.add(info);
                        isAdded = manager.addPhoneUnivInfo(name.getText(), phone.getText(), major.getText(), year.getText());
		}
		else
		{
			//info = new PhoneInfo(name.getText(), phone.getText());
			//isAdded = manager.infoStorage.add(info);
                        isAdded = manager.addPhoneInfo(name.getText(), phone.getText());
		}
		
		if(isAdded)
		{
			text.append("Update Completed.\n");
		}
		else
		{
			text.append("Update Failed: was unable to update data - either already existed or something wrong.\n");
		}
	}
}