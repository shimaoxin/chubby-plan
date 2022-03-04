package com.shimaoxin.chubbyplan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ：shimaoxin
 * @date ：Created in 2022/3/4 17:33
 * @description：
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    SUCCESS(0, "成功");

    private Integer code;

    private String msg;

}
