package com.div.controller;

import com.div.dto.RoleDto;
import com.div.service.RoleService;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping
    public RoleDto creatRole(@RequestBody RoleDto roleDto) {
        return roleService.creatRole(roleDto);

    }

    @GetMapping

    public List<RoleDto>getAllRole(){
        return roleService.getAllRole();

    }

    @GetMapping("/{id}")

    public RoleDto getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id);

    }
    @PutMapping("/{id}")

    public void updateRoleById(@PathVariable Long id,@RequestBody RoleDto roleDto){
        roleService.updateRoleById(id,roleDto);

    }
    @DeleteMapping("/{id}")

    public void deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
    }
}
