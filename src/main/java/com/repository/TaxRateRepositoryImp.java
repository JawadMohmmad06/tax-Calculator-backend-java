package com.repository;

import com.domain.TaxRate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TaxRateRepositoryImp implements TaxRateRipository {
    private SessionFactory sessionFactory;

    public TaxRateRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<TaxRate> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<TaxRate> taxRateQuery = session.createQuery("from taxslnrate", TaxRate.class);
        return taxRateQuery.getResultList();
    }
    public TaxRate get() {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TaxRate.class, 1L);
    }
    public TaxRate update(TaxRate taxRate) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(taxRate);
        return taxRate;
    }

}
