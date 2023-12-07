<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///K:/Thip/4.7.0/websrcsvil/dtd/xhtml1-transitional.dtd">
<html>
<!-- WIZGEN Therm 2.0.0 as Form - multiBrowserGen = true -->
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
  BODataCollector YPsnDatiRicLaterpointBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YPsnDatiRicLaterpointForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YPsnDatiRicLaterpointForm", "YPsnDatiRicLaterpoint", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/fornacecalandra/thip/base/vendite/generaleVE/YPsnDatiRicLaterpoint.js"); 
  YPsnDatiRicLaterpointForm.setServletEnvironment(se); 
  YPsnDatiRicLaterpointForm.setJSTypeList(jsList); 
  YPsnDatiRicLaterpointForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YPsnDatiRicLaterpointForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YPsnDatiRicLaterpointForm.setWebFormModifierClass("it.thera.thip.cs.web.DatiPersWebFormModifier"); 
  YPsnDatiRicLaterpointForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YPsnDatiRicLaterpointForm.getMode(); 
  String key = YPsnDatiRicLaterpointForm.getKey(); 
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
        YPsnDatiRicLaterpointForm.outTraceInfo(getClass().getName()); 
        String collectorName = YPsnDatiRicLaterpointForm.findBODataCollectorName(); 
                YPsnDatiRicLaterpointBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YPsnDatiRicLaterpointBODC instanceof WebDataCollector) 
            ((WebDataCollector)YPsnDatiRicLaterpointBODC).setServletEnvironment(se); 
        YPsnDatiRicLaterpointBODC.initialize("YPsnDatiRicLaterpoint", true, 0); 
        YPsnDatiRicLaterpointForm.setBODataCollector(YPsnDatiRicLaterpointBODC); 
        int rcBODC = YPsnDatiRicLaterpointForm.initSecurityServices(); 
        mode = YPsnDatiRicLaterpointForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YPsnDatiRicLaterpointForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YPsnDatiRicLaterpointBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YPsnDatiRicLaterpointForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YPsnDatiRicLaterpointForm); 
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
  myToolBarTB.setParent(YPsnDatiRicLaterpointForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YPsnDatiRicLaterpointForm.getBodyOnBeforeUnload()%>" onload="<%=YPsnDatiRicLaterpointForm.getBodyOnLoad()%>" onunload="<%=YPsnDatiRicLaterpointForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YPsnDatiRicLaterpointForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YPsnDatiRicLaterpointForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YPsnDatiRicLaterpointBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YPsnDatiRicLaterpointForm.getServlet()%>" method="post" name="YPsnDatiRicLaterpointForm" style="height:100%"><%
  YPsnDatiRicLaterpointForm.writeFormStartElements(out); 
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
          <td height="100%">
            <!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(YPsnDatiRicLaterpointForm); 
 mytabbed.addTab("tab1", "it.fornacecalandra.thip.base.vendite.generaleVE.resources.YPsnDatiRicLaterpoint", "tab1", "YPsnDatiRicLaterpoint", null, null, null, null); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;">
              <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab1")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab1"); %>
                <table style="width: 100%;">
                  <tr>
                    <td colspan="2" valign="top">
                      <% 
  WebCheckBox YPsnDatiRicLaterpointRicezioneAbilitata =  
     new com.thera.thermfw.web.WebCheckBox("YPsnDatiRicLaterpoint", "RicezioneAbilitata"); 
  YPsnDatiRicLaterpointRicezioneAbilitata.setParent(YPsnDatiRicLaterpointForm); 
%>
<input id="<%=YPsnDatiRicLaterpointRicezioneAbilitata.getId()%>" name="<%=YPsnDatiRicLaterpointRicezioneAbilitata.getName()%>" type="checkbox" value="Y"><%
  YPsnDatiRicLaterpointRicezioneAbilitata.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPsnDatiRicLaterpoint", "RNumeratoreDocVen", null); 
   label.setParent(YPsnDatiRicLaterpointForm); 
%><label class="<%=label.getClassType()%>" for="NumeratoreDocumentoVendit"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPsnDatiRicLaterpointSerieDocumentoVendita =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPsnDatiRicLaterpoint", "SerieDocumentoVendita", false, false, true, 1, null, null); 
  YPsnDatiRicLaterpointSerieDocumentoVendita.setParent(YPsnDatiRicLaterpointForm); 
  YPsnDatiRicLaterpointSerieDocumentoVendita.write(out); 
