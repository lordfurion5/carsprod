package management.system.at.an.IT.enterprise.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String reliability;

    private String quality;

    private String service;

    public Assessment(String reliability, String quality, String service) {
        this.reliability = reliability;
        this.quality = quality;
        this.service = service;
    }

    public Assessment() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getReliability() {
        return reliability;
    }

    public void setReliability(String reliability) {
        this.reliability = reliability;
    }


    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;



}



