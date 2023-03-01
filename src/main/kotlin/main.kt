fun main() {

    print("Введите сумму трансфера: ")
    val getTransferAmount = readln().toInt()
    print("Введите карту или платёжную систему, которую будете использовать: ")
    val getTypeOfTransfer = readln()
    val finalCommissions = calculateCommissionAmount(getTransferAmount, cardType = getTypeOfTransfer)
    println("Комиссия при переводе $getTransferAmount р., используя \"$getTypeOfTransfer\", составит $finalCommissions.")

}


fun calculateCommissionAmount(transferAmount: Int, cardType: String = "VK pay", monthTransferAmount: Int = 0): Int {

    val totalTransfer = transferAmount + monthTransferAmount
    return checkCommissionFromTypeOfTransfer(cardType, totalTransfer)
}

fun checkCommissionFromTypeOfTransfer(typeOfTransfer: String, transferAmount: Int): Int {

    var sumOfCommission = 0
    val minimalCommission = 35
    val sumOfMonthTransferAmount = 75_000
    val percentForMastercardAndMaestro = 0.006
    val percentForVisaAndMir = 0.0075
    val requiredCommissionForMastercardAndVisa = 20
    when (typeOfTransfer) {
        "Vk pay" -> sumOfCommission = 0
        "Mastercard", "Maestro" -> if (transferAmount > sumOfMonthTransferAmount) sumOfCommission =
            (transferAmount * percentForMastercardAndMaestro + requiredCommissionForMastercardAndVisa).toInt() else sumOfCommission = 0

        "Visa", "Мир" -> if ((transferAmount * percentForVisaAndMir) < minimalCommission) sumOfCommission = minimalCommission else sumOfCommission =
            (transferAmount * percentForVisaAndMir).toInt()
    }
    return sumOfCommission

}