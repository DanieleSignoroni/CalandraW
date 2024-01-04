<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///W:\PthDev\Projects\Panthera\FornaceCalandra\WebContent\dtd/xhtml1-transitional.dtd">
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
  BODataCollector YLstTesTrasBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YLstTesTrasForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YLstTesTrasForm", "YLstTesTras", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/fornacecalandra/thip/base/listini/YLstTesTras.js"); 
  YLstTesTrasForm.setServletEnvironment(se); 
  YLstTesTrasForm.setJSTypeList(jsList); 
  YLstTesTrasForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YLstTesTrasForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YLstTesTrasForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YLstTesTrasForm.getMode(); 
  String key = YLstTesTrasForm.getKey(); 
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
        YLstTesTrasForm.outTraceInfo(getClass().getName()); 
        String collectorName = YLstTesTrasForm.findBODataCollectorName(); 
                YLstTesTrasBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YLstTesTrasBODC instanceof WebDataCollector) 
            ((WebDataCollector)YLstTesTrasBODC).setServletEnvironment(se); 
        YLstTesTrasBODC.initialize("YLstTesTras", true, 0); 
        YLstTesTrasForm.setBODataCollector(YLstTesTrasBODC); 
        int rcBODC = YLstTesTrasForm.initSecurityServices(); 
        mode = YLstTesTrasForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YLstTesTrasForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YLstTesTrasBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YLstTesTrasForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YLstTesTrasForm); 
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
  myToolBarTB.setParent(YLstTesTrasForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YLstTesTrasForm.getBodyOnBeforeUnload()%>" onload="<%=YLstTesTrasForm.getBodyOnLoad()%>" onunload="<%=YLstTesTrasForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YLstTesTrasForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YLstTesTrasForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YLstTesTrasBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YLstTesTrasForm.getServlet()%>" method="post" name="YLstTesTrasForm" style="height:100%"><%
  YLstTesTrasForm.writeFormStartElements(out); 
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
  mytabbed.setParent(YLstTesTrasForm); 
 mytabbed.addTab("tab1", "it.fornacecalandra.thip.base.listini.resources.YLstTesTras", "tab1", "YLstTesTras", null, null, null, null); 
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
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YLstTesTras", "IdListino", null); 
   label.setParent(YLstTesTrasForm); 
%><label class="<%=label.getClassType()%>" for="IdListino"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YLstTesTrasIdListino =  
     new com.thera.thermfw.web.WebTextInput("YLstTesTras", "IdListino"); 
  YLstTesTrasIdListino.setParent(YLstTesTrasForm); 
%>
<input class="<%=YLstTesTrasIdListino.getClassType()%>" id="<%=YLstTesTrasIdListino.getId()%>" maxlength="<%=YLstTesTrasIdListino.getMaxLength()%>" name="<%=YLstTesTrasIdListino.getName()%>" size="<%=YLstTesTrasIdListino.getSize()%>"><% 
  YLstTesTrasIdListino.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YLstTesTras", "IdVettore", null); 
   label.setParent(YLstTesTrasForm); 
%><label class="<%=label.getClassType()%>" for="Vettore"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YLstTesTrasVettore =  
     new com.thera.thermfw.web.WebMultiSearchForm("YLstTesTras", "Vettore", false, false, true, 1, null, null); 
  YLstTesTrasVettore.setParent(YLstTesTrasForm); 
  YLstTesTrasVettore.write(out); 
%>
<!--<span class="multisearchform" id="Vettore"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YLstTesTras", "DataInzValidita", null); 
   label.setParent(YLstTesTrasForm); 
%><label class="<%=label.getClassType()%>" for="DataInzValidita"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YLstTesTrasDataFinValidita =  
     new com.thera.thermfw.web.WebTextInput("YLstTesTras", "DataFinValidita"); 
  YLstTesTrasDataFinValidita.setShowCalendarBtn(true); 
  YLstTesTrasDataFinValidita.setParent(YLstTesTrasForm); 
%>
<input class="<%=YLstTesTrasDataFinValidita.getClassType()%>" id="<%=YLstTesTrasDataFinValidita.getId()%>" maxlength="<%=YLstTesTrasDataFinValidita.getMaxLength()%>" name="<%=YLstTesTrasDataFinValidita.getName()%>" size="<%=YLstTesTrasDataFinValidita.getSize()%>"><% 
  YLstTesTrasDataFinValidita.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YLstTesTras", "DataFinValidita", null); 
   label.setParent(YLstTesTrasForm); 
%><label class="<%=label.getClassType()%>" for="DataFinValidita"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YLstTesTrasDataInzValidita =  
     new com.thera.thermfw.web.WebTextInput("YLstTesTras", "DataInzValidita"); 
  YLstTesTrasDataInzValidita.setShowCalendarBtn(true); 
  YLstTesTrasDataInzValidita.setParent(YLstTesTrasForm); 
%>
<input class="<%=YLstTesTrasDataInzValidita.getClassType()%>" id="<%=YLstTesTrasDataInzValidita.getId()%>" maxlength="<%=YLstTesTrasDataInzValidita.getMaxLength()%>" name="<%=YLstTesTrasDataInzValidita.getName()%>" size="<%=YLstTesTrasDataInzValidita.getSize()%>"><% 
  YLstTesTrasDataInzValidita.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YLstTesTras", "IdTipoTrasporto", null); 
   label.setParent(YLstTesTrasForm); 
%><label class="<%=label.getClassType()%>" for="TipoTrasporto"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YLstTesTrasTipoTrasporto =  
     new com.thera.thermfw.web.WebMultiSearchForm("YLstTesTras", "TipoTrasporto", false, false, true, 1, null, null); 
  YLstTesTrasTipoTrasporto.setParent(YLstTesTrasForm); 
  YLstTesTrasTipoTrasporto.write(out); 
%>
<!--<span class="multisearchform" id="TipoTrasporto"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                    </td>
                    <td valign="top">
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2" valign="top">
                      <!--<span class="editgrid" id="YLstRigTras">--><% 
  WebEditGrid YLstTesTrasYLstRigTras =  
     new com.thera.thermfw.web.WebEditGrid("YLstTesTras", "YLstRigTras", 8, new String[]{"IdFascia", "IdListino", "IdAzienda", "KmDa", "KmA", "Prezzo", "Azienda.Descrizione"}, 3, null, null,false,"com.thera.thermfw.web.servlet.GridActionAdapterForIndependentRow"); 
 YLstTesTrasYLstRigTras.setParent(YLstTesTrasForm); 
 YLstTesTrasYLstRigTras.setNoControlRowKeys(false); 
 YLstTesTrasYLstRigTras.addHideAsDefault("Azienda.Descrizione"); 
 YLstTesTrasYLstRigTras.write(out); 
%>
<!--</span>-->
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
  errorList.setParent(YLstTesTrasForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YLstTesTrasForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YLstTesTrasForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YLstTesTrasBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YLstTesTrasForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YLstTesTrasBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YLstTesTrasBODC.getErrorList().getErrors()); 
           if(YLstTesTrasBODC.getConflict() != null) 
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
     if(YLstTesTrasBODC != null && !YLstTesTrasBODC.close(false)) 
        errors.addAll(0, YLstTesTrasBODC.getErrorList().getErrors()); 
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
     String errorPage = YLstTesTrasForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YLstTesTrasBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YLstTesTrasForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
