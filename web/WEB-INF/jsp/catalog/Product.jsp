<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="viewCategory?categoryId=${sessionScope.product.categoryId}">Return to ${sessionScope.product.categoryId}</a>
</div>

<div id="Catalog">

<h2>${sessionScope.product.name}</h2>

<table>
	<tr>
		<th>Item ID</th>
		<th>Product ID</th>
		<th>Description</th>
		<th>List Price</th>
		<th>&nbsp;</th>
	</tr>
	<%--<c:forEach var="item" items="${sessionScope.itemList}">
		<tr>
			<td>
                <a href="viewItem?itemId=${item.itemId}">${item.itemId}</a>
            </td>
			<td>
			    ${item.product.productId}
            </td>
			<td>
			    ${item.attribute1} ${item.attribute2} ${item.attribute3}
			    ${item.attribute4} ${item.attribute5} ${sessionScope.product.name}
            </td>
			<td>
                <fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00" /></td>
			<td>
                <a class="Button" href="addItemToCart?workingItemId=${item.itemId}">Add to Cart</a>
            </td>
		</tr>
	</c:forEach>--%>
	<s:iterator value="itemList">
		<tr>
			<td>
				<a href="viewItem?itemId=<s:property value="itemId"/>"><s:property value="itemId"/></a>
			</td>
					<s:property value="productId"/>
			</td>
			<td>
					<s:property value="attribute1"/><s:property value="attribute2"/><s:property value="attribute3"/>
					<s:property value="attribute4"/><s:property value="attribute5"/><s:property value="#product.name"/>
			</td>
			<td>
				<s:property value="listPrice"/>
			</td>
			<td>
				<a class="Button" href="addItemToCart?workingItemId=<s:property value="itemId"/>">Add to Cart</a>
			</td>
		</tr>
	</s:iterator>
	<tr>
		<td>
		</td>
	</tr>
</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>





