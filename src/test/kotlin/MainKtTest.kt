import org.junit.Test
import org.junit.Assert.*

class MainKtTest {
    @Test
    fun checkCommissionFromTypeOfTransfer_VKPay() {
        val typeOfTransferVKPay = "VK pay"
        val transferAmountVKpay = 50000

        val result = checkCommissionFromTypeOfTransfer(
            typeOfTransfer = typeOfTransferVKPay,
            transferAmount = transferAmountVKpay
        )

        assertEquals(0, result)
    }

    @Test
    fun checkCommissionFromTypeOfTransfer_MastercardHasNotCommission() {
        val typeOfTransferMastercard = "Mastercard"
        val transferAmountMastercard = 50000

        val result = checkCommissionFromTypeOfTransfer(
            typeOfTransfer = typeOfTransferMastercard,
            transferAmount = transferAmountMastercard
        )

        assertEquals(100, result)
    }

    @Test
    fun checkCommissionFromTypeOfTransfer_MastercardHasCommission() {
        val typeOfTransferMastercard = "Mastercard"
        val transferAmountMastercard = 100_000

        val result = checkCommissionFromTypeOfTransfer(
            typeOfTransfer = typeOfTransferMastercard,
            transferAmount = transferAmountMastercard
        )

        assertEquals(620, result)
    }

    @Test
    fun checkCommissionFromTypeOfTransfer_MaestroHasNotCommission() {
        val typeOfTransferMaestro = "Maestro"
        val transferAmountMaestro = 40000

        val result = checkCommissionFromTypeOfTransfer(
            typeOfTransfer = typeOfTransferMaestro,
            transferAmount = transferAmountMaestro
        )

        assertEquals(0, result)
    }

    @Test
    fun checkCommissionFromTypeOfTransfer_MaestroHasCommission() {
        val typeOfTransferMaestro = "Maestro"
        val transferAmountMaestro = 200_000

        val result = checkCommissionFromTypeOfTransfer(
            typeOfTransfer = typeOfTransferMaestro,
            transferAmount = transferAmountMaestro
        )

        assertEquals(1220, result)
    }

    @Test
    fun checkCommissionFromTypeOfTransfer_VisaHasPercentCommission() {
        val typeOfTransferVisa = "Visa"
        val transferAmountVisa = 200_000

        val result = checkCommissionFromTypeOfTransfer(
            typeOfTransfer = typeOfTransferVisa,
            transferAmount = transferAmountVisa
        )

        assertEquals(1500, result)
    }
@Test
    fun checkCommissionFromTypeOfTransfer_VisaHasMinimumCommission() {
        val typeOfTransferVisa = "Visa"
        val transferAmountVisa = 2000

        val result = checkCommissionFromTypeOfTransfer(
            typeOfTransfer = typeOfTransferVisa,
            transferAmount = transferAmountVisa
        )

        assertEquals(35, result)
    }

    @Test
    fun checkCommissionFromTypeOfTransfer_MirHasPercentCommission() {
        val typeOfTransferMir = "Мир"
        val transferAmountMir = 100_000

        val result = checkCommissionFromTypeOfTransfer(
            typeOfTransfer = typeOfTransferMir,
            transferAmount = transferAmountMir
        )

        assertEquals(750, result)
    }
    @Test
    fun checkCommissionFromTypeOfTransfer_MirHasMinimumCommission() {
        val typeOfTransferMir = "Мир"
        val transferAmountMir = 1000

        val result = checkCommissionFromTypeOfTransfer(
            typeOfTransfer = typeOfTransferMir,
            transferAmount = transferAmountMir
        )

        assertEquals(350, result)
    }


}