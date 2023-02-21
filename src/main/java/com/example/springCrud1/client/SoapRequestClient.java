package com.example.springCrud1.client;


import com.test_soap.GetConvertedXmlRequest;
import com.test_soap.GetConvertedXmlResponse;


import com.test_soap.PersonsPortService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class SoapRequestClient extends WebServiceGatewaySupport {

//        @Value("${soap.uri}")
//        public String soapUri;

    PersonsPortService personsPortService = new PersonsPortService();


    public SoapRequestClient(Jaxb2Marshaller marshaller) {

        this.setDefaultUri("http://localhost:8080/ws");
        this.setMarshaller(marshaller);
        this.setUnmarshaller(marshaller);

    }


    public String getConvertedXML(String xml){

        GetConvertedXmlRequest getConvertedXmlRequest = new GetConvertedXmlRequest();
        getConvertedXmlRequest.setSourceXmlText(xml);
//        GetConvertedXmlResponse getConvertedXmlResponse = (GetConvertedXmlResponse) getWebServiceTemplate().marshalSendAndReceive(getConvertedXmlRequest);
        GetConvertedXmlResponse getConvertedXmlResponse = personsPortService.getPersonsPortSoap11().getConvertedXml(getConvertedXmlRequest);
        return getConvertedXmlResponse.getConvertedXmlText();
    }

//    public String getSoapUri() {
//        return soapUri;
//    }
//
//    public void setSoapUri(String soapUri) {
//        this.soapUri = soapUri;
//    }
}
