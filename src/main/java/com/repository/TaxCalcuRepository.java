package com.repository;

import com.domain.Variables;

import java.util.List;

public interface TaxCalcuRepository {
    public List<Variables> getAll();
    public Variables update(Variables variables);
    public Variables get(Long id);
    public Variables create(Variables variables);
    public void delete(Long id);
    public List<Variables> gethistory(long userid);
}
