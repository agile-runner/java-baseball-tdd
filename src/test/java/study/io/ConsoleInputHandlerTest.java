package study.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.io.ConsoleInputHandler;
import study.io.InputHandler;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConsoleInputHandlerTest {

    private Scanner scanner;
    private InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new ConsoleInputHandler();
    }

    @DisplayName("컴퓨터와 비교할 서로 다른 세자리의 수를 입력받는다.")
    @Test
    void getNumberFromUser_3digit() {
        // given
        String input = "123\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);

        // when
        int[] digits = inputHandler.getDigitsFromUser(scanner);

        // then
        int[] expected = {1, 2, 3};
        assertThat(digits).isEqualTo(expected);
    }

    @DisplayName("입력은 반드시 세 자리여야 컴퓨터와 비교 가능하다.(1)")
    @Test
    void getNumberFromUser_4digit() {
        // given
        String input = "1234\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);

        // when & then
        assertThatThrownBy(() -> inputHandler.getDigitsFromUser(scanner))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용자 입력은 세 자리만 가능합니다.");
    }

    @DisplayName("입력은 반드시 세 자리여야 컴퓨터와 비교 가능하다.(2)")
    @Test
    void getNumberFromUser_2digit() {
        // given
        String input = "12\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);

        // when & then
        assertThatThrownBy(() -> inputHandler.getDigitsFromUser(scanner))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용자 입력은 세 자리만 가능합니다.");
    }

    @DisplayName("입력은 반드시 숫자여야 컴퓨터와 비교 가능하다.")
    @Test
    void getNumberFromUser_string() {
        // given
        String input = "A23\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);

        // when & then
        assertThatThrownBy(() -> inputHandler.getDigitsFromUser(scanner))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용자 입력은 숫자만 가능합니다.");
    }

    @DisplayName("각 자리의 숫자는 중복될 수 없다.")
    @Test
    void getNumberFromUser_duplication() {
        // given
        String input = "112\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);

        // when & then
        assertThatThrownBy(() -> inputHandler.getDigitsFromUser(scanner))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각 자리 숫자는 중복될 수 없습니다.");
    }

}