package com.kevincode.controllers;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevincode.controllers.request.createUserDto;
import com.kevincode.data.mysql.entitites.ERoleMysqlEntity;
import com.kevincode.data.mysql.entitites.RoleMysqlEntity;
import com.kevincode.data.mysql.entitites.UserMysqlEntity;
import com.kevincode.data.mysql.repositories.UserMysqlRepository;

import jakarta.validation.Valid;

@RestController
public class PrincipalController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMysqlRepository userMysqlRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World Not Secured";
    }

    @GetMapping("/helloSecured")
    public String helloSecured() {
        return "Hello World Secured";
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody createUserDto createUserDTO) {
        // los roles en el dto viene como un string, por lo que tengo que convertir ese
        // valor
        // 1 createUserDTO.getRoles(): Obtiene la colección de roles del DTO, que es unSet<String>

        // 2 .stream(): Convierte la colección en un Stream para aplicar operaciones funcionales

        // 3 .map(): Mapea cada elemento String del stream a un objeto RoleMysqlEntity
        // Usa un builder para construir el objeto
        // Obtiene el enum valor correspondiente al string
        // Devuelve un Stream de RoleMysqlEntity

        // 4 .collect(Collectors.toSet()):
        // Finaliza el stream recogiendo los resultados en un Set
        // Evita duplicados al usar un Set

        // 5 Set<RoleMysqlEntity> roles: Declaration de la variable de destino
        Set<RoleMysqlEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> RoleMysqlEntity.builder()
                        .name(ERoleMysqlEntity.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserMysqlEntity userMysqlEntity = UserMysqlEntity.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();

                userMysqlRepository.save(userMysqlEntity);

        return ResponseEntity.ok(userMysqlEntity);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id) {
        userMysqlRepository.deleteById(Long.parseLong(id));
        return "Se ha borrado el user con id ".concat(id);
    }
}
