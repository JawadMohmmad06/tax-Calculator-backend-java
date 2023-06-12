package com.service;

import com.domain.Variables;
import com.repository.TaxCalcuRepositoryImp;
import com.repository.TaxRateRepositoryImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Service
@Transactional
public class AdminServiceImp implements AdminService{
    private TaxRateRepositoryImp taxRateRepositoryImp;
    private TaxCalcuRepositoryImp taxCalcuRepositoryImp;

    private DataSource dataSource;
    public AdminServiceImp(TaxCalcuRepositoryImp taxCalcuRepositoryImp, TaxRateRepositoryImp taxRateRepositoryImp) {
        this.taxCalcuRepositoryImp = taxCalcuRepositoryImp;
        this.taxRateRepositoryImp = taxRateRepositoryImp;
    }
    @Transactional(readOnly = true)
    public List<Variables> get() {
        return taxCalcuRepositoryImp.getAll();
    }
    @Transactional
    public Variables update(Variables variables) {
        return taxCalcuRepositoryImp.update(variables);
    }
    @Transactional
    public void delete(Long id) {
        taxCalcuRepositoryImp.delete(id);
    }
    @Transactional(readOnly = true)
    public Variables getid(Long id) {
        return taxCalcuRepositoryImp.get(id);
    }
}
