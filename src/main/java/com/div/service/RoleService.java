package com.div.service;

import com.div.dto.RoleDto;
import com.div.entity.Role;
import com.div.mapper.RoleMapper;
import com.div.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private  final RoleRepository roleRepository;

    private  final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }


    public RoleDto creatRole(RoleDto roleDto) {
    Role role=roleMapper.toRole(roleDto);
    Role savedRole=roleRepository.save(role);

    return roleMapper.toDto(savedRole);
    }

    public List<RoleDto> getAllRole() {
        List<Role> all =roleRepository.findAll();
        List<RoleDto>roleDtoList=all.stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());


        return roleDtoList;
    }

    public RoleDto getRoleById(Long id) {

        Role role = roleRepository.findById(id).orElse(null);

        return roleMapper.toDto(role);
    }

    public void updateRoleById(Long id, RoleDto roleDto) {
        Optional<Role>roleOptional= roleRepository.findById(id);
        if(roleOptional.isPresent()){
         Role oldRole=   roleOptional.get();
         oldRole.setName(roleDto.getName());
         roleRepository.save(oldRole);
        }
    }

    public void deleteRole(Long id) {

        roleRepository.deleteById(id);

    }
}
