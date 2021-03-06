/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/* @test
 * @bug 8073400
 * @summary Some Monospaced logical fonts have a different width
 * @author Dmitry Markov
 * @run main MonospacedGlyphWidthTest
 */
import java.awt.*;
import java.awt.font.FontRenderContext;

public class MonospacedGlyphWidthTest {
    private static final int START_INDEX = 0x2018;
    private static final int END_INDEX = 0x201F;

    public static void main(String[] args) {
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        double width = getCharWidth(font, 'a');

        for (int i = START_INDEX; i <= END_INDEX; i++) {
            if (width != getCharWidth(font, (char)i)) {
                throw new RuntimeException("Test Failed: characters have different width!");
            }
        }
        System.out.println("Test Passed!");
    }

    private static double getCharWidth(Font font, char c) {
        FontRenderContext fontRenderContext = new FontRenderContext(null, false, false);
        return font.getStringBounds(new char[] {c}, 0, 1, fontRenderContext).getWidth();
    }
}

