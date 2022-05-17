package raktarprojekt;

import java.text.Collator;
import java.util.Comparator;

public class NevComparator implements Comparator<Elelmiszer>{

    @Override
    public int compare(Elelmiszer egyik, Elelmiszer masik) {
        Collator col = Collator.getInstance();
        return col.compare(egyik.getNev(), masik.getNev());
    }

}
