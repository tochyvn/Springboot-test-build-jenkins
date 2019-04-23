package com.capgemini.overview.Entity.security;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="app_role")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role_name")
    private RoleName roleName;

    @Column(name="description")
    private String description;

}
