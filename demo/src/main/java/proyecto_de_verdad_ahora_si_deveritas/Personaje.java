package proyecto_de_verdad_ahora_si_deveritas;

class Personaje implements Registro {
    int id, rareza, nivel; String nombre;
    Personaje() {}
    Personaje(int id, String nombre, int rareza, int nivel) {
        this.id = id; this.nombre = nombre;
        this.rareza = rareza; this.nivel = nivel;
    }
    public Object getValue(String c) {
        if ("id".equals(c)) return id;
        if ("nombre".equals(c)) return nombre;
        if ("rareza".equals(c)) return rareza;
        if ("nivel".equals(c)) return nivel;
        return null;
    }
    public void setValue(String c, Object v) {
        if ("nombre".equals(c)) nombre = v.toString();
        else if ("rareza".equals(c)) rareza = Integer.parseInt(v.toString());
        else if ("nivel".equals(c)) nivel = Integer.parseInt(v.toString());
    }
    public String toString() { return nombre; }
}