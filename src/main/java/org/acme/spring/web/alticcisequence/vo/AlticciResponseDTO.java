package org.acme.spring.web.alticcisequence.vo;

import java.math.BigInteger;

public class AlticciResponseDTO {

    private String strProcessingTime;
    private BigInteger result;

    public AlticciResponseDTO(String strProcessingTime, BigInteger result) {
        this.strProcessingTime = strProcessingTime;
        this.result = result;
    }

    public String getProcessingTime() {
        return strProcessingTime;
    }

    public void setProcessingTime(String strProcessingTime) {
        this.strProcessingTime = strProcessingTime;
    }

    public BigInteger getResult() {
        return result;
    }

    public void setResult(BigInteger result) {
        this.result = result;
    }

}
