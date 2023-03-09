package com.wyyl1.pm.common.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AssertUtilsTest {

    @Nested
    class IsTrue {
        @Test
        void isTrueWithMessageSupplier() {
            AssertUtils.isTrue(true, () -> "enigma");
        }

        @Test
        void isTrueWithFalseAndMessageSupplier() {
            assertThatIllegalArgumentException().isThrownBy(() ->
                            AssertUtils.isTrue(false, () -> "enigma"))
                    .withMessageContaining("enigma");
        }

        @Test
        void isTrueWithFalseAndNullMessageSupplier() {
            assertThatIllegalArgumentException().isThrownBy(() ->
                            AssertUtils.isTrue(false, (Supplier<String>) null))
                    .withMessage(null);
        }
    }

    @Nested
    class CheckArgument {
        @Test
        void isTrueWithMessageSupplier() {
            AssertUtils.checkArgument(true, () -> "enigma");
        }

        @Test
        void isTrueWithFalseAndMessageSupplier() {
            assertThatIllegalArgumentException().isThrownBy(() ->
                            AssertUtils.checkArgument(false, () -> "enigma"))
                    .withMessageContaining("enigma");
        }

        @Test
        void isTrueWithFalseAndNullMessageSupplier() {
            assertThatIllegalArgumentException().isThrownBy(() ->
                            AssertUtils.checkArgument(false, (Supplier<String>) null))
                    .withMessage(null);
        }
    }
}