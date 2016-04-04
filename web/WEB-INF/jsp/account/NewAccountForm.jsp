<%--
  Created by IntelliJ IDEA.
  User: liangx
  Date: 2016-03-24
  Time: 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>
<script type="text/javascript">
    var xmlHttpRequest;
    function createXMLHttpRequest()
    {
        if (window.XMLHttpRequest) //非IE浏览器
        {
            xmlHttpRequest = new XMLHttpRequest();
        }
        else if (window.ActiveObject)//IE6以上浏览器
        {
            xmlHttpRequest = new ActiveObject("Msxml2.XMLHTTP");
        }
        else //IE6及以下浏览器
        {
            xmlHttpRequest = new ActiveObject("Microsoft.XMLHTTP");
        }
    }

    function usernameIsExist()
    {
        var username = document.userInfo.username.value;
        sendRequest("usernameValidation?username="+username);
    }

    function sendRequest(url){
        createXMLHttpRequest();
        xmlHttpRequest.open("GET", url, true);
        xmlHttpRequest.onreadystatechange = processResponse;
        xmlHttpRequest.send(null);
    }

    function processResponse(){
        if(xmlHttpRequest.readyState == 4){
            if(xmlHttpRequest.status == 200){
                var responseInfo = xmlHttpRequest.responseXML.getElementsByTagName("info")[0].firstChild.data;
                var div1 = document.getElementById("usernameInfo");
                if(responseInfo == "Exist"){
                    div1.innerHTML="<font color='red'>The User ID is Exist</font>";
                }
                else{
                    div1.innerHTML="<font color='green'>The User ID is Available</font>";
                }
            }
        }
    }

</script>

<div id="Catalog">

    <form action="saveAccount" method="post" name="userInfo" id="userInfo">

        <h3>User Information</h3>

        <table>
            <tr>
                <td>User ID:</td>
                <td>
                    <input type="text" name="username" id="username" onblur="usernameIsExist();"/>
                    <div id="usernameInfo"></div>
                </td>
            </tr>
            <tr>
                <td>New password:</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td><input type="password" name="repeatedPassword"/></td>
            </tr>
        </table>

        <%@ include file="IncludeAccountFields.jsp"%>

        <input type="submit" name="newAccount" value="Save Account Information"/>

    </form>
</div>

</div>
<%@ include file="../common/IncludeBottom.jsp"%>


