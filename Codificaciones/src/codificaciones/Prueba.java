package codificaciones;

public class Prueba {
    public Prueba() {
        super();
    }

    public static void main(String[] args) {
        Alfabeto fuente = new Alfabeto();
        Alfabeto codigo = new Alfabeto();
        CodigoBloque codigobloque = new CodigoBloque(fuente,codigo);
        Palabra x1 = new Palabra(1,1,0);
        Palabra x2 = new Palabra(0,1);
        Palabra x3 = new Palabra(1,1,1);
        Palabra x4 = new Palabra(0,0);
        Palabra x5 = new Palabra(1,0);
        Palabra x6 = new Palabra();
                
        codigo.addSimbolos("0");
        codigo.addSimbolos("1");
        
        fuente.addSimbolos("s1");
        fuente.addSimbolos("s2");
        fuente.addSimbolos("s3");
        fuente.addSimbolos("s4");
        fuente.addSimbolos("s5");
        //fuente.addSimbolos("s6");
        
        codigobloque.addPalabra(x1);
        codigobloque.addPalabra(x2);
        codigobloque.addPalabra(x3);
        codigobloque.addPalabra(x4);
        codigobloque.addPalabra(x5);
        codigobloque.addProb(0.4);
        codigobloque.addProb(0.12);
        codigobloque.addProb(0.25);
        codigobloque.addProb(0.08);
        codigobloque.addProb(0.15);
        
        //codigobloque.addPalabra(x6);
        
        System.out.println("La codificacion cumple con las propiedades de codigo bloque: " +codigobloque.cumpleCodigoBloque());
        System.out.println("La codificacion es no singular: " + codigobloque.esNoSingular());
        System.out.println("Desigualdad de Kraft: " +codigobloque.cumpleDesigualdad());
        System.out.println("La codificacion es instantanea: " +codigobloque.esInstantaneo());
        System.out.println("Longitud media del codigo: " +codigobloque.calcularLongitudMedia());
        System.out.println("Entriopia:" + codigobloque.calcularEntropia());
    }
}
