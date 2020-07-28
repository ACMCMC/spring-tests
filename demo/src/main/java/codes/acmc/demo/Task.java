package codes.acmc.demo;

import java.sql.Timestamp;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private int current_status;
    private String error_msg;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Timestamp start_time;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Timestamp end_time;

    public Task() {
    };

    public Task(Long id, String username, int current_status, @Nullable String error_msg,
            @Nullable Timestamp start_time, @Nullable Timestamp end_time) {
        this.id = id;
        this.username = username;
        this.current_status = current_status;
        this.error_msg = error_msg;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public Long getId() {
        return this.id;
    }

    public String getusername() {
        return this.username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public int getcurrent_status() {
        return this.current_status;
    }

    public void setcurrent_status(int current_status) {
        this.current_status = current_status;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public Timestamp getstart_date() {
        return this.start_time;
    }

    public void setstart_date(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getend_date() {
        return this.end_time;
    }

    public void setend_date(Timestamp end_time) {
        this.end_time = end_time;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else if (((Task) obj).id == this.id) {
            return true;
        } else {
            return false;
        }
    }

}