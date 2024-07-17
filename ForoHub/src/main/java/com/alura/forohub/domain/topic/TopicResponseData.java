package com.alura.forohub.domain.topic;

public record TopicResponseData(
        Long id,
        String title,
        String message,
        String date,
        int author,
        String course ) {
    public TopicResponseData(Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getAuthor(), topic.getCourse());
    }
}
