package com.carnote.service;

import com.carnote.model.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    public void add(UserRole userRole);
    public void edit(UserRole userRole);
    public void delete(int id);
    public UserRole getUserRole(int id);
    public List getAllUserRoles(String username);
}