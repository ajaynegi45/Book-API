package com.libraryman_api.member;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;


@Entity
public class Members implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "member_id_generator")
    @SequenceGenerator(name = "member_id_generator",
            sequenceName = "member_id_sequence",
            allocationSize = 1)
    @Column(name = "member_id")
    private int memberId;

    @Column(nullable = false)
    private String name;

    @Column(name = "username")
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "membership_date")
    private Date membershipDate;


    public Members() {
    }

    public Members(String name, String email, String password, Role role, Date membershipDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.membershipDate = membershipDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

}
