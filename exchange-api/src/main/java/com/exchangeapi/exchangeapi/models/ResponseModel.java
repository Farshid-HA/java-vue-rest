    package com.exchangeapi.exchangeapi.models;

    import lombok.Getter;
    import lombok.Setter;

    @Setter
    @Getter
    public class ResponseModel<T> {
        private T data;
    }
