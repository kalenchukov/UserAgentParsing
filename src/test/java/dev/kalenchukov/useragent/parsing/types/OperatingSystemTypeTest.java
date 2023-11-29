/*
 * Copyright © 2023 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.useragent.parsing.types;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс проверки методов перечисления {@link OperatingSystemType}.
 *
 * @author Алексей Каленчуков
 */
public class OperatingSystemTypeTest
{
    /**
     * Проверка метода {@link OperatingSystemType#getName()}.
     */
    @Test
    public void getName()
    {
        OperatingSystemType operatingSystemType = OperatingSystemType.LINUX;

        String actualName = operatingSystemType.getName();

        assertThat(actualName).isEqualTo("Linux");
    }

    /**
     * Класс проверки статических методов.
     *
     * @author Алексей Каленчуков
     */
    @Nested
    public class Static
    {
        /**
         * Проверка метода {@link OperatingSystemType#getAllNames()}.
         */
        @Test
        public void getAllNames()
        {
            List<String> operatingSystems = OperatingSystemType.getAllNames();
            // Отнимается 1 так как в результат OperatingSystemType.getAll() не попадает OperatingSystemType.UNKNOWN
            int expectedSize = OperatingSystemType.values().length - 1;

            int actualSize = operatingSystems.size();

            assertThat(actualSize).isEqualTo(expectedSize);
        }
    }
}