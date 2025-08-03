package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UmpireTest {

    private Umpire umpire;

    public UmpireTest(Umpire umpire) {
        this.umpire = umpire;
    }

    @BeforeEach
    void setUp() {
        umpire = new Umpire();
    }

    @DisplayName("숫자 배열 중 위치와 숫자가 아무것도 일치하지 않는 경우, 0스트라이크 이다.")
    @Test
    void strike_zero() {
        // given
        int[] userInputs = {1, 2, 3};
        int[] targets = {4, 5, 6};

        // when
        int strikeCount = umpire.strike(userInputs, targets);

        // then
        assertThat(strikeCount).isEqualTo(0);
    }

    @DisplayName("숫자 배열 중 위치와 숫자가 하나만 일치하는 경우, 1스트라이크 이다.")
    @Test
    void strike_one() {
        // given
        int[] userInputs = {1, 2, 3};
        int[] targets = {1, 5, 6};

        // when
        int strikeCount = umpire.strike(userInputs, targets);

        // then
        assertThat(strikeCount).isEqualTo(1);
    }

    @DisplayName("숫자 배열 중 위치와 숫자가 두 개 일치하는 경우, 2스트라이크 이다.")
    @Test
    void strike_two() {
        // given
        int[] userInputs = {1, 2, 3};
        int[] targets = {1, 2, 6};

        // when
        int strikeCount = umpire.strike(userInputs, targets);

        // then
        assertThat(strikeCount).isEqualTo(2);
    }

    @DisplayName("숫자 배열 중 위치와 숫자가 모두 일치하는 경우, 3스트라이크 이다.")
    @Test
    void strike_three() {
        // given
        int[] userInputs = {1, 2, 3};
        int[] targets = {1, 2, 3};

        // when
        int strikeCount = umpire.strike(userInputs, targets);

        // then
        assertThat(strikeCount).isEqualTo(3);
    }

}
