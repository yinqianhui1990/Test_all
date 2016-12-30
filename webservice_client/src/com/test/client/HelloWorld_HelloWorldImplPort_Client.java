
package com.test.client;

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
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.8
 * 2016-10-26T10:07:47.024+08:00
 * Generated source version: 3.1.8
 * 
 */
public final class HelloWorld_HelloWorldImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.webservice.test.com/", "HelloWorld");

    private HelloWorld_HelloWorldImplPort_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = HelloWorld_Service.WSDL_LOCATION;
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
      
        HelloWorld_Service ss = new HelloWorld_Service(wsdlURL, SERVICE_NAME);
        HelloWorld port = ss.getHelloWorldImplPort();  
        
        {
        System.out.println("Invoking sayHi...");
        String _sayHi_text = "";
        String _sayHi__return = port.sayHi(_sayHi_text);
        System.out.println("sayHi.result=" + _sayHi__return);


        }
        {
        System.out.println("Invoking sayHiToUserList...");
        java.util.List<com.test.client.User> _sayHiToUserList_arg0 = null;
        java.util.List<String> _sayHiToUserList__return = port.sayHiToUserList(_sayHiToUserList_arg0);
        System.out.println("sayHiToUserList.result=" + _sayHiToUserList__return);


        }
        {
        System.out.println("Invoking sayHiToUser...");
        com.test.client.User _sayHiToUser_arg0 = null;
        String _sayHiToUser__return = port.sayHiToUser(_sayHiToUser_arg0);
        System.out.println("sayHiToUser.result=" + _sayHiToUser__return);


        }

        System.exit(0);
    }

}
