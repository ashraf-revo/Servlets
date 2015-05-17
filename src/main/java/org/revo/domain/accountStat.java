package org.revo.domain;

import java.io.Serializable;

/**
 * Created by ashraf on 4/25/15.
 */
public class accountStat implements Serializable{
    private String name;

    public accountStat() {
    }

    public accountStat(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
