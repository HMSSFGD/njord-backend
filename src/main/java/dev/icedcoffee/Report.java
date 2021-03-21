package dev.icedcoffee;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.*;
import java.util.*;

@Entity
public class Report extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable= false, nullable = false)
    public long id;
    @Column(nullable = false)
    public float lat;
    @Column(nullable = false)
    public float lng;
    @Column(nullable = false)
    public Status status = Status.UNREAD;
    @Column(nullable = false)
    public Priority priority = Priority.NOTSET;
    @Column(length = 660001)
    public String image = null;

    public static List<Report> getUnresolved() {
        List<Report> r = list("status < ?1", Status.RESOLVED);
        return r;
    }
}
