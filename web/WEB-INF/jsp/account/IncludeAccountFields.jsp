<%--
  Created by IntelliJ IDEA.
  User: liangx
  Date: 2016-03-24
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<h3>Account Information</h3>

<table>
    <tr>
        <td>First name:</td>
        <td><input type="text" name="firstName" value="${sessionScope.account.firstName}" /></td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td><input type="text" name="lastName" value="${sessionScope.account.lastName}"/></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><input type="text" name="email" value="${sessionScope.account.email}"/></td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td><input type="text" name="phone" value="${sessionScope.account.email}"/></td>
    </tr>
    <tr>
        <td>Address 1:</td>
        <td><input type="text" name="address1" value="${sessionScope.account.address1}"/></td>
    </tr>
    <tr>
        <td>Address 2:</td>
        <td><input type="text" name="address2" size="40" value="${sessionScope.account.address2}"/></td>
    </tr>
    <tr>
        <td>City:</td>
        <td><input type="text" name="city" value="${sessionScope.account.city}"/></td>
    </tr>
    <tr>
        <td>State:</td>
        <td><input type="text" name="state" size="4" value="${sessionScope.account.state}"/></td>
    </tr>
    <tr>
        <td>Zip:</td>
        <td><input type="text" name="zip" size="10" value="${sessionScope.account.zip}"/></td>
    </tr>
    <tr>
        <td>Country:</td>
        <td><input type="text" name="country" size="15" value="${sessionScope.account.country}"/></td>
    </tr>
</table>

<h3>Profile Information</h3>

<table>
    <tr>
        <td>Language Preference:</td>
        <td><select name="languagePreference">
            <!-- 循环 -->
            <option>${language }</option>
            <option value="ENGLISH">english</option>
            <option selected="selected" value="CHINESE">chinese</option>

        </select></td>
    </tr>
    <tr>
        <td>Favourite Category:</td>
        <td><select name="account.favouriteCategoryId">
            <option value="FISH">FISH</option>
            <option selected="selected" value="DOGS">DOGS</option>
            <option value="REPTILES">REPTILES</option>
            <option value="CATS">CATS</option>
            <option value="BIRDS">BIRDS</option>
        </select></td>
    </tr>
    <tr>
        <td>Enable MyList</td>
        <td><input type="checkbox" name="listOption" value="1" /></td>
    </tr>
    <tr>
        <td>Enable MyBanner</td>
        <td><input type="checkbox" name="bannerOption" value="1" /></td>
    </tr>

</table>

