<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

<table>
	<tr>
		<th>&nbsp;</th>
		<th>Product ID</th>
		<th>Name</th>
	</tr>
	<%--<c:forEach var="product" items="${sessionScope.productList}">
		<tr>
			<td>
                <a href="viewProduct?productId=${product.productId}">${product.description}</a>
            </td>
			<td><b>
                <a href="viewProduct?productId=${product.productId}"><font color="BLACK"> ${product.productId} </font></a>
            </b></td>
			<td>${product.name}</td>
		</tr>
	</c:forEach>--%>
	<s:iterator value="productList">
		<tr>
			<td>
				<a href="viewProduct?productId=<s:property value="description"/>"><s:property value="description"/></a>
			</td>
			<td><b>
				<a href="viewProduct?productId=<s:property value="productId"/>"><font color="BLACK"><s:property value="productId"/> </font></a>
			</b></td>
			<td><s:property value="name"/></td>
		</tr>
	</s:iterator>
	<tr>
		<td></td>
	</tr>

</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>




