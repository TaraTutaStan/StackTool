package ru.stack.tool.serviceclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stack.tool.deserializer.DateDeserializer;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    @JsonProperty("question_id")
    private Long id;

    @JsonProperty("is_answered")
    private Boolean answered;

    @JsonProperty("answer_count")
    private Integer answerCount;

    private String link;

    @JsonProperty("creation_date")
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime creationDate;

    private String title;

    private Owner owner;

}
