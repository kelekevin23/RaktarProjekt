package modell;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;

public class Konzerv extends Elelmiszer implements Serializable{

    private String leiras, receptAjanlas;

    public Konzerv(String nev, String gyarto, String leiras) {
        super(nev, gyarto);
        this.leiras = leiras;
        this.receptAjanlas = "nincs";
    }

    public Konzerv(String nev, String gyarto, String leiras, String receptAjanlas) {
        super(nev, gyarto);
        this.leiras = leiras;
        this.receptAjanlas = receptAjanlas;
        receptetMutat(this.receptAjanlas);

    }

    public Konzerv(String nev, String gyarto, String leiras, LocalDate lejaratiDatum) {
        super(nev, gyarto, lejaratiDatum);
        this.leiras = leiras;
        this.receptAjanlas = "nincs";
    }

    public Konzerv(String nev, String gyarto, String leiras, String receptAjanlas, LocalDate lejaratiDatum) {
        super(nev, gyarto, lejaratiDatum);
        this.leiras = leiras;
        this.receptAjanlas = receptAjanlas;
        receptetMutat(this.receptAjanlas);
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tKonzerv{" + "leiras=" + leiras + ", receptAjanlas=" + receptAjanlas + '}';
    }

    private void receptetMutat(String nev){
          File f = new File(nev);
 
        if (f.exists())
            System.out.println("Létezik a fájl");
        else
            System.out.println("Nem létezik a fájl");
    }
}
