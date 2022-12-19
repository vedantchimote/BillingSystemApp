package tech.vedantchimote.controller;

import tech.vedantchimote.entity.Role;
import tech.vedantchimote.entity.User;
import tech.vedantchimote.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {

        List<User> userList = role.getUsers();
        userList.forEach(user -> {
            List<Role> roles = new ArrayList<>();
            roles.add(role);
            user.setRoles(roles);
        });
        Role newRole = roleService.saveRole(role);
        ResponseEntity<Role> responseEntity = new ResponseEntity<>(newRole, HttpStatus.CREATED);
        return responseEntity;
    }
}
