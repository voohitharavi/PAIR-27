/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phone_book;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author comqsjb
 */
public class  DeleteEventHandler implements ActionListener
{
	JTextField delField;
	JTextArea textArea;
	
	public DeleteEventHandler(JTextField field, JTextArea area)
	{
		delField = field;
		textArea = area;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String name = delField.getText();
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		boolean isDeleted = manager.deleteData(name);
		if(isDeleted)
			textArea.append("Remove Completed.\n");
		else
			textArea.append("Remove Failed: info does not exist.\n");
	}
}