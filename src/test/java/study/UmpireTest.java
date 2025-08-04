package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UmpireTest {

    private Umpire umpire;

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

    @DisplayName("숫자가 일치하고 위치까지 일치하면, 볼이 아닌 스트라이크이다.")
    @Test
    void ball_zero_but_three_strike() {
        // given
        int[] userInputs = {1, 2, 3};
        int[] targets = {1, 2, 3};

        // when
        int ballCount = umpire.ball(userInputs, targets);

        // then
        assertThat(ballCount).isEqualTo(0);
    }

    @DisplayName("숫자가 모두 일치하지 않으면, 0볼 이다.")
    @Test
    void ball_zero() {
        // given
        int[] userInputs = {4, 5, 6};
        int[] targets = {1, 2, 3};

        // when
        int ballCount = umpire.ball(userInputs, targets);

        // then
        assertThat(ballCount).isEqualTo(0);
    }

    @DisplayName("하나의 숫자가 일치하지만 위치가 일치하지 않으면, 1볼 이다.")
    @Test
    void ball_one() {
        // given
        int[] userInputs = {3, 5, 6};
        int[] targets = {1, 2, 3};

        // when
        int ballCount = umpire.ball(userInputs, targets);

        // then
        assertThat(ballCount).isEqualTo(1);
    }

    @DisplayName("두 개의 숫자가 일치하지만 위치가 일치하지 않으면, 2볼 이다.")
    @Test
    void ball_two() {
        // given
        int[] userInputs = {3, 1, 6};
        int[] targets = {1, 2, 3};

        // when
        int ballCount = umpire.ball(userInputs, targets);

        // then
        assertThat(ballCount).isEqualTo(2);
    }

    @DisplayName("세 개의 숫자가 일치하지만 위치가 일치하지 않으면, 3볼 이다.")
    @Test
    void ball_three() {
        // given
        int[] userInputs = {3, 1, 2};
        int[] targets = {1, 2, 3};

        // when
        int ballCount = umpire.ball(userInputs, targets);

        // then
        assertThat(ballCount).isEqualTo(3);
    }
}
