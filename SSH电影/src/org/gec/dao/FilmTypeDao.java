package org.gec.dao;

import org.gec.entity.Filmtype;

import java.util.List;

public interface FilmTypeDao {
    List<Filmtype> findAllTypes();
}
