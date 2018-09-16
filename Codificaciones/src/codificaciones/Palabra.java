package codificaciones;

import java.util.ArrayList;

public class Palabra {
    private ArrayList<String> palabra = new ArrayList<String>();
    
    public Palabra() {
        super();
    }
    
    public void addSimbolo(String simbolo){
        palabra.add(simbolo);
    }

    public ArrayList<String> getPalabras() {
        return palabra;
    }


    @Override
    public boolean equals(Object object) {
        boolean same = true;
        int i=0;
        Palabra aux = (Palabra) object;
        if(palabra.size() != aux.getPalabras().size())
            same = false;
        while(same && i<palabra.size()){
            if(!aux.getPalabras().get(i).equalsIgnoreCase(this.palabra.get(0)))
                same = false;
            i++;
        }
        return same;
    }
    
}
