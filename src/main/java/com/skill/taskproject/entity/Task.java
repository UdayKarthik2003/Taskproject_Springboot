package com.skill.taskproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "task")

public class Task {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @jakarta.persistence.Column(name = "taskname", nullable = false)
    private String taskName;

    @ManyToOne(fetch= jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name="user_id")
    private  Users user;

}
