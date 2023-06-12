package com.service;

import com.domain.Variables;

import java.util.List;

public interface AdminService {
    public List<Variables> get();
    public Variables update(Variables variables);
    public void delete(Long id);
    public Variables getid(Long id);
}
