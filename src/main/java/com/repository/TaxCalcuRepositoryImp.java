package com.repository;
import com.domain.Variables;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TaxCalcuRepositoryImp implements TaxCalcuRepository {
    private SessionFactory sessionFactory;
    public TaxCalcuRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Variables> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Variables> variablesQuery = session.createQuery("from Variables", Variables.class);

        return variablesQuery.getResultList();
    }
    public Variables update(Variables variables) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(variables);
        return variables;
    }
    public Variables get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Variables.class, id);
    }
    public Variables create(Variables variables) {
        Session session = sessionFactory.getCurrentSession();
        session.save(variables);
        return variables;
    }
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Variables variables = get(id);
        if (variables != null) {
            session.delete(variables);
        }
    }
    public List<Variables> gethistory(long userid) {
        Session session = sessionFactory.getCurrentSession();
        Query<Variables> variablesQuery1 = session.createQuery("from Variables where userid = :userid", Variables.class);
        variablesQuery1.setParameter("userid", userid);
        return variablesQuery1.getResultList();
    }

}
