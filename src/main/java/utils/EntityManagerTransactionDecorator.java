package utils;

import lombok.RequiredArgsConstructor;

import jakarta.persistence.EntityManager;

@RequiredArgsConstructor
public class EntityManagerTransactionDecorator{

    private final EntityManager entityManager;

    public Object save(Object o){
        entityManager.getTransaction().begin();

        try {
            entityManager.persist(o);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }

        return o;
    }


    public Object update(Object o){
        entityManager.getTransaction().begin();
        Object res;
        try {
            res = entityManager.merge(o);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }

        return res;
    }

    public void delete(Object o){
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(o);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public Object get(Class className, Object id){
        entityManager.getTransaction().begin();
        Object res;
        try {
            res = entityManager.find(className, id);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
        return res;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void close(){
        entityManager.close();
    }
}
