package org.gec.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.gec.dao.FilmTypeDao;
import org.gec.dao.FilminfoDao;
import org.gec.dao.impl.FilmTypeDaoImpl;
import org.gec.dao.impl.FilminfoDaoImpl;
import org.gec.entity.Filminfo;
import org.gec.entity.Filmtype;
import org.gec.service.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Cinema extends ActionSupport {
    @Autowired
    private FilmTypeService filmTypeService;

    List<Filmtype> allFilmType;

    public List<Filmtype> getAllFilmType() {
        return allFilmType;
    }

    public String execute() {
        //获取所有的电影类型
        allFilmType = filmTypeService.findAllTypes();
        return SUCCESS;
    }

}
