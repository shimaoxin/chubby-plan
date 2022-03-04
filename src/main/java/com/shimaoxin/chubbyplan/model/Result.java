package com.shimaoxin.chubbyplan.model;

import com.shimaoxin.chubbyplan.enums.ResultEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author ：shimaoxin
 * @date ：Created in 2022/3/4 17:27
 * @description：
 */
@Data
public class Result {

    @ApiModelProperty(value = "相应编码，0为成功，错误为非0")
    private Integer code;

    @ApiModelProperty(value = "相应消息")
    private String message;

    @ApiModelProperty(value = "相应结果")
    private Object data;

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultEnum resultEnum, Object data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
        this.data = data;
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static Result success(Object data) {
        return new Result(ResultEnum.SUCCESS, data);
    }

    /**
     * 成功
     * @return
     */
    public static Result success() {
        return new Result(ResultEnum.SUCCESS, null);
    }

}
