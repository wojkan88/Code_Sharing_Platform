package platform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @JsonIgnore
    private String uuid;
    @JsonIgnore
    private String title = "Code";
    private String code;
    private LocalDateTime date;
    @Column(name = "time_restriction")
    private long time;
    @Column(name = "views_restriction")
    private long views;

    public Code() {
    }

    public Code(String code, LocalDateTime date, long time, long views) {
        this.uuid = UUID.randomUUID().toString();
        this.code = code;
        this.date = date;
        this.time = time;
        this.views = views;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonIgnore
    public LocalDateTime getCreationDate() {
        return date;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}