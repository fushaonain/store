<%--
  Created by IntelliJ IDEA.
  User: liangx
  Date: 2016-03-23
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css"
          media="screen" />

    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>JPetStore Demo</title>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />


    <link href="js/jquery-ui.css">
    <!--调用jquery-->
    <script type="text/javascript" src="js/jquery-2.2.3.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript">
        $(function(){
        $("#language").autocomplete({
            source: ["Chinese", "English", "Spanish", "Russian", "French", "Japanese", "Korean", "German"]
        });
        });
    </script>


</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="images/logo-topbar.gif" /></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="viewCart"><img align="middle" name="img_cart" src="images/cart.gif" />
            </a>
            <img align="middle" src="images/separator.gif" />

            <c:if test="${sessionScope.accountBean == null}">
                <a href="loginForm">Sign In</a>
            </c:if>
            <c:if test="${sessionScope.accountBean != null}">
                <c:if test="${sessionScope.authenticated == false}">
                    <a href="loginForm">Sign In</a>
                </c:if>
            </c:if>
            <c:if test="${sessionScope.accountBean != null}">
                <c:if test="${sessionScope.authenticated == true}">
                    <a href="signOut">Sign Out</a>
                    <img align="middle" src="images/separator.gif" />
                    <a href="ToMyAccount">My Account</a>
                </c:if>
            </c:if>
        </div>
    </div>


    <div id="search">
        <div id="SearchContent">
            <s:form action="search" method="post">
                <tr>
                    <td><s:textfield name="keyword" theme="simple"/></td>
                        <%--<input type="button" id="submit" value="Search"/>--%>
                    <td> <s:submit theme="simple" value="Search"></s:submit></td>
                </tr>
            </s:form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="viewCategory?categoryId=FISH"><img
                src="images/sm_fish.gif" /></a> <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=DOGS"><img
                src="images/sm_dogs.gif" /></a> <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=REPTILES"><img
                src="images/sm_reptiles.gif" /></a> <img
            src="images/separator.gif" /> <a href="viewCategory?categoryId=CATS"><img
            src="images/sm_cats.gif" /></a> <img src="images/separator.gif" />
        <a href="viewCategory?categoryId=BIRDS"><img
                src="images/sm_birds.gif" /></a>
    </div>

</div>

<div id="Content">