%>
<!--<span class="multisearchform" id="SerieDocumentoVendita"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPsnDatiRicLaterpoint", "RSerieDocVen", null); 
   label.setParent(YPsnDatiRicLaterpointForm); 
%><label class="<%=label.getClassType()%>" for="SerieDocumentoVendita"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPsnDatiRicLaterpointNumeratoreDocumentoVendit =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPsnDatiRicLaterpoint", "NumeratoreDocumentoVendit", false, false, true, 1, null, null); 
  YPsnDatiRicLaterpointNumeratoreDocumentoVendit.setParent(YPsnDatiRicLaterpointForm); 
  YPsnDatiRicLaterpointNumeratoreDocumentoVendit.write(out); 
%>
<!--<span class="multisearchform" id="NumeratoreDocumentoVendit"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                    </td>
                    <td valign="top">
                    </td>
                  </tr>
                  <tr>
									<td colspan="2" valign="top"><!--<span class="editgrid" id="YTrasCauTesNuovaLat">--><% 
  WebEditGrid YPsnDatiRicLaterpointYTrascodificaCauTesNL =  
     new com.thera.thermfw.web.WebEditGrid("YPsnDatiRicLaterpoint", "YTrascodificaCauTesNL", 8, new String[]{"RCauNuovaLat", "RCauTes"}, 1, null, null,false,"com.thera.thermfw.web.servlet.GridActionAdapterForIndependentRow"); 
 YPsnDatiRicLaterpointYTrascodificaCauTesNL.setParent(YPsnDatiRicLaterpointForm); 
 YPsnDatiRicLaterpointYTrascodificaCauTesNL.setNoControlRowKeys(false); 
 YPsnDatiRicLaterpointYTrascodificaCauTesNL.write(out); 
%>
<BR><% 
   request.setAttribute("parentForm", YPsnDatiRicLaterpointForm); 
   String CDForYTrascodificaCauTesNL = "YTrascodificaCauTesNL"; 
%>
<jsp:include page="/it/fornacecalandra/thip/base/vendite/generaleVE/YTrasCauTesNuovaLat.jsp" flush="true"> 
<jsp:param name="EditGridCDName" value="<%=CDForYTrascodificaCauTesNL%>"/> 
<jsp:param name="Mode" value="NEW"/> 
</jsp:include> 
<!--</span>--></td>
								</tr>
								<tr>
									<td colspan="2" valign="top"><!--<span class="editgrid" id="YTrasCauRigNuovaLat">--><% 
  WebEditGrid YPsnDatiRicLaterpointYTrascodificaCauRigNL =  
     new com.thera.thermfw.web.WebEditGrid("YPsnDatiRicLaterpoint", "YTrascodificaCauRigNL", 8, new String[]{"RCauNuovaLat", "RCauRig"}, 1, null, null,false,"com.thera.thermfw.web.servlet.GridActionAdapterForIndependentRow"); 
 YPsnDatiRicLaterpointYTrascodificaCauRigNL.setParent(YPsnDatiRicLaterpointForm); 
 YPsnDatiRicLaterpointYTrascodificaCauRigNL.setNoControlRowKeys(false); 
 YPsnDatiRicLaterpointYTrascodificaCauRigNL.write(out); 
%>
<BR><% 
   request.setAttribute("parentForm", YPsnDatiRicLaterpointForm); 
   String CDForYTrascodificaCauRigNL = "YTrascodificaCauRigNL"; 
%>
<jsp:include page="/it/fornacecalandra/thip/base/vendite/generaleVE/YTrasCauRigNuovaLat.jsp" flush="true"> 
<jsp:param name="EditGridCDName" value="<%=CDForYTrascodificaCauRigNL%>"/> 
<jsp:param name="Mode" value="NEW"/> 
</jsp:include> 
<!--</span>--></td>
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
  errorList.setParent(YPsnDatiRicLaterpointForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YPsnDatiRicLaterpointForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YPsnDatiRicLaterpointForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YPsnDatiRicLaterpointBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YPsnDatiRicLaterpointForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YPsnDatiRicLaterpointBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YPsnDatiRicLaterpointBODC.getErrorList().getErrors()); 
           if(YPsnDatiRicLaterpointBODC.getConflict() != null) 
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
     if(YPsnDatiRicLaterpointBODC != null && !YPsnDatiRicLaterpointBODC.close(false)) 
        errors.addAll(0, YPsnDatiRicLaterpointBODC.getErrorList().getErrors()); 
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
     String errorPage = YPsnDatiRicLaterpointForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YPsnDatiRicLaterpointBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YPsnDatiRicLaterpointForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
