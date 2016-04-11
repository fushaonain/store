<%--
  Created by IntelliJ IDEA.
  User: liangx
  Date: 2016-04-04
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>


    <div id="Catalog">
        <form action="confimOrder">

            <table>
                <tbody><tr>
                    <th colspan="2">Payment Details</th>
                </tr>
                <tr>
                    <td>Card Type:</td>
                    <td><select name="order.cardType">
                        <option selected="selected" value="Visa">Visa</option><option value="MasterCard">MasterCard</option><option value="American Express">American Express</option>
                    </select></td>
                </tr>
                <tr>
                    <td>Card Number:</td>
                    <td><input name="order.creditCard" value="999 9999 9999 9999" type="text"> * Use a fake
                        number!</td>
                </tr>
                <tr>
                    <td>Expiry Date (MM/YYYY):</td>
                    <td><input name="order.expiryDate" value="12/03" type="text"></td>
                </tr>
                <tr>
                    <th colspan="2">Billing Address</th>
                </tr>

                <tr>
                    <td>First name:</td>
                    <td><input name="order.billToFirstName" value="${sessionScope.account.firstName}" type="text"></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td><input name="order.billToLastName" value="${sessionScope.account.lastName}" type="text"></td>
                </tr>
                <tr>
                    <td>Address 1:</td>
                    <td><input name="order.billAddress1" value="${sessionScope.account.address1}" type="text" size="40"></td>
                </tr>
                <tr>
                    <td>Address 2:</td>
                    <td><input name="order.billAddress2" value="${sessionScope.account.address2}" type="text" size="40"></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><input name="order.billCity" value="${sessionScope.account.city}" type="text"></td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td><input name="order.billState" value="${sessionScope.account.state}" type="text" size="4"></td>
                </tr>
                <tr>
                    <td>Zip:</td>
                    <td><input name="order.billZip" value="${sessionScope.account.zip}" type="text" size="10"></td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td><input name="order.billCountry" value="${sessionScope.account.country}" type="text" size="15"></td>
                </tr>

                <tr>
                    <td colspan="2"><input name="shippingAddressRequired" value="true" type="checkbox">
                        Ship to different address...</td>
                </tr>

                </tbody></table>

            <input name="newOrder" value="Continue" type="submit">
        </form>
    </div>

    <%@ include file="../common/IncludeBottom.jsp"%>
