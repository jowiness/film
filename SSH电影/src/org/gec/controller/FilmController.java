package org.gec.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.gec.dao.FilminfoDao;
import org.gec.dao.impl.FilminfoDaoImpl;
import org.gec.entity.Filminfo;
import org.gec.entity.Filmtype;
import org.gec.service.FilmInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilmController extends ActionSupport {

    @Autowired
    private FilmInfoService filmInfoService;
    private String filmname;
    private Integer typeid;
    private String actor;
    private String director;
    private Double smallprice;
    private Double bigprice;

    //票价
    private Double ticketprice;

    public List<Filminfo> getResult() {
        return result;
    }

    //电影list
    List<Filminfo> result;

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setSmallprice(Double smallprice) {
        this.smallprice = smallprice;
    }

    public void setBigprice(Double bigprice) {
        this.bigprice = bigprice;
    }

    public void setTicketprice(Double ticketprice) {
        this.ticketprice = ticketprice;
    }

    public String findFilms() throws Exception{
        Filmtype filmtype = new Filmtype();

        //选了类型
        if (typeid != 0){
            filmtype.setTypeid(typeid);
        }

        //电影条件
        Filminfo filminfo = new Filminfo(filmtype,filmname,actor,director,bigprice,smallprice);

        //查询
        result = filmInfoService.findAllInfo(filminfo);

        return SUCCESS;
    }

    public String FilmAddServlet() throws Exception{
        //电影类型
        Filmtype filmtype = new Filmtype();
        filmtype.setTypeid(typeid);

        //电影条件
        Filminfo filminfo = new Filminfo(filmtype,filmname,actor,director,bigprice,smallprice);
        //设置票价
        filminfo.setTicketprice(ticketprice);

        //查询
        filmInfoService.save(filminfo);

        ActionContext.getContext().put("message","电影添加成功");
        return SUCCESS;
    }

}
