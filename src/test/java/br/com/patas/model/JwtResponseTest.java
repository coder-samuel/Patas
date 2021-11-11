package br.com.patas.model;

import org.junit.jupiter.api.Test;

import br.com.patas.model.JwtResponse;

import static org.junit.jupiter.api.Assertions.*;

class JwtResponseTest {

    @Test
    void getToken() {
        JwtResponse j = new JwtResponse("getToken");
        assertEquals("getToken", j.getToken());
    }
}