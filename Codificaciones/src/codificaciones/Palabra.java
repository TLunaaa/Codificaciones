package codificaciones;

import java.util.ArrayList;

public class Palabra implements Cloneable {
    private ArrayList<String> palabra = new ArrayList<String>();
    
    public Palabra() {
        super();
    }
    
    public Palabra(int simbolo1){
        this.palabra.add(Integer.toString(simbolo1));
    }
    
    public Palabra(int simbolo1,int simbolo2){
        this.palabra.add(Integer.toString(simbolo1));
        this.palabra.add(Integer.toString(simbolo2));
    }
    
    public Palabra(int simbolo1,int simbolo2,int simbolo3){
        this.palabra.add(Integer.toString(simbolo1));
        this.palabra.add(Integer.toString(simbolo2));
        this.palabra.add(Integer.toString(simbolo3));
    }
    
    public Palabra(int simbolo1,int simbolo2,int simbolo3,int simbolo4){
        this.palabra.add(Integer.toString(simbolo1));
        this.palabra.add(Integer.toString(simbolo2));
        this.palabra.add(Integer.toString(simbolo3));
        this.palabra.add(Integer.toString(simbolo4));
    }
    
    public void addSimbolo(String simbolo){
        palabra.add(simbolo);
    }

    public ArrayList<String> getPalabras() {
        return palabra;
    }

    public void setPalabra(ArrayList<String> palabra) {
        this.palabra = palabra;
    }


    @Override
    public boolean equals(Object object) {
        boolean same = true;
        int i=0;
        Palabra aux = (Palabra) object;
        if(palabra.size() != aux.getPalabras().size())
            same = false;
        while(same && i<palabra.size()){
            if(!aux.getPalabras().get(i).equalsIgnoreCase(this.palabra.get(i)))
                same = false;
            i++;
        }
        return same;
    }
    
    public boolean esPrefijo(Palabra otrapalabra){
        try{
            boolean prefix = false;
            Palabra copypalabra = (Palabra) otrapalabra.clone();
            ArrayList<String> arreglo = copypalabra.getPalabras();
            if(arreglo.size() >= this.palabra.size()){
                while(this.palabra.size() < arreglo.size()){
                    arreglo.remove(arreglo.size()-1);
                }
                copypalabra.setPalabra(arreglo);
                if(this.equals(copypalabra)){
                    prefix = true;
                    System.out.println(this.palabra + " es prefijo de " + otrapalabra);
                }
                    return prefix;
            }
            
        }catch(CloneNotSupportedException e){
            
        }
        return false;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        try{
            Palabra nObjeto = (Palabra)super.clone();
            nObjeto.palabra = (ArrayList<String>)this.palabra.clone();
            return nObjeto;
        }catch(CloneNotSupportedException e){
            throw new InternalError(e.toString());
        }
    }


    @Override
    public int hashCode() {
        // TODO Implement this method
        return super.hashCode();
    }

    @Override
    public String toString() {
        return this.palabra.toString();
    }
}
