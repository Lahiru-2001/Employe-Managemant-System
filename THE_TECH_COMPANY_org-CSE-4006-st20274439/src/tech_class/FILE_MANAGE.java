/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tech_class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author User
 */
public final class FILE_MANAGE {
     private static final String FILE_PATH = "E:\\THE_TECH_COMPANY_FILES\\FILE__";

    File file;
    private final String fileName;

    public FILE_MANAGE(String fileName)
    {
        this.fileName = fileName;   
        create_NewFile();
    }
    public boolean create_NewFile() {
        try {
            file = new File(FILE_PATH + fileName);
            if (file.createNewFile()){
                System.out.println("File Created: " + file.getName());
                return true;
            }   
            else
            {
            System.out.println("File Already Exisit !");
            return false;
            }
        } catch(IOException e) {
            System.err.println("Something went wrong with creating file" + e);
            return false;
        }
    }
    
     public boolean writeDataToFile(String record)
     {
        try {
            file.createNewFile();
            try (FileWriter fileWriter = new FileWriter(file, true); 
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(record);
                bufferedWriter.newLine();
            }

            return true;
        } catch (IOException e) {
            System.err.println("Something went wrong with writing" + e);
            return false;
        }
    }
    
     public BufferedReader readAFile() {
        if(!create_NewFile())
        {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                return bufferedReader;
            } catch (IOException e) {
                System.err.println("Something went wrong with Reading the file" + e);
            }
        }     
        return null;
    }
}
