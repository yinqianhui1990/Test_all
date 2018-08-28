
package com.sy.cxf.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.8
 * 2017-10-18T14:12:58.849+08:00
 * Generated source version: 3.1.8
 * 
 */
public final class MobileCodeWSSoap_MobileCodeWSSoap_Client {

    private static final QName SERVICE_NAME = new QName("http://WebXml.com.cn/", "MobileCodeWS");

    private MobileCodeWSSoap_MobileCodeWSSoap_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = MobileCodeWS.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        MobileCodeWS ss = new MobileCodeWS(wsdlURL, SERVICE_NAME);
        MobileCodeWSSoap port = ss.getMobileCodeWSSoap();  
        
        {
        System.out.println("Invoking getMobileCodeInfo...");
        String _getMobileCodeInfo_mobileCode = "13249099256";
        String _getMobileCodeInfo_userID = "";
        String _getMobileCodeInfo__return = port.getMobileCodeInfo(_getMobileCodeInfo_mobileCode, _getMobileCodeInfo_userID);
        System.out.println("getMobileCodeInfo.result=" + _getMobileCodeInfo__return);


        }
        {
        System.out.println("Invoking getDatabaseInfo...");
        ArrayOfString _getDatabaseInfo__return = port.getDatabaseInfo();
        System.out.println("getDatabaseInfo.result=" + _getDatabaseInfo__return);


        }

        System.exit(0);
    }

}
