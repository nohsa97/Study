var test = document.getElementById('asd');
var tests = document.getElementById('test');
var tess = "sda"

tests.onclick = function () {
    // var str = "";
    // str = test.value;
    //     alert(str.indexOf("x"));
    var name = $("#asd").val();
    // var str = "";
    // str = name;
    var str = name;
    str = tess;
    // var str = $("#asd").val();
    if(str.indexOf(" ") >= 0){
        str = name.split(' ').slice(0,-1).join(' ');
    }
    else {
        str = "no";
    }
    alert(str);
          
}
