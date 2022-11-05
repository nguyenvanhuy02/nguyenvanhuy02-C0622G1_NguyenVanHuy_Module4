package com.case_study.model.security;

import com.case_study.model.employee.Employee;

import javax.persistence.*;
import java.util.List;


@Entity
public class User {

    @Id
    private String userName;
    private String password;
    private boolean isEnabled;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @OneToOne(mappedBy = "user")
    private Employee employees;

    public User() {
    }

    public User(String userName, String password, boolean isEnabled, List<Role> roles, Employee employees) {
        this.userName = userName;
        this.password = password;
        this.isEnabled = isEnabled;
        this.roles = roles;
        this.employees = employees;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }
}
