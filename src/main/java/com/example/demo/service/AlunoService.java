package com.example.demo.service;

import com.example.demo.entity.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    private List<Aluno> findAllAlunos() {
        return alunoRepository.findAll();
    }

    private Optional<Aluno> findAlunoById(Long id) {
        return alunoRepository.findById(id);
    }

    private Aluno saveAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    private void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    private Aluno updateAluno (Long id, Aluno updateAluno) {
        return alunoRepository.findById(id).map(aluno -> {
            aluno.setName(updateAluno.getName());
            aluno.setEmail(updateAluno.getEmail());
            aluno.setDataNascimento(updateAluno.getDataNascimento());
            aluno.setSenha(updateAluno.getSenha());
            return alunoRepository.save(aluno);
        }).orElseThrow(() -> new RuntimeException("Aluno não existe!"));
    }

}
