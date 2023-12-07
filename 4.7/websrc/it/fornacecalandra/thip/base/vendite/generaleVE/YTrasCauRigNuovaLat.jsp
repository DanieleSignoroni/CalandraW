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
  BODataCollector YTrasCauRigNuovaLatBODC = null; 
  WebFormForInternalRowForm YTrasCauRigNuovaLatForm =  
     new com.thera.thermfw.web.WebFormForInternalRowForm(request, response, "YTrasCauRigNuovaLatForm", "YTrasCauRigNuovaLat", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, false, false, true, true, null, 1); 
  int mode = YTrasCauRigNuovaLatForm.getMode(); 
  String key = YTrasCauRigNuovaLatForm.getKey(); 
  String errorMessage; 
  boolean requestIsValid = false; 
  boolean leftIsKey = false; 
  String leftClass = ""; 
  try 
  {
     se.initialize(request, response); 
     if(se.begin()) 
     { 
        YTrasCauRigNuovaLatForm.outTraceInfo(getClass().getName()); 
        ClassADCollection globCadc = YTrasCauRigNuovaLatForm.getClassADCollection(); 
        requestIsValid = true; 
        YTrasCauRigNuovaLatForm.write(out); 
        String collectorName = YTrasCauRigNuovaLatForm.findBODataCollectorName(); 
				 YTrasCauRigNuovaLatBODC = (BODataCollector)Factory.createObject(collectorName); 
        YTrasCauRigNuovaLatBODC.initialize("YTrasCauRigNuovaLat", true, 1); 
        YTrasCauRigNuovaLatForm.setBODataCollector(YTrasCauRigNuovaLatBODC); 
        WebForm parentForm = (WebForm)request.getAttribute("parentForm"); 
        YTrasCauRigNuovaLatForm.setJSTypeList(parentForm.getOwnerForm().getJSTypeList()); 
        YTrasCauRigNuovaLatForm.setParent(parentForm); 
        YTrasCauRigNuovaLatForm.writeHeadElements(out); 
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
   YTrasCauRigNuovaLatForm.writeBodyStartElements(out); 
%> 

	<% 
  if(false) 
  { 
%> 
<form name="YTrasCauRigNuovaLatForm"><% 
  } 
%> 
<%
   YTrasCauRigNuovaLatForm.writeFormStartElements(out); 
%> 

		<table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
			<tr>
				<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YTrasCauRigNuovaLat", "RCauNuovaLat", null); 
   label.setParent(YTrasCauRigNuovaLatForm); 
%><label class="<%=label.getClassType()%>" for="RCauNuovaLat"><%label.write(out);%></label><%}%></td>
				<td valign="top"><% 
  WebTextInput YTrasCauRigNuovaLatRCauNuovaLat =  
     new com.thera.thermfw.web.WebTextInput("YTrasCauRigNuovaLat", "RCauNuovaLat"); 
  YTrasCauRigNuovaLatRCauNuovaLat.setParent(YTrasCauRigNuovaLatForm); 
%>
<input class="<%=YTrasCauRigNuovaLatRCauNuovaLat.getClassType()%>" id="<%=YTrasCauRigNuovaLatRCauNuovaLat.getId()%>" maxlength="<%=YTrasCauRigNuovaLatRCauNuovaLat.getMaxLength()%>" name="<%=YTrasCauRigNuovaLatRCauNuovaLat.getName()%>" size="<%=YTrasCauRigNuovaLatRCauNuovaLat.getSize()%>"><% 
  YTrasCauRigNuovaLatRCauNuovaLat.write(out); 
%>
</td>
			</tr>
				<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YTrasCauRigNuovaLat", "RCauRig", null); 
   label.setParent(YTrasCauRigNuovaLatForm); 
%><label class="<%=label.getClassType()%>" for="CausaleDocVenRig"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebMultiSearchForm YTrasCauRigNuovaLatCausaleDocVenRig =  
     new com.thera.thermfw.web.WebMultiSearchForm("YTrasCauRigNuovaLat", "CausaleDocVenRig", false, false, true, 1, null, null); 
  YTrasCauRigNuovaLatCausaleDocVenRig.setParent(YTrasCauRigNuovaLatForm); 
  YTrasCauRigNuovaLatCausaleDocVenRig.write(out); 
%>
<!--<span class="multisearchform" id="CausaleDocVenRig"></span>--></td>
								</tr>
		</table>
	<%
  YTrasCauRigNuovaLatForm.writeFormEndElements(out); 
%>
<% 
  if(false) 
  { 
%> 
</form><% 
  } 
%> 

<%
   YTrasCauRigNuovaLatForm.writeBodyEndElements(out); 
%> 
<% 
  if(false) 
  { 
%> 
</body><% 
  } 
%> 

