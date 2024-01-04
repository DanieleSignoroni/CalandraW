<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///W:\PthDev\Projects\Panthera\FornaceCalandra\WebContent\dtd/xhtml1-transitional.dtd">
<html>
<!-- WIZGEN Therm 2.0.0 as Form riga indipendente - multiBrowserGen = true -->
<%=WebGenerator.writeRuntimeInfo()%>
  <head>
<%@ page contentType="text/html; charset=Cp1252"%>
<%@ page import= " 
  java.sql.*, 
  java.util.*, 
  java.lang.reflect.*, 
  javax.naming.*, 
  com.thera.thermfw.common.*, 
  com.thera.thermfw.type.*, 
  com.thera.thermfw.web.*, 
  com.thera.thermfw.security.*, 
  com.thera.thermfw.base.*, 
  com.thera.thermfw.ad.*, 
  com.thera.thermfw.persist.*, 
  com.thera.thermfw.gui.cnr.*, 
  com.thera.thermfw.setting.*, 
  com.thera.thermfw.collector.*, 
  com.thera.thermfw.batch.web.*, 
  com.thera.thermfw.batch.*, 
  com.thera.thermfw.pref.* 
"%> 
<%
  ServletEnvironment se = (ServletEnvironment)Factory.createObject("com.thera.thermfw.web.ServletEnvironment"); 
  BODataCollector YLstRigTrasBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebFormForIndipendentRowForm YLstRigTrasForm =  
     new com.thera.thermfw.web.WebFormForIndipendentRowForm(request, response, "YLstRigTrasForm", "YLstRigTras", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, false, null); 
  YLstRigTrasForm.setServletEnvironment(se); 
  YLstRigTrasForm.setJSTypeList(jsList); 
  YLstRigTrasForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YLstRigTrasForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YLstRigTrasForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YLstRigTrasForm.getMode(); 
  String key = YLstRigTrasForm.getKey(); 
  String errorMessage; 
  boolean requestIsValid = false; 
  boolean leftIsKey = false; 
  boolean conflitPresent = false; 
  String leftClass = ""; 
  try 
  {
     se.initialize(request, response); 
     if(se.begin()) 
     { 
        YLstRigTrasForm.outTraceInfo(getClass().getName()); 
        String collectorName = YLstRigTrasForm.findBODataCollectorName(); 
	     YLstRigTrasBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YLstRigTrasBODC instanceof WebDataCollector) 
            ((WebDataCollector)YLstRigTrasBODC).setServletEnvironment(se); 
        YLstRigTrasBODC.initialize("YLstRigTras", true, 0); 
        YLstRigTrasForm.setBODataCollector(YLstRigTrasBODC); 
        int rcBODC = YLstRigTrasForm.initSecurityServices(); 
        mode = YLstRigTrasForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YLstRigTrasForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YLstRigTrasBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YLstRigTrasForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YLstRigTrasForm); 
   request.setAttribute("menuBar", menuBar); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="menuBar"/> 
</jsp:include> 
<% 
  menuBar.write(out); 
  menuBar.writeChildren(out); 
