package site.blbc.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @description:
 * @author: Ian Zheng
 * @date: 2019-07-26
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "sys_account", schema = "test")
public class SysAccountEntity extends BaseEntity {
    private String name;
    private String username;
    private String password;
    private LocalDate birthday;
}
