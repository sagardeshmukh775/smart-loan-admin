package com.smartloan.smtrick.smart_loan_admin_new.repository;

import com.google.firebase.database.DatabaseReference;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.CheckList;
import com.smartloan.smtrick.smart_loan_admin_new.models.Commission;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModelCo;
import com.smartloan.smtrick.smart_loan_admin_new.models.Expences;

import java.util.Map;

public interface LeedRepository {

    void readAllLeeds(final CallBack callback);

    void readLeedsByUserId(final String userId, final CallBack callBack);

    void createLeed(final LeedsModel leedsModel, final CallBack callback);

    void deleteLeed(final String leedId, final CallBack callback);

    void updateLeed(final String leedId, final Map leedMap, final CallBack callback);

    void updateCoApplicantLeed(final LeedsModelCo leedsModel, final CallBack callback);

    void readLeedByLeedId(final String leedId, final CallBack callBack);

    void readLeedsByStatus(final String status, final CallBack callBack);

    void readLeedsByID(final String name, final CallBack callBack);

    void readLeedsByName(final String id, final CallBack callBack);

    void createInvoice(final LeedsModel leedsModel, final CallBack callback);

    void readAllInvoices(final CallBack callback);

    void updateLeedDocuments(final String leedId, final Map leedMap, final CallBack callback);

    void createBank(final Bank leedsModel, final CallBack callback);

    void readAllBanks(final CallBack callback);

    void readUserByRole(final String role, final CallBack callBack);

    void readInvoicesByStatus(final String status, final CallBack callBack);

    void createSalary(final Expences expences, final CallBack callback);

    void createTravellingAllowance(final Expences leedsModel, final CallBack callback);

    void createRent(final Expences expences, final CallBack callback);

    void createlightBill(final Expences expences, final CallBack callback);

    void createOtherExpence(final Expences expences, final CallBack callback);

    void readExpence(final CallBack callback);

    void readExpenceByStatus(final String status, final CallBack callBack);

    void updateExpence(final String leedId, final Map leedMap, final CallBack callback);

    void updateCommission(final String leedId, final Map leedMap, final CallBack callback);

    void createCommission(final Commission leedsModel, final CallBack callback);

    void readAllCommission(final CallBack callback);

    void createCheckList(final CheckList checkList, final CallBack callback);

    void readChecklistByRule(final String Rule, final CallBack callBack);

}