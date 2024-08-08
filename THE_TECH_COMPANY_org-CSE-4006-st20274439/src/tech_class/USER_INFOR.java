
package tech_class;

import java.io.BufferedReader;
import java.io.IOException;


public class USER_INFOR {
    
private String USERNAME;
private String PASSWORD;
private String USERTYPE;

 FILE_MANAGE FILE_MANAGE = new FILE_MANAGE("User_Info.txt");

  public  USER_INFOR (){}
    public USER_INFOR(String USERNAME, String PASSWORD) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }
 
public USER_INFOR(String USERNAME,String PASSWORD,String USERTYPE)
{
this.USERNAME=USERNAME;
this.PASSWORD=PASSWORD;
this.USERTYPE=USERTYPE;
}

public void setUserId(String USERNAME)
{
    this.USERNAME=USERNAME;
}
public String getUSERNAME()
{
    return USERNAME;
}

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPassword(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getUSERTYPE() {
        return USERTYPE;
    }

    public void setUSERTYPE(String USERTYPE) {
        this.USERTYPE = USERTYPE;
    }

 public boolean addNewUser()
 {
        if(!FILE_MANAGE.create_NewFile()){
            String record = USERNAME + " " + PASSWORD+ " " + USERTYPE ;   
                           
            return FILE_MANAGE.writeDataToFile(record);
        }
        return false;
    }
 
 
    public boolean validateLogin() {
        try {
            String[] words = null;
            
            BufferedReader bufferedReader = FILE_MANAGE.readAFile();
            String user;
            while ((user = bufferedReader.readLine()) != null) {              
                words = user.split(" ");
                if (words[0].equals(USERNAME) && words[1].equals(PASSWORD))
                {
                    this.setUSERNAME(words[0]);
                    this.setPASSWORD(words[1]);
                    this.setUSERTYPE(words[2]);
                    return true;
                }
            }
        } catch (IOException e) {
       System.err.println("Something went wrong validating login" + e);
       return false;
        }      
        return false;
    }

    private void setUSERNAME(String word) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setPASSWORD(String word) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
