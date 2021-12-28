
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.HocVien;

/**
 *
 * @author PH Laptop
 */
public class function {
    public static void Sort(HocVien hv[],boolean k){
        // k = true là sắp xếp tăng dần k = false là giảm dần
        int x ;
        for(int i=0;i<hv.length-1;i++){
            x = i ;
            for(int j=i+1;j<hv.length;j++)
                if( k == true ? (hv[j].getDiemthi() < hv[x].getDiemthi()) : (hv[j].getDiemthi() > hv[x].getDiemthi()))                    
                    x = j ;                       
            HocVien temp =hv[i] ;
            hv[i] = hv[x] ;
            hv[x] = temp ;   
         }
    }
    public static HocVien [] Add(HocVien hv[],HocVien h){
        HocVien[] the = new HocVien[hv.length+1];
        for(int i=0;i<hv.length;i++){
            the[i] = hv[i] ;
        }
        the[hv.length] = h ;
        hv = the ;
        return hv ;
    }
    public static HocVien [] Delete(HocVien hv[],int index){
        HocVien[] the = new HocVien[hv.length-1];
        for(int i=0;i<hv.length-1;i++){
            if(i<index)
                the[i] = hv[i];
            else
                the[i] = hv[i+1];
            }
        hv = the ;
        return hv ;
    }
    public static HocVien[] readFromFile(String filename) {
        if(!hasObject("hocvien.txt")){
            HocVien obj[]  = new HocVien[0] ;
            return obj ;
        }
        HocVien obj[]  = null ;
        HocVien[] pb = null ;
        try {
            FileInputStream f = new FileInputStream(filename) ;
            ObjectInputStream ois= new ObjectInputStream(f);
            obj = new HocVien[20];
            int i = 0 ;
            while(f.available()>0){
               obj[i] =  (HocVien) ois.readObject();  
               i++ ;
            }
            pb = new HocVien[i] ;
            for(int j=0;j<i;j++){
                pb[j] = obj[j] ;
            }
//            System.out.println("Đã đọc xong");
            f.close();
            ois.close();
            
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } 
        catch (ClassNotFoundException ex) {
            ex.printStackTrace(); 
        }
       return pb ;
    }
    public static boolean hasObject(String filename) {
        FileInputStream fi;
	boolean check = true;
	try {
            fi = new FileInputStream(filename);
            ObjectInputStream inStream = new ObjectInputStream(fi);
            if (inStream.readObject() == null) {
		check = false;
            }
            inStream.close();
            } catch (FileNotFoundException e) {
                check = false;
            } catch (IOException e) {
                check = false;
            } catch (ClassNotFoundException e) {
                check = false;
                e.printStackTrace();
            }
            return check;
	}
    public static void SaveData(String filename, HocVien obj[]){
        FileOutputStream f = null;
	ObjectOutputStream oos = null;
        try { 
            f = new FileOutputStream(filename);
            oos = new ObjectOutputStream(f);           
            for(int i=0;i<obj.length;i++){

                oos.writeObject(obj[i]);
            }
            f.close();
            oos.close();
//            System.out.println("Xong!");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void writeToFile(String filename, HocVien obj){
        
        FileOutputStream f = null;
	ObjectOutputStream oos = null;
	try {
            if(!hasObject(filename)){
                f = new FileOutputStream(filename);
                oos = new ObjectOutputStream(f);
            } 
            else {
                f = new FileOutputStream(filename, true);
                oos = new ObjectOutputStream(f) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            }
            oos.writeObject(obj);  
            f.close();
            oos.close();
//            System.out.println("Xong!");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
