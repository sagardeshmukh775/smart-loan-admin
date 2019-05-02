package com.smartloan.smtrick.smart_loan_admin.repository;

import com.smartloan.smtrick.smart_loan_admin.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin.models.LeedsModelCo;

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

}
