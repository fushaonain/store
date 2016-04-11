<%--
  Created by IntelliJ IDEA.
  User: liangx
  Date: 2016-04-04
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>
    <ul class="messages">
        <li>Thank you, your order has been submitted.</li>
    </ul>
    <div id="BackLink">
        <a href="main">Return to Main Menu</a>
    </div>

    <div id="Catalog">

        <table>
            <tbody>
            <tr>
                <th align="center" colspan="2">Order #1000 2014/03/23 10:46:43</th>
            </tr>
            <tr>
                <th colspan="2">Payment Details</th>
            </tr>
            <tr>
                <td>Card Type:</td>
                <td>MasterCard</td>
            </tr>
            <tr>
                <td>Card Number:</td>
                <td>999 9999 9999 9999 * Fake number!</td>
            </tr>
            <tr>
                <td>Expiry Date (MM/YYYY):</td>
                <td>12/03</td>
            </tr>
            <tr>
                <th colspan="2">Billing Address</th>
            </tr>
            <tr>
                <td>First name:</td>
                <td>${sessionScope.account.firstName}</td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td>${sessionScope.account.lastName}</td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td>${sessionScope.account.address1}</td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td>${sessionScope.account.address2}</td>
            </tr>
            <tr>
                <td>City:</td>
                <td>${sessionScope.account.city}</td>
            </tr>
            <tr>
                <td>State:</td>
                <td>${sessionScope.account.state}</td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td>${sessionScope.account.zip}</td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>${sessionScope.account.country}</td>
            </tr>
            <tr>
                <th colspan="2">Shipping Address</th>
            </tr>
            <tr>
                <td>First name:</td>
                <td>${sessionScope.account.firstName}</td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td>${sessionScope.account.lastName}</td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td>${sessionScope.account.address1}</td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td>${sessionScope.account.address2}</td>
            </tr>
            <tr>
                <td>City:</td>
                <td>${sessionScope.account.city}</td>
            </tr>
            <tr>
                <td>State:</td>
                <td>${sessionScope.account.state}</td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td>${sessionScope.account.zip}</td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>${sessionScope.account.country}</td>
            </tr>
            <tr>
                <td>Courier:</td>
                <td>UPS</td>
            </tr>
            <tr>
                <td colspan="2">Status: P</td>
            </tr>
            <tr>
                <td colspan="2">
                    <table>
                        <tbody>
                        <tr>
                            <th>Item ID</th>
                            <th>Description</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total Cost</th>
                        </tr>

                        <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
                            <tr>
                                <td>
                                    <a href="viewItem?itemId=${cartItem.item.itemId}">${cartItem.item.itemId}</a>
                                </td>
                                <td>
                                        ${cartItem.item.attribute1} ${cartItem.item.attribute2}
                                        ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                                        ${cartItem.item.attribute5} ${cartItem.item.product.name}
                                </td>
                                <td>
                                    <fmt:formatNumber value="${cartItem.quantity}" />
                                </td>
                                <td>
                                    <fmt:formatNumber value="${cartItem.item.listPrice}" pattern="$#,##0.00" />
                                </td>
                                <td>
                                    <fmt:formatNumber value="${cartItem.total}" pattern="$#,##0.00" />
                                </td>
                            </tr>
                        </c:forEach>
                        <%--<tr>
                            <th colspan="5">Total: $18.50</th>
                        </tr>--%>
                        </tbody>
                    </table>
                </td>
            </tr>

            </tbody>
        </table>

    </div>
<%@ include file="../common/IncludeBottom.jsp"%>

