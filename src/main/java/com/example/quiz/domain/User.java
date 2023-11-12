package com.example.quiz.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String u_id;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private boolean isActive;
    private boolean isAdmin;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
}
