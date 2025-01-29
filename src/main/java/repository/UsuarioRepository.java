package repository;

import controller.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class UsuarioRepository {
    private final SessionFactory sessionFactory;
    private final Session session;

    public UsuarioRepository() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public UsuarioRepository(Session session) {
        this.session = session;
        this.sessionFactory = session.getSessionFactory();
    }

    public void saveUser(Usuario usuario) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public Usuario getUserById(int id) {
        return session.get(Usuario.class, id);
    }

    public List<Usuario> getAllUsers() {
        return session.createQuery("FROM Usuario", Usuario.class).list();
    }

    public void updateUser(Usuario usuario) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(usuario);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            Usuario usuario = session.get(Usuario.class, id);
            if (usuario != null) {
                session.delete(usuario);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void close() {
        session.close();
        sessionFactory.close();
    }
}
