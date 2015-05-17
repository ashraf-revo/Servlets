package model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ashraf on 5/8/15.
 */
public class displayx implements Serializable {
    private String img;
    private String name;
    private String master;
    private String desc;
    private List<String> filename;
    private String states;

    public displayx(String img, String name, String master, String desc, List<String> filename, String states) {
        this.img = img;
        this.name = name;
        this.master = master;
        this.desc = desc;
        this.filename = filename;
        this.states = states;
    }

    public displayx() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getFilename() {
        return filename;
    }

    public void setFilename(List<String> filename) {
        this.filename = filename;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }
}
