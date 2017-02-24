package codingbo.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by bob
 * on 16.11.21.
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long _id;
    private String name;

    @Generated(hash = 423771417)
    public User(Long _id, String name) {
        this._id = _id;
        this.name = name;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        this._id = id;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }
}
