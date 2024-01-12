const ctx = document.querySelector('canvas');
const c = ctx.getContext('2d');

ctx.width = window.innerWidth;
ctx.height = window.innerHeight;

const backgroundColor = "#b7c2c9";

c.fillStyle = backgroundColor;
c.fillRect(0,0, ctx.width, ctx.height);

const ball = document.getElementById("ball");
xBall = ctx.width / 2;
yBall = ctx.height / 2;
xBallSpeed = 5;
yBallSpeed = 5;

//TODO:
//Bounds on where each paddle can go (will use the parameter constraints) >> not implemented yet

class Paddle{
    constructor({position, velocity, color, constraints})
    {
        this.position = position;
        this.constraints = constraints;
        this.velocity = velocity;
        this.height = 100;
        this.width = 5;
        this.color = color;
        this.isHit = false;
    }
    draw()
    {
        c.fillStyle = this.color;
        c.fillRect(this.position.x, this.position.y, this.width, this.height)
        
    }
    update()
    {
        this.draw();

        this.position.y = this.position.y + this.velocity.y;
        this.position.x += this.velocity.x;
    } 
}

class Goal{
    constructor({position, color})
    {
        this.position = position;
        this.height = 150;
        this.width = 30;
        this.color = color;
        this.isHit = false;
    }
    draw()
    {
        c.fillStyle = this.color;
        c.fillRect(this.position.x, this.position.y, this.width, this.height)
        
    }
    update()
    {
        this.draw();
    } 
}

//creates red and blue paddles w/ parameters
//red player = player 1
const player1 = new Paddle({
    position: {
        x:100,
        y:ctx.height * 0.5
    }, 
    velocity: {
        x:0,
        y:0
    },
    color: "#d64b62",
    constraints: {
        x1:0,
        y1:0,
        x2: ctx.width / 2,
        y2: ctx.height 
    }
});
//blue player = player 2
const player2 = new Paddle({
    position: {
        x:ctx.width - 10 - 100,
        y:ctx.height * 0.5
    }, 
    velocity: {
        x:0,
        y:0
    },
    color: "#4ba1d6",
    constraints: {
        x1:ctx.width / 2,
        y1: 0,
        x2: ctx.width,
        y2: ctx.height 
    }
});

// //creates red and blue goals w/ parameters
// const redGoal = new Goal({
//     position: {
//         x:0,
//         y:ctx.height * 0.5 - 25
//     }, 
//     color: "#9c3647"
// });
// const blueGoal = new Goal({
//     position: {
//         x:ctx.width - 15,
//         y:ctx.height * 0.5 - 25
//     }, 
//     color: "#2371a1"
// });

//moves paddles
window.addEventListener('keydown', (e) => {
    switch(event.key)
    {
        // case 'ArrowRight':
        //     player2.velocity.x = 10;
        //     break;
        // case 'ArrowLeft':
        //     player2.velocity.x = -10;
        //     break;
        case 'ArrowUp':
            player2.velocity.y = -15;
            break;
        case 'ArrowDown':
            player2.velocity.y = 15;
            break;
      
        // case 'd':
        //     player1.velocity.x = 10;
        //     break;
        // case 'a':
        //     player1.velocity.x = -10;
        //     break;
        case 'w':
            player1.velocity.y = -15;
            break;
        case 's':
            player1.velocity.y = 15;
            break;
        
            //cheat codes
        case 't':
            alert("Red Scored!");
            setConstants();
        case 'b':
            alert("Blue Scored!");
            setConstants();
    }
});
window.addEventListener('keyup', (e) => {
    switch(event.key)
    {
        case 'ArrowRight':
            player2.velocity.x = 0;
            break;
        case 'ArrowLeft':
            player2.velocity.x = 0;
            break;
        case 'ArrowUp':
            player2.velocity.y = 0;
            break;
        case 'ArrowDown':
            player2.velocity.y = 0;
            break;
       
        case 'd':
            player1.velocity.x = 0;
            break;
        case 'a':
            player1.velocity.x = 0;
            break;
        case 'w':
            player1.velocity.y = 0;
            break;
        case 's':
            player1.velocity.y = 0;
            break;
            
    }
});



function setConstants()
{
    xBall = ctx.width / 2;
    yBall = ctx.height /2;
    player1.position.x = 100;
    player1.position.y = ctx.height * 0.5;
    player1.velocity.x = 0;
    player1.velocity.y = 0;

    player2.position.x = ctx.width - 10 - 100;
    player2.position.y = ctx.height * 0.5;
    player2.velocity.x = 0;
    player2.velocity.y = 0;
}

function animate() {
    requestAnimationFrame(animate);
    c.fillStyle = backgroundColor;
    c.fillRect(0,0, ctx.width, ctx.height);

    player1.update();
    player2.update();

    c.fillStyle = "#9c3647";
    c.fillRect(0,0,25,window.innerWidth);
    c.fillStyle = "#2371a1";
    c.fillRect(window.innerWidth - 25, 0, 25, window.innerWidth);

    // redGoal.update();
    // blueGoal.update();

    //moves ball
    xBall += xBallSpeed;
    yBall += yBallSpeed;
    if (xBall + 50 > window.innerWidth || xBall < 0) {
        xBallSpeed = -xBallSpeed;
    }
    if (yBall + 50 > window.innerHeight || yBall < 0) {
        yBallSpeed = -yBallSpeed;
    }
    
    //checks if it is bouncing on red/player 1 paddle
    //error-works half of the time
    if ((player1.position.x + player1.width + 10 > xBall) && (xBall > player1.position.x - 10) &&
    (player1.position.y + player1.height + 10 > yBall) && (yBall > player1.position.y - 10))
    {
        xBallSpeed = -xBallSpeed;
        console.log("hit red");

    }
    //checks if it is bouncing on blue/player 2 paddle
    //error
    if ((player2.position.x + player2.width + 10 > xBall) && (xBall > player2.position.x - 10) &&
    (player2.position.y + player2.height + 10 > yBall) && (yBall > player2.position.y - 10))
    {
        xBallSpeed = -xBallSpeed;
        console.log("hit blue");
    }

    //check if red goal
    //works
    // if((redGoal.width > xBall) && (xBall > 0) && (ctx.height * 0.5 - 25 + redGoal.height > yBall) && (yBall > ctx.height * 0.5 - 25))
    //added a 10px buffer
    if(25 > xBall && xBall > 0 && yBall > 0 && ctx.height > yBall)
    {
        alert("Blue Scored!");
        setConstants();
    } 
    //check if blue goal
    //error
    // if((ctx.width - 15 < xBall) && (xBall < ctx.width - 15 + blueGoal.width) && (blueGoal.height + ctx.height * 0.5 - 25 > yBall) && (yBall > ctx.height * 0.5 - 25))
    //added a 10px buffer
    if(ctx.width > xBall && xBall > ctx.width - 25 - 25 && yBall > 0 && ctx.height > yBall)
    {
        alert("Red Scored!");
        setConstants();
    } 
    ball.style.left = xBall + "px";
    ball.style.top = yBall + "px";

    //draws dashed lines
    c.strokeStyle = "black"
    c.setLineDash([5, 3]); /*dashes are 5px and spaces are 3px*/
    c.beginPath();
    c.moveTo(ctx.width/2, 0);
    c.lineTo(ctx.width/2, ctx.height);
    c.stroke();


}
animate();
