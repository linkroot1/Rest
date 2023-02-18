package com.example.springCrud1.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapRequestClient extends WebServiceGatewaySupport {

//    public GetConvertedXmlResponse getConvertedXml(String xmlText) {
//        GetConvertedXmlRequest request = new GetConvertedXmlRequest();
//        request.setSourceXmlText(xmlText);
//
//        GetConvertedXmlResponse response = (GetConvertedXmlResponse) getWebServiceTemplate()
//                .marshalSendAndReceive("http://localhost:8080/service/convert", request,
//                        new SoapActionCallback(
//                                "http://www.test-soap.com/GetConvertedXmlRequest"));
//
//        return response;
//    }
}
