package eu.tutorials.bankaccountprogram

class BankAccount(
    var accountHolder: String,
    var balance: Double)
{

    private val transactionHistory = mutableListOf<String>()

    //para yatirma
    fun deposit(amount: Double){
        balance += amount
        transactionHistory.add("$accountHolder deposited $$amount")
    }

    //para cekme
    fun withtdraw(amount: Double){
        if(amount <= balance){
            balance -= amount
            transactionHistory.add("$accountHolder withdrew $$amount")
        }else{
            println("You don't have the funds to withdraw $$amount ")
        }
    }

    //islem goruntuleme
    fun displayTransactionHistory(){
        println("Transaction history for $accountHolder")
        for(transaction in transactionHistory){
            println(transaction)
        }
    }

    fun acctBalance(){
        println("$accountHolder's " +
                "balance is $balance")
    }

}