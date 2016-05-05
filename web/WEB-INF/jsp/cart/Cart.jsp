<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

<div id="Cart">

<h2>Shopping Cart</h2>
	<form action="updateCartQuantities" method="post">
		<table>
			<tr>
				<th><b>Item ID</b></th>
				<th><b>Product ID</b></th>
				<th><b>Description</b></th>
				<th><b>In Stock?</b></th>
				<th><b>Quantity</b></th>
				<th><b>List Price</b></th>
				<th><b>Total Cost</b></th>
				<th>&nbsp;</th>
			</tr>

			<s:if test="cart.numberOfItems == 0">
				<tr>
					<td colspan="8"><b>Your cart is empty.</b></td>
				</tr>
			</s:if>

			<s:iterator value="cart.cartItems">
				<tr>
					<td>
						<a href="viewItem?itemId=<s:property value="item.itemId"/>"><s:property value="item.itemId"/> </a>
					</td>
					<td>
						<s:property value="item.product.productId"/>
					</td>
					<td>
						<s:property value="item.attribute1"/><s:property value="item.attribute2"/>
						<s:property value="item.attribute3"/><s:property value="item.attribute4"/>
						<s:property value="item.attribute5"/><s:property value="item.product.name"/>
					</td>
					<td>
						<s:property value="inStock"/>
					</td>
					<td>
						<s:textfield value="%{quantity}" theme="simple" label="itemId"/>
						<%--<s:property value="quantity"/>--%>
					</td>
					<td>
						<s:property value="item.listPrice"/>
					</td>
					<td>
						<s:property value="total"/>
					</td>
					<td>
						<a href="removeItemFromCart?workingItemId=<s:property value="item.itemId"/>" class="Button">Remove</a>
					</td>
				</tr>
			</s:iterator>
			<tr>
				<td colspan="7">
					<input type="submit" value="Update Cart"/>
				</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>

		<s:if test="cart.numberOfItems > 0">
			<c:if test="${sessionScope.accountBean == null}">
				<a href="loginForm" class="Button">Proceed to Checkout</a>
			</c:if>
		</s:if>
	<s:if test="cart.numberOfItems > 0">
		<c:if test="${sessionScope.accountBean != null}">
			<c:if test="${sessionScope.authenticated == false}">
				<a href="loginForm" class="Button">Proceed to Checkout</a>
			</c:if>
		</c:if>
	</s:if>
	<s:if test="cart.numberOfItems > 0">
		<c:if test="${sessionScope.accountBean != null}">
			<c:if test="${sessionScope.authenticated == true}">
				<a href="toCheckOut" class="Button">Proceed to Checkout</a>
			</c:if>
		</c:if>
	</s:if>
</div>

<div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>