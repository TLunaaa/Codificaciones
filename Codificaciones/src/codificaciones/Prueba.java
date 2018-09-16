package codificaciones;

public class Prueba {
    public Prueba() {
        super();
    }

    public static void main(String[] args) {
        Alfabeto fuente = new Alfabeto();
        Alfabeto codigo = new Alfabeto();
        CodigoBloque codigobloque = new CodigoBloque(fuente,codigo);
        Palabra x1 = new Palabra();
        Palabra x2 = new Palabra();
        Palabra x3 = new Palabra();
        Palabra x4 = new Palabra();
        Palabra x5 = new Palabra();
        Palabra x6 = new Palabra();
        
        x1.addSimbolo("0");
        x1.addSimbolo("0");
        x1.addSimbolo("0");
        
        x2.addSimbolo("0");
        x2.addSimbolo("0");
        x2.addSimbolo("1");
        
        x3.addSimbolo("0");
        x3.addSimbolo("1");
        x3.addSimbolo("0");
        
        x4.addSimbolo("0");
        x4.addSimbolo("1");
        x4.addSimbolo("1");
        
        x5.addSimbolo("1");
        x5.addSimbolo("0");
        x5.addSimbolo("0");
        
        x6.addSimbolo("1");
        x6.addSimbolo("0");
        x6.addSimbolo("1");
        
        codigo.addSimbolos("0");
        codigo.addSimbolos("1");
        
        fuente.addSimbolos("s1");
        fuente.addSimbolos("s2");
        fuente.addSimbolos("s3");
        fuente.addSimbolos("s4");
        fuente.addSimbolos("s5");
        fuente.addSimbolos("s6");
        
        codigobloque.addPalabra(x1);
        codigobloque.addPalabra(x2);
        codigobloque.addPalabra(x3);
        codigobloque.addPalabra(x4);
        codigobloque.addPalabra(x5);
        codigobloque.addPalabra(x6);
        
        System.out.println(codigobloque.cumpleCodigoBloque());
        System.out.println(codigobloque.esNoSingular());
    }
}
