package com.example.qrliturgy.Tables.Admin;

import com.example.qrliturgy.Tables.Admin.DTOS.AdminDTORequest;
import com.example.qrliturgy.Tables.Admin.DTOS.AdminDTOResponse;
import com.example.qrliturgy.Tables.Admin.exceptions.AdminExists;
import com.example.qrliturgy.Tables.Admin.exceptions.AdminNotFounded;
import com.example.qrliturgy.Tables.Admin.exceptions.SenhaIncorreta;
import com.example.qrliturgy.Utils.HashDeSenhas;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final HashDeSenhas hashDeSenhas;

    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper, HashDeSenhas hashDeSenhas) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
        this.hashDeSenhas = hashDeSenhas;
    }

    public AdminDTOResponse login(AdminDTORequest loginDTO){
        AdminEntity admin = adminRepository.findByEmail(loginDTO.email()).orElseThrow(()-> new AdminNotFounded("Administrador não encontrado"));

        if (!hashDeSenhas.verificaSenha(loginDTO.password(), admin.getPassword())){
            throw new SenhaIncorreta("Senha incorreta");
        }

        return adminMapper.toDTO(admin);
    }

    public void changePassword(String email, String oldPassword, String newPassword){

        AdminEntity admin = adminRepository.findByEmail(email).orElseThrow(()-> new AdminNotFounded("Administrador não encontrado"));

        if(!hashDeSenhas.verificaSenha(oldPassword, admin.getPassword())){
            throw new SenhaIncorreta("Senha incorreta!");
        }

        if(hashDeSenhas.verificaSenha(newPassword, admin.getPassword())){
            throw new SenhaIncorreta("Senha precisa ser nova!");
        }

        if (newPassword.length() < 6){
            throw new SenhaIncorreta("Senha precisa ter no mínimo 6 digitos");
        }

        if (!newPassword.matches(".*\\d.")){
            throw new SenhaIncorreta("Senha precisa conter pelo menos 1 número");
        }

        if (!newPassword.matches(".*[a-zA-Z].")){
            throw new SenhaIncorreta("Senha precisa conter pelo menos 1 letra");
        }

        try{
            admin.setPassword(hashDeSenhas.codificarSenha(newPassword));
            adminRepository.save(admin);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao setar nova senha" + e);
        }
    }

    public AdminDTOResponse register(AdminDTORequest adminDTORequest){
        if ( adminRepository.findByEmail(adminDTORequest.email()).isPresent() || adminRepository.findByNome(adminDTORequest.nome()).isPresent()){
            throw new AdminExists("Administrador já cadastrado");
        }

        if (adminDTORequest.password().length() < 6){
            throw new SenhaIncorreta("Senha precisa ter no mínimo 6 digitos");
        }

        if (!adminDTORequest.password().matches(".*\\d.")){
            throw new SenhaIncorreta("Senha precisa conter pelo menos 1 número");
        }

        if (!adminDTORequest.password().matches(".*[a-zA-Z].")){
            throw new SenhaIncorreta("Senha precisa conter pelo menos 1 letra");
        }

        String senhaEncriptada = hashDeSenhas.codificarSenha(adminDTORequest.password());

        try{
            AdminEntity newAdmin = new AdminEntity();
            newAdmin.setNome(adminDTORequest.nome());
            newAdmin.setEmail(adminDTORequest.email());
            newAdmin.setPassword(senhaEncriptada);

            adminRepository.save(newAdmin);
            return adminMapper.toDTO(newAdmin);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar administrador" + e);
        }
    }
}
