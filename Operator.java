import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

public class Operator extends JFrame{
	 	File masini;
	    File plati;
	    File Total;


	    public Operator(){
	        masini = new File("masini.txt");
	        plati = new File("plati.txt");
	        Total=new File("Total.txt");
	        if(!plati.exists()){
	            salvarePlati("0");
	        }
	        if(!Total.exists()){
	            salvareTotal("0");
	        }

	    }
	    public void salvareTotal(String data) {
	    	 try {
		            FileWriter fw = new FileWriter(Total, false);
		            fw.write(data+"\n");
		            fw.close();
		        }
		        catch(IOException ioex){
		            System.out.println("eroare la salvarea datelor de incasari...");
		        }
			
		}
		public void salvareMasina(String data){
	        try {
	            FileWriter fw = new FileWriter(masini, true);
	            fw.write(data + "\n");
	            fw.close();
	        }
	        catch(IOException ioex){
	            System.out.println("eroare la salvarea datelor masinii...");
	        }
	    }

	    public void salvarePlati(String data){
	        try {
	            FileWriter fw = new FileWriter(plati, true);
	            fw.write(data+"\n");
	            fw.close();
	        }
	        catch(IOException ioex){
	            System.out.println("eroare la salvarea datelor de incasari...");
	        }
	    }

	    public float loadTotal(){
	        char data[] = new char[100];
	        try {
	            FileReader fr = new FileReader(Total);
	            fr.read(data);
	            fr.close();
	        }
	        catch(IOException ioex){
	            System.out.println("eroare la incarcarea datelor de incasari...");
	        }
	        String platiContent = new String(data);

	        if(platiContent.compareTo("")!=0)
	            return Float.parseFloat(platiContent);
	        else
	            return 0;

	    }

}
