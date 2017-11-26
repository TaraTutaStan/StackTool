package ru.stack.tool.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Model for bussiness layout
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question {

    private Long id;

    /**
     * The question has answer
     */
    private Boolean answered;

    private Integer answerCount;

    /**
     * Link to source
     */
    private String link;

    private LocalDateTime creationDate;

    private String title;

    /**
     * Nikname of owner from source
     */
    private String owner;

}
