package model;

import jakarta.persistence.*;

@Entity
@Table(name = "house_points")
public class HousePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "giver")
    private model.Person giver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver")
    private model.Person receiver;

    @Column(name = "points")
    private Integer points;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public model.Person getGiver() {
        return giver;
    }

    public void setGiver(model.Person giver) {
        this.giver = giver;
    }

    public model.Person getReceiver() {
        return receiver;
    }

    public void setReceiver(model.Person receiver) {
        this.receiver = receiver;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}