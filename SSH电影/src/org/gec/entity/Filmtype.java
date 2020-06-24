package org.gec.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Filmtype {
    private Integer typeid;
    private String typename;
    private Set<Filminfo> filmInfo = new HashSet<>();

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filmtype filmtype = (Filmtype) o;
        return typeid == filmtype.typeid &&
                Objects.equals(typename, filmtype.typename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeid, typename);
    }

    public Set<Filminfo> getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(Set<Filminfo> filmInfo) {
        this.filmInfo = filmInfo;
    }
}
