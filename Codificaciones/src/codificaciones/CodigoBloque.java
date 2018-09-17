package codificaciones;

import java.util.ArrayList;
import java.util.Iterator;

public class CodigoBloque {
    private ArrayList<Palabra> palabrasXi = new ArrayList<Palabra>();
    private ArrayList<Double> probPi = new ArrayList<Double>();
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
    
    public void addProb(double prob){
        this.probPi.add(prob);
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
    
    public double cumpleDesigualdad(){
        double acum=0;
        int li,r;
        r = this.codigo.getLength();
        Iterator it = this.palabrasXi.iterator();
        while(it.hasNext()){
            Palabra palabra = (Palabra) it.next();
            li = palabra.getPalabras().size();
            acum += Math.pow(r, -li);
        }
        return acum;
    }
    
    public boolean esInstantaneo(){
        boolean result = true;
        int i=0,j=0;
        if(this.cumpleDesigualdad()<=1){
            while(result && i<this.palabrasXi.size() ){
                Palabra palabra1 = this.palabrasXi.get(i);
                j = 0;
                while(result && j<this.palabrasXi.size()){
                    if(j!=i){
                        Palabra palabra2 = this.palabrasXi.get(j);
                        if(palabra1.esPrefijo(palabra2)){
                            result = false;
                        }
                    }
                    j++;
                    
                }
                i++;
            }
        }else{
            result = false;
        }
        return result;
    }
    
    public double calcularEntropia(){
        double prob,acum=0;
        for(int i=0;i<this.probPi.size();i++){
            prob = this.probPi.get(i);
            acum += prob * this.logbase(this.codigo.getLength(), (1/prob));
        }
       return acum;
    }
    
    public double logbase(int b,double x){
        return (Math.log10(x)/Math.log10(b));
        
    }
    
    public double calcularLongitudMedia(){
        double prob,acum=0;
        int size,longpalabra;
        if(this.probPi.size()==this.palabrasXi.size()){
            size = this.probPi.size();
            for(int i=0;i<size;i++){
                prob = this.probPi.get(i);
                longpalabra = this.palabrasXi.get(i).getPalabras().size();
                acum += prob * longpalabra;
            }
        }
        return acum;
    }

}
