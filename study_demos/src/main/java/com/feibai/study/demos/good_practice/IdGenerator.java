package com.feibai.study.demos.good_practice;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ���Id��������ڵ����⣺����������REQUEST_ID������1��ʼ����
 */
public class IdGenerator {

    private static final AtomicInteger REQUEST_ID = new AtomicInteger(1);
    private static final String POD_NAME = System.getenv("HOSTNAME");

    public String getAuthId() {
        return getRequestId("AUTHENTICATE");
    }

    public String getOnDemandMatrixVolId() {
        return getRequestId("ON_DEMAND_MATRIX_VOL");
    }

    public static long getUniqueId() {

        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    private String getRequestId(String context) {
        return String.format("%s-%s-%s", context, REQUEST_ID.getAndIncrement(), POD_NAME);
    }

}
