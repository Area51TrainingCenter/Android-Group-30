package com.example.testSoap.wcf;




//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.0.8.0
//
// Created by Quasar Development at 24/03/2017
//
//---------------------------------------------------




import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.*;
import org.kxml2.kdom.Element;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RELCalculatorSoap12
{
    interface RELIWcfMethod
    {
        RELExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws Exception;

        Object ProcessResult(RELExtendedSoapSerializationEnvelope __envelope, Object result) throws Exception;
    }

    String url="http://www.dneonline.com/calculator.asmx";

    int timeOut=60000;
    public List< HeaderProperty> httpHeaders;
    public boolean enableLogging;

    public RELCalculatorSoap12(){}

    public RELCalculatorSoap12(String url)
    {
        this.url = url;
    }

    public RELCalculatorSoap12(String url,int timeOut)
    {
        this.url = url;
        this.timeOut=timeOut;
    }

    protected Transport createTransport()
    {
        try
        {
            java.net.URI uri = new java.net.URI(url);
            if(uri.getScheme().equalsIgnoreCase("https"))
            {
                int port=uri.getPort()>0?uri.getPort():443;
                return new HttpsTransportSE(uri.getHost(), port, uri.getPath(), timeOut);
            }
            else
            {
                return new HttpTransportSE(url,timeOut);
            }

        }
        catch (java.net.URISyntaxException e)
        {
        }
        return null;
    }
    
    protected RELExtendedSoapSerializationEnvelope createEnvelope()
    {
        RELExtendedSoapSerializationEnvelope envelope= new RELExtendedSoapSerializationEnvelope(RELExtendedSoapSerializationEnvelope.VER12);
        return envelope;
    }
    
    protected List sendRequest(String methodName,RELExtendedSoapSerializationEnvelope envelope,Transport transport  )throws Exception
    {
        return transport.call(methodName, envelope, httpHeaders);
    }

    Object getResult(Class destObj,Object source,String resultName,RELExtendedSoapSerializationEnvelope __envelope) throws Exception
    {
        if(source==null)
        {
            return null;
        }
        if(source instanceof SoapPrimitive)
        {
            SoapPrimitive soap =(SoapPrimitive)source;
            if(soap.getName().equals(resultName))
            {
                Object instance=__envelope.get(source,destObj,false);
                return instance;
            }
        }
        else
        {
            SoapObject soap = (SoapObject)source;
            if (soap.hasProperty(resultName))
            {
                Object j=soap.getProperty(resultName);
                if(j==null)
                {
                    return null;
                }
                Object instance=__envelope.get(j,destObj,false);
                return instance;
            }
            else if( soap.getName().equals(resultName)) {
                Object instance=__envelope.get(source,destObj,false);
                return instance;
            }
       }

       return null;
    }

        
    public Integer Add(final Integer intA,final Integer intB ) throws Exception
    {
        return (Integer)execute(new RELIWcfMethod()
        {
            @Override
            public RELExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              RELExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://tempuri.org/", "Add");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="http://tempuri.org/";
                __info.name="intA";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(intA);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="http://tempuri.org/";
                __info.name="intB";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(intB);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(RELExtendedSoapSerializationEnvelope __envelope,Object __result)throws Exception {
                SoapObject __soap=(SoapObject)__result;
                Object obj = __soap.getProperty("AddResult");
                if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return Integer.parseInt(j.toString());
                }
                else if (obj!= null && obj instanceof Integer){
                    return (Integer)obj;
                }
                return null;
            }
        },"http://tempuri.org/Add");
    }
    
    public Integer Subtract(final Integer intA,final Integer intB ) throws Exception
    {
        return (Integer)execute(new RELIWcfMethod()
        {
            @Override
            public RELExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              RELExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://tempuri.org/", "Subtract");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="http://tempuri.org/";
                __info.name="intA";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(intA);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="http://tempuri.org/";
                __info.name="intB";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(intB);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(RELExtendedSoapSerializationEnvelope __envelope,Object __result)throws Exception {
                SoapObject __soap=(SoapObject)__result;
                Object obj = __soap.getProperty("SubtractResult");
                if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return Integer.parseInt(j.toString());
                }
                else if (obj!= null && obj instanceof Integer){
                    return (Integer)obj;
                }
                return null;
            }
        },"http://tempuri.org/Subtract");
    }
    
    public String Multiply(final String intA,final String intB ) throws Exception
    {
/*This feature is available in Premium account, Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account*/
        return null;    
    }
    
    public String Divide(final String intA,final String intB ) throws Exception
    {
/*This feature is available in Premium account, Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account*/
        return null;    
    }

    
    protected Object execute(RELIWcfMethod wcfMethod,String methodName) throws Exception
    {
        Transport __httpTransport=createTransport();
        __httpTransport.debug=enableLogging;
        RELExtendedSoapSerializationEnvelope __envelope=wcfMethod.CreateSoapEnvelope();
        try
        {
            sendRequest(methodName, __envelope, __httpTransport);
            
        }
        finally {
            if (__httpTransport.debug) {
                if (__httpTransport.requestDump != null) {
                    android.util.Log.i("requestDump",__httpTransport.requestDump);    
                    
                }
                if (__httpTransport.responseDump != null) {
                    android.util.Log.i("responseDump",__httpTransport.responseDump);
                }
            }
        }
        Object __retObj = __envelope.bodyIn;
        if (__retObj instanceof org.ksoap2.SoapFault){
            org.ksoap2.SoapFault __fault = (org.ksoap2.SoapFault)__retObj;
            throw convertToException(__fault,__envelope);
        }else{
            return wcfMethod.ProcessResult(__envelope,__retObj);
        }
    }
    
        
    Exception convertToException(org.ksoap2.SoapFault fault,RELExtendedSoapSerializationEnvelope envelope)
    {

        return new Exception(fault.faultstring);
    }
}


