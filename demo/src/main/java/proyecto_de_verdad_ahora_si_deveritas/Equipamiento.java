package proyecto_de_verdad_ahora_si_deveritas;

public class Equipamiento implements Registro{
    int id; String nombre; int rareza;
    Equipamiento() {}
    Equipamiento(int id, String nombre, int rareza) {
        this.id = id; this.nombre = nombre;
        this.rareza = rareza;
    }
    public Object getValue(String c){
        if ("id".equals(c)) return id;
        if ("nombre".equals(c)) return nombre;
        if ("rareza".equals(c)) return rareza;
        return null;
    }
    public void setValue(String c, Object v){
        if ("nombre".equals(c)) nombre = v.toString();
        else if ("rareza".equals(c)) rareza = Integer.parseInt(v.toString());
    }
    public String toString() {return nombre;}
    
}
