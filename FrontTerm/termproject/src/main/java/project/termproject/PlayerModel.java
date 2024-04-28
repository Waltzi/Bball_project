package project.termproject;

import lombok.Data;

@Data
public class PlayerModel {
    private Long id;
    private String firstName;
    private String lastName;
    private int jerseyNumber;
    private Boolean active = true;
}
