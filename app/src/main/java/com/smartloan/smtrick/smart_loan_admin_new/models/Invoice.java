package com.smartloan.smtrick.smart_loan_admin_new.models;

import java.util.ArrayList;

public class Invoice {
    private String invoiceId;
    private String phone;
    private String status;
    private String customerName;
    private String loanapprovedaamount;
    private String loandisbussedamount;
    private String loanpendingamount;


    public Invoice() {
        this.invoiceId = "";
        this.phone = "";
        this.status = "";
        this.customerName = "";
        this.loanapprovedaamount = "";
        this.loandisbussedamount = "";
        this.loanpendingamount = "";
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
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

    public String getLoanpendingamount() {
        return loanpendingamount;
    }

    public void setLoanpendingamount(String loanpendingamount) {
        this.loanpendingamount = loanpendingamount;
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
