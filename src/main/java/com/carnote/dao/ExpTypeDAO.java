package com.carnote.dao;

import com.carnote.model.entity.ExpType;

public interface ExpTypeDAO {

    public ExpType getExpType(int id);
    public ExpType getExpTypeByName(String name);
}
