package com.ifpb.ads.crud;

import com.ifpb.ads.entidades.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class CRUD {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public CRUD() {
        this.entityManager = Persistence.createEntityManagerFactory("Persistencia").createEntityManager();
        this.transaction = entityManager.getTransaction();
    }

    // Inserir na tabela
    public void create(Pessoa p) {
        this.transaction.begin();
        this.entityManager.persist(p);
        this.transaction.commit();
    }

    // Listar todos
    public List<Pessoa> read() {
        CriteriaQuery<Pessoa> criteria = entityManager.getCriteriaBuilder().
                createQuery(Pessoa.class);
        criteria.select(criteria.from(Pessoa.class));
        return entityManager.createQuery(criteria).getResultList();
    }
    
    // Atualizar (necessário setar o id para a Pessoa)
    public void update (Pessoa p){
        this.transaction.begin();
        this.entityManager.merge(p);
        this.transaction.commit();
    }
    
    // Remover da tabela
    public void delete (int id){
        this.transaction.begin();
        Pessoa aux = this.entityManager.find(Pessoa.class, id);
        if (aux != null){
            this.entityManager.remove(aux);
        }
        this.transaction.commit();
    }

}
