package com.smartloan.smtrick.smart_loan_admin_new.models;

import android.support.v4.app.NotificationCompat;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Invoice {

    private String customerName;
    private String invoiceId;
    private String invoiceNumber;
    private String disbussmentDate;

    private String loanapprovedaamount;
    private String totalpayoutamount;
    private String loandisbussedamount;
    private String pendingdisbussedamount;
    private String payoutbussedamount;
    private String tdsAmount;
    private String commisionwithtdsAmount;
    private String phone;
    private String status;
    private String agentId;
    private String leedId;
    private String loanType;

    public Invoice() {
        this.invoiceId = "";
        this.invoiceNumber = "";
        this.phone = "";
        this.status = "";
        this.customerName = "";
        this.leedId = "";
        this.loanapprovedaamount = "";
        this.loandisbussedamount = "";

        this.totalpayoutamount = "";
        this.pendingdisbussedamount = "";
        this.payoutbussedamount = "";
        this.commisionwithtdsAmount = "";
        this.disbussmentDate = "";

        this.tdsAmount = "";
        this.agentId = "";
        this.loanType = "";
    }



    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLeedId() {
        return leedId;
    }

    public void setLeedId(String leedId) {
        this.leedId = leedId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoanapprovedaamount() {
        return loanapprovedaamount;
    }

    public void setLoanapprovedaamount(String loanapprovedaamount) {
        this.loanapprovedaamount = loanapprovedaamount;
    }

    public String getLoandisbussedamount() {
        return loandisbussedamount;
    }

    public void setLoandisbussedamount(String loandisbussedamount) {
        this.loandisbussedamount = loandisbussedamount;
    }

    public String getTdsAmount() {
        return tdsAmount;
    }

    public void setTdsAmount(String tdsAmount) {
        this.tdsAmount = tdsAmount;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }


    public String getTotalpayoutamount() {
        return totalpayoutamount;
    }

    public void setTotalpayoutamount(String totalpayoutamount) {
        this.totalpayoutamount = totalpayoutamount;
    }

    public String getPendingdisbussedamount() {
        return pendingdisbussedamount;
    }

    public void setPendingdisbussedamount(String pendingdisbussedamount) {
        this.pendingdisbussedamount = pendingdisbussedamount;
    }

    public String getPayoutbussedamount() {
        return payoutbussedamount;
    }

    public void setPayoutbussedamount(String payoutbussedamount) {
        this.payoutbussedamount = payoutbussedamount;
    }

    public String getCommisionwithtdsAmount() {
        return commisionwithtdsAmount;
    }

    public void setCommisionwithtdsAmount(String commisionwithtdsAmount) {
        this.commisionwithtdsAmount = commisionwithtdsAmount;
    }

    public String getDisbussmentDate() {
        return disbussmentDate;
    }

    public void setDisbussmentDate(String disbussmentDate) {
        this.disbussmentDate = disbussmentDate;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    @Exclude
    public Map getLeedStatusMap1() {
        Map<String, Object> leedMap = new HashMap();
        leedMap.put(NotificationCompat.CATEGORY_STATUS, getStatus());

        return leedMap;
    }

    public static ArrayList<Invoice> getSentInvoices() {
        ArrayList<Invoice> results = new ArrayList<Invoice>();
        for (int i = 0; i < 20; i++) {
            Invoice sr = new Invoice();
            sr.setInvoiceId("INV 000" + i);
            sr.setCustomerName("Mr Pratik Patel");
            sr.setPhone("Axis Bank");
            sr.setStatus("Sent");
            results.add(sr);
        }
        return results;
    }

    public static ArrayList<Invoice> getAcceptedInvoices() {
        ArrayList<Invoice> results = new ArrayList<Invoice>();
        for (int i = 0; i < 20; i++) {
            Invoice sr = new Invoice();
            sr.setInvoiceId("INV 000" + i);
            sr.setCustomerName("Mr Pratik Patel");
            sr.setPhone("Axis Bank");
            sr.setStatus("Unpaid");
            results.add(sr);
        }
        return results;
    }

    public static ArrayList<Invoice> getPaidInvoices() {
        ArrayList<Invoice> results = new ArrayList<Invoice>();
        for (int i = 0; i < 20; i++) {
            Invoice sr = new Invoice();
            sr.setInvoiceId("INV 000" + i);
            sr.setCustomerName("Mr Pratik Patel");
            sr.setPhone("Axis Bank");
            sr.setStatus("Paid");
            results.add(sr);
        }
        return results;
    }

    public static ArrayList<Invoice> getRejectedInvoices() {
        ArrayList<Invoice> results = new ArrayList<Invoice>();
        for (int i = 0; i < 20; i++) {
            Invoice sr = new Invoice();
            sr.setInvoiceId("INV 000" + i);
            sr.setCustomerName("Mr Pratik Patel");
            sr.setPhone("Axis Bank");
            sr.setStatus("Rejected");
            results.add(sr);
        }
        return results;
    }
}
