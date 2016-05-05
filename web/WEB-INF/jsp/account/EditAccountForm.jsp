<%--
  Created by IntelliJ IDEA.
  User: liangx
  Date: 2016-03-24
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>


    <div id="Catalog">


        <form action="updateAccount" method="post">

            <h3>User Information</h3>

            <table>
                <tbody>
                <tr>
                    <td>User ID:</td>
                    <td>
                        <input type="text" name="username" readonly= "true" value="<s:property value="username"/>" id="username" onblur="usernameIsExist();"/>
                        <div id="usernameInfo"></div>
                    </td>
                </tr>
                <tr>
                    <td>New password:</td>
                    <td><input id="stripes--517137302" name="password"
                               type="text"><script type="text/javascript">
                        setTimeout(
                                function() {
                                    try {
                                        var z = document
                                                .getElementById('stripes--517137302');
                                        z.focus();
                                        z.select();
                                    } catch (e) {
                                    }
                                }, 1);
                    </script></td>
                </tr>
                <tr>
                    <td>Repeat password:</td>
                    <td><input name="repeatedPassword" type="text"></td>
                </tr>
                </tbody>
            </table>

            <%@ include file="IncludeAccountFields.jsp"%>

            <input name="editAccount" value="Save Account Information"
                   type="submit">

        </form>
        <a href="listOrder">My Orders</a>

    </div>
<%@ include file="../common/IncludeBottom.jsp"%>

