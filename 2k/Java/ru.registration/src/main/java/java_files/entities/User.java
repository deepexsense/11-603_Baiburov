package java_files.entities;


import lombok.*;

@Builder
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
public class User extends Entity{
    private Long id;
    private String email;
    private String password;
    private String name;
    private String country;
    private String gender;
    private Boolean subscribe;

    public User(String email, String password, String name, String country, String gender, boolean subscribe) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.country = country;
        this.gender = gender;
        this.subscribe = subscribe;
        this.id = 0L;
    }
}
