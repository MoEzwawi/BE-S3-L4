package MoEzwawi.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Location {
    @Column(name="venue_name",unique = false)
    private String name;
    @Column(name="venue_city")
    private String city;

    public Location() {

    }
    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
