<%@page import="com.ssavr.solr.model.IceCream"%>
<%@page import="com.ssavr.solr.model.IceCreamDocuments"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Collections"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>


<%
	IceCream bean = null;
	String iceCreamDocIds = "";
%>

<aui:fieldset>
	<span
		class="aui-field aui-field-text aui-field-input-asset-selector aui-field-focused">
		<span class="aui-field-content"> <label class="aui-field-label"
			for="_substance_WAR_substanceportlet_reportTitles">
				Ice Cream Recipe(s)				
				 </label> 
				 <span class="aui-field-element">
				<div
					class="aui-widget aui-component aui-autocomplete aui-textboxlist aui-tagselector aui-tagselector-focused"
					tabindex="0">
					<span
						class="lfr-tags-selector-content aui-autocomplete-content aui-textboxlist-content aui-tagselector-content">


						<ul id="<portlet:namespace />revDocUlId_"
							class="aui-helper-clearfix aui-textboxlistentry-holder">
							<span class="aui-textboxlistentry-content"> <span
								class="aui-textboxlistentry-text"></span> <span
								class="aui-textboxlistentry-close"></span>
							</span>

							<%
								if(bean != null){
									List<IceCreamDocuments> documents = bean.getDocuments();
									for(IceCreamDocuments document : documents){
										iceCreamDocIds += String.valueOf(document.getDocumentId()) + StringPool.COMMA;
										String title = document.getTitle();
							%>

	
								<li id="<portlet:namespace />revDocLiId_<%=document.getDocumentId()%>"
									class="aui-widget aui-component aui-textboxlistentry"
									tabindex="0">
									<span class="aui-textboxlistentry-content">
										<span class="aui-textboxlistentry-text"><%=title%></span>
										<span class="aui-icon aui-icon-close aui-textboxlistentry-close" onclick="javaScript:<portlet:namespace/>removeDoc(<%=document.getDocumentId()%>)"></span>
									</span>
								</li>
							<%
									}
								}
							%>
						</ul> <span
						class="aui-widget aui-component aui-toolbar aui-toolbar-horizontal">
							<span id="spanId" class="aui-toolbar-content">
								<button id="add"
									class="aui-buttonitem-content aui-widget aui-component aui-buttonitem aui-state-default aui-buttonitem-icon-label aui-toolbar-first aui-toolbar-last aui-toolbar-item"
									type="button" title=""
									onclick="javaScript:<portlet:namespace />addDoc()">
									<span class="aui-buttonitem-icon aui-icon aui-icon-plus"></span>
									<span id="spanId" class="aui-buttonitem-label">Add</span>
								</button>
						</span>
					</span> <aui:input name="iceCreamDocumentsIds"
							type="hidden" value="<%=iceCreamDocIds%>" />
					</span>
				</div>
		</span>
	</span>
	</span>
</aui:fieldset>


<%
	long dlScopeGroupId = themeDisplay.getScopeGroupId();
	LiferayPortletURL documentLibURL = PortletURLFactoryUtil.create(request, PortletKeys.JOURNAL, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	documentLibURL.setWindowState(LiferayWindowState.POP_UP);
	documentLibURL.setPortletMode(PortletMode.VIEW);
	documentLibURL.setParameter("struts_action", "/journal/select_document_library");
	documentLibURL.setParameter("groupId", String.valueOf(dlScopeGroupId));
	/* documentLibURL.setParameter("revampMultiDocField", "true"); */
%>

<script charset="utf-8" type="text/javascript">
	function <portlet:namespace />addDoc(){
		
		window.open('<%=documentLibURL.toString()%>','Select_Template','directories=no,height=640,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=680');
		
		_15_selectDocumentLibraryForRevamp= function(selectedDocId, selectedDocTitle) {
			
			var liId = '' + '<portlet:namespace />revDocLiId_' + selectedDocId;
			liId = "'" + liId + "'";			
			
			var holder = AUI().one('#<portlet:namespace />revDocUlId_');
			var childNode = AUI().Node.create("<li id="+liId+" class=\"aui-widget aui-component aui-textboxlistentry\" tabindex=\"0\"></li>");
			
			var content = "<span class=\"aui-textboxlistentry-content\">"
						  +		"<span class=\"aui-textboxlistentry-text\">"+selectedDocTitle+"</span>"
						  +		"<span class=\"aui-icon aui-icon-close aui-textboxlistentry-close\" onclick=\"javaScript:<portlet:namespace/>removeDoc('"+selectedDocId+"')\"></span>"
						  +"</span>";
				
			var hiddenSelectedDocIdsNode = AUI().one('#<portlet:namespace />iceCreamDocumentsIds');
			
			var  hiddenSelectedDocIds = hiddenSelectedDocIdsNode.get('value');
			
			if(hiddenSelectedDocIds == ''){
				
				hiddenSelectedDocIdsNode.val(selectedDocId);
				
				childNode.html(content);
				childNode.appendTo(holder);
			}else {				
				if(hiddenSelectedDocIds.indexOf(selectedDocId) == -1) {
										
					hiddenSelectedDocIds = hiddenSelectedDocIds + '<%=StringPool.COMMA%>' + selectedDocId;
					hiddenSelectedDocIdsNode.val(hiddenSelectedDocIds);
					
					childNode.html(content);
					childNode.appendTo(holder);
				}
			}
		}
	}
</script>

<script charset="utf-8" type="text/javascript">
	function <portlet:namespace />removeDoc(selectedDocId){
		
		var nodeToDelete = AUI().one('#<portlet:namespace />revDocLiId_'+selectedDocId);		
				
		var hiddenSelectedDocIdsNode = AUI().one('#<portlet:namespace />iceCreamDocumentsIds');
		
		var hiddenSelectedDocIds = hiddenSelectedDocIdsNode.get('value');
		
		if(hiddenSelectedDocIds != ''){		
			
			var removeDocIdCase_1 = selectedDocId + '<%=StringPool.COMMA%>';
			var removeDocIdCase_2 = '<%=StringPool.COMMA%>' + selectedDocId;
			var removeDocIdCase_3 = selectedDocId;
			
			if(hiddenSelectedDocIds.indexOf(removeDocIdCase_1) != -1) {				
				hiddenSelectedDocIds = hiddenSelectedDocIds.replace(removeDocIdCase_1, '');
				hiddenSelectedDocIdsNode.val(hiddenSelectedDocIds);
				nodeToDelete.remove();
			}else if(hiddenSelectedDocIds.indexOf(removeDocIdCase_2) != -1) {
				hiddenSelectedDocIds = hiddenSelectedDocIds.replace(removeDocIdCase_2, '');
				hiddenSelectedDocIdsNode.val(hiddenSelectedDocIds);
				nodeToDelete.remove();
			}else if(hiddenSelectedDocIds.indexOf(removeDocIdCase_3) != -1) {
				hiddenSelectedDocIds = hiddenSelectedDocIds.replace(removeDocIdCase_3, '');
				hiddenSelectedDocIdsNode.val(hiddenSelectedDocIds);
				nodeToDelete.remove();
			}			
		}
	}	
</script>
