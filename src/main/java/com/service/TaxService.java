package com.service;

import com.domain.TaxRate;
import com.domain.Variables;

import java.util.List;

public interface TaxService {
    public double taxible_salary(int basic_salary,int conveyance,int medical,int house_rent,int festibal);
    public Variables calcu(Variables variables);
    public List<Variables> gethistory(long userid);
    public Variables update(Variables variables);
    public Variables get(Long id);
    public void delete(Long id);
    public List<Variables> getAll();
    public List<Variables> get();
    public TaxRate gettaxrate();
    public TaxRate updatet(TaxRate taxRate);
}
