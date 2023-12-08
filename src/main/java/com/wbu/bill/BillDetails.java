package com.wbu.bill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author shuo.yu2@dxc.com
 * @className BillDetails
 * @description 账单类，记录账单的各个项目
 * @date 2023/12/8
 * @version 1.0
 */
public class BillDetails<T> implements Serializable {
    private Integer billId;
    private Date billDate;
    private BigDecimal billTotalCost;
}
