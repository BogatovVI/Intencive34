package ru.aston.bogatov_vi.task5.Entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserOrder extends User{
    @Type(type = "jsonb")
    @Column(name = "Meta")
    private String meta;
}