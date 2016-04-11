<%--
  Created by IntelliJ IDEA.
  User: liangx
  Date: 2016-04-04
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>

    <h2>My Orders</h2>

    <table>
        <tr>
            <th>Order ID</th>
            <th>Date</th>
            <th>Total Price</th>
        </tr>
        <!-- 循环 -->
        <tr>
            <td><a href="ViewOrder.html">1000</a></td>
            <td>2014/03/23 12:00:00</td>
            <td>$18.50</td>
        </tr>
        <c:forEach var="order" items="${sessionScope.order}">
            <tr>
                <td>
                    ${order}
                </td>
                <td>
                        ${cartItem.item.product.productId}
                </td>
                <td>
                        ${cartItem.item.attribute1} ${cartItem.item.attribute2}
                        ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                        ${cartItem.item.attribute5} ${cartItem.item.product.name}
                </td>
                <td>
                        ${cartItem.inStock}
                </td>
                <td>
                    <input type="text" name="${cartItem.item.itemId}" value="${cartItem.quantity}" />
                </td>
                <td>
                    <fmt:formatNumber value="${cartItem.item.listPrice}" pattern="$#,##0.00" />
                </td>
                <td>
                    <fmt:formatNumber value="${cartItem.total}" pattern="$#,##0.00" />
                </td>
                <td>
                    <a href="removeItemFromCart?workingItemId=${cartItem.item.itemId}" class="Button">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>
<%@ include file="../common/IncludeBottom.jsp"%>



