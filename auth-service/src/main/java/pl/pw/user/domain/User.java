package pl.pw.user.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final String name;
    private final String password;
    private final String role;

    @SuppressWarnings("unused")
    private User() {
        this.name = null;
        this.password = null;
        this.role = null;
    }
}