package com.ironyard.movies.data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jasonskipper on 10/3/16.
 */
@Entity
public class Movie {
    private String name;
    private String cat;
    private int salesAmountMillions;

    /**
     * Composition means this object is composed of others
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<Actor> actors;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getSalesAmountMillions() {
        return salesAmountMillions;
    }

    public void setSalesAmountMillions(int salesAmountMillions) {
        this.salesAmountMillions = salesAmountMillions;
    }
}
