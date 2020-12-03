package by.bsuir.blurbot.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BotUser {
    private Integer id;
    private String firstName;
}
