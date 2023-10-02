package lesson4.card;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PaymentFormTest {

    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности формы оплаты на сайте.
     * * Вместо реальной кредитной карты используйте мок-объект.
     * Создайте класс `CreditCard` с методами `getCardNumber()`, `getCardHolder()`, `getExpiryDate()`, `getCvv()`, `charge(double amount)`.
     * Создайте класс `PaymentForm` с методом `pay(double amount)`.
     * В тестовом классе, создайте мок-объект для класса `CreditCard`.
     * Определите поведение мок-объекта с помощью метода `when()`.
     * Создайте объект класса `PaymentForm`, передайте ему мок-объект в качестве аргумента.
     * Вызовите метод `pay()` и убедитесь, что мок-объект вызывает метод `charge()`
     */

    @Test
    void testCharge () {
        CreditCard creditCardMock = mock(CreditCard.class);
        when(creditCardMock.getCardNumber()).thenReturn("4444");
        when(creditCardMock.getCardHolder()).thenReturn("user");
        when(creditCardMock.getExpiryDate()).thenReturn("12.12.2022");
        when(creditCardMock.getCvv()).thenReturn("142");

        PaymentForm paymentForm = new PaymentForm(creditCardMock);
        paymentForm.pay(1000);

        verify(creditCardMock, times(1)).charge(1000);
    }

}