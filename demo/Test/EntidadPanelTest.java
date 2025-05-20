import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.*;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.doNothing;

import javax.swing.JOptionPane;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EntidadPanelTest {

    Connection mockConn;
    Statement mockStmt;
    PreparedStatement mockPs;
    ResultSet mockRs;

    RegistroFactory<MockRegistro> factory;
    EntidadPanel<MockRegistro> panel;

    List<String> columnas = List.of("id", "nombre");

    @BeforeEach
    void setup() throws SQLException {
        mockConn = mock(Connection.class);
        mockStmt = mock(Statement.class);
        mockPs = mock(PreparedStatement.class);
        mockRs = mock(ResultSet.class);

        when(mockConn.createStatement()).thenReturn(mockStmt);
        when(mockStmt.executeQuery(anyString())).thenReturn(mockRs);
        when(mockConn.prepareStatement(anyString(), anyInt())).thenReturn(mockPs);

        factory = new RegistroFactory<>() {
            @Override
            public MockRegistro fromResultSet(ResultSet rs) throws SQLException {
                MockRegistro r = new MockRegistro();
                r.setValue("id", rs.getString("id"));
                r.setValue("nombre", rs.getString("nombre"));
                return r;
            }

            @Override
            public MockRegistro createEmpty() {
                return new MockRegistro();
            }
        };

        panel = new EntidadPanel<>(mockConn, "tabla_test", columnas, factory);
    }

    @Test
    void testCargarTodos_agregaRegistros() throws SQLException {
        when(mockRs.next()).thenReturn(true, false);
        when(mockRs.getString("id")).thenReturn("1");
        when(mockRs.getString("nombre")).thenReturn("Camila");

        panel.cargarTodos();

        assertEquals(1, panel.model.size());
        assertEquals("Camila", panel.model.getElementAt(0).getValue("nombre"));
    }

    @Test
    void testBtnNuevo_insertaRegistro() throws SQLException {
        // Simular entrada del usuario
        mockUserInput("Juan");

        // Simular generación de llave
        ResultSet keys = mock(ResultSet.class);
        when(mockPs.getGeneratedKeys()).thenReturn(keys);
        when(keys.next()).thenReturn(true);
        when(keys.getString(1)).thenReturn("2");

        // Simular botón presionado
        panel.btnNuevo.doClick();

        // Verifica que se haya ejecutado INSERT
        verify(mockPs).executeUpdate();
    }

    @Test
    void testBtnGuardar_actualizaRegistro() throws SQLException {
        // Simula que hay un elemento seleccionado
        MockRegistro r = new MockRegistro();
        r.setValue("id", "1");
        r.setValue("nombre", "OldName");
        panel.model.addElement(r);
        panel.list.setSelectedIndex(0);

        // Modifica campo de nombre
        panel.fields[1].setText("NewName");

        // Simula botón presionado
        when(mockConn.prepareStatement(anyString())).thenReturn(mockPs);
        panel.btnGuardar.doClick();

        // Verifica que se haya ejecutado UPDATE
        verify(mockPs).executeUpdate();
        assertEquals("NewName", r.getValue("nombre"));
    }

    @Test
    void testBtnEliminar_eliminaRegistro() throws SQLException {
        // Simula selección
        MockRegistro r = new MockRegistro();
        r.setValue("id", "5");
        r.setValue("nombre", "Carlos");
        panel.model.addElement(r);
        panel.list.setSelectedIndex(0);
        panel.fields[0].setText("5");

        // Simula confirmación positiva
        JOptionPane pane = mock(JOptionPane.class);
        JOptionPane.setDefaultLocale(Locale.ENGLISH);
        mockConfirmDialog(JOptionPane.YES_OPTION);

        when(mockConn.prepareStatement(anyString())).thenReturn(mockPs);

        // Simula botón presionado
        panel.btnEliminar.doClick();

        verify(mockPs).executeUpdate();
    }

    // --- Clases auxiliares ---

    /** Implementación simulada de Registro */
    static class MockRegistro implements Registro {
        Map<String, Object> data = new HashMap<>();

        @Override
        public Object getValue(String col) {
            return data.get(col);
        }

        @Override
        public void setValue(String col, Object val) {
            data.put(col, val);
        }

        @Override
        public String toString() {
            return String.valueOf(getValue("nombre"));
        }
    }

    // Simula JOptionPane.showInputDialog
    void mockUserInput(String... inputs) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(inputs));
        JOptionPane mockPane = mock(JOptionPane.class);
        mockStatic(JOptionPane.class);
        when(JOptionPane.showInputDialog(any(), anyString())).thenAnswer(inv -> queue.poll());
    }

    // Simula JOptionPane.showConfirmDialog
    void mockConfirmDialog(int response) {
        mockStatic(JOptionPane.class);
        when(JOptionPane.showConfirmDialog(any(), anyString()))
                .thenReturn(response);
    }
}
