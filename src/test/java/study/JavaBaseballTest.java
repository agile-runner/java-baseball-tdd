package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.exception.GameException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static study.exception.ErrorCode.SELECTION_INVALID_OPTION;

class JavaBaseballTest {

    @DisplayName("사용자는 주어진 옵션만 선택 가능합니다.")
    @Test
    void handleRestartOrQuit_notGivenOption() {
        // given
        int selection = 3;

        JavaBaseball javaBaseball = new JavaBaseball();

        // when & then
        assertThatThrownBy(() -> javaBaseball.handleRestartOrQuit(selection))
                .isInstanceOf(GameException.class)
                .hasMessage(SELECTION_INVALID_OPTION.getMessage());
    }

}