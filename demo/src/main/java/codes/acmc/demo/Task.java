package codes.acmc.demo;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.stream.Collectors;

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

    private enum CurrentStatus {
        NOT_YET_STARTED(0, "Not yet started"), STARTED(1, "Started"), FINISHED(2, "Finished"), FAILED(3, "Failed");

        private int currentStatus;
        private String humanReadableCurrentStatus;

        private CurrentStatus(int currentStatus, String humanReadableCurrentStatus) {
            this.currentStatus = currentStatus;
            this.humanReadableCurrentStatus = humanReadableCurrentStatus;
        }

        public int getCurrentStatus() {
            return this.currentStatus;
        }

        public String getHumanReadableCurrentStatus() {
            return humanReadableCurrentStatus;
        }

        public CurrentStatus findCurrentStatusByInt(int currentStatus) {
            CurrentStatus resultStatus;
            try {
                resultStatus = Arrays.asList(values()).stream()
                        .filter(statusState -> statusState.currentStatus == currentStatus).collect(Collectors.toList())
                        .get(0);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return (resultStatus);
        };
    };

    private CurrentStatus current_status;

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
        this.current_status = this.current_status.findCurrentStatusByInt(current_status);
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCurrentStatus() {
        return this.current_status.getCurrentStatus();
    }

    public String getHumanReadableCurrentStatus() {
        return this.current_status.getHumanReadableCurrentStatus();
    }

    public void setCurrentStatus(int current_status) {
        this.current_status = this.current_status.findCurrentStatusByInt(current_status);
    }

    public String getErrorMsg() {
        return this.error_msg;
    }

    public void setErrorMsg(String error_msg) {
        this.error_msg = error_msg;
    }

    public Timestamp getStartTime() {
        return this.start_time;
    }

    public void setStartTime(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEndTime() {
        return this.end_time;
    }

    public void setEndTime(Timestamp end_time) {
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