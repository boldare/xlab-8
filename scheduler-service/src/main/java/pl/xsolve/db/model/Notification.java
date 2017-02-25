package pl.xsolve.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;

    protected Date lastUpdate;

    public Notification() {
    }

    public Notification(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return lastUpdate != null ? lastUpdate.equals(that.lastUpdate) : that.lastUpdate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
