<%--
  Created by IntelliJ IDEA.
  User: liangx
  Date: 2016-03-23
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

    <h2><s:property value="#category.name"></s:property></h2>

    <table>
        <tr>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <%--<c:forEach var="product" items="${sessionScope.productList}">
            <tr>
                <td>
                    <a href="viewProduct?productId=${product.productId}">${product.productId}</a>
                </td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>--%>
        <s:iterator value="productList">
            <tr>
                <td>
                    <a href="viewProduct?productId=<s:property value="productId"/>"><s:property value="productId"/> </a>
                </td>
                <td><s:property value="name"/> </td>
            </tr>
        </s:iterator>
    </table>

</div>


    <%@include file="../common/IncludeBottom.jsp"%>



