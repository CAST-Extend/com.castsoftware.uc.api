BUG
----
 the generated code for the Web Service client needs a little fix to force HTTP 1.1 (or web service calls hang for 5 min before completing)
 
         _call.setProperty(MessageContext.HTTP_TRANSPORT_VERSION,HTTPConstants.HEADER_PROTOCOL_V11);
         
need to be added to
         
         protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
         
just before         
         
         return _call;