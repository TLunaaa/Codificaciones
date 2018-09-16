package codificaciones;

import java.util.ArrayList;
import java.util.Iterator;

public class CodigoBloque {
    private ArrayList<Palabra> palabrasXi = new ArrayList<Palabra>();
    private Alfabeto fuente;
    private Alfabeto codigo;
    
    public CodigoBloque(Alfabeto fuente,Alfabeto codigo) {
        this.fuente = fuente;
        this.codigo = codigo;
    }
    
    public void addPalabra(Palabra palabra){
        if(this.palabrasXi.size() < this.fuente.getLength()){
            this.palabrasXi.add(palabra);
        }
    }
    
    public boolean cumpleCodigoBloque(){
        boolean result=true;
        Iterator it = palabrasXi.iterator();
        while(it.hasNext() && result ==true){
            Palabra palabra =(Palabra) it.next();
            Iterator it2 = palabra.getPalabras().iterator();
            while(it2.hasNext() && result ==true){
                String simbolo = (String) it2.next();
                if(!codigo.containsSimbolo(simbolo))
                    result = false;
            }
        }
        return result;
    }
    
    public boolean esNoSingular(){
        boolean result=true;
        for(int i=0;i<this.palabrasXi.size();i++){
            Palabra palabra = this.palabrasXi.get(i);
            for(int j = i+1;j<this.palabrasXi.size();j++){
                if(palabra.equals(this.palabrasXi.get(j)))
                    result = false;
            }
        }
        return result;
    }
    
}
