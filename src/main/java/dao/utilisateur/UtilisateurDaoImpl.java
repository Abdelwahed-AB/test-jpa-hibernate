package dao.utilisateur;

import entities.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.DbConfig;

import java.util.List;

public class UtilisateurDaoImpl implements IUtilisateurDao{

    private EntityManager entityManager;

    public UtilisateurDaoImpl() {
        this.entityManager = DbConfig.entityManager();
    }

    @Override
    public List<Utilisateur> rechercher() {
        entityManager.getTransaction().begin();
        try{
            Query query = entityManager.createQuery(
                    "from Utilisateur u order by u.id asc"
            );
            List<Utilisateur> results = query.getResultList();
            entityManager.getTransaction().commit();
            return results;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteUtilisateur(Utilisateur user) {
        entityManager.getTransaction().begin();
        try{
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
