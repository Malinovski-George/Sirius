package by.malinovski.book.model.Photos;

import by.malinovski.book.model.Flat;

import javax.persistence.*;

@Entity
@Table(name = "flat_photo")
public class FlatPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "image")
    @Lob
    private byte[] image;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flat")
    private Flat flat;

    // -- gettets and setters --

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }
}
