package com.github.legal.param;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by luohao on 21/01/2018.
 */
@Data
public class PageReq implements Serializable {

    private Integer pageNo = 1;

    private Integer pageSize = 5;

    private Boolean paged = false;

}
