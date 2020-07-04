package com.f00lish.xcloud.generate.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

@ApiModel("返回信息")
public class ResultMessage<T> {
    private static String SUCCESS = "操作成功";
    private static String ERROR = "操作失败";
    public static int OK = 0;
    public static int FAILL = 1;
    @ApiModelProperty(
            value = "提示信息",
            name = "message",
            example = "操作成功"
    )
    protected String message;
    @ApiModelProperty(
            value = "数据",
            name = "data"
    )
    protected T data;
    @ApiModelProperty(
            value = "状态码",
            name = "status"
    )
    protected int status;
    @ApiModelProperty(
            value = "时间戳",
            name = "timestamp"
    )
    private Timestamp timestamp;

    public static <T> ResultMessage<T> success() {
        return success(OK, SUCCESS, null);
    }

    public static <T> ResultMessage<T> success(T data) {
        return success(OK, SUCCESS, data);
    }

    public static <T> ResultMessage<T> success(String message, T data) {
        return success(OK, message, data);
    }

    public static <T> ResultMessage<T> success(int status, String message) {
        return success(status, message, null);
    }

    public static <T> ResultMessage<T> success(int status, String message, T data) {
        return (new ResultMessage()).data(data).message(message).putTimeStamp().status(status);
    }

    public ResultMessage<T> message(String message) {
        this.message = message;
        return this;
    }

    public static <T> ResultMessage<T> error() {
        return error(FAILL, ERROR, null);
    }

    public static <T> ResultMessage<T> error(String message) {
        return error(FAILL, message, null);
    }

    public static <T> ResultMessage<T> error(int status, String message) {
        return error(status, message, null);
    }

    public static <T> ResultMessage<T> error(int status, String message, T data) {
        ResultMessage<T> responseMessage = new ResultMessage();
        responseMessage.message = message;
        responseMessage.status(status);
        responseMessage.data(data);
        return responseMessage.putTimeStamp();
    }

    public static <T> ResultMessage<T> create(int status, String message, T data) {
        return (new ResultMessage()).data(data).message(message).status(status).putTimeStamp();
    }

    public ResultMessage<T> data(T data) {
        this.data = data;
        return this;
    }

    public T getData() {
        return this.data;
    }

    private ResultMessage<T> putTimeStamp() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        return this;
    }

    public ResultMessage<T> status(int status) {
        this.status = status;
        return this;
    }

    public ResultMessage() {
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResultMessage)) {
            return false;
        } else {
            ResultMessage<?> other = (ResultMessage)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                if (this.getStatus() != other.getStatus()) {
                    return false;
                } else {
                    Object this$timestamp = this.getTimestamp();
                    Object other$timestamp = other.getTimestamp();
                    if (this$timestamp == null) {
                        if (other$timestamp != null) {
                            return false;
                        }
                    } else if (!this$timestamp.equals(other$timestamp)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResultMessage;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        result = result * 59 + this.getStatus();
        Object $timestamp = this.getTimestamp();
        result = result * 59 + ($timestamp == null ? 43 : $timestamp.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResultMessage(message=" + this.getMessage() + ", data=" + this.getData() + ", status=" + this.getStatus() + ", timestamp=" + this.getTimestamp() + ")";
    }
}
