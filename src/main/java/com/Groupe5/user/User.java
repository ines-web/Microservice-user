package com.Groupe5.user;
import java.io.Serializable;
import jakarta.persistence.*;


@Entity
@Table(name = "user", schema = "public", catalog = "postgres")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 32)
     private String name;
    @Basic
    @Column(name = "email")
    private String email="";

    public User(String name, String email) {

        this.name = name;
        this.email = email;
    }

    public User() {}

    public Long getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public String getMel() {
        return email;
    }

    public void setMel(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Identite {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
