const canvas = document.querySelector('canvas');
const c = canvas.getContext('2d');
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

// define Flower constructor
function Flower(centerX, centerY, radius, numPetals, color){
    this.centerX = centerX;
    this.centerY = centerY;
    this.radius = radius;
    this.numPetals = numPetals;
    this.color = color;
}

// Define Flower draw method
Flower.prototype.draw = function(){
    c.beginPath();
    
    // draw petals
    for (var n = 0; n < this.numPetals; n++) {
        var theta1 = ((Math.PI * 2) / this.numPetals) * (n + 1);
        var theta2 = ((Math.PI * 2) / this.numPetals) * (n);
        
        var x1 = (this.radius * Math.sin(theta1)) + this.centerX;
        var y1 = (this.radius * Math.cos(theta1)) + this.centerY;
        var x2 = (this.radius * Math.sin(theta2)) + this.centerX;
        var y2 = (this.radius * Math.cos(theta2)) + this.centerY;
        
        c.moveTo(this.centerX, this.centerY);
        c.bezierCurveTo(x1, y1, x2, y2, this.centerX, this.centerY);
    }
    
    c.closePath();
    c.fillStyle = this.color;
    c.fill();
    
    // draw yellow center
    c.beginPath();
    c.arc(this.centerX, this.centerY, this.radius / 5, 0, 2 * Math.PI, false);
    c.fillStyle = "yellow";
    c.fill();
};

window.onload = function(){
    
    // define an array of colors
    var colorArray = [];
    colorArray.push("red"); // 0
    colorArray.push("orange"); // 1
    colorArray.push("blue"); // 2
    colorArray.push("purple"); // 3

    var centerX = 120;
    var centerY = 200;
    var radius = 50;
    var colorIndex = Math.round(Math.random() * (colorArray.length - 1));
        
    var thisFlower = new Flower(centerX, centerY, radius, 5, colorArray[colorIndex]);
    thisFlower.draw();

};