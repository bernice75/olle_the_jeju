function good(){
    var s = document.getElementById('smile').getAttribute('value');
    if(s==0){
        document.getElementById('smile').setAttribute('class','fa fa-smile-o fa-2x');
        document.getElementById('smile').setAttribute('value','1');
    }else{
        document.getElementById('smile').setAttribute('class','fa fa-meh-o fa-2x');
        document.getElementById('smile').setAttribute('value','0');
    }
}