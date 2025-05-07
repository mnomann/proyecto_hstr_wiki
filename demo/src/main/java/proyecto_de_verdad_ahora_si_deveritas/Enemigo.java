package proyecto_de_verdad_ahora_si_deveritas;

class Enemigo implements Registro {
    int id, nivel, tipoEnemigoId;
    String nombre, tipoNombre;
    Enemigo() {}
    Enemigo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;

    }
    public Object getValue(String c) {
        switch (c) {
            case "id": return id;
            case "nombre": return nombre;
        }
        return null;
    }
    public void setValue(String c, Object v) {
        switch (c) {
            case "nombre": nombre = v.toString(); break;
        }
    }
    public String toString() { return nombre + " (" + tipoNombre + ")"; }
}
