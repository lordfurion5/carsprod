package management.system.at.an.IT.enterprise.demo.models;

import javax.persistence.*;

@Entity
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;


    private String title
            ;
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


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Comment(){

    }
    public Comment(String name, String title){
        this.name=name;
        this.title=title;
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

