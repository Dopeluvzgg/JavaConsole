package com.wbu.bill;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shuo.yu2@dxc.com
 * @version 1.0
 * @className BillItem
 * @description 账单项目类，记录具体项目的名称，单价，数量，总价等。
 * @date 2023/12/8
 */
public class BillItem implements Serializable {
    private Integer billId;
    private Integer billItemId;
    private String billItemName;
    private Integer billAmount;
    private BigDecimal billItemCost;
    private BigDecimal billItemTotalCost;

    public BillItem() {
    }

    public BillItem(Integer billId, Integer billItemId, String billItemName, BigDecimal billItemCost, Integer billAmount, BigDecimal billItemTotalCost) {
        this.billId = billId;
        this.billItemId = billItemId;
        this.billItemName = billItemName;
        this.billItemCost = billItemCost;
        this.billAmount = billAmount;
        this.billItemTotalCost = billItemTotalCost;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getBillItemId() {
        return billItemId;
    }

    public void setBillItemId(Integer billItemId) {
        this.billItemId = billItemId;
    }

    public String getBillItemName() {
        return billItemName;
    }

    public void setBillItemName(String billItemName) {
        this.billItemName = billItemName;
    }

    public BigDecimal getBillItemCost() {
        return billItemCost;
    }

    public void setBillItemCost(BigDecimal billItemCost) {
        this.billItemCost = billItemCost;
    }

    public Integer getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Integer billAmount) {
        this.billAmount = billAmount;
    }

    public BigDecimal getBillItemTotalCost() {
        return billItemTotalCost;
    }

    public void setBillItemTotalCost(BigDecimal billItemTotalCost) {
        this.billItemTotalCost = billItemTotalCost;
    }

    @Override
    public String toString() {
        return "BillItem{" +
                "billId=" + billId +
                ", billItemId=" + billItemId +
                ", billItemName='" + billItemName + '\'' +
                ", billItemCost=" + billItemCost +
                ", billAmount=" + billAmount +
                ", billItemTotalCost=" + billItemTotalCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillItem billItem = (BillItem) o;

        if (getBillItemTotalCost() != null ? !getBillItemTotalCost().equals(billItem.getBillItemTotalCost()) : billItem.getBillItemTotalCost() != null)
            return false;
        if (getBillItemCost() != null ? !getBillItemCost().equals(billItem.getBillItemCost()) : billItem.getBillItemCost() != null)
            return false;
        if (getBillItemName() != null ? !getBillItemName().equals(billItem.getBillItemName()) : billItem.getBillItemName() != null)
            return false;
        if (getBillItemId() != null ? !getBillItemId().equals(billItem.getBillItemId()) : billItem.getBillItemId() != null)
            return false;
        if (getBillId() != null ? !getBillId().equals(billItem.getBillId()) : billItem.getBillId() != null)
            return false;
        return getBillAmount() != null ? getBillAmount().equals(billItem.getBillAmount()) : billItem.getBillAmount() == null;
    }

    @Override
    public int hashCode() {
        int result = getBillId() != null ? getBillId().hashCode() : 0;
        result = 31 * result + (getBillItemId() != null ? getBillItemId().hashCode() : 0);
        result = 31 * result + (getBillItemName() != null ? getBillItemName().hashCode() : 0);
        result = 31 * result + (getBillItemCost() != null ? getBillItemCost().hashCode() : 0);
        result = 31 * result + (getBillAmount() != null ? getBillAmount().hashCode() : 0);
        result = 31 * result + (getBillItemTotalCost() != null ? getBillItemTotalCost().hashCode() : 0);
        return result;
    }
}
