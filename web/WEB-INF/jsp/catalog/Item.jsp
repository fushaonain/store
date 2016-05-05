<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="#">Return to <s:property value="item.product.productId"/></a>
</div>

<div id="Catalog">

<table>
	<tr>
		<td><s:property value="%{item.product.description}"/></td>
	</tr>
	<tr>
		<td><b> <s:property value="item.itemId"/> </b></td>
	</tr>
	<tr>
		<td><b><font size="4"> <s:property value="item.attribute1"/>
		<s:property value="item.attribute2"/><s:property value="item.attribute3"/>
		<s:property value="item.attribute4"/><s:property value="item.attribute5"/>
		<s:property value="item.product.name"/> </font></b></td>
	</tr>
	<tr>
		<td><s:property value="item.product.name"/></td>
	</tr>
	<tr>
		<td>
			<s:if test="item.quantity <= 0">
        		Back ordered.
            </s:if>
			<s:if test="item.quantity > 0">
      			<s:property value="item.quantity"/> in stock.
	  		</s:if>
		</td>
	</tr>
	<tr>
		<td><s:property value="item.listPrice"/></td>
	</tr>

	<tr>
		<td>
            <a class="Button" href="addItemToCart?workingItemId=<s:property value="item.itemId"/>">Add to Cart</a>
        </td>
	</tr>
</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>



