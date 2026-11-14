package com.pedro.helpdesk.exception;

import java.io.Serializable;

public class StanderError implements Serializable {
    private static final long serialVersionUID = 1L;

    private long timestamp;
    private Integer status;
    private String error;
    private String path;

    public StanderError(Long timestamp, Integer status, String error) {
        super();
    }
    public StanderError(Long timestamp, Integer status, String error, String path) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
