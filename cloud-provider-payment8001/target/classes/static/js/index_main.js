window.onload = function () {
    //var Lis = document.getElementsByTagName('li');
    var Lis = document.getElementsByClassName("topmenu_li");
    for (var i = 0; i < Lis.length; i++) {
        Lis[i].i = i;//由于Js中的闭包 for循环中的i是最后一个数 所以不能直接使用i
        Lis[i].onmouseover = function () {
            this.className = "lihover";
            // 为其添加lihover类的样式 后面的.submenu span等会自动继承

            var h0 = (this.i - 1) * 30 + 42;//当前的一级菜单的高度 30为每一行的高度 42为标题的高度
            var y = this.getElementsByTagName('div')[0].offsetHeight;//当前一级菜单下悬浮层的高度(没有下一级会报错)
            var h = this.getElementsByTagName('div')[0].style.top + y;
            if (h < h0) {
                this.getElementsByTagName('div')[0] = h0 + 'px';
                //防止当悬浮层内容太少的时候其远离一级菜单
            }
            if (y > 550) {
                this.getElementsByTagName('div')[0].style.top = "3px";
                //防止当悬浮层内容太多的时候一屏无法展示完整将其上移
            }
        }
        Lis[i].onmouseout = function () {
            this.className = "";
        }
    }
}

/*jq 闭包区*/
(function () {

    $("#input_search_btn").on("click",function () {
        alert(1);
        search($("#searchInput").val());
    })
    function search(str) {
        if(str!=undefined && str.trim()!=""){
            alert(str);
        }else{
            alert("null");
        }
    }

})
