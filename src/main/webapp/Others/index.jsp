<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <meta content="telephone=no,email=no" name="format-detection" />
    <title>定制回家卡 温暖回家路</title>
    <link rel="stylesheet" type="text/css" href="${StaticResourcesUrl}/midea-gohome/Others/css/reset.css?version=${version}" />
    <link rel="stylesheet" type="text/css" href="${StaticResourcesUrl}/midea-gohome/Others/css/swiper-3.4.0.min.css?version=${version}" />
    <link rel="stylesheet" type="text/css" href="${StaticResourcesUrl}/midea-gohome/Others/css/cityPicker.css?version=${version}">
    <link rel="stylesheet" type="text/css" href="${StaticResourcesUrl}/midea-gohome/Others/css/index.css?version=${version}" />

    <script type="text/javascript" >
        var html = document.documentElement;
        var windowWidth = html.clientWidth;
        if(windowWidth>640){
            windowWidth=640;
        };
        html.style.fontSize = windowWidth / 6.4+'px';
    </script>
</head>
<body>

<!--loading页-->
<div class="loading" id="loading-page">
    <div class="loading_image"></div>
    <div class="loading-tips" id="loading-info">
    </div>
</div>

<!-- 引导页 -->
<div class="swiper-container">
      <div class="swiper-wrapper">
        <div class="swiper-slide" id="intros_1">
            <div class="rules">活动规则</div>
            <div class="start-button"></div>
            <div class="slide-button" id="slide_one"></div>
        </div>
        <div class="swiper-slide" id="intros_2">
            <div class="slide-button"></div>
        </div>
        <div class="swiper-slide" id="intros_3">
            <div class="slide-button"></div>
        </div>
        <div class="swiper-slide" id="intros_4">
            <div class="slide-button"></div>
        </div>
    </div>
</div>
<div id="qrcode" class="hidden"></div>
<%--<!-- 取票机 -->--%>
<div class="ticket-machine hidden">
    <input id="city1" type="text" name="" class="departure-place" placeholder="他乡" readonly>
    <input id="city2" type="text" name="" class="destination-place" placeholder="家" readonly>
    <div class="temperature-left"></div>
    <div class="temperature-right"></div>
    <div class="Count-down-left"></div>
    <div class="Count-down-right"></div>
    <div class="generate-ticket"></div>
    <div class="ticket">
        <span class="start"></span>
        <span class="over"></span>
        <span class="start2"></span>
        <span class="over2"></span>
        <span class="back-button"></span>
    </div>
</div>

<%--<!-- 点击车票缩略图显示车票大图 -->--%>

<div class="ticket-larger hidden">
<img src="" id="composeImgUrl" style="width: 100%;height: auto">
    <%--<div class="top_1">--%>
        <%--<p class="text_one"><span class="special_one">2016</span>年</p>--%>

        <%--<p class="text_two"><span class="copy">你看不见你看不</span>我在<span class="special_one"></span>，家在<span class="special_two"></span></p>--%>

        <%--<p class="text_three">回家的路<span class="special_one"></span>公里，温差<span class="special_two"></span>度</p>--%>

        <%--<p class="text_four">无论<span class="special_one">路</span>有多远，<span class="special_two">过年</span>回家</p>--%>

        <%--<p class="text_five">才是<span class="special_one">美的</span>旅行</p>--%>
    <%--</div>--%>
    <%--<div class="top_2"></div>--%>
    <%--<div class="top_3">--%>
        <%--&lt;%&ndash;<span class="top_3_1">回家路上，怎能缺少好友陪伴。</span>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<span class="top_3_2">保存图片发送给好友，邀请TA一起买票回家吧！</span>&ndash;%&gt;--%>
            <%--<div class="top_4">--%>
                <%--<span class="erweima"></span>--%>
            <%--</div>--%>
    <%--</div>--%>
    <%--<span class="large_one"></span>--%>
    <%--<span class="large_two"></span>--%>
    <%--<span class="large_three"></span>--%>
    <%--<span class="large_four"></span>--%>
    <%--<span class="large_five"></span>--%>
    <%--<span class="large_six"></span>--%>
    <%--<span class="pingyin_1"></span>--%>
    <%--<span class="pingyin_2"></span>--%>
    <div class="collect-button"></div>
</div>

<!-- 邀请好友收集温暖 -->
<div class="invite_help hidden">
    <div class="red_progress"></div>
    <div class="quilt quTouch"></div>
    <div class="quilt2 hidden quTouch"></div>
    <div class="sweater_left quTouch1"></div>
    <div class="sweater_left2 hidden quTouch1"></div>
    <div class="sweater_right quTouch2"></div>
    <div class="sweater_right2 hidden quTouch2"></div>
    <div class="air_conditioner quTouch3"></div>
    <div class="air_conditioner2 hidden quTouch3"></div>
    <div class="scarf quTouch4"></div>
    <div class="scarf2 hidden quTouch4"></div>
    <div class="trousers quTouch5"></div>
    <div class="trousers2 hidden quTouch5"></div>
    <div class="open_gift" id="open_gift"></div>
