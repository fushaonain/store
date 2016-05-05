<%@ include file="../common/IncludeTop.jsp"%>

<h2>My Orders</h2>

<table>
	<tr>
		<th>Order ID</th>
		<th>Date</th>
		<th>Total Price</th>
	</tr>
	<!-- 循环 -->
	<%--<c:forEach var="order" items="${sessionScope.order}">
		<tr>
			<td>
				<a href="viewExistOrder?orderId=${order.orderId}">${order.orderId}</a>
			</td>

			<td>
				<fmt:formatDate value="${order.orderDate}" />
			</td>
			<td>
				<fmt:formatNumber value="${order.totalPrice}" pattern="$#,##0.00" />
			</td>
		</tr>
	</c:forEach>--%>
	<s:iterator value="orderList">
		<tr>
			<td>
				<a href="viewExistOrder?orderId=<s:property value="orderId"/>"><s:property value="orderId"/> </a>
			</td>

			<td>
				<s:property value="orderDate"></s:property>
			</td>
			<td>
				<s:property value="totalPrice"></s:property>
			</td>
		</tr>
	</s:iterator>
</table>

</div>
<%@ include file="../common/IncludeBottom.jsp"%>


