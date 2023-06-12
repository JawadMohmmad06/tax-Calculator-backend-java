package com.repository;

import com.domain.TaxRate;

import java.util.List;

public interface TaxRateRipository {
    public List<TaxRate> getAll();
    public TaxRate get();
    public TaxRate update(TaxRate taxRate);
}
