package management.system.at.an.IT.enterprise.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Manufacturer {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        private String name;

    private String logo;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }


        public String getName() {
            return name;
        }


    public String getLogo() {
        return logo;
    }
        public Manufacturer(){

        }
        public Manufacturer(String name, String logo){
            this.name=name;
            this.logo=logo;
        }

        public void setName(String name) {
            this.name = name;
        }
    public void setLogo(String logo) {
        this.logo = logo;
    }

        @OneToMany(
                cascade = CascadeType.ALL,
                orphanRemoval = true
        )
        private List<Car> tasks = new ArrayList<>();

    }


