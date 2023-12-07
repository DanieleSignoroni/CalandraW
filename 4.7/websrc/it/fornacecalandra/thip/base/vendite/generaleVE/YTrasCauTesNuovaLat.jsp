<!-- WIZGEN Therm 2.0.0 as Form riga interna - multiBrowserGen = true -->
<% 
  if(false) 
  { 
%> 
<head><% 
  } 
%> 

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
  BODataCollector YTrasCauTesNuovaLatBODC = null; 
  WebFormForInternalRowForm YTrasCauTesNuovaLatForm =  
     new com.thera.thermfw.web.WebFormForInternalRowForm(request, response, "YTrasCauTesNuovaLatForm", "YTrasCauTesNuovaLat", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, false, false, true, true, null, 1); 
  int mode = YTrasCauTesNuovaLatForm.getMode(); 
  String key = YTrasCauTesNuovaLatForm.getKey(); 
  String errorMessage; 
  boolean requestIsValid = false; 
  boolean leftIsKey = false; 
  String leftClass = ""; 
  try 
  {
     se.initialize(request, response); 
     if(se.begin()) 
     { 
        YTrasCauTesNuovaLatForm.outTraceInfo(getClass().getName()); 
        ClassADCollection globCadc = YTrasCauTesNuovaLatForm.getClassADCollection(); 
        requestIsValid = true; 
        YTrasCauTesNuovaLatForm.write(out); 
        String collectorName = YTrasCauTesNuovaLatForm.findBODataCollectorName(); 
				 YTrasCauTesNuovaLatBODC = (BODataCollector)Factory.createObject(collectorName); 
        YTrasCauTesNuovaLatBODC.initialize("YTrasCauTesNuovaLat", true, 1); 
        YTrasCauTesNuovaLatForm.setBODataCollector(YTrasCauTesNuovaLatBODC); 
        WebForm parentForm = (WebForm)request.getAttribute("parentForm"); 
        YTrasCauTesNuovaLatForm.setJSTypeList(parentForm.getOwnerForm().getJSTypeList()); 
        YTrasCauTesNuovaLatForm.setParent(parentForm); 
        YTrasCauTesNuovaLatForm.writeHeadElements(out); 
     }
  }
  catch(NamingException e) { 
    errorMessage = e.getMessage(); 
  } 
  catch(SQLException e) { 
     errorMessage = e.getMessage(); 
  } 
  finally 
  { 
     try 
     { 
        se.end(); 
     } 
     catch(IllegalArgumentException e) { 
        e.printStackTrace(); 
     } 
     catch(SQLException e) { 
        e.printStackTrace(); 
     } 
  } 
%> 
<% 
  if(false) 
  { 
%> 
</head><% 
  } 
%> 

<% 
  if(false) 
  { 
%> 
<body style="margin: 0px; overflow: hidden;"><% 
  } 
%> 
<%
   YTrasCauTesNuovaLatForm.writeBodyStartElements(out); 
%> 

	<% 
  if(false) 
  { 
%> 
<form name="YTrasCauTesNuovaLatForm"><% 
  } 
%> 
<%
   YTrasCauTesNuovaLatForm.writeFormStartElements(out); 
%> 

		<table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
			<tr>
				<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YTrasCauTesNuovaLat", "RCauNuovaLat", null); 
   label.setParent(YTrasCauTesNuovaLatForm); 
%><label class="<%=label.getClassType()%>" for="RCauNuovaLat"><%label.write(out);%></label><%}%></td>
				<td valign="top"><% 
  WebTextInput YTrasCauTesNuovaLatRCauNuovaLat =  
     new com.thera.thermfw.web.WebTextInput("YTrasCauTesNuovaLat", "RCauNuovaLat"); 
  YTrasCauTesNuovaLatRCauNuovaLat.setParent(YTrasCauTesNuovaLatForm); 
%>
<input class="<%=YTrasCauTesNuovaLatRCauNuovaLat.getClassType()%>" id="<%=YTrasCauTesNuovaLatRCauNuovaLat.getId()%>" maxlength="<%=YTrasCauTesNuovaLatRCauNuovaLat.getMaxLength()%>" name="<%=YTrasCauTesNuovaLatRCauNuovaLat.getName()%>" size="<%=YTrasCauTesNuovaLatRCauNuovaLat.getSize()%>"><% 
  YTrasCauTesNuovaLatRCauNuovaLat.write(out); 
%>
</td>
			</tr>
				<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YTrasCauTesNuovaLat", "RCauTes", null); 
   label.setParent(YTrasCauTesNuovaLatForm); 
%><label class="<%=label.getClassType()%>" for="CausaleDocVenTes"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebMultiSearchForm YTrasCauTesNuovaLatCausaleDocVenTes =  
     new com.thera.thermfw.web.WebMultiSearchForm("YTrasCauTesNuovaLat", "CausaleDocVenTes", false, false, true, 1, null, null); 
  YTrasCauTesNuovaLatCausaleDocVenTes.setParent(YTrasCauTesNuovaLatForm); 
  YTrasCauTesNuovaLatCausaleDocVenTes.write(out); 
%>
<!--<span class="multisearchform" id="CausaleDocVenTes"></span>--></td>
								</tr>
		</table>
	<%
  YTrasCauTesNuovaLatForm.writeFormEndElements(out); 
%>
<% 
  if(false) 
  { 
%> 
</form><% 
  } 
%> 

<%
   YTrasCauTesNuovaLatForm.writeBodyEndElements(out); 
%> 
<% 
  if(false) 
  { 
%> 
</body><% 
  } 
%> 

