package proyecto_de_verdad_ahora_si_deveritas;

class MaterialEnemigo implements Registro {
    int id, enemigo_id;
    String nombre, enemigo;

    MaterialEnemigo() {}

    MaterialEnemigo(int id, String nombre, int enemigo_id, String enemigo) {
        this.id = id;
        this.nombre = nombre;
        this.enemigo_id = enemigo_id;
        this.enemigo = enemigo;
    }

    public Object getValue(String c) {
        return switch (c) {
            case "id" -> id;
            case "nombre" -> nombre;
            case "enemigo_id" -> enemigo_id;
            case "enemigo" -> enemigo;
            default -> null;
        };
    }

    public void setValue(String c, Object v) {
        switch (c) {
            case "nombre" -> nombre = v.toString();
            case "enemigo_id" -> enemigo_id = Integer.parseInt(v.toString());
        }
    }

    public String toString() {
        return nombre + " (" + enemigo + ")";
    }
}