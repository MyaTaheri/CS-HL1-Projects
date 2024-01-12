const ctx = document.querySelector('canvas');
const c = ctx.getContext('2d');

ctx.width = window.innerWidth;
ctx.height = window.innerHeight;
// const pi = Math.PI;

const backgroundColor = "#87b1d6";

c.fillStyle = backgroundColor;
c.fillRect(0,0, ctx.width, ctx.height);
const gravity = 2.5;

class Sprite{
    constructor({position, velocity, color})
    {
        this.position = position;
        this.velocity = velocity;
        this.height = 150;
        this.width = 50;
        this.color = color;
        this.isAttacking = false;
        this.attackBox = {
            position:{
                x: this.position.x,
                y: this.position.y
            },
            width: 100,
            height: 50
        }
    }
    draw()
    {
        // c.fillStyle = "#463b8a";
        // c.fillRect(this.position.x, this.position.y, 50, 150)
        if(this.isAttacking)
        {
            c.fillStyle = "green"
            c.fillRect(this.attackBox.position.x, this.attackBox.position.y, this.attackBox.width, this.attackBox.height)
        }
        c.fillStyle = this.color;
        c.fillRect(this.position.x, this.position.y, this.width, this.height)
        
    }
    attack()
    {
        this.isAttacking = true;
        setTimeout(()=>{this.isAttacking = false}, 100);
    }
    update()
    {
        this.draw();
        this.position.x += this.velocity.x;
        this.position.y = this.position.y + this.velocity.y + gravity;
        this.attackBox.position.y = this.position.y;
        this.attackBox.position.x = this.position.x;

        if (this.position.y + this.height > ctx.height)
        {
            this.veloicty = 0;
            this.position.y = ctx.height - this.height;
        }
       
    } 
}

const player1 = new Sprite({
    position: {
        x:0,
        y:0
    }, 
    velocity: {
        x:0,
        y:0
    },
    color: "#463b8a"

});
const player2 = new Sprite({
    position: {
        x:500,
        y:50
    }, 
    velocity: {
        x:0,
        y:0
    },
    color: "red"
});

function animate()
{
    window.requestAnimationFrame(animate);
    c.fillStyle = backgroundColor;
    c.fillRect(0,0, ctx.width, ctx.height);
    player1.update();
    player2.update();
    if(rectCollision({
        r1: player1, 
        r2: player2
    }))
        console.log("player 2 hit")
}

window.addEventListener('keydown', (e) => {
    switch(event.key)
    {
        case 'ArrowRight':
            player2.velocity.x = 10;
            break;
        case 'ArrowLeft':
            player2.velocity.x = -10;
            break;
        case 'ArrowUp':
            player2.velocity.y = -15;
            break;
        case 'ArrowDown':
            player2.velocity.y = 15;
            break;
        case '/':
                player2.attack();
                break;

        case 'd':
            player1.velocity.x = 10;
            break;
        case 'a':
            player1.velocity.x = -10;
            break;
        case 'w':
            player1.velocity.y = -10;
            break;
        case 's':
            player1.velocity.y = 10;
            break;
        case ' ':
            player1.attack();
            break;
            
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

function rectCollision({r1, r2})
{
    return (r1.attackBox.position.x + r1.attackBox.width >= r2.position.x
        && r1.attackBox.position.x <= r2.attackBox.position.x + r2.attackBox.width 
        // && r1.isAttacking 
        );
}
animate(); 
