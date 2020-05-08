package com.carnote.service;

import com.carnote.model.entity.ExpType;

public interface ExpTypeService {

    public ExpType getExpType(int id);
    public ExpType getExpTypeByName(String name);
}
