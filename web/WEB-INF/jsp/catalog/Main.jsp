<%--
  Created by IntelliJ IDEA.
  User: liangx
  Date: 2016-03-23
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../common/IncludeTop.jsp"%>

    <div id="Welcome">
        <div id="WelcomeContent">
            Welcome to MyPetStore!
        </div>
    </div>

    <div id="Main">
        <div id="Sidebar">
            <div id="SidebarContent">
                <s:a href="viewCategory?categoryId=FISH"><img src="images/fish_icon.gif" /></s:a>
                <br/> Saltwater, Freshwater <br/>
                <s:a href="viewCategory?categoryId=DOGS"><img src="images/dogs_icon.gif" /></s:a>
                <br /> Various Breeds <br />
                <s:a href="viewCategory?categoryId=CATS"><img src="images/cats_icon.gif" /></s:a>
                <br /> Various Breeds, Exotic Varieties <br />
                <s:a href="viewCategory?categoryId=REPTILES"><img src="images/reptiles_icon.gif" /></s:a>
                <br /> Lizards, Turtles, Snakes <br />
                <s:a href="viewCategory?categoryId=BIRDS"><img src="images/birds_icon.gif" /></s:a>
                <br /> Exotic Varieties
            </div>
        </div>

        <div id="MainImage">
            <div id="MainImageContent">
                <map name="estoremap">
                    <area alt="Birds" coords="72,2,280,250" href="viewCategory?categoryId=BIRDS" shape="rect" />
                    <area alt="Fish" coords="2,180,72,250" href="viewCategory?categoryId=FISH" shape="rect" />
                    <area alt="Dogs" coords="60,250,130,320" href="viewCategory?categoryId=DOGS" shape="rect" />
                    <area alt="Reptiles" coords="140,270,210,340" href="viewCategory?categoryId=REPTILES" shape="rect" />
                    <area alt="Cats" coords="225,240,295,310" href="viewCategory?categoryId=CATS" shape="rect" />
                    <area alt="Birds" coords="280,180,350,250" href="viewCategory?categoryId=BIRDS" shape="rect" />
                </map>
                <img height="355" src="images/splash.gif" align="middle" usemap="#estoremap" width="350" />
            </div>
        </div>
        <div id="Separator">&nbsp;</div>
    </div>


<%@include file="../common/IncludeBottom.jsp"%>