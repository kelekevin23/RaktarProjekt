package raktarprojekt;

import java.time.LocalDate;

public class RaktarProjekt {

    public static void main(String[] args) throws DatumException {

        Raktar r = new Raktar();

        //String date = "2016-08-16";
        String date = "2022-05-19";
        LocalDate localDate = LocalDate.parse(date);
        r.felvesz(new Konzerv("só", "Kft", "ételhez", localDate));

        r.felvesz(new Konzerv("bab", "Gyár", "csípős"));
        r.felvesz(new Konzerv("sütőpor", "Otthon", "ételkészítéshez", "recept.txt"));

        kiir(r);
        //System.out.println("\nRendezés név szerint.");
        //r.rendezNev();
        // kiir(r);
        System.out.println("\nRendezés gyártó szerint.");
        r.rendezGyarto();
        kiir(r);
    }

    public static void kiir(Raktar rak) {
        for (Elelmiszer elemiszer : rak) {
            System.out.println(elemiszer);
        }
    }

}
