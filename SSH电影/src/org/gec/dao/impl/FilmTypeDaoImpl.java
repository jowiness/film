package org.gec.dao.impl;

import org.gec.dao.FilmTypeDao;
import org.gec.entity.Filmtype;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("filmTypeDao")
public class FilmTypeDaoImpl implements FilmTypeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Filmtype> findAllTypes() {
        //1 创建查询条件
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Filmtype.class);

        //2返回给servlet
        List<Filmtype> list = criteria.list();

        return list;
    }
}
