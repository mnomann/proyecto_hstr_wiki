package proyecto_de_verdad_ahora_si_deveritas;

/**
 * Interfaz que representa un registro genérico con acceso dinámico a sus propiedades.
 *
 * <p>Esta interfaz permite trabajar de forma abstracta con distintas entidades del sistema
 * (como personajes, materiales o equipamiento), permitiendo la lectura y escritura de
 * valores mediante el nombre de la columna.
 *
 * <p>Es especialmente útil en componentes genéricos como {@code EntidadPanel} que pueden
 * manejar cualquier tipo de registro sin conocer su estructura concreta.
 */
interface Registro {

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
