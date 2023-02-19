package com.example.springCrud1.client;


import com.test_soap.GetConvertedXmlRequest;
import com.test_soap.GetConvertedXmlResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class SoapRequestClient extends WebServiceGatewaySupport {


    public SoapRequestClient(Jaxb2Marshaller marshaller) {

        this.setDefaultUri("http://localhost:8080/ws");
        this.setMarshaller(marshaller);
        this.setUnmarshaller(marshaller);

    }


    public String getConvertedXML(String xml){

        GetConvertedXmlRequest getConvertedXmlRequest = new GetConvertedXmlRequest();
        getConvertedXmlRequest.setSourceXmlText(xml);
        GetConvertedXmlResponse getConvertedXmlResponse = (GetConvertedXmlResponse) getWebServiceTemplate().marshalSendAndReceive(getConvertedXmlRequest);
        return getConvertedXmlResponse.getConvertedXmlText();
    }
}
