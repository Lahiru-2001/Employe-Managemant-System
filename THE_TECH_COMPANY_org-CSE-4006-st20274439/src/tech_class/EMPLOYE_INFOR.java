
package tech_class;

import java.io.BufferedReader;
import java.io.IOException;



public class EMPLOYE_INFOR {
    private String  EmployeeName;
    private String epfnumber;
    private String Deparment;
    private String Designation;
    FILE_MANAGE FILE_MANAGE = new FILE_MANAGE("Employee__.txt");

   public EMPLOYE_INFOR(){}
    
    public EMPLOYE_INFOR( String EmployeeName, String epfnumber ,String Deparment,String Designation) {
        this.EmployeeName = EmployeeName;
        this.epfnumber= epfnumber;
        this.Deparment = Deparment;
        this.Designation=Designation;
    
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public String getepfnumber() {
        return epfnumber;
    }

    public void setepfnumber(String epfnumber) {
        this.epfnumber = epfnumber;
    }

    public String getDeparment() {
        return Deparment;
    }

    public void setDeparment(String Deparment) {
        this.Deparment = Deparment;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }
    
    
       public boolean addEmployee() {
        
        if(!FILE_MANAGE.create_NewFile())
        {
String record =  EmployeeName + " " + epfnumber + " " + Designation +" "+ Deparment;

System.err.println( EmployeeName + " " + epfnumber + " " +Designation + " " + Deparment);
            return FILE_MANAGE.writeDataToFile(record);
        }
        return false;
    }
       
      public boolean searchEmployee(String keyword) 
      {
        boolean isFound = false;   
        try {
            String[] words = null;          
            BufferedReader bufferedReader = FILE_MANAGE.readAFile();
            String employee;       
            outerloop:
            while ((employee = bufferedReader.readLine()) != null) 
               
            {              
                words = employee.split(" ");           
                for (String word : words) 
                {
                    if (word.equals(keyword)) 
                    {
                        isFound = true;                      
                        
                        this.setEmployeeName(words[0]);
                        this.setepfnumber((words[1])); 
                        this.setDesignation(words[2]);
                        this.setDeparment(words[3]);
                        break outerloop;
                    }
                }
            }
        } catch (IOException e) {
             System.err.println("Something went wrong searching Employee" + e);
        } 
        return isFound;
    

    }
    public boolean searchEmployeeByName(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}

