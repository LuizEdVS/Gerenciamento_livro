package com.example.books;

import com.example.books.model.Livro;
import com.example.books.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro criar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public boolean deletarPorId(Long id) {
        if (!livroRepository.existsById(id)) {
            return false;
        }
        livroRepository.deleteById(id);
        return true;
    }
}

