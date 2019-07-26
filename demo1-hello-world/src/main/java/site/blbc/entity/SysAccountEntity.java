package site.blbc.entity;

import lombok.*;

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
public class SysAccountEntity {
    private Long id;
    private String name;
    private String username;
    private String password;
    private LocalDate birthday;
}
