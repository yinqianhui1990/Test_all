
package com.lx.test;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import javax.xml.namespace.QName;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.1.8
 * 2017-10-19T15:31:22.919+08:00
 * Generated source version: 3.1.8
 * 
 */
public final class ServiceSoap_ServiceSoap_Client_Test_yin {

    private static final QName SERVICE_NAME = new QName("http://www.bsoft.com.cn/webservices/", "Service");

    private ServiceSoap_ServiceSoap_Client_Test_yin() {
    }

    public static String getPatientListXml(String deptCode){
        URL wsdlURL = Service.WSDL_LOCATION;
        Service ss = new Service(wsdlURL, SERVICE_NAME);
        ServiceSoap port = ss.getServiceSoap();
        String _getZyBrxxKsdm_inXML = "<?xml version='1.0' encoding='utf-8' ?>" +
                " <DataInfo> " +
                "<Ksdm>" +
                deptCode+
                "</Ksdm > " +
                " </DataInfo>";
        System.out.println(_getZyBrxxKsdm_inXML);
        String _getZyBrxxKsdm__return = port.getZyBrxxKsdm(_getZyBrxxKsdm_inXML);
        return _getZyBrxxKsdm__return;
    }
    public static void main(String args[]) throws Exception {
       /* URL wsdlURL = Service.WSDL_LOCATION;
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
      
        Service ss = new Service(wsdlURL, SERVICE_NAME);
        ServiceSoap port = ss.getServiceSoap();



        {
            System.out.println("Invoking getZyBrxxKsdm...");
            String _getZyBrxxKsdm_inXML = "<?xml version='1.0' encoding='utf-8' ?> <DataInfo> <Ksdm>2441</Ksdm >  </DataInfo>";
            String _getZyBrxxKsdm__return = port.getZyBrxxKsdm(_getZyBrxxKsdm_inXML);
            System.out.println("getZyBrxxKsdm.result=" + _getZyBrxxKsdm__return);


        }
*/

        System.out.println( getPatientListXml("2430"));


        System.exit(0);
    }

}
