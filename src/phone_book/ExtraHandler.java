/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
   DELETE ALL RECORDS
 */
package phone_book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExtraHandler implements ActionListener {
    
    JTextField delField;
    JTextArea textArea;
    

	
	public ExtraHandler(JTextField field, JTextArea area)
	{
		delField = field;
		textArea = area;
	}
	// delete all records
	public void actionPerformed(ActionEvent e)
	{
		String name = delField.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		boolean isDeleted = manager.deleteAllData();
		if(isDeleted)
			textArea.append("All records deleted.\n");
        }        
    
}

