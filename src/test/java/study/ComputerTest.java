package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @DisplayName("컴퓨터는 사용자가 맞춰야 할 세 자리 숫자를 생성한다.")
    @Test
    void generateRandomNumber_3digit() {
        // given & when
        int[] random = computer.generateRandomNumber();

        // then
        assertThat(random.length).isEqualTo(3);
    }

}