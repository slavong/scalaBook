//##################################################################################################
// Chapter 3. Next Steps in Scala
//##################################################################################################

// Step 7. Parameterize arrays with types

val big = new java.math.BigInteger("123456789")

val greetStrings = new Array[String](3)
greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!\n"
for ( i <- 0 to 2 )
  print(greetStrings(i))

val greetStrings2 = new Array[String](3)
greetStrings2.update(0, "Hello")
greetStrings2.update(1, ", ")
greetStrings2.update(2, "world!\n")
for ( i <- 0 to 2 )
  print(greetStrings2.apply(i))

val numNames = Array("zero", "one", "two")
val numNames2 = Array.apply("zero", "one", "two")

// Step 8. Use lists

val oneTwoThree = List(1,2,3)

val oneTwo = List(1,2)
val threeFour = List(3,4)
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo +" and "+ threeFour + " were not mutated.")
println("Thus, "+ oneTwoThreeFour + " is a new list.")

val twoThree = List(2,3)
val oneTwoThree2 = 1 :: twoThree
println(oneTwoThree2)

val oneTwoThree3 = 1 :: 2 :: 3 :: Nil
println(oneTwoThree3)

List()
Nil
List("Cool", "tools","rule")
val thrill = "Will" :: "fill" :: "until" :: Nil
List("a","b") ::: List("c","d")
thrill(2) // until
thrill.count(s => s.length == 4) // 2
thrill.drop(2) // List(until)
thrill.dropRight(2) // List(Will)
thrill.exists(s => s == "until") // true
thrill.filter(s => s.length == 4) // List(Will,fill)
thrill.forall(s => s.endsWith("l")) // true
thrill.foreach(s => print(s)) // Willfilluntil
thrill.foreach(print) // Willfilluntil
thrill.head // Will
thrill.init // List(Will, fill)
thrill.isEmpty // false
thrill.last // until
thrill.length // 3
thrill.map( s => s + "y") // List(Willy,filly,untily)
thrill.mkString(", ") // Will, fill, until
thrill.filterNot(s => s.length == 4 ) // List(until)
thrill.reverse // List(until, fill, Will)
// thrill.sort( (s,t) => s.charAt(0).toLower < t.charAt(0).toLower ) // no sort method?
thrill.tail // List(fill, until)

// Step 9. Use tuples

val pair = (99, "Luftballons")
println(pair._1)
println(pair._2)

// Step 10. User sets and maps

var jetSet = Set("Boeing", "Airbus")
jetSet += "Lear"
jetSet
println(jetSet.contains("Cessna"))

import scala.collection.mutable
import scala.io.Source
val movieSet = mutable.Set("Hitch","Poltergeist")
movieSet += "Shrek"
println(movieSet)

import scala.collection.immutable.HashSet
val hashSet = HashSet("Tomatoes","Chilies")
println(hashSet + "Coriander")

val treasureMap = mutable.Map[Int, String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
treasureMap
println(treasureMap(2))

val romanNumeral = Map(
  1 -> "I",
  2 -> "II",
  3 -> "III",
  4 -> "IV",
  5 -> "V"
)
romanNumeral(4)

// Step 11. Learn to recognize the functional style

val args = "Scala is even more fun".split(" ")
def printArgs(args: Array[String]) : Unit = {
  var i = 0
  while (i < args.length) {
    println(args(i))
    i += 1
  }
}
printArgs(args)

def printArgs2(args: Array[String]) : Unit = {
  for (arg <- args) println(arg)
}
printArgs2(args)

def printArgs3(args: Array[String]) : Unit = {
  args.foreach(println)
}
printArgs3(args)

def formatArgs(args: Array[String]) = {
  args.mkString("\n")
}
formatArgs(args)
print(formatArgs(args))

val res = formatArgs(Array("zero","one","two"))

// import org.scalatest_ ??
// assert(res = "zero\none\ntwo")

// Step 12. Read lines from a file

//val args2 = Array("c:/apps/github/scalaBook/src/main/resource/test.txt")
val args2 = Array("c:/apps/github/scalaBook/src/main/scala/c03.sc")
if ( args2.length > 0 )
  for ( line <- Source.fromFile(args2(0)).getLines() ) {
    println(line.length + " " + line)
  }
else Console.err.println("Please enter filename")


def widthOfLength(s:String) = s.length.toString.length;
if ( args2.length > 0) {
  val lines = Source.fromFile(args2(0)).getLines().toList
  val longestLine = lines.reduceLeft(
    (a,b) => if ( a.length > b.length ) a else b
  )
  val maxWidth = widthOfLength(longestLine)
  for ( line <- lines ) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line )
  }
} else Console.err.println("Please enter filename")