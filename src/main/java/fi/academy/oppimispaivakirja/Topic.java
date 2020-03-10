package fi.academy.oppimispaivakirja;

import javax.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "topic_id_seq")
    @SequenceGenerator(name = "topic_id_seq",sequenceName = "topic_id_seq",allocationSize = 1)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String title;
    private String description;
    private String additionalSource;
    private boolean complete;
    private Date creationDate;
    private Date completionDate;
    private LocalDateTime alarm;
    private boolean set_alarm;

    public Topic(){
    }

    public LocalDateTime getAlarm() {
        return alarm;
    }

    public void setAlarm(LocalDateTime alarm) {
        this.alarm = alarm;
    }

    public boolean isSet_alarm() {
        return set_alarm;
    }

    public void setSet_alarm(boolean set_alarm) {
        this.set_alarm = set_alarm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalSource() {
        return additionalSource;
    }

    public void setAdditionalSource(String additionalSource) {
        this.additionalSource = additionalSource;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
}