</div>

<!-- 蒙版提示 -->
<%--填写号码弹窗--%>
<div class="cover coverBef">
    <%--<div class="cover_in"></div>--%>
    <div class="dialog dialog1" onclick="return">
        <span class="dia_text">活动内含神秘大礼，为保证我们能联系到您，请先输入手机号哦~</span>
        <input type="text" class="dia_input">
        <div class="ensure_btn">确定</div>
    </div>
        <div class="dialog dialog2">
            <div class="dia_text2">获得<span class="dia_text3"></span></div>
            <div class="get_gift"></div>
        </div>
    <div class="dialog dialog3">
        <%--<span class="dia_text2">啊哦~姿势不对</span>--%>
        <%--<span class="dia_text3">您没有抽到奖品呢~</span>--%>
    </div>
    <div class="dialog dialog4">
        <span class="dia_text1">请输入您的真实有效信息，工作人员将在活动结束后安排奖品寄送</span>
        <div class="info_1"><input type="text" class="name" placeholder="姓名"></div>
        <div class="info_2"><input type="text" class="tel_phone" placeholder="手机号码"></div>
        <div class="info_3"><input type="text" class="address" placeholder="地址"></div>
        <div class="submit">提交</div>
    </div>
    <div class="dialog dialog5">
        <span class="dia_text1">提交成功</span>
    </div>
    <div class="dialog dialog6">
        <div class="head_img"></div>
        <span class="dia_text1">我的奖品</span>
        <span class="award"></span>
        <span class="dia_text2"></span>
        <div class="info_4">姓名<span class="name"></span></div>
        <div class="info_5">手机号码<span class="tel_phone"></span></div>
        <div class="info_6">地址<span class="address"></span></div>
    </div>
    <div class="dialog dialog7">
        <div class="head_img"></div>
        <span class="dia_text1">我的奖品</span>
        <span class="award"></span>
        <span class="dia_text2"></span>
        <div class="get_gift"></div>
        <span class="tips">您还没有领取您的奖品哦，赶快领取吧</span>
    </div>
        <div class="dialog dialog9">
            <p class="rule_text1">活动规则</p>
            <p class="rule_text2">定制回家卡 温暖回家路</p>
            <p class="rule_text3">2017春运即将起航，你是否已经准备好返乡的车票，过年回家，就是最美的旅行。快来定制你的专属回家卡吧！</p>
            <p class="rule_text4">邀请好友帮忙点亮温暖物件，温度达到26°C，即有机会获得丰厚礼品哦！</p>
            <p class="rule_text5">特等奖  美的空调</p>
            <p class="rule_text6">一等奖  被子、小米移动电源</p>
            <p class="rule_text8">二等奖  保温水壶、抱枕毯</p>
            <p class="rule_text10">三等奖  美的熊</p>
            <div class="close">×</div>
        </div>
</div>

<!-- 邀请好友点亮 -->
<div class="Collect-warmth">

</div>

</body>
<script type="text/javascript" src="${StaticResourcesUrl}/midea-gohome/Others/js/jquery-1.11.3.min.js?version=${version}"></script>
<script type="text/javascript" src="${StaticResourcesUrl}/midea-gohome/Others/js/jquery.cookie.min.js?version=${version}"></script>
<script type="text/javascript" src="${StaticResourcesUrl}/midea-gohome/Others/js/cityPicker.js?version=${version}"></script>
<script type="text/javascript" src="${StaticResourcesUrl}/midea-gohome/Others/js/swiper-3.4.0.jquery.min.js?version=${version}"></script>
<script src="${StaticResourcesUrl}/midea-gohome/Others/js/hidpi-canvas.js?version=${version}" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${StaticResourcesUrl}/midea-gohome/Others/js/index.js?version=${version}"></script>
<script type="text/javascript" src="${StaticResourcesUrl}/midea-gohome/Others/js/img-base64.js?version=${version}"></script>
<script type="text/javascript" src="${StaticResourcesUrl}/midea-gohome/Others/js/qrcode.js?version=${version}"></script>
<script>
    var StaticResourcesUrl="${StaticResourcesUrl}";
    var urlDomain="${urlDomain}/Media/index.jsp";
    var weixinUrl="${urlDomain}/weixin/index";
</script>

<script type="text/javascript">
    window._pt_lt = new Date().getTime();
    window._pt_sp_2 = [];
    _pt_sp_2.push('setAccount,173b4b78');
    var _protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    (function() {
        var atag = document.createElement('script'); atag.type = 'text/javascript'; atag.async = true;
        atag.src = _protocol + 'js.ptengine.cn/173b4b78.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(atag, s);
    })();
</script>

</html>

