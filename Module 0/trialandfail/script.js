/**
 * Created by Joris on 16-2-2017.
 */
window.onload = function () {
    var current,
        screen,
        output,
        limit,
        zero,
        period,
        operator;

    screen = document.getElementById("Result");

    var elem = document.getElementsByClassName("numberButton");
    var len = elem.length;

    for (var i = 0; i < len; i++) {
        elem[i].addEventListener("click", function () {
            var number = this.value;
            output = screen.innerHTML += number;
            limit = output.length;
            if (limit > 16) {
                alert("Sorry no more input is allowed");
            }
        }, false);
    }

    document.getElementById("0").addEventListener("click", function () {
        zero = this.value;
        if (screen.innerHTML === "") {
            output = screen.innerHTML = zero;
        }
        else if (screen.innerHTML === output) {
            output = screen.innerHTML += zero;
        }
    }, false);

    document.getElementById("decimal").addEventListener("click", function () {
        period = this.value;
        if (screen.innerHTML === "") {
            output = screen.innerHTML = screen.innerHTML.concat("0.");
        }
        else if (screen.innerHTML === output) {
            screen.innerHTML = screen.innerHTML.concat(".");
        }
    }, false);

    document.getElementById("calculate").addEventListener("click", function(){
        if (screen.innerHTML === output) {
            screen.innerHTML = eval(output);
        }
        else {
            screen.innerHTML = "";
        }
    }, false);

    document.getElementById("clear").addEventListener("click", function(){
        screen.innerHTML = "";
    }, false);

    var elem1 = document.querySelectorAll(".operator");
    var len1 = elem1.length;

    for (var i = 0; i < len1; i++) {
        elem1[i].addEventListener("click", function () {
            operator = this.value;
            if (screen.innerHTML === "") {
                screen.innerHTML = screen.innerHTML.concat("");
            }
            else if (output) {
                screen.innerHTML = output.concat(operator);
            }
        }, false);

    }
};