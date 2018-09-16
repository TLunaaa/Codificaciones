package codificaciones;

import java.util.ArrayList;

public class Alfabeto {
    private ArrayList<String> simbolos = new ArrayList<String>();
    
    public Alfabeto() {
        super();
    }
    
    public void addSimbolos(String simbolo){
        this.simbolos.add(simbolo);
    }
    
    public int getLength(){
        return this.simbolos.size();
    }
    
    public boolean containsSimbolo(String simbolo){
        return simbolos.contains(simbolo);
    }
    
}
