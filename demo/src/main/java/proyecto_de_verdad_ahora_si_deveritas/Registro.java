package proyecto_de_verdad_ahora_si_deveritas;

/**
 * Interfaz que representa un registro genérico con acceso dinámico a sus propiedades.
 *
 * <p>Permite trabajar de forma abstracta con distintas entidades del sistema
 * (como personajes, materiales o equipamiento), facilitando la lectura y escritura de
 * valores mediante el nombre del campo.
 *
 * <p>Es especialmente útil en componentes genéricos como {@code EntidadPanel} que pueden
 * operar sobre cualquier tipo de entidad sin conocer su estructura exacta.
 */
public interface Registro {

    /**
     * Obtiene el valor de un campo del registro dado su nombre.
     *
     * @param col nombre de la columna o campo
     * @return el valor correspondiente, o {@code null} si no existe
     */
    Object getValue(String col);

    /**
     * Establece el valor de un campo del registro dado su nombre.
     *
     * @param col nombre de la columna o campo
     * @param val nuevo valor a asignar
     */
    void setValue(String col, Object val);
}
