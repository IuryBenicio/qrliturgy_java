package com.example.qrliturgy.Tables.Admin;

import com.example.qrliturgy.Tables.Admin.DTOS.AdminDTOResponse;
import com.example.qrliturgy.Tables.Admin.DTOS.AdminDTORequest;
import com.example.qrliturgy.Tables.Admin.DTOS.AdminDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity<AdminDTOResponse> loginAdmin(@RequestBody AdminDTORequest loginDTO){
        AdminDTO user = adminService.login(loginDTO);
        AdminDTOResponse response = new AdminDTOResponse(user, "Login efetuado com sucesso");
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<AdminDTOResponse> registerAdmin(@RequestBody AdminDTORequest registerDTO){
        AdminDTO user = adminService.register(registerDTO);
        AdminDTOResponse response = new AdminDTOResponse(user, "Registro efetuado com sucesso");
        return ResponseEntity.status(200).body(response);
    }
}
