package br.com.patas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.patas.config.JwtTokenUtil;
import br.com.patas.entities.Pessoa;
import br.com.patas.enums.EnumException;
import br.com.patas.exception.ValidationException;
import br.com.patas.model.JwtRequest;
import br.com.patas.model.JwtResponse;
import br.com.patas.services.PessoaService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private PessoaService usuarioService;

    @Autowired
    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, PessoaService usuarioService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<Object> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {

        Pessoa p = usuarioService.getPersonByEmail(authenticationRequest.getUsername()).orElseThrow(() ->
                new ValidationException(EnumException.ITEM_NAO_ENCONTRADO));

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final String token = jwtTokenUtil.generateToken(p,
                authenticationRequest.getSpecificClaim() != null ? authenticationRequest.getSpecificClaim().toString().replace("=", ":") : "");

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws ValidationException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new ValidationException(EnumException.INVALID_CREDENTIALS);
        }
    }
}
