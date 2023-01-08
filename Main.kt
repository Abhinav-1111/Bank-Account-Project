fun main(args: Array<String>) {
    println("Welcome to your banking system \n")
    println("Which type of account would to like to create? \n")
    println("1. Debit account \n")
    println("2. Credit account \n")
    println("3. Checking account \n")

    var accountType = " "
    var userChoice = 0

    while(accountType == " "){
        println("Choose an Option(1, 2 or 3)")
        (1..5).random()
        var userChoice = (1..5).random()
        println("The Selected option is.. $userChoice")

        when(userChoice){
            1 -> accountType = "Debit"
            2 -> accountType = "Credit"
            3 -> accountType = "Checking"
            else -> continue
        }
    }
    println("You have created a $accountType account.")
    println()

    var accountBalance = (0..1000).random()
    println("The current balance is $accountBalance dollars.")

    val money = (0..1000).random()
    println("The amount you transferred is ${money} dollars.")

    var output = 0

    fun withdraw(amount: Int): Int{
        accountBalance = accountBalance - money
        println("You successfully withdraw $money dollars. You current balance is $accountBalance dollars. ")
        return amount
    }

    output = withdraw(money)
    println("The amount you withdraw is $output dollars.")

    fun debitWithdraw(amount: Int): Int{
        if (accountBalance == 0){
            println("Can't withdraw, no money on this account")
            return accountBalance
        }
        else if (amount > accountBalance){
            println("Not enough money on this account! The current balance is ${accountBalance} dollars.")
            return 0
        }
        else{
            return withdraw(amount)
        }
    }

    output = debitWithdraw(money)
    println("The amount you withdraw is $output dollars.")

    fun deposit(amount: Int): Int{
        accountBalance = accountBalance + amount
        println("You successfully deposited $amount dollars. The current balance is $accountBalance dollars." )
        return amount
    }

    output = deposit(money)
    println("The amount you deposited is $output dollars.")

    fun creditDeposit(amount: Int): Int{
        if (accountBalance == 0){
            println("The account is completely paid off! Do not deposit money")
            return accountBalance
        }
        else if (accountBalance + money >= 0){
            println("Deposit failed, you tried to pay off an amount greater than the credit balance. The checking balance is ${accountBalance} dollars.")
            return accountBalance
        }
        else if (amount == -accountBalance){
            accountBalance = 0
            println("You have paid off this account")
            return amount
        }
        else{
            return deposit(amount)
        }
    }

    output = creditDeposit(money)
    println("The amount you deposited is $output dollars.")
    println()

    fun transfer(mode: String){
        val transferAmount: Int
        when(mode) {
            "withdraw" ->{
                if (accountType == "Debit"){
                    transferAmount = debitWithdraw(money)

                }
                else{
                    transferAmount = withdraw(money)
                }
                println("The amount you withdrew is $transferAmount dollars.")
            }

            "Deposit" ->{
                if (accountType == "Credit"){
                    transferAmount = creditDeposit(money)
                }
                else{
                    transferAmount = deposit(money)
                }
                println("The amount you deposit is $transferAmount dollars.")
            }
            else -> return
        }
    }

    var isSystenOpen = true
    var option = 0

    while (isSystenOpen){
        println("What would you like to do? \n")
        println("1. Checking account balance\n")
        println("2. Withdraw money \n")
        println("3. Deposit money \n")
        println("4. Close the app \n")
        println("Which option do you choose? (1, 2, 3 or 4)")

        option = (1..5).random()
        println("The Selected option is $option")

        when(option){
            1 ->  println(" Checking account balance")
            2 ->  transfer("withdraw")
            3 ->  transfer("Deposit")
            4 -> {
                isSystenOpen = false
                println("The system is closed")
            }
            else -> continue
        }
    }
}