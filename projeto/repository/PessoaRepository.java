package com.example.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projeto.model.Pessoa;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public PessoaService (PessoaRepository pessoaRepository){

        this.PessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public Optional buscarPorId(Long id){
        return pessoaRepository.findById(id);
    }

    public Pessoa salvarPessoa(Pessoa){
        return pessoaRepository.save(pessoa);
    }
    public void deletarPessoa(Long id){
        pessoaRepository.deletarById(id);
    }

} 
