package project.termproject;

import lombok.Data;

@Data
public class PlayerModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private int jerseyNumber;
}