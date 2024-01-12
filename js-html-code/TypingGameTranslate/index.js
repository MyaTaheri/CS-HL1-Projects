const outputDiv = document.getElementById("output")

const canvas = document.querySelector('canvas');
const ctx = canvas.getContext('2d');
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;
let wordsArray =  [
  "apple",
  "cherry",
  "orange",
  "grape",
  "strawberry",
  "kiwi",
  "mango",
  "peach",
  "pear",
  "plum",
  "lime",
  "blackberry",
  "raspberry",
  "pomegranate",
  "coconut",
  "avocado",
  "papaya",
  "melon",
  "fig",
  "nectarine",
  "guava",
  "kiwifruit",
  "dragonfruit",
  "persimmon",
  "gooseberry",
  "apricot",
  "tangerine",
  "cantaloupe",
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
  "acorn",
  "bread",
  "butter",
  "cheese",
  "salad",
  "pasta",
  "pizza",
  "burger",
  "taco",
  "sushi",
  "steak",
  "chicken",
  "fish",
  "lobster",
  "crab",
  "soup",
  "stew",
  "curry",
  "rice",
  "noodle",
  "potato",
  "carrot",
  "spinach",
  "tomato",
  "cucumber",
  "onion",
  "garlic",
  "ginger",
  "chocolate",
  "vanilla",
  "caramel",
  "mint",
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

let spanishWordsArray = [
  "manzana", // apple
  "cereza", // cherry
  "naranja", // orange
  "uva", // grape
  "fresa", // strawberry
  "kiwi", // kiwi
  "mango", // mango
  "pera", // pear
  "ciruela", // plum
  "lima", // lime
  "mora", // blackberry
  "frambuesa", // raspberry
  "granada", // pomegranate
  "coco", // coconut
  "aguacate", // avocado
  "papaya", // papaya
  "melón", // melon
  "higo", // fig
  "nectarina", // nectarine
  "guayaba", // guava
  "kiwi", // kiwifruit
  "pitahaya", // dragonfruit
  "caqui", // persimmon
  "grosella", // gooseberry
  "albaricoque", // apricot
  "mandarina", // tangerine
  "cantalupo", // cantaloupe
  "pomelo", // grapefruit
  "kumquat", // kumquat
  "ruibarbo", // rhubarb
  "cacahuate", // peanut
  "almendra", // almond
  "anacardo", // cashew
  "nuez", // walnut
  "pacana", // pecan
  "pistacho", // pistachio
  "avellana", // hazelnut
  "macadamia", // macadamia
  "bellota", // acorn
  "pan", // bread
  "mantequilla", // butter
  "queso", // cheese
  "ensalada", // salad
  "pasta", // pasta
  "pizza", // pizza
  "hamburguesa", // burger
  "taco", // taco
  "sushi", // sushi
  "filete", // steak
  "pollo", // chicken
  "pescado", // fish
  "langosta", // lobster
  "cangrejo", // crab
  "sopa", // soup
  "guiso", // stew
  "curry", // curry
  "arroz", // rice
  "fideos", // noodle
  "papa", // potato
  "zanahoria", // carrot
  "espinaca", // spinach
  "tomate", // tomato
  "pepino", // cucumber
  "cebolla", // onion
  "ajo", // garlic
  "jengibre", // ginger
  "chocolate", // chocolate
  "vainilla", // vanilla
  "caramelo", // caramel
  "menta", // mint
  "jugo", // juice
  "soda", // soda
  "agua", // water
  "leche", // milk
  "vino", // wine
  "cerveza", // beer
  "whisky", // whiskey
  "vodka", // vodka
  "ron", // rum
  "ginebra", // gin
  "tequila", // tequila
];

let zombies = []
var speed = 2;

console.log(speed);
const image = new Image();
image.src = 'pic01.jpg'; 
image.height = 150;
image.width = 500;

function setSpeed(newSpeed)
{
  speed = newSpeed;
}

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
    if (spanishWordsArray[this.number] === outputDiv.textContent)
    {
      wordsArray.shift();
      spanishWordsArray.shift();
      console.log(wordsArray[0]);
      this.x = -100
      this.y = -100 
      this.velocity = 0
      outputDiv.textContent = "";      
    }
    if (outputDiv.textContent === "antisnydercode")
    {
      window.location.href= "win.html";
    }
  }
  update()
  {
    this.draw();
    this.x -= this.velocity
    
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

