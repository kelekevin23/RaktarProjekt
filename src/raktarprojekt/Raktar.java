package raktarprojekt;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Raktar implements Serializable, Iterable<Elelmiszer>{

    ArrayList<Elelmiszer> elelmiszerek;

    public Raktar() {
        elelmiszerek = new ArrayList<>();
    }

    public void felvesz(Konzerv ujElelmiszer) throws DatumException{
        LocalDate jelenlegi = ujElelmiszer.getLejaratiDatum();     
        String datumString = jelenlegi.toString().replaceAll("-", "");
        
        
        String maiDatumString = LocalDate.now().toString().replaceAll("-", "");
        
        if (Integer.parseInt(maiDatumString) > Integer.parseInt(datumString)) {
           throw new DatumException("lejár élelmiszer");
        } else{
             elelmiszerek.add(ujElelmiszer);
        }

    }
    
    public List<Elelmiszer> getElelmiszerek() {
        return Collections.unmodifiableList(elelmiszerek);
    }

    public void rendezNev() {
        Collections.sort(elelmiszerek, new NevComparator());
    }

    public void rendezGyarto() {
        Collections.sort(elelmiszerek, new GyartoComparator());
    }
    
    @Override
    public Iterator<Elelmiszer> iterator() {
        return getElelmiszerek().iterator();
    }

    @Override
    public String toString() {
        return "Raktar{" + "elelmiszerek=\n" + elelmiszerek + '}';
    }
    
    
    
    
}
