package ru.alfa.stubs.WS.soap;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by nestor on 03.07.2017.
 */
@Provider
@Consumes( "text/xml" )
@Produces( "text/xml" )
public class Soap11Provider extends AbstractSoapProvider {
    @Override
    public SOAPMessage readFrom(Class<SOAPMessage> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        try {
            return modifyMessage(SOAPConstants.SOAP_1_1_PROTOCOL, entityStream);
        } catch (SOAPException e) {
            throw new IOException(e);
        }
    }
}
