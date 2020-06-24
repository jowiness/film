package org.gec.dao;

import org.gec.entity.Filminfo;

import java.util.List;

public interface FilminfoDao {
    List<Filminfo> findAllInfo(Filminfo filminfo);

    void save(Filminfo filminfo);
}
