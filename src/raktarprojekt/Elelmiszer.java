package raktarprojekt;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Elelmiszer implements Serializable{

    private String nev, gyarto;
    private LocalDate lejaratiDatum;

    public Elelmiszer(String nev, String gyarto) {
        this(nev, gyarto, LocalDate.now().plusYears(1));
    }

    public Elelmiszer(String nev, String gyarto, LocalDate lejaratiDatum) {
        this.nev = nev;
        this.gyarto = gyarto;
        this.lejaratiDatum = lejaratiDatum;
    }

    public String getNev() {
        return nev;
    }

    public String getGyarto() {
        return gyarto;
    }

    public LocalDate getLejaratiDatum() {
        return lejaratiDatum;
    }

    
    @Override
    public String toString() {
        return "Elelmiszer\n\t{" + "nev=" + nev + ", gyarto=" + gyarto + ", lejaratiDatum=" + lejaratiDatum + '}';
    }
    
    
    
}
