package com.FarraXD.CRUD_01.DAO;
import com.FarraXD.CRUD_01.Models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsuarioDAOImplement implements  IUsuarioDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuario> getUsuario() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();

    }
    @Override
    public void Eliminar(Long id) {

        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);

    }

    @Override
    public void CrearUsuario(Usuario usuario) {

        entityManager.merge(usuario);
    }

    @Override
    public boolean EmailAuthPass(Usuario usuario) {
        String query = "FROM Usuario WHERE Email= :email";

        List<Usuario> Lista = entityManager.createQuery(query)
                .setParameter("email" , usuario.getEmail())
                .getResultList();

        if (Lista.isEmpty()){
            return  false;
        }
        String passwordHashed = Lista.get(0).getContrasena();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

       return argon2.verify(passwordHashed, usuario.getContrasena());
    }
}
