package com.example.not_simple_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "key_value")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EntityKeyValue {
    @Id
    @Column(name = "data_key", nullable = false, unique = true)
    private String key;
    @Column(name = "data_value", nullable = true, unique = false)
    private String value;
}
