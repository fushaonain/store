<%--
  Created by IntelliJ IDEA.
  User: liangx
  Date: 2016-03-23
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../common/IncludeTop.jsp"%>
<script>
    function reloadImage() {
        //document.getElementById("btn").disabled=true;
        document.getElementById("imgservlet").src = 'validation';
    }
</script>


<div id="Catalog">
    <form action="login" method="post">
        <p>Please enter your username and password.</p>
        </p>
        <p style="color: red">${requestScope.error}</p>
        <p>
            Username:<input type="text" name="username" /><br/>
            Password:<input type="password" name="password" /><br/>
            <!--  Validation Code:<input type="text" name="validationCode"/>
    <img src="validation" id="imgservlet" onclick="reloadImage()"/>
    -->
            <!--  <input type="button" value="changeImage" onclick="reloadImage()" id="btn">-->
        </p>
        <input type="submit" name="signon" value="Login" />
    </form>

    Need a user name and password? <a href="toRegisterServlet">Register
    Now!</a>

</div>
<%@include file="../common/IncludeBottom.jsp"%>



