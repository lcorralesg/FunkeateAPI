package com.example.funkeateapi.model;

import javax.persistence.*;

/**
 *
 * author = Jacko Tinoco
 *
 * */

@Entity
@Table(name="funkos_diseño")
public class Diseño {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
