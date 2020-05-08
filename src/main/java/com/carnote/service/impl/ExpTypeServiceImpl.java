package com.carnote.service.impl;

import com.carnote.dao.ExpTypeDAO;
import com.carnote.model.entity.ExpType;
import com.carnote.service.ExpTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExpTypeServiceImpl implements ExpTypeService {

    @Autowired
    ExpTypeDAO expTypeDAO;

    @Override
    @Transactional
    public ExpType getExpType(int id) {
        return expTypeDAO.getExpType(id);
    }

    @Override
    @Transactional
    public ExpType getExpTypeByName(String name) {
        return expTypeDAO.getExpTypeByName(name);
    }
}
