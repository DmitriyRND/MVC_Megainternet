package org.example.mvc_megainternet.service;

import lombok.RequiredArgsConstructor;
import org.example.mvc_megainternet.model.Statement;
import org.example.mvc_megainternet.repository.StatementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatementService {

    private final StatementRepository repository;

    public Statement saveStatement(Statement statement) {
        return repository.save(statement);

    }

    public List<Statement> getAllStatements() {
        return repository.findAll();
    }

    public void  deleteById(String id) {
        repository.deleteById(Long.parseLong(id));
    }

    public Statement getById(long id) {

        return repository.findById(id).orElse(null);
    }
}
