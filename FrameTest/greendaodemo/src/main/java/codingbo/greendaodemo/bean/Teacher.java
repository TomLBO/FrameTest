package codingbo.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by bob
 * on 16.12.8.
 */
@Entity
public class Teacher {
    @Id(autoincrement = true)
    private long id;
    @Unique
    private String tId;
    @Property(nameInDb = "T_NAME")
    private String name;
    private String subject;

    @Generated(hash = 1607547928)
    public Teacher(long id, String tId, String name, String subject) {
        this.id = id;
        this.tId = tId;
        this.name = name;
        this.subject = subject;
    }

    @Generated(hash = 1630413260)
    public Teacher() {
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTId() {
        return this.tId;
    }

    public void setTId(String tId) {
        this.tId = tId;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
