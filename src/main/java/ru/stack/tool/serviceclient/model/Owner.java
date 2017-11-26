package ru.stack.tool.serviceclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Owner {

    private Integer reputation;

    private Integer user_id;

    private String display_name;

    private String link;

}
