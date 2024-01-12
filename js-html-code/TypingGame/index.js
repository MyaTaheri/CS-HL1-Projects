const outputDiv = document.getElementById("output")

const canvas = document.querySelector('canvas');
const ctx = canvas.getContext('2d');
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;
score = 0;
let wordsArray =  [
  "apple",
  "banana",
  "cherry",
  "orange",
  "grape",
  "strawberry",
  "blueberry",
  "watermelon",
  "kiwi",
  "pineapple",
  "mango",
  "peach",
  "pear",
  "plum",
  "lemon",
  "lime",
  "blackberry",
  "raspberry",
  "cranberry",
  "pomegranate",
  "coconut",
  "avocado",
  "papaya",
  "melon",
  "fig",
  "date",
  "nectarine",
  "passionfruit",
  "guava",
  "kiwifruit",
  "dragonfruit",
  "persimmon",
  "gooseberry",
  "apricot",
  "tangerine",
  "cantaloupe",
  "honeydew",
  "grapefruit",
  "kumquat",
  "rhubarb",
  "peanut",
  "almond",
  "cashew",
  "walnut",
  "pecan",
  "pistachio",
  "hazelnut",
  "macadamia",
  "chestnut",
  "acorn",
  "bread",
  "butter",
  "cheese",
  "salad",
  "pasta",
  "pizza",
  "burger",
  "sandwich",
  "taco",
  "sushi",
  "steak",
  "chicken",
  "fish",
  "shrimp",
  "lobster",
  "crab",
  "soup",
  "stew",
  "curry",
  "rice",
  "noodle",
  "potato",
  "carrot",
  "broccoli",
  "spinach",
  "asparagus",
  "zucchini",
  "tomato",
  "cucumber",
  "onion",
  "garlic",
  "ginger",
  "chocolate",
  "vanilla",
  "caramel",
  "mint",
  "coffee",
  "tea",
  "juice",
  "soda",
  "water",
  "milk",
  "wine",
  "beer",
  "whiskey",
  "vodka",
  "rum",
  "gin",
  "tequila",
];

let zombies = []
var speed = 2;

console.log(speed);
const image = new Image();
image.src = 'pic01.jpg'; 
image.height = 150;
image.width = 500;

class Zombie{
  constructor(number,x,y,velocity,word)
  {
    this.number = number;
    this.x = x;
    this.y = y;
    this.velocity = velocity;
    this.word = word;
  }
  draw() {
    ctx.fillStyle = 'rgb(6, 6, 6)'
    ctx.font = "20px serif"
    ctx.fillText(this.word, this.x, this.y - 20,100);
    ctx.drawImage(image, this.x, this.y, 50, 150);
    ctx.fill();
    if (this.x < 100 && this.x > 0)
    {
      console.log(this.x);
      this.x = -100;
      this.y = -100;
      this.velocity = 0;
      window.location.href= "lose.html";
    }
  }
  check()
  {
    if (this.word === outputDiv.textContent)
    {
      wordsArray.shift();
      console.log("taget hit!");
      this.x = -100
      this.y = -100 
      this.velocity = 0
      outputDiv.textContent = "";  
      score += 1;  
      console.log(score);
      document.getElementById("score").innerHTML = score;
      new Audio('goose.mp3').play()

      if (score % 5 === 0)
      {
        speed += 0.5
        document.getElementById("speed").innerHTML = speed;

      }
    }
    
    if (outputDiv.textContent === "antisnydercode")
    {
      window.location.href= "win.html";
    }
  }
  update()
  {
    this.draw();
    this.x -= speed
    
  }
}
function init()
{
  for(let k = 0; k < wordsArray.length; k++)
  {
    zombies.push(new Zombie(k, 800 + 200 * k, 35 + Math.floor(Math.random() * 350), speed, wordsArray[k]))
  }
}
function animate()
{
  window.requestAnimationFrame(animate);
  ctx.fillStyle = 'rgb(129, 194, 194)';
  ctx.fillRect(0,0,canvas.width, canvas.height)
  zombies.forEach((zombie,i)=>{
      zombie.update();
  });
}
init();
animate();

function type()
{
    document.addEventListener("DOMContentLoaded", function(){
    //get the output container
    //listen for the key pressed
    document.addEventListener("keyup", function(event){
        //check if key is pressed
        if (event.key ==="Enter")
        {
            shoot();
        }
        else if(event.key.length === 1)
        {
            outputDiv.textContent += event.key;
        }
        else if (event.key === "Backspace")
        {
            var substring = outputDiv.textContent.substring(0, outputDiv.textContent.length - 1);
            outputDiv.textContent = substring;
        }
    })
})
}
type();

function shoot()
{
    console.log("shoot");
    zombies.forEach((zombie,i)=>{
      zombie.check();
    });
    if (wordsArray.length === 0)
    {
      window.location.href= "win.html";
    }
}



// image.onload = function() {
//   const zombie = {
//     position: {
//       x: canvas.width + 30,
//       y: 10,
//     },
//     velocity: {
//       x: -2,
//       y: 0,
//     },
//     color: 'green',
//     width: 150,
//     height: 500,
//     image: image,
//     draw: function() {
//       ctx.fillStyle = this.color;
//       ctx.fillRect(this.position.x, this.position.y, this.width, this.height);

//       if (this.image) {
//         ctx.drawImage(this.image, this.position.x, this.position.y, this.width, this.height);
//       }
//     },
//     update: function() {
//       this.draw();
//       this.position.y += this.velocity.y;
//       this.position.x += this.velocity.x;
//       if (this.position.x + this.width < 100) {
//         this.position.x = canvas.width;
//       }
//     }
//   };

//   function animate() {
//     ctx.clearRect(0, 0, canvas.width, canvas.height);
//     zombie.update();
//     requestAnimationFrame(animate);
//   }

//   animate();
// };

