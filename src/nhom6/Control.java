/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author PH Laptop
 */
public class Control {
    public static HocVien[] readFromFile(String filename) {
        HocVien obj[]  = null ;
       
        try {
            FileInputStream f = new FileInputStream(filename) ;
            ObjectInputStream ois= new ObjectInputStream(f);
            int n = ois.readInt();
            obj = new HocVien[n];
            int i = 0 ;
            while(f.available()>0){
               obj[i] =  (HocVien) ois.readObject();  
               i++ ;
            }
            f.close();
            ois.close();
            
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } 
        catch (ClassNotFoundException ex) {
            ex.printStackTrace(); 
        }
       return obj ;
    }
    public static void writeToFile(String filename, HocVien obj[]){
        FileOutputStream fout = null;
	ObjectOutputStream oos = null;
	try {
            fout = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fout);
            oos.writeInt(obj.length);
            for(int i=0;i<obj.length;i++){
                oos.writeObject(obj[i]);
            }
            fout.close();
            oos.close();
            }catch (Exception ex) {
                ex.printStackTrace();
        }
    }
}