%> 
<% 
  WebToolBar myToolBarTB = new com.thera.thermfw.web.WebToolBar("myToolBar", "24", "24", "16", "16", "#f7fbfd","#C8D6E1"); 
  myToolBarTB.setParent(YLstRigTrasForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YLstRigTrasForm.getBodyOnBeforeUnload()%>" onload="<%=YLstRigTrasForm.getBodyOnLoad()%>" onunload="<%=YLstRigTrasForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YLstRigTrasForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YLstRigTrasForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YLstRigTrasBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YLstRigTrasForm.getServlet()%>" method="post" name="YLstRigTrasForm" style="height:100%"><%
  YLstRigTrasForm.writeFormStartElements(out); 
%>

      <table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
        <tr>
          <td style="height:0">
            <% menuBar.writeElements(out); %> 

          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% myToolBarTB.writeChildren(out); %> 

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput YLstRigTrasIdAzienda =  
     new com.thera.thermfw.web.WebTextInput("YLstRigTras", "IdAzienda"); 
  YLstRigTrasIdAzienda.setParent(YLstRigTrasForm); 
%>
<input class="<%=YLstRigTrasIdAzienda.getClassType()%>" id="<%=YLstRigTrasIdAzienda.getId()%>" maxlength="<%=YLstRigTrasIdAzienda.getMaxLength()%>" name="<%=YLstRigTrasIdAzienda.getName()%>" size="<%=YLstRigTrasIdAzienda.getSize()%>" type="hidden"><% 
  YLstRigTrasIdAzienda.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput YLstRigTrasIdListino =  
     new com.thera.thermfw.web.WebTextInput("YLstRigTras", "IdListino"); 
  YLstRigTrasIdListino.setParent(YLstRigTrasForm); 
%>
<input class="<%=YLstRigTrasIdListino.getClassType()%>" id="<%=YLstRigTrasIdListino.getId()%>" maxlength="<%=YLstRigTrasIdListino.getMaxLength()%>" name="<%=YLstRigTrasIdListino.getName()%>" size="<%=YLstRigTrasIdListino.getSize()%>" type="hidden"><% 
  YLstRigTrasIdListino.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput YLstRigTrasIdFascia =  
     new com.thera.thermfw.web.WebTextInput("YLstRigTras", "IdFascia"); 
  YLstRigTrasIdFascia.setParent(YLstRigTrasForm); 
%>
<input class="<%=YLstRigTrasIdFascia.getClassType()%>" id="<%=YLstRigTrasIdFascia.getId()%>" maxlength="<%=YLstRigTrasIdFascia.getMaxLength()%>" name="<%=YLstRigTrasIdFascia.getName()%>" size="<%=YLstRigTrasIdFascia.getSize()%>" type="hidden"><% 
  YLstRigTrasIdFascia.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td height="100%">
            <!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(YLstRigTrasForm); 
 mytabbed.addTab("tab1", "it.fornacecalandra.thip.base.listini.resources.YLstRigTras", "tab1", "YLstRigTras", null, null, null, null); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;">
              <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab1")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab1"); %>
                <table style="width: 100%;">
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YLstRigTras", "IdFascia", null); 
   label.setParent(YLstRigTrasForm); 
%><label class="<%=label.getClassType()%>" for="IdFascia"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                    </td>
                    <td valign="top">
                    </td>
                  </tr>
                </table>
              <% mytabbed.endTab(); %> 
</div>
            </div><% mytabbed.endTabbed();%> 

     </td>
   </tr>
</table><!--</span>-->
          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(YLstRigTrasForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YLstRigTrasForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YLstRigTrasForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YLstRigTrasBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YLstRigTrasForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YLstRigTrasBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YLstRigTrasBODC.getErrorList().getErrors()); 
           if(YLstRigTrasBODC.getConflict() != null) 
                conflitPresent = true; 
     } 
     else 
        errors.add(new ErrorMessage("BAS0000010")); 
  } 
  catch(NamingException e) { 
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("CBS000025", errorMessage));  } 
  catch(SQLException e) {
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("BAS0000071", errorMessage));  } 
  catch(Throwable e) {
     e.printStackTrace(Trace.excStream);
  }
  finally 
  {
     if(YLstRigTrasBODC != null && !YLstRigTrasBODC.close(false)) 
        errors.addAll(0, YLstRigTrasBODC.getErrorList().getErrors()); 
     try 
     { 
        se.end(); 
     }
     catch(IllegalArgumentException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
     catch(SQLException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
  } 
  if(!errors.isEmpty())
  { 
      if(!conflitPresent)
  { 
     request.setAttribute("ErrorMessages", errors); 
     String errorPage = YLstRigTrasForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YLstRigTrasBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YLstRigTrasForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
