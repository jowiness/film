package org.gec.service.impl;

import org.gec.dao.FilminfoDao;
import org.gec.entity.Filminfo;
import org.gec.service.FilmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("filmInfoService")
public class FilmInfoServiceImpl implements FilmInfoService {
    @Autowired
    private FilminfoDao filminfoDao;

    @Override
    public List<Filminfo> findAllInfo(Filminfo filminfo) {
        return filminfoDao.findAllInfo(filminfo);
    }

    @Override
    public void save(Filminfo filminfo) {
        filminfoDao.save(filminfo);
    }
}
