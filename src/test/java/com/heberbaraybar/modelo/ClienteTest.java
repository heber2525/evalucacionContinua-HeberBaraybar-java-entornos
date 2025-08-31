package com.heberbaraybar.modelo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void crearCLiente(){
        cliente = new Cliente("Heber", "Baraybar", "671237941", 221122, "heber@.com");

    }

    @Test
    public void testGetCompararNombreClienteAlta(){
        assertEquals("Heber", cliente.getNombre());
    }

    @Test
    public void testSetCambiarNombreCliente(){
        cliente.setNombre("Paco");
        assertEquals("Paco", cliente.getNombre());
    }
    @Test
    public void testEmailIncorrecto(){
        cliente.setDni(222);
        assertNotEquals(232323, cliente.getDni());
    }
}
