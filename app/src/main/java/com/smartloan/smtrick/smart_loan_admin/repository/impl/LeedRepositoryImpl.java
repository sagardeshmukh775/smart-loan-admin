package com.smartloan.smtrick.smart_loan_admin.repository.impl;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.smartloan.smtrick.smart_loan_admin.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin.models.LeedModel;
import com.smartloan.smtrick.smart_loan_admin.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin.models.LeedsModelCo;
import com.smartloan.smtrick.smart_loan_admin.models.User;
import com.smartloan.smtrick.smart_loan_admin.repository.FirebaseTemplateRepository;
import com.smartloan.smtrick.smart_loan_admin.repository.LeedRepository;

import java.util.ArrayList;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.SALES;
import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.STATUS_VERIFIED;

public class LeedRepositoryImpl extends FirebaseTemplateRepository implements LeedRepository {
    @Override
    public void readAllLeeds(final CallBack callBack) {
        final Query query = Constant.LEEDS_TABLE_REF;
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readLeedsByUserId(String userId, final CallBack callBack) {
        final Query query = Constant.LEEDS_TABLE_REF.orderByChild("createdBy").equalTo(userId);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createLeed(LeedsModel leedsModel, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.LEEDS_TABLE_REF.child(leedsModel.getLeedId());
        fireBaseCreate(databaseReference, leedsModel, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void createInvoice(LeedsModel leedsModel, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.INVOICE_TABLE_REF.child(leedsModel.getLeedId());
        fireBaseCreate(databaseReference, leedsModel, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void deleteLeed(String leedId, CallBack callback) {
        DatabaseReference databaseReference = Constant.LEEDS_TABLE_REF.child(leedId);
        fireBaseDelete(databaseReference, callback);
    }

    @Override
    public void updateLeed(String leedId, Map leedMap, final CallBack callBack) {
        final DatabaseReference databaseReference = Constant.LEEDS_TABLE_REF.child(leedId);
        fireBaseUpdateChildren(databaseReference, leedMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void updateCoApplicantLeed(LeedsModelCo leedsModelCo, final CallBack callBack) {
        final DatabaseReference databaseReference = Constant.COAPPLICANT_LEEDS_TABLE_REF.child(leedsModelCo.getLeedId());
        fireBaseCreate(databaseReference, leedsModelCo, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }




    @Override
    public void readLeedByLeedId(String leedId, final CallBack callBack) {
        final Query query = Constant.LEEDS_TABLE_REF.child(leedId);
        fireBaseReadData(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        DataSnapshot child = dataSnapshot.getChildren().iterator().next();
                        LeedsModel leedsModel = child.getValue(LeedsModel.class);
                        callBack.onSuccess(leedsModel);
                    } else
                        callBack.onSuccess(null);
                } else
                    callBack.onSuccess(null);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readLeedsByStatus(String status, final CallBack callBack) {
        final Query query = Constant.LEEDS_TABLE_REF.orderByChild("status").equalTo(status);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readLeedsByID(String id, final CallBack callBack) {
        final Query query = Constant.COAPPLICANT_LEEDS_TABLE_REF.orderByChild("leedNumber").equalTo(id);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readLeedsByName(String name, final CallBack callBack) {
        final Query query = Constant.LEEDS_TABLE_REF.orderByChild("salesPerson").equalTo(name);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);

                            if (leedsModel.getStatus().equalsIgnoreCase(STATUS_VERIFIED))
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void updateLeedDocuments(String leedId, Map leedMap, final CallBack callBack) {
        final DatabaseReference databaseReference = Constant.LEEDS_TABLE_REF.child(leedId).child("documentImages");
        fireBaseUpdateChildren(databaseReference, leedMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }
}
