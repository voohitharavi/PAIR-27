/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phone_book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author comqsjb
 */
public class PhoneBookManager
{
	private final File dataFile = new File(System.getProperty("user.dir") + "\\src\\PhoneBook.dat");
	HashSet<PhoneInfo> infoStorage = new HashSet<PhoneInfo>();
	
	static PhoneBookManager inst = null;
	public static PhoneBookManager createManagerInst()
	{
		if(inst == null)
			inst = new PhoneBookManager();
		return inst;
	}
	
	PhoneBookManager()
	{
            System.out.println(System.getProperty("user.dir"));
		readFromFile();
	}
        
        public boolean changePhoneInfo(String name, String phone)
        {
            if (name.equals("")||phone.equals("")) return false;
                try
                {  
                PhoneInfo pi = new PhoneInfo(name,phone);
                if (infoStorage.contains(pi));
                infoStorage.remove(pi);
                infoStorage.add(pi);
                storeToFile();
                return true;
                }
                catch (Exception e)
                {
                    return false;
                }    
        }

        
        public boolean changePhoneUnivInfo(String name, String phone,String major, String year)
        {

           return true;  
        }
        
        public boolean changePhoneCompanyInfo(String name, String phone, String company)
        {
           return true;
        }
        
        public boolean addPhoneInfo(String name, String phone)
        {
            if (name.equals("")||phone.equals("")) return false;
            try
            {  
            PhoneInfo pi = new PhoneInfo(name,phone);
            if (infoStorage.contains(pi)) return false;
            infoStorage.add(pi);            
            storeToFile();
            return true;
            }
            catch (Exception e)
            {
                return false;
            }
        }
        
        public boolean addPhoneUnivInfo(String name, String phone,String major, String year)
        {
            if (name.equals("")||phone.equals("")||major.equals("")||year.equals("")) return false;
            try
            {
            PhoneInfo pi = new PhoneUnivInfo(name,phone,major,Integer.parseInt(year));
            if (infoStorage.contains(pi)) return false;
            infoStorage.add(pi);
            storeToFile();
            return true;
            }
            catch (Exception e) {return false;}
        }
        
        public boolean addPhoneCompanyInfo(String name, String phone, String company)
        {
            if (name.equals("")||phone.equals("")||company.equals("")) return false;
            try
            {
                PhoneInfo pi = new PhoneCompanyInfo(name,phone,company);
                if (infoStorage.contains(pi)) return false;
                infoStorage.add(pi);
                storeToFile();
                return true;
            }
            
            catch (Exception e) {return false;}
        }

	public String searchData(String name)
	{
		PhoneInfo info = search(name);
		if(info == null)
			return null;
		else
			return info.toString();
	}

	public String searchNumberData(String number)
	{
		PhoneInfo info = searchNumber(number);
		if(info == null)
			return null;
		else
			return info.toString();
	}
	public boolean deleteData(String name)
	{	
		Iterator<PhoneInfo> itr=infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo curInfo=itr.next();
			if(name.compareTo(curInfo.name) == 0)
			{
				itr.remove();
                                storeToFile();
				return true;
			}
		}
		return false;
	}
		public boolean deleteAllData()
	{	
		Iterator<PhoneInfo> itr=infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo curInfo=itr.next();
			//if(name.compareTo(curInfo.name) == 0)
			//
				itr.remove();
                                storeToFile();
			
		}
		return true;
	}
	private PhoneInfo searchNumber(String phoneNumber)
	{
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo curInfo=itr.next();
			if(phoneNumber.compareTo(curInfo.phoneNumber) == 0)
				return curInfo;
		}
		return null;
	}

        private PhoneInfo search(String name)
	{
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while(itr.hasNext())
		{
			PhoneInfo curInfo=itr.next();
			if(name.compareTo(curInfo.name) == 0)
				return curInfo;
		}
		return null;
	}
	public void storeToFile()
	{
		try
		{
			FileOutputStream file = new FileOutputStream(dataFile);		
			ObjectOutputStream out = new ObjectOutputStream(file);
			Iterator<PhoneInfo> itr=infoStorage.iterator();
			while(itr.hasNext())
				out.writeObject(itr.next());			
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
        
        public String toString()
        {
        String retval = "";
        Iterator<PhoneInfo> itr=infoStorage.iterator();
        while(itr.hasNext())
		{
			PhoneInfo curInfo=itr.next();
                        retval+=curInfo.toString() + "\r\n";
		}
        return retval;
        }
	
	public void readFromFile()
	{
		if(dataFile.exists() == false)
			return;
		try
		{
			FileInputStream file = new FileInputStream(dataFile);		
			ObjectInputStream in = new ObjectInputStream(file);
			while(true)
			{
				PhoneInfo info = (PhoneInfo)in.readObject();
				if(info == null)
					break;
				infoStorage.add(info);
			}
			in.close();
		}
		catch(IOException e)
		{
			return;
		}
		catch(ClassNotFoundException e)
		{
			return;
		}
	}
}
