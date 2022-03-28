package com.hualala.openapi.sdk.beans.request.order;

import com.hualala.openapi.sdk.beans.request.BaseBean;
import lombok.Data;

import java.util.List;

@Data
public class TableBean extends BaseBean {
    private String tableName;
    private String terminal;
    private List<Long> shopIDList;
}
   
    