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
public class ChangeHandlers implements ActionListener{
    
    JTextField name;
	JTextField phone;
	JTextField major;
	JTextField year;
	JTextField company;
	JTextArea text;
	Vector<String> inputList = new Vector<String>();
	
	boolean operationSuccessful = false;
	
	PhoneInfo info;
    
        public ChangeHandlers(JTextField nameField, JTextField phoneField, JTextField majorField, JTextField yearField, JTextArea textArea)
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
                    
                        System.out.println("We want to change an entry with company info in it");
                        operationSuccessful = manager.changePhoneCompanyInfo(name.getText(), phone.getText(),company.getText());
		}		
		else if(major.getText().equals("") == false && year.getText().equals("") == false)
		{
                            System.out.println("We want to change an entry with university info in it");
			 operationSuccessful= manager.changePhoneUnivInfo(name.getText(), phone.getText(), major.getText(), year.getText());
		}
		else
		{
                        System.out.println("We want to change an entry with just name and number info in it");
			operationSuccessful= manager.changePhoneInfo(name.getText(), phone.getText());
		}
		
		if(operationSuccessful)
		{
			text.append("Change Completed.\n");
		}
		else
		{
			text.append("Change Failed: was unable to update data - either already existed or something wrong.\n");
		}
	}
}
