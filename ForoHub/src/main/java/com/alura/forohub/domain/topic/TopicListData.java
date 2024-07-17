package com.alura.forohub.domain.topic;

public record TopicListData(
        Long id,
        String title,
        String message,
        String date ) {

    public TopicListData(Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate());
    }
}
