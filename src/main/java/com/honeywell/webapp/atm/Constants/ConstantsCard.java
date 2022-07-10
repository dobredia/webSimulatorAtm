package com.honeywell.webapp.atm.Constants;

public interface ConstantsCard {
    String URL_GET_CARD_INFORMATION = "http://localhost:8080/getBalance/";
    String URL_POST_LOGIN = "http://localhost:8080/login";
    String URL_CARD_NUMBER = "?cardNumber=";
    String URL_PIN = "&pin=";
    String URL_CARD = "http://localhost:8080/card/";
    String URL_CHANGE_PIN = "/updatePin?newCardPin=";


}
