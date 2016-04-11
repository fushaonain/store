<%--
  Created by IntelliJ IDEA.
  User: liangx
  Date: 2016-04-04
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>


    <div id="BackLink">
        <a href="main">Return to Main Menu</a>
    </div>

    <div id="Catalog">
        Please confirm the information below and then press continue...

        <table>
            <tbody>
            <tr>
                <th align="center" colspan="2"><font size="4"><b>Order</b></font>
                    <br> <font size="3"><b> 2014/03/23 10:46:43</b></font></th>
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
            </tbody>
        </table>


        <a class="Button"
           href="viewOrder">Confirm</a>
    </div>

<%@ include file="../common/IncludeBottom.jsp"%>





