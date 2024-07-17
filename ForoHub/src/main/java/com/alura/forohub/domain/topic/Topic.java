package com.alura.forohub.domain.topic;

import com.alura.forohub.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

@Entity(name = "Topic")
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private String creationDate;
    private Boolean status;
    private Integer author;
    private String course;

    public Topic(TopicCreationData topicCreationData){
        this.title = topicCreationData.title();
        this.message = topicCreationData.message();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        this.creationDate = currentDateTime.format(formatter);
        this.status = true;
        this.author = topicCreationData.author();
        this.course = topicCreationData.course();
    }

    public void updateTopic(TopicUpdateData topicUpdateData){
        if(topicUpdateData.title() != null)
            this.title = topicUpdateData.title();
        if(topicUpdateData.message() != null)
            this.message = topicUpdateData.message();
    }

    public void deactivateTopic(){
        this.status = false;
    }
}

