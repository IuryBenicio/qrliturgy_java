package com.example.qrliturgy.Tables.Admin;

import com.example.qrliturgy.Tables.Admin.DTOS.AdminDTORequest;
import com.example.qrliturgy.Tables.Admin.DTOS.AdminDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminDTORequest loginDTO){
        AdminDTOResponse Response = adminService.login(loginDTO);
        return ResponseEntity.ok(Response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminDTORequest registerDTO){
        AdminDTOResponse response = adminService.register(registerDTO);
        return ResponseEntity.ok(response);
    }
}
