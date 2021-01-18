package management.system.at.an.IT.enterprise.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

        private String name;

    private String photoURL;

    private String descr;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }


        public String getName() {
            return name;
        }

    public String getDesc() {
        return descr;
    }

    public String getPhotoURL() {
        return photoURL;
    }
        public Car(){

        }
        public Car(String name, String photoURL, String descr){
            this.name=name;
            this.photoURL=photoURL;
            this.descr=descr;
        }

    public void setDesc(String descr) {
        this.descr = descr;
    }

        public void setName(String name) {
            this.name = name;
        }


    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Manufacturer manufacturer;


    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments = new ArrayList<>();


    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Assessment> assessments = new ArrayList<>();



}


