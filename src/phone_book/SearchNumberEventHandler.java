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


public class SearchNumberEventHandler implements ActionListener
{
	JTextField searchField;
	JTextArea textArea;
	
	public SearchNumberEventHandler(JTextField field, JTextArea area)
	{
		searchField=field;
		textArea=area;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String number = searchField.getText();
		PhoneBookManager manager=PhoneBookManager.createManagerInst();
		String srchResult = manager.searchNumberData(number);
		if(srchResult == null)
		{
			textArea.append("Search Failed: info does not exist.\n");
		}
		else
		{
			textArea.append("Search Completed:\n");
			textArea.append(srchResult);
			textArea.append("\n");
		}
	}
}
