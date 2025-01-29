package controller;

import model.LivroModel;
import repository.LivroRepository;

import java.sql.SQLException;

public class LivroController {
    private LivroRepository livroRepository = new LivroRepository();

    public String salvar(LivroModel livro) throws SQLException{
        return livroRepository.salvar(livro);
    }


}
