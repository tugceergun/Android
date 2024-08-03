package eu.tutorials.rockpaperscissors

fun main() {

    var computerChoice = ""
    var playerChoice = ""

    println("Rock, Paper or Scissors?")

    //while ile dogru input kontrolu. Dogru girilene kadar tekrar tekrar sorar.
    while(true){
        playerChoice = readln()
        if(playerChoice == "Rock" || playerChoice == "Paper" || playerChoice=="Scissors"){
            break
        }else {
            println("Choice one of them.")
        }
    }


    val randomNumber = (1..3).random()
    when (randomNumber) {
        1 -> {
            computerChoice= "Rock"
        }
        2 -> {
            computerChoice= "Paper"
        }
        else -> {
            computerChoice= "Scissors"
        }
    }

    println(computerChoice)

        val winner = when {
            playerChoice == computerChoice -> "Tie"
            playerChoice == "Rock" && computerChoice == "Scissors" -> "Player"
            playerChoice == "Paper" && computerChoice == "Rock" -> "Player"
            playerChoice == "Scissors" && computerChoice == "Paper" -> "Player"

            else -> "Computer"

        }

    if(winner == "Tie"){
        println("It is a tie")
    }else{
        println("$winner won!")
    }
}