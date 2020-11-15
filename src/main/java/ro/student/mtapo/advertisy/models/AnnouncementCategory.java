package ro.student.mtapo.advertisy.models;

import javax.persistence.*;

@Entity
@Table(name = "announcement_category")
public class AnnouncementCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    public AnnouncementCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnnouncementCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
