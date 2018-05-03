/*
IntelliJ IDEA
*/

// Chapter 2. First steps in scala

// Step 1. Learn to use scala interpreter

1+2

res0 * 3

println("Hello, world!")

// Step 2. Define some variables

val msg = "Hello, world!"

val msg2: java.lang.String = "Hello again, world!"

val msg3: String = "Hello again, world!"

println(msg)

// msg = "Goodbye, cruel world!" // Error:(20, 13) reassignment to val

var greeting = "Hello, world!"
greeting = "Leave me alone, world!"

val multiLine =
  "This is the next line."

//val oops =


  // in scala shell there would be an error due to two bland lines

// Step 3. Define some functions

def max(x: Int, y: Int): Int = {
  if ( x > y ) x
  else y
}

def max2(x: Int, y: Int): Int = if ( x > y ) x else y

max(3,5)

def greet () = println ("Hello, world!")

greet()

// :quit

// Step 4. Write some scala scripts

println ("Hello, world, from a script!")

var args = "planet".split(" ")
println ("Hello, "+ args(0))

// Step 5. Loop with while, decide with if
args = "Scala is fun".split(" ")
var i = 0
while ( i < args.length) {
  println(args(i))
  i += 1
}

//var
args = "Scala is even more fun".split(" ")
//var
i = 0
while ( i < args.length) {
  if ( i != 0)
    print(" ")
  print(args(i))
  i += 1
}
println()

// Step 6. Iterate with foreach and for

args.foreach(arg => println(arg))

args.foreach((arg: String) => println(arg))

args.foreach(println)

for ( arg <- args ) println(arg)



