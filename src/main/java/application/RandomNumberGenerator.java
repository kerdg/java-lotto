package application;

public class RandomNumberGenerator {

    public int generateRandomNumber(int minValue, int maxValue) {
        int randomNumber = (int) (Math.random() * maxValue) + minValue;
        validNumber(minValue, maxValue, randomNumber);

        return randomNumber;
    }

    private void validNumber(int minValue, int maxValue, int number) {
        if (number < minValue || number > maxValue) {
            throw new IllegalArgumentException("랜덤으로 생성된 숫자는 " + minValue + "이상 " + maxValue + "이하여야 합니다.");
        }
    }
}
