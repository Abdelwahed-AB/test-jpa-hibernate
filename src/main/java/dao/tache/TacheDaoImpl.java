package dao.tache;

import entities.Tache;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.DbConfig;

import java.util.List;

public class TacheDaoImpl implements ITacheDao{

    private EntityManager entityManager;

    public TacheDaoImpl() {
        entityManager = DbConfig.entityManager();
    }

    @Override
    public List<Tache> rechercher() {
        entityManager.getTransaction().begin();
        try{
            Query query = entityManager.createQuery(
                    "from Tache t order by t.id asc"
            );
            List<Tache> results = query.getResultList();
            entityManager.getTransaction().commit();
            return results;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
