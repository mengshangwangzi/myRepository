package com.wangxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wx
 * @Description:
 * @Title:
 * @Package
 * @date 2021/1/10 9:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    private String name;

    private String password;

}
