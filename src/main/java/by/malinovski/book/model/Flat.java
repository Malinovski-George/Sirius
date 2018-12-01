package by.malinovski.book.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name="flat")
public class Flat {

    //General
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private User flatOwner;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "flat", cascade = CascadeType.ALL)
    private FlatAttributes flatAttributes;

    @Column(name = "descriptionShort", nullable = false, length=250)
    private String descriptionShort;

    //TODO dinamic search of city/streetid
    //Address
    @Column(name = "city", nullable = false, length=250)
    private String city;

    @Column(name = "street", nullable = false, length=250)
    private String street;

    @Column(name = "house", nullable = false, length=250)
    private String house;

    //Service
    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified", nullable = false, length=250)
    private Date modified;


    //private List<FlatPhoto> flatPhotos = new LinkedList<>();


    //  private FlatStatistic statistic;

}
