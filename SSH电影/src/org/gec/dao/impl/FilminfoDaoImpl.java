package org.gec.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.gec.dao.FilminfoDao;
import org.gec.entity.Filminfo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("filminfoDao")
public class FilminfoDaoImpl implements FilminfoDao {
    @Autowired//byType 按照类型来完成注入  @ReSource byName
    private SessionFactory sessionFactory;


    @Override
    public List<Filminfo> findAllInfo(Filminfo filminfo) {
        //查询条件
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Filminfo.class);

        //各种判断
        if(StringUtils.isNotEmpty(filminfo.getFilmname())){
            criteria.add(Restrictions.like("filmname","%"+filminfo.getFilmname()+"%"));
        }

        if(StringUtils.isNotEmpty(filminfo.getActor())){
            criteria.add(Restrictions.like("actor","%"+filminfo.getActor()+"%"));
        }

        if(StringUtils.isNotEmpty(filminfo.getDirector())){
            criteria.add(Restrictions.like("director","%"+filminfo.getDirector()+"%"));
        }

        if(filminfo.getFilmType().getTypeid() != null){
            criteria.add(Restrictions.eq("filmType.typeid",filminfo.getFilmType().getTypeid()));
        }

        if(filminfo.getSmallprice() != null){
            criteria.add(Restrictions.ge("ticketprice",filminfo.getSmallprice()));
        }

        if(filminfo.getBigprice() != null){
            criteria.add(Restrictions.le("ticketprice",filminfo.getBigprice()));
        }


        return criteria.list();
    }

    @Override
    public void save(Filminfo filminfo) {
        System.out.println("daoimpl.save:" + filminfo);
        this.sessionFactory.getCurrentSession().save(filminfo);
    }

}
