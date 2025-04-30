package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

interface Registro {
    Object getValue(String col);
    void setValue(String col, Object val);
}

interface RegistroFactory<T extends Registro> {
    T fromResultSet(ResultSet rs) throws SQLException;
    T createEmpty();
}

class Via implements Registro {





    
    int id; String nombre;
    Via() {}
    Via(int id, String nombre) { this.id = id; this.nombre = nombre; }
    public Object getValue(String c) {
        if ("id".equals(c)) return id;
        if ("nombre".equals(c)) return nombre;
        return null;
    }
    public void setValue(String c, Object v) {
        if ("nombre".equals(c)) nombre = v.toString();
    }
    public String toString() { return nombre; }
}