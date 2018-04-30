package ESA_ALE.ALE_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Telefonliste {


    ArrayList<TelefonEintrag> telefonbuch = new ArrayList<>();


    public static void main(String args[]){

    }
    protected void clear(){
        telefonbuch.clear();
    }
    protected int size(){
        return telefonbuch.size();
    }

    protected void addEntry(String name, String nummer){

        TelefonEintrag eintrag = new TelefonEintrag(name, nummer);
        telefonbuch.add(eintrag);
    }

    protected void removeEntry(String name, String nummer){

        List<TelefonEintrag> ergebnis = telefonbuch.stream()
                .filter(e -> e.getName().equals(name) && e.getNumber().equals(nummer)) //Wenn Name und Nummer übereinstimmen, wird das Objekt auf eine Liste gepackt
                .collect(Collectors.toList());

        ergebnis.forEach(e -> telefonbuch.remove(e)); //Und jedes Objekt der Liste fliegt aus dem originalen Telefonbuch raus

    }

    protected boolean modifyEntry (String nameAlt, String nummerAlt, String nameNeu, String nummerNeu){

        TelefonEintrag neuerEintrag = new TelefonEintrag(nameNeu, nummerNeu);

        boolean ersetzt;

        List<TelefonEintrag> ergebnis = telefonbuch.stream()
                .filter(e -> e.getName().equals(nameAlt) && e.getNumber().equals(nummerAlt))
                .collect(Collectors.toList());

        ersetzt = !ergebnis.isEmpty(); //Wenn die Liste nicht leer ist, ist die Variable true

        if (ersetzt) ergebnis.forEach(e -> telefonbuch.set(telefonbuch.indexOf(e), neuerEintrag)); //Wenn sie true ist, bedeutet das, es gibt einen Eintrag zum Ersetzten

       return ersetzt;

    }
    protected String searchByName(String name){

        List<TelefonEintrag> ergebnis = telefonbuch.stream()
                .filter(e -> e.getName().contains(name))
                .collect(Collectors.toList());


        StringBuilder rueckgabe = new StringBuilder();
        ergebnis.forEach(e -> rueckgabe.append(e.toString()));

        return rueckgabe.toString();
    }

    protected String searchNameByNumber(String nummer){

        List<TelefonEintrag> ergebnis = telefonbuch.stream()
                .filter(e -> e.getNumber().contains(nummer))
                .collect(Collectors.toList());

        StringBuilder rueckgabe = new StringBuilder();
        ergebnis.forEach(e -> rueckgabe.append(e.toString()));

        return rueckgabe.toString();
    }

}
