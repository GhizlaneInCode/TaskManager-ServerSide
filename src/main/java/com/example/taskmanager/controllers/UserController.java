package com.example.taskmanager.controllers;

import com.example.taskmanager.dto.requests.UpdateRoleRequestDto;
import com.example.taskmanager.dto.requests.UserRequestDto;
import com.example.taskmanager.dto.responses.UserResponseDto;
import com.example.taskmanager.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return  ResponseEntity.ok(userService.getAllUsers());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "update User Role")
    @PutMapping("/{id}/role")
    public ResponseEntity<UserResponseDto> UpdateUserRole(@PathVariable Long id,@Valid @RequestBody UpdateRoleRequestDto roleRequestDto){
        return ResponseEntity.ok(userService.UpdateUserRole(id, roleRequestDto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update User")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> UpdateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDto requestDto){
        return ResponseEntity.ok(userService.UpdateUser(id,requestDto));
    }
}
