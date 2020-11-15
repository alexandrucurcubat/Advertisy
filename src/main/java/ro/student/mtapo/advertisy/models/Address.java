package ro.student.mtapo.advertisy.models;


import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "street_address")
    String streetAddress;

    @ManyToOne
    @JoinColumn(name = "county_id")
    County county;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", county=" + county +
                '}';
    }
}
