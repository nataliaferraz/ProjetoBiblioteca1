package repository;

import model.LivroModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class LivroRepository {

    private static LivroRepository instance;
    protected EntityManager entityManager;

    public LivroRepository(){
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static LivroRepository getInstance(){
        if(instance == null){
            instance = new LivroRepository();
        }
        return instance;
    }

    public String salvar(LivroModel livro) throws SQLException {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(livro);
            entityManager.getTransaction().commit();
            return "Salvo com Sucesso.";
        }catch(Exception e){
            return e.getMessage();
        }
    }
}
