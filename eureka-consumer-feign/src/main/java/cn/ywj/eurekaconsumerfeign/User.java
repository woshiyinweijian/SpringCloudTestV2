package cn.ywj.eurekaconsumerfeign;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 3842077826449755019L;
    private String name;
    private Integer age;
}
