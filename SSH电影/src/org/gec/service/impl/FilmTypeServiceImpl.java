package org.gec.service.impl;

import org.gec.dao.FilmTypeDao;
import org.gec.entity.Filmtype;
import org.gec.service.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("filmTypeService")
public class FilmTypeServiceImpl implements FilmTypeService {
    @Autowired
    private FilmTypeDao filmTypeDao;

    @Override
    public List<Filmtype> findAllTypes() {
        return filmTypeDao.findAllTypes();
    }
}
