package model;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollment")
public class Enrollment {
    @EmbeddedId
    private EnrollmentId id;

    @MapsId("personEnrollment")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_enrollment", nullable = false)
    private model.Person personEnrollment;

    @MapsId("courseEnrollment")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_enrollment", nullable = false)
    private Course courseEnrollment;

    public EnrollmentId getId() {
        return id;
    }

    public void setId(EnrollmentId id) {
        this.id = id;
    }

    public model.Person getPersonEnrollment() {
        return personEnrollment;
    }

    public void setPersonEnrollment(model.Person personEnrollment) {
        this.personEnrollment = personEnrollment;
    }

    public Course getCourseEnrollment() {
        return courseEnrollment;
    }

    public void setCourseEnrollment(Course courseEnrollment) {
        this.courseEnrollment = courseEnrollment;
    }

}