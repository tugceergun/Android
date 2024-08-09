package eu.tutorials.bankaccountprogram

    fun main(){

        //object
        val tugcesAccount = BankAccount("Tugce",1338.2)

        tugcesAccount.deposit(200.0)
        tugcesAccount.withtdraw(1200.0)
        tugcesAccount.deposit(3000.0)
        tugcesAccount.deposit(2000.0)
        tugcesAccount.withtdraw(3333.15)

        tugcesAccount.displayTransactionHistory()

        tugcesAccount.acctBalance()

        //object
        val sarahAccount = BankAccount("Sarah", 0.00)
        sarahAccount.deposit(100.0)
        sarahAccount.withtdraw(10.0)
        sarahAccount.deposit(300.0)

        sarahAccount.displayTransactionHistory()
        sarahAccount.acctBalance()

    }