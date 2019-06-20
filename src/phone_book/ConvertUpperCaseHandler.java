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

public class ConvertUpperCaseHandler implements ActionListener{
    
    JTextField name;
	JTextField phone;
	JTextField major;
	JTextField year;
	JTextField company;
	JTextArea text;
	Vector<String> inputList = new Vector<String>();
	
	boolean operationSuccessful = false;
	
	PhoneInfo info;
    
        public ConvertUpperCaseHandler(JTextField nameField)
	{
		name = nameField;
		
	}
        
        public void actionPerformed(ActionEvent e)
	{
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		if(name.getText().equals("") == false );
		{
                        String UpperCaseName;
                        UpperCaseName = name.getText().toUpperCase();
                        name.setText(UpperCaseName);
                        System.out.println("converted to upper case");
		}		

	}
}
