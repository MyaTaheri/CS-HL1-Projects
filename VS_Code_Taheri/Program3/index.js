const ctx = document.querySelector('canvas');
const c = ctx.getContext('2d');

// ctx.width = window.innerWidth;
ctx.width = 1024;
ctx.height = 576;
const pi = Math.PI;

c.beginPath();
// c.fillStyle = "#191970";

//random background color:
// const randomColor = Math.floor(Math.random()*16777215).toString(16);
// document.body.style.backgroundColor = "#" + randomColor;
// color.innerHTML = "#" + randomColor;

for (let x = 0; x < 10; x++)
{
    // c.strokeStyle = generateRandomColor();
    // var one = Math.random() *256;
    // var two = Math.random() *256;
    // var three = Math.random() *256;
    // c.strokeStyle = rgb(one + two + three);
    c.lineWidth = 5;
    c.beginPath();
    // c.moveTo(140, ctx.width * (x/11));
    c.moveTo(5+x*14, 5);
    c.lineTo (5+x*14, 140);
    c.stroke();

}

//bad attempt of trying to resize lines to screen:

// c.beginPath();
// c.fillStyle = "#4169E1";
// for (let x = 0; x < 10; x++)
// {
//     c.lineWidth = 5;
//     c.beginPath();
//     var k = ctx.width * (x/11);
//     c.moveTo(k, 5);
//     c.lineTo (k, 140);
//     c.stroke();
// }



//c.fillRect(100,100,2,100);
//super skiny rectangle that looks like line

function generateRandomColor(){
    let maxVal = 0xFFFFFF; // 16777215
    let randomNumber = Math.random() * maxVal; 
    randomNumber = Math.floor(randomNumber);
    randomNumber = randomNumber.toString(16);
    let randColor = randomNumber.padStart(6, 0);   
    return `#${randColor.toUpperCase()}`
    //https://www.educative.io/answers/how-to-generate-a-random-color-in-javascript
}

function samGenerateColor(){
    
}