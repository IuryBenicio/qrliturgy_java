package com.example.qrliturgy.Tables.Liturgia;

import com.example.qrliturgy.Tables.Liturgia.DTO.LiturgiaDTORequest;
import com.example.qrliturgy.Tables.Liturgia.DTO.LiturgiaDTOResponse;
import com.example.qrliturgy.Tables.Liturgia.exceptions.LiturgiaNotFounded;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LiturgiaService {

    private final LiturgiaRepository liturgiaRepository;
    private final LiturgiaMapper liturgiaMapper;
    private final LiturgiaMapperNull liturgiaMapperNull;

    public LiturgiaService(LiturgiaRepository liturgiaRepository, LiturgiaMapper liturgiaMapper, LiturgiaMapperNull liturgiaMapperNull) {
        this.liturgiaRepository = liturgiaRepository;
        this.liturgiaMapper = liturgiaMapper;
        this.liturgiaMapperNull = liturgiaMapperNull;
    }

    public LiturgiaDTOResponse getLiturgia(){
        LiturgiaEntity liturgia = liturgiaRepository.findFirstByOrderByIdDesc().orElseThrow(()-> new LiturgiaNotFounded("Liturgia não encontrada"));
        return liturgiaMapper.toDTO(liturgia);
    }

    @Transactional //se ocorrer um erro essa anotação garante que o processo será totalmente revertido
    public LiturgiaDTOResponse editLiturgia(long id, LiturgiaDTORequest dto){
        LiturgiaEntity liturgia = liturgiaRepository.findById(id).orElseThrow(()->new LiturgiaNotFounded("Liturgia não encontrada"));

        liturgiaMapperNull.updateEntityFromDTO(dto, liturgia);
        try{
            liturgiaRepository.save(liturgia);
            return liturgiaMapper.toDTO(liturgia);
        } catch (Exception e) {
            throw new RuntimeException("erro ao editar liturgia: " + e.getMessage());
        }
    }

    public LiturgiaDTOResponse newLiturgia(LiturgiaDTORequest dto){
        LiturgiaEntity liturgia = new LiturgiaEntity();
        liturgiaMapperNull.createNewEntity(liturgia, dto);
        liturgiaRepository.save(liturgia);
        return liturgiaMapper.toDTO(liturgia);
    }
}
