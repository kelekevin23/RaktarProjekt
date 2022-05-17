package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import modell.DatumException;
import modell.Elelmiszer;
import modell.Konzerv;
import modell.Raktar;

public class RaktarProjekt {

    public static void main(String[] args) throws DatumException, IOException {

        Raktar r = new Raktar();

        //String date = "2016-08-16";  hibás dátum --> kivétel
        String date = "2022-05-19";
        LocalDate localDate = LocalDate.parse(date);
        r.felvesz(new Konzerv("só", "Kft", "ételhez", localDate));

        r.felvesz(new Konzerv("bab", "Gyár", "csípős"));
      //r.felvesz(new Konzerv("sütőpor", "Otthon", "ételkészítéshez", "recept.txt"));

        kiir(r);
        //System.out.println("\nRendezés név szerint.");
        //r.rendezNev();
        // kiir(r);
        System.out.println("\nRendezés gyártó szerint.");
        r.rendezGyarto();
        kiir(r);
        
        //mentés és betöltés
        /*mentes(r);
        r = null;
        System.out.println(r);
        r = betoltes();
        kiir(r);*/
             
        
    }

    public static void kiir(Raktar rak) {
        for (Elelmiszer elemiszer : rak) {
            System.out.println(elemiszer);
        }
    }
    
    public static void mentes(Raktar r) throws IOException {
        try {
            FileOutputStream fajlKi = new FileOutputStream("raktar.bin");
            ObjectOutputStream objKi = new ObjectOutputStream(fajlKi);
            objKi.writeObject(r);
            objKi.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static Raktar betoltes() {
        Raktar r = null;
        try {
            r = (Raktar) new ObjectInputStream(new FileInputStream("raktar.bin")).readObject();
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        } finally {
            return r;
        }
    }

}
