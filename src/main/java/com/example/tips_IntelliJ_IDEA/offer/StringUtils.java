/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.tips_IntelliJ_IDEA.offer;

import com.example.tips_IntelliJ_IDEA.lang3.*;
import com.example.tips_IntelliJ_IDEA.lang3.function.ToBooleanBiFunction;
import com.example.tips_IntelliJ_IDEA.lang3.text.WordUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/**
 * <p>Operations on {@link String} that are
 * {@code null} safe.</p>
 *
 * <ul>
 *  <li><b>IsEmpty/IsBlank</b>
 *      - checks if a String contains text</li>
 *  <li><b>Trim/Strip</b>
 *      - removes leading and trailing whitespace</li>
 *  <li><b>Equals/Compare</b>
 *      - compares two strings in a null-safe manner</li>
 *  <li><b>startsWith</b>
 *      - check if a String starts with a prefix in a null-safe manner</li>
 *  <li><b>endsWith</b>
 *      - check if a String ends with a suffix in a null-safe manner</li>
 *  <li><b>IndexOf/LastIndexOf/Contains</b>
 *      - null-safe index-of checks
 *  <li><b>IndexOfAny/LastIndexOfAny/IndexOfAnyBut/LastIndexOfAnyBut</b>
 *      - index-of any of a set of Strings</li>
 *  <li><b>ContainsOnly/ContainsNone/ContainsAny</b>
 *      - checks if String contains only/none/any of these characters</li>
 *  <li><b>Substring/Left/Right/Mid</b>
 *      - null-safe substring extractions</li>
 *  <li><b>SubstringBefore/SubstringAfter/SubstringBetween</b>
 *      - substring extraction relative to other strings</li>
 *  <li><b>Split/Join</b>
 *      - splits a String into an array of substrings and vice versa</li>
 *  <li><b>Remove/Delete</b>
 *      - removes part of a String</li>
 *  <li><b>Replace/Overlay</b>
 *      - Searches a String and replaces one String with another</li>
 *  <li><b>Chomp/Chop</b>
 *      - removes the last part of a String</li>
 *  <li><b>AppendIfMissing</b>
 *      - appends a suffix to the end of the String if not present</li>
 *  <li><b>PrependIfMissing</b>
 *      - prepends a prefix to the start of the String if not present</li>
 *  <li><b>LeftPad/RightPad/Center/Repeat</b>
 *      - pads a String</li>
 *  <li><b>UpperCase/LowerCase/SwapCase/Capitalize/Uncapitalize</b>
 *      - changes the case of a String</li>
 *  <li><b>CountMatches</b>
 *      - counts the number of occurrences of one String in another</li>
 *  <li><b>IsAlpha/IsNumeric/IsWhitespace/IsAsciiPrintable</b>
 *      - checks the characters in a String</li>
 *  <li><b>DefaultString</b>
 *      - protects against a null input String</li>
 *  <li><b>Rotate</b>
 *      - rotate (circular shift) a String</li>
 *  <li><b>Reverse/ReverseDelimited</b>
 *      - reverses a String</li>
 *  <li><b>Abbreviate</b>
 *      - abbreviates a string using ellipses or another given String</li>
 *  <li><b>Difference</b>
 *      - compares Strings and reports on their differences</li>
 *  <li><b>LevenshteinDistance</b>
 *      - the number of changes needed to change one String into another</li>
 * </ul>
 *
 * <p>The {@code StringUtils} class defines certain words related to
 * String handling.</p>
 *
 * <ul>
 *  <li>null - {@code null}</li>
 *  <li>empty - a zero-length string ({@code ""})</li>
 *  <li>space - the space character ({@code ' '}, char 32)</li>
 *  <li>whitespace - the characters defined by {@link Character#isWhitespace(char)}</li>
 *  <li>trim - the characters &lt;= 32 as in {@link String#trim()}</li>
 * </ul>
 *
 * <p>{@code StringUtils} handles {@code null} input Strings quietly.
 * That is to say that a {@code null} input will return {@code null}.
 * Where a {@code boolean} or {@code int} is being returned
 * details vary by method.</p>
 *
 * <p>A side effect of the {@code null} handling is that a
 * {@code NullPointerException} should be considered a bug in
 * {@code StringUtils}.</p>
 *
 * <p>Methods in this class include sample code in their Javadoc comments to explain their operation.
 * The symbol {@code *} is used to indicate any input including {@code null}.</p>
 *
 * <p>#ThreadSafe#</p>
 *
 * @see String
 * @since 1.0
 */
//@Immutable
public class StringUtils {

    // Performance testing notes (JDK 1.4, Jul03, scolebourne)
    // Whitespace:
    // Character.isWhitespace() is faster than WHITESPACE.indexOf()
    // where WHITESPACE is a string of all whitespace characters
    //
    // Character access:
    // String.charAt(n) versus toCharArray(), then array[n]
    // String.charAt(n) is about 15% worse for a 10K string
    // They are about equal for a length 50 string
    // String.charAt(n) is about 4 times better for a length 3 string
    // String.charAt(n) is best bet overall
    //
    // Append:
    // String.concat about twice as fast as StringBuffer.append
    // (not sure who tested this)

    /**
     * A String for a space character.
     *
     * @since 3.2
     */
    public static final String SPACE = " ";

    /**
     * The empty String {@code ""}.
     *
     * @since 2.0
     */
    public static final String EMPTY = "";

    /**
     * A String for linefeed LF ("\n").
     *
     * @see <a href="http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.10.6">JLF: Escape Sequences
     * for Character and String Literals</a>
     * @since 3.2
     */
    public static final String LF = "\n";

    /**
     * A String for carriage return CR ("\r").
     *
     * @see <a href="http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.10.6">JLF: Escape Sequences
     * for Character and String Literals</a>
     * @since 3.2
     */
    public static final String CR = "\r";

    /**
     * Represents a failed index search.
     *
     * @since 2.1
     */
    public static final int INDEX_NOT_FOUND = -1;

    /**
     * <p>The maximum size to which the padding constant(s) can expand.</p>
     */
    private static final int PAD_LIMIT = 8192;

    /**
     *
     */
    private static final Pattern STRIP_ACCENTS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); //$NON-NLS-1$

    /**
     * <p>Abbreviates a String using ellipses. This will turn
     * "Now is the time for all good men" into "Now is the time for..."</p>
     *
     * <p>Specifically:</p>
     * <ul>
     *   <li>If the number of characters in {@code str} is less than or equal to
     *       {@code maxWidth}, return {@code str}.</li>
     *   <li>Else abbreviate it to {@code (substring(str, 0, max-3) + "...")}.</li>
     *   <li>If {@code maxWidth} is less than {@code 4}, throw an
     *       {@code IllegalArgumentException}.</li>
     *   <li>In no case will it return a String of length greater than
     *       {@code maxWidth}.</li>
     * </ul>
     *
     * <pre>
     * StringUtils.abbreviate(null, *)      = null
     * StringUtils.abbreviate("", 4)        = ""
     * StringUtils.abbreviate("abcdefg", 6) = "abc..."
     * StringUtils.abbreviate("abcdefg", 7) = "abcdefg"
     * StringUtils.abbreviate("abcdefg", 8) = "abcdefg"
     * StringUtils.abbreviate("abcdefg", 4) = "a..."
     * StringUtils.abbreviate("abcdefg", 3) = IllegalArgumentException
     * </pre>
     *
     * @param str      the String to check, may be null
     * @param maxWidth maximum length of result String, must be at least 4
     * @return abbreviated String, {@code null} if null String input
     * @throws IllegalArgumentException if the width is too small
     * @since 2.0
     */
    public static String abbreviate(final String str, final int maxWidth) {

        return abbreviate(str, "...", 0, maxWidth);
    }

    /**
     * <p>Abbreviates a String using ellipses. This will turn
     * "Now is the time for all good men" into "...is the time for..."</p>
     *
     * <p>Works like {@code abbreviate(String, int)}, but allows you to specify
     * a "left edge" offset.  Note that this left edge is not necessarily going to
     * be the leftmost character in the result, or the first character following the
     * ellipses, but it will appear somewhere in the result.
     *
     * <p>In no case will it return a String of length greater than
     * {@code maxWidth}.</p>
     *
     * <pre>
     * StringUtils.abbreviate(null, *, *)                = null
     * StringUtils.abbreviate("", 0, 4)                  = ""
     * StringUtils.abbreviate("abcdefghijklmno", -1, 10) = "abcdefg..."
     * StringUtils.abbreviate("abcdefghijklmno", 0, 10)  = "abcdefg..."
     * StringUtils.abbreviate("abcdefghijklmno", 1, 10)  = "abcdefg..."
     * StringUtils.abbreviate("abcdefghijklmno", 4, 10)  = "abcdefg..."
     * StringUtils.abbreviate("abcdefghijklmno", 5, 10)  = "...fghi..."
     * StringUtils.abbreviate("abcdefghijklmno", 6, 10)  = "...ghij..."
     * StringUtils.abbreviate("abcdefghijklmno", 8, 10)  = "...ijklmno"
     * StringUtils.abbreviate("abcdefghijklmno", 10, 10) = "...ijklmno"
     * StringUtils.abbreviate("abcdefghijklmno", 12, 10) = "...ijklmno"
     * StringUtils.abbreviate("abcdefghij", 0, 3)        = IllegalArgumentException
     * StringUtils.abbreviate("abcdefghij", 5, 6)        = IllegalArgumentException
     * </pre>
     *
     * @param str      the String to check, may be null
     * @param offset   left edge of source String
     * @param maxWidth maximum length of result String, must be at least 4
     * @return abbreviated String, {@code null} if null String input
     * @throws IllegalArgumentException if the width is too small
     * @since 2.0
     */
    public static String abbreviate(final String str, final int offset, final int maxWidth) {
        return abbreviate(str, "...", offset, maxWidth);
    }

    /**
     * <p>Abbreviates a String using another given String as replacement marker. This will turn
     * "Now is the time for all good men" into "Now is the time for..." if "..." was defined
     * as the replacement marker.</p>
     *
     * <p>Specifically:</p>
     * <ul>
     *   <li>If the number of characters in {@code str} is less than or equal to
     *       {@code maxWidth}, return {@code str}.</li>
     *   <li>Else abbreviate it to {@code (substring(str, 0, max-abbrevMarker.length) + abbrevMarker)}.</li>
     *   <li>If {@code maxWidth} is less than {@code abbrevMarker.length + 1}, throw an
     *       {@code IllegalArgumentException}.</li>
     *   <li>In no case will it return a String of length greater than
     *       {@code maxWidth}.</li>
     * </ul>
     *
     * <pre>
     * StringUtils.abbreviate(null, "...", *)      = null
     * StringUtils.abbreviate("abcdefg", null, *)  = "abcdefg"
     * StringUtils.abbreviate("", "...", 4)        = ""
     * StringUtils.abbreviate("abcdefg", ".", 5)   = "abcd."
     * StringUtils.abbreviate("abcdefg", ".", 7)   = "abcdefg"
     * StringUtils.abbreviate("abcdefg", ".", 8)   = "abcdefg"
     * StringUtils.abbreviate("abcdefg", "..", 4)  = "ab.."
     * StringUtils.abbreviate("abcdefg", "..", 3)  = "a.."
     * StringUtils.abbreviate("abcdefg", "..", 2)  = IllegalArgumentException
     * StringUtils.abbreviate("abcdefg", "...", 3) = IllegalArgumentException
     * </pre>
     *
     * @param str          the String to check, may be null
     * @param abbrevMarker the String used as replacement marker
     * @param maxWidth     maximum length of result String, must be at least {@code abbrevMarker.length + 1}
     * @return abbreviated String, {@code null} if null String input
     * @throws IllegalArgumentException if the width is too small
     * @since 3.6
     */
    public static String abbreviate(final String str, final String abbrevMarker, final int maxWidth) {
        return abbreviate(str, abbrevMarker, 0, maxWidth);
    }

    /**
     * <p>Abbreviates a String using a given replacement marker. This will turn
     * "Now is the time for all good men" into "...is the time for..." if "..." was defined
     * as the replacement marker.</p>
     *
     * <p>Works like {@code abbreviate(String, String, int)}, but allows you to specify
     * a "left edge" offset.  Note that this left edge is not necessarily going to
     * be the leftmost character in the result, or the first character following the
     * replacement marker, but it will appear somewhere in the result.
     *
     * <p>In no case will it return a String of length greater than {@code maxWidth}.</p>
     *
     * <pre>
     * StringUtils.abbreviate(null, null, *, *)                 = null
     * StringUtils.abbreviate("abcdefghijklmno", null, *, *)    = "abcdefghijklmno"
     * StringUtils.abbreviate("", "...", 0, 4)                  = ""
     * StringUtils.abbreviate("abcdefghijklmno", "---", -1, 10) = "abcdefg---"
     * StringUtils.abbreviate("abcdefghijklmno", ",", 0, 10)    = "abcdefghi,"
     * StringUtils.abbreviate("abcdefghijklmno", ",", 1, 10)    = "abcdefghi,"
     * StringUtils.abbreviate("abcdefghijklmno", ",", 2, 10)    = "abcdefghi,"
     * StringUtils.abbreviate("abcdefghijklmno", "::", 4, 10)   = "::efghij::"
     * StringUtils.abbreviate("abcdefghijklmno", "...", 6, 10)  = "...ghij..."
     * StringUtils.abbreviate("abcdefghijklmno", "*", 9, 10)    = "*ghijklmno"
     * StringUtils.abbreviate("abcdefghijklmno", "'", 10, 10)   = "'ghijklmno"
     * StringUtils.abbreviate("abcdefghijklmno", "!", 12, 10)   = "!ghijklmno"
     * StringUtils.abbreviate("abcdefghij", "abra", 0, 4)       = IllegalArgumentException
     * StringUtils.abbreviate("abcdefghij", "...", 5, 6)        = IllegalArgumentException
     * </pre>
     *
     * @param str          the String to check, may be null
     * @param abbrevMarker the String used as replacement marker
     * @param offset       left edge of source String
     * @param maxWidth     maximum length of result String, must be at least 4
     * @return abbreviated String, {@code null} if null String input
     * @throws IllegalArgumentException if the width is too small
     * @since 3.6
     */
    public static String abbreviate(final String str, final String abbrevMarker, int offset, final int maxWidth) {
        if (isNotEmpty(str) && EMPTY.equals(abbrevMarker) && maxWidth > 0) {
            return substring(str, 0, maxWidth);
        } else if (isAnyEmpty(str, abbrevMarker)) {
            return str;
        }
        final int abbrevMarkerLength = abbrevMarker.length();
        final int minAbbrevWidth = abbrevMarkerLength + 1;
        final int minAbbrevWidthOffset = abbrevMarkerLength + abbrevMarkerLength + 1;

        if (maxWidth < minAbbrevWidth) {
            throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", minAbbrevWidth));
        }
        final int strLen = str.length();
        if (strLen <= maxWidth) {
            return str;
        }
        if (offset > strLen) {
            offset = strLen;
        }
        if (strLen - offset < maxWidth - abbrevMarkerLength) {
            offset = strLen - (maxWidth - abbrevMarkerLength);
        }
        if (offset <= abbrevMarkerLength + 1) {
            return str.substring(0, maxWidth - abbrevMarkerLength) + abbrevMarker;
        }
        if (maxWidth < minAbbrevWidthOffset) {
            throw new IllegalArgumentException(String.format("Minimum abbreviation width with offset is %d", minAbbrevWidthOffset));
        }
        if (offset + maxWidth - abbrevMarkerLength < strLen) {
            return abbrevMarker + abbreviate(str.substring(offset), abbrevMarker, maxWidth - abbrevMarkerLength);
        }
        return abbrevMarker + str.substring(strLen - (maxWidth - abbrevMarkerLength));
    }

    private static boolean isAnyEmpty(String str, String abbrevMarker) {
        return false;
    }

    private static String substring(String str, int i, int maxWidth) {
        return "";
    }

    /**
     * Appends the suffix to the end of the string if the string does not
     * already end with the suffix.
     *
     * @param str        The string.
     * @param suffix     The suffix to append to the end of the string.
     * @param ignoreCase Indicates whether the compare should ignore case.
     * @param suffixes   Additional suffixes that are valid terminators (optional).
     * @return A new String if suffix was appended, the same string otherwise.
     */
    private static String appendIfMissing(final String str, final CharSequence suffix, final boolean ignoreCase, final CharSequence... suffixes) {
        if (str == null || isEmpty(suffix) || endsWith(str, suffix, ignoreCase)) {
            return str;
        }
        if (ArrayUtils.isNotEmpty(suffixes)) {
            for (final CharSequence s : suffixes) {
                if (endsWith(str, s, ignoreCase)) {
                    return str;
                }
            }
        }
        return str + suffix.toString();
    }

    /**
     * Appends the suffix to the end of the string if the string does not
     * already end with any of the suffixes.
     *
     * <pre>
     * StringUtils.appendIfMissing(null, null) = null
     * StringUtils.appendIfMissing("abc", null) = "abc"
     * StringUtils.appendIfMissing("", "xyz") = "xyz"
     * StringUtils.appendIfMissing("abc", "xyz") = "abcxyz"
     * StringUtils.appendIfMissing("abcxyz", "xyz") = "abcxyz"
     * StringUtils.appendIfMissing("abcXYZ", "xyz") = "abcXYZxyz"
     * </pre>
     * <p>With additional suffixes,</p>
     * <pre>
     * StringUtils.appendIfMissing(null, null, null) = null
     * StringUtils.appendIfMissing("abc", null, null) = "abc"
     * StringUtils.appendIfMissing("", "xyz", null) = "xyz"
     * StringUtils.appendIfMissing("abc", "xyz", new CharSequence[]{null}) = "abcxyz"
     * StringUtils.appendIfMissing("abc", "xyz", "") = "abc"
     * StringUtils.appendIfMissing("abc", "xyz", "mno") = "abcxyz"
     * StringUtils.appendIfMissing("abcxyz", "xyz", "mno") = "abcxyz"
     * StringUtils.appendIfMissing("abcmno", "xyz", "mno") = "abcmno"
     * StringUtils.appendIfMissing("abcXYZ", "xyz", "mno") = "abcXYZxyz"
     * StringUtils.appendIfMissing("abcMNO", "xyz", "mno") = "abcMNOxyz"
     * </pre>
     *
     * @param str      The string.
     * @param suffix   The suffix to append to the end of the string.
     * @param suffixes Additional suffixes that are valid terminators.
     * @return A new String if suffix was appended, the same string otherwise.
     * @since 3.2
     */
    public static String appendIfMissing(final String str, final CharSequence suffix, final CharSequence... suffixes) {
        return appendIfMissing(str, suffix, false, suffixes);
    }

    /**
     * Appends the suffix to the end of the string if the string does not
     * already end, case insensitive, with any of the suffixes.
     *
     * <pre>
     * StringUtils.appendIfMissingIgnoreCase(null, null) = null
     * StringUtils.appendIfMissingIgnoreCase("abc", null) = "abc"
     * StringUtils.appendIfMissingIgnoreCase("", "xyz") = "xyz"
     * StringUtils.appendIfMissingIgnoreCase("abc", "xyz") = "abcxyz"
     * StringUtils.appendIfMissingIgnoreCase("abcxyz", "xyz") = "abcxyz"
     * StringUtils.appendIfMissingIgnoreCase("abcXYZ", "xyz") = "abcXYZ"
     * </pre>
     * <p>With additional suffixes,</p>
     * <pre>
     * StringUtils.appendIfMissingIgnoreCase(null, null, null) = null
     * StringUtils.appendIfMissingIgnoreCase("abc", null, null) = "abc"
     * StringUtils.appendIfMissingIgnoreCase("", "xyz", null) = "xyz"
     * StringUtils.appendIfMissingIgnoreCase("abc", "xyz", new CharSequence[]{null}) = "abcxyz"
     * StringUtils.appendIfMissingIgnoreCase("abc", "xyz", "") = "abc"
     * StringUtils.appendIfMissingIgnoreCase("abc", "xyz", "mno") = "abcxyz"
     * StringUtils.appendIfMissingIgnoreCase("abcxyz", "xyz", "mno") = "abcxyz"
     * StringUtils.appendIfMissingIgnoreCase("abcmno", "xyz", "mno") = "abcmno"
     * StringUtils.appendIfMissingIgnoreCase("abcXYZ", "xyz", "mno") = "abcXYZ"
     * StringUtils.appendIfMissingIgnoreCase("abcMNO", "xyz", "mno") = "abcMNO"
     * </pre>
     *
     * @param str      The string.
     * @param suffix   The suffix to append to the end of the string.
     * @param suffixes Additional suffixes that are valid terminators.
     * @return A new String if suffix was appended, the same string otherwise.
     * @since 3.2
     */
    public static String appendIfMissingIgnoreCase(final String str, final CharSequence suffix, final CharSequence... suffixes) {
        return appendIfMissing(str, suffix, true, suffixes);
    }

    /**
     * <p>Capitalizes a String changing the first character to title case as
     * per {@link Character#toTitleCase(int)}. No other characters are changed.</p>
     *
     * <p>For a word based algorithm, see {@link WordUtils#capitalize(String)}.
     * A {@code null} input String returns {@code null}.</p>
     *
     * <pre>
     * StringUtils.capitalize(null)  = null
     * StringUtils.capitalize("")    = ""
     * StringUtils.capitalize("cat") = "Cat"
     * StringUtils.capitalize("cAt") = "CAt"
     * StringUtils.capitalize("'cat'") = "'cat'"
     * </pre>
     *
     * @param str the String to capitalize, may be null
     * @return the capitalized String, {@code null} if null String input
     * @see WordUtils#capitalize(String)
     * @since 2.0
     */
    public static String capitalize(final String str) {
        final int strLen = length(str);
        if (strLen == 0) {
            return str;
        }

        final int firstCodepoint = str.codePointAt(0);
        final int newCodePoint = Character.toTitleCase(firstCodepoint);
        if (firstCodepoint == newCodePoint) {
            // already capitalized
            return str;
        }

        final int[] newCodePoints = new int[strLen]; // cannot be longer than the char array
        int outOffset = 0;
        newCodePoints[outOffset++] = newCodePoint; // copy the first codepoint
        for (int inOffset = Character.charCount(firstCodepoint); inOffset < strLen; ) {
            final int codepoint = str.codePointAt(inOffset);
            newCodePoints[outOffset++] = codepoint; // copy the remaining ones
            inOffset += Character.charCount(codepoint);
        }
        return new String(newCodePoints, 0, outOffset);
    }

    public static int length(CharSequence str) {
        return 0;
    }

    /**
     * <p>Centers a String in a larger String of size {@code size}
     * using the space character (' ').</p>
     *
     * <p>If the size is less than the String length, the original String is returned.
     * A {@code null} String returns {@code null}.
     * A negative size is treated as zero.</p>
     *
     * <p>Equivalent to {@code center(str, size, " ")}.</p>
     *
     * <pre>
     * StringUtils.center(null, *)   = null
     * StringUtils.center("", 4)     = "    "
     * StringUtils.center("ab", -1)  = "ab"
     * StringUtils.center("ab", 4)   = " ab "
     * StringUtils.center("abcd", 2) = "abcd"
     * StringUtils.center("a", 4)    = " a  "
     * </pre>
     *
     * @param str  the String to center, may be null
     * @param size the int size of new String, negative treated as zero
     * @return centered String, {@code null} if null String input
     */
    public static String center(final String str, final int size) {
        return center(str, size, ' ');
    }

    /**
     * <p>Centers a String in a larger String of size {@code size}.
     * Uses a supplied character as the value to pad the String with.</p>
     *
     * <p>If the size is less than the String length, the String is returned.
     * A {@code null} String returns {@code null}.
     * A negative size is treated as zero.</p>
     *
     * <pre>
     * StringUtils.center(null, *, *)     = null
     * StringUtils.center("", 4, ' ')     = "    "
     * StringUtils.center("ab", -1, ' ')  = "ab"
     * StringUtils.center("ab", 4, ' ')   = " ab "
     * StringUtils.center("abcd", 2, ' ') = "abcd"
     * StringUtils.center("a", 4, ' ')    = " a  "
     * StringUtils.center("a", 4, 'y')    = "yayy"
     * </pre>
     *
     * @param str     the String to center, may be null
     * @param size    the int size of new String, negative treated as zero
     * @param padChar the character to pad the new String with
     * @return centered String, {@code null} if null String input
     * @since 2.0
     */
    public static String center(String str, final int size, final char padChar) {
        if (str == null || size <= 0) {
            return str;
        }
        final int strLen = str.length();
        final int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        str = leftPad(str, strLen + pads / 2, padChar);
        str = rightPad(str, size, "");
        return str;
    }

    public static String leftPad(String str, int i, char padChar) {
        return "";
    }

    /**
     * <p>Centers a String in a larger String of size {@code size}.
     * Uses a supplied String as the value to pad the String with.</p>
     *
     * <p>If the size is less than the String length, the String is returned.
     * A {@code null} String returns {@code null}.
     * A negative size is treated as zero.</p>
     *
     * <pre>
     * StringUtils.center(null, *, *)     = null
     * StringUtils.center("", 4, " ")     = "    "
     * StringUtils.center("ab", -1, " ")  = "ab"
     * StringUtils.center("ab", 4, " ")   = " ab "
     * StringUtils.center("abcd", 2, " ") = "abcd"
     * StringUtils.center("a", 4, " ")    = " a  "
     * StringUtils.center("a", 4, "yz")   = "yayz"
     * StringUtils.center("abc", 7, null) = "  abc  "
     * StringUtils.center("abc", 7, "")   = "  abc  "
     * </pre>
     *
     * @param str    the String to center, may be null
     * @param size   the int size of new String, negative treated as zero
     * @param padStr the String to pad the new String with, must not be null or empty
     * @return centered String, {@code null} if null String input
     * @throws IllegalArgumentException if padStr is {@code null} or empty
     */
    public static String center(String str, final int size, String padStr) {
        if (str == null || size <= 0) {
            return str;
        }
        if (isEmpty(padStr)) {
            padStr = SPACE;
        }
        final int strLen = str.length();
        final int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        str = leftPad(str, strLen + pads / 2, 's');
        str = rightPad(str, size, padStr);
        return str;
    }

    private static String rightPad(String str, int size, String padStr) {
        return "";
    }

    /**
     * <p>Removes one newline from end of a String if it's there,
     * otherwise leave it alone.  A newline is &quot;{@code \n}&quot;,
     * &quot;{@code \r}&quot;, or &quot;{@code \r\n}&quot;.</p>
     *
     * <p>NOTE: This method changed in 2.0.
     * It now more closely matches Perl chomp.</p>
     *
     * <pre>
     * StringUtils.chomp(null)          = null
     * StringUtils.chomp("")            = ""
     * StringUtils.chomp("abc \r")      = "abc "
     * StringUtils.chomp("abc\n")       = "abc"
     * StringUtils.chomp("abc\r\n")     = "abc"
     * StringUtils.chomp("abc\r\n\r\n") = "abc\r\n"
     * StringUtils.chomp("abc\n\r")     = "abc\n"
     * StringUtils.chomp("abc\n\rabc")  = "abc\n\rabc"
     * StringUtils.chomp("\r")          = ""
     * StringUtils.chomp("\n")          = ""
     * StringUtils.chomp("\r\n")        = ""
     * </pre>
     *
     * @param str the String to chomp a newline from, may be null
     * @return String without newline, {@code null} if null String input
     */
    public static String chomp(final String str) {
        if (isEmpty(str)) {
            return str;
        }

        if (str.length() == 1) {
            final char ch = str.charAt(0);
            if (ch == CharUtils.CR || ch == CharUtils.LF) {
                return EMPTY;
            }
            return str;
        }

        int lastIdx = str.length() - 1;
        final char last = str.charAt(lastIdx);

        if (last == CharUtils.LF) {
            if (str.charAt(lastIdx - 1) == CharUtils.CR) {
                lastIdx--;
            }
        } else if (last != CharUtils.CR) {
            lastIdx++;
        }
        return str.substring(0, lastIdx);
    }

    /**
     * <p>Removes {@code separator} from the end of
     * {@code str} if it's there, otherwise leave it alone.</p>
     *
     * <p>NOTE: This method changed in version 2.0.
     * It now more closely matches Perl chomp.
     * This method uses {@link String#endsWith(String)}.</p>
     *
     * <pre>
     * StringUtils.chomp(null, *)         = null
     * StringUtils.chomp("", *)           = ""
     * StringUtils.chomp("foobar", "bar") = "foo"
     * StringUtils.chomp("foobar", "baz") = "foobar"
     * StringUtils.chomp("foo", "foo")    = ""
     * StringUtils.chomp("foo ", "foo")   = "foo "
     * StringUtils.chomp(" foo", "foo")   = " "
     * StringUtils.chomp("foo", "foooo")  = "foo"
     * StringUtils.chomp("foo", "")       = "foo"
     * StringUtils.chomp("foo", null)     = "foo"
     * </pre>
     *
     * @param str       the String to chomp from, may be null
     * @param separator separator String, may be null
     * @return String without trailing separator, {@code null} if null String input
     * @deprecated This feature will be removed in Lang 4.0, use {@link StringUtils#removeEnd(String, String)} instead
     */
    @Deprecated
    public static String chomp(final String str, final String separator) {
        return removeEnd(str, separator);
    }

    private static String removeEnd(String str, String separator) {
        return null;
    }

    /**
     * <p>Remove the last character from a String.</p>
     *
     * <p>If the String ends in {@code \r\n}, then remove both
     * of them.</p>
     *
     * <pre>
     * StringUtils.chop(null)          = null
     * StringUtils.chop("")            = ""
     * StringUtils.chop("abc \r")      = "abc "
     * StringUtils.chop("abc\n")       = "abc"
     * StringUtils.chop("abc\r\n")     = "abc"
     * StringUtils.chop("abc")         = "ab"
     * StringUtils.chop("abc\nabc")    = "abc\nab"
     * StringUtils.chop("a")           = ""
     * StringUtils.chop("\r")          = ""
     * StringUtils.chop("\n")          = ""
     * StringUtils.chop("\r\n")        = ""
     * </pre>
     *
     * @param str the String to chop last character from, may be null
     * @return String without last character, {@code null} if null String input
     */
    public static String chop(final String str) {
        if (str == null) {
            return null;
        }
        final int strLen = str.length();
        if (strLen < 2) {
            return EMPTY;
        }
        final int lastIdx = strLen - 1;
        final String ret = str.substring(0, lastIdx);
        final char last = str.charAt(lastIdx);
        if (last == CharUtils.LF && ret.charAt(lastIdx - 1) == CharUtils.CR) {
            return ret.substring(0, lastIdx - 1);
        }
        return ret;
    }

    /**
     * <p>Compare two Strings lexicographically, as per {@link String#compareTo(String)}, returning :</p>
     * <ul>
     *  <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both {@code null})</li>
     *  <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
     *  <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
     * </ul>
     *
     * <p>This is a {@code null} safe version of :</p>
     * <blockquote><pre>str1.compareTo(str2)</pre></blockquote>
     *
     * <p>{@code null} value is considered less than non-{@code null} value.
     * Two {@code null} references are considered equal.</p>
     *
     * <pre>
     * StringUtils.compare(null, null)   = 0
     * StringUtils.compare(null , "a")   &lt; 0
     * StringUtils.compare("a", null)    &gt; 0
     * StringUtils.compare("abc", "abc") = 0
     * StringUtils.compare("a", "b")     &lt; 0
     * StringUtils.compare("b", "a")     &gt; 0
     * StringUtils.compare("a", "B")     &gt; 0
     * StringUtils.compare("ab", "abc")  &lt; 0
     * </pre>
     *
     * @param str1 the String to compare from
     * @param str2 the String to compare to
     * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal or greater than {@code str2}
     * @see #compare(String, String, boolean)
     * @see String#compareTo(String)
     * @since 3.5
     */
    public static int compare(final String str1, final String str2) {
        return compare(str1, str2, true);
    }

    /**
     * <p>Compare two Strings lexicographically, as per {@link String#compareTo(String)}, returning :</p>
     * <ul>
     *  <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both {@code null})</li>
     *  <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
     *  <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
     * </ul>
     *
     * <p>This is a {@code null} safe version of :</p>
     * <blockquote><pre>str1.compareTo(str2)</pre></blockquote>
     *
     * <p>{@code null} inputs are handled according to the {@code nullIsLess} parameter.
     * Two {@code null} references are considered equal.</p>
     *
     * <pre>
     * StringUtils.compare(null, null, *)     = 0
     * StringUtils.compare(null , "a", true)  &lt; 0
     * StringUtils.compare(null , "a", false) &gt; 0
     * StringUtils.compare("a", null, true)   &gt; 0
     * StringUtils.compare("a", null, false)  &lt; 0
     * StringUtils.compare("abc", "abc", *)   = 0
     * StringUtils.compare("a", "b", *)       &lt; 0
     * StringUtils.compare("b", "a", *)       &gt; 0
     * StringUtils.compare("a", "B", *)       &gt; 0
     * StringUtils.compare("ab", "abc", *)    &lt; 0
     * </pre>
     *
     * @param str1       the String to compare from
     * @param str2       the String to compare to
     * @param nullIsLess whether consider {@code null} value less than non-{@code null} value
     * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal ou greater than {@code str2}
     * @see String#compareTo(String)
     * @since 3.5
     */
    public static int compare(final String str1, final String str2, final boolean nullIsLess) {
        if (str1 == str2) { // NOSONARLINT this intentionally uses == to allow for both null
            return 0;
        }
        if (str1 == null) {
            return nullIsLess ? -1 : 1;
        }
        if (str2 == null) {
            return nullIsLess ? 1 : -1;
        }
        return str1.compareTo(str2);
    }

    /**
     * <p>Compare two Strings lexicographically, ignoring case differences,
     * as per {@link String#compareToIgnoreCase(String)}, returning :</p>
     * <ul>
     *  <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both {@code null})</li>
     *  <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
     *  <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
     * </ul>
     *
     * <p>This is a {@code null} safe version of :</p>
     * <blockquote><pre>str1.compareToIgnoreCase(str2)</pre></blockquote>
     *
     * <p>{@code null} value is considered less than non-{@code null} value.
     * Two {@code null} references are considered equal.
     * Comparison is case insensitive.</p>
     *
     * <pre>
     * StringUtils.compareIgnoreCase(null, null)   = 0
     * StringUtils.compareIgnoreCase(null , "a")   &lt; 0
     * StringUtils.compareIgnoreCase("a", null)    &gt; 0
     * StringUtils.compareIgnoreCase("abc", "abc") = 0
     * StringUtils.compareIgnoreCase("abc", "ABC") = 0
     * StringUtils.compareIgnoreCase("a", "b")     &lt; 0
     * StringUtils.compareIgnoreCase("b", "a")     &gt; 0
     * StringUtils.compareIgnoreCase("a", "B")     &lt; 0
     * StringUtils.compareIgnoreCase("A", "b")     &lt; 0
     * StringUtils.compareIgnoreCase("ab", "ABC")  &lt; 0
     * </pre>
     *
     * @param str1 the String to compare from
     * @param str2 the String to compare to
     * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal ou greater than {@code str2},
     * ignoring case differences.
     * @see #compareIgnoreCase(String, String, boolean)
     * @see String#compareToIgnoreCase(String)
     * @since 3.5
     */
    public static int compareIgnoreCase(final String str1, final String str2) {
        return compareIgnoreCase(str1, str2, true);
    }

    /**
     * <p>Compare two Strings lexicographically, ignoring case differences,
     * as per {@link String#compareToIgnoreCase(String)}, returning :</p>
     * <ul>
     *  <li>{@code int = 0}, if {@code str1} is equal to {@code str2} (or both {@code null})</li>
     *  <li>{@code int < 0}, if {@code str1} is less than {@code str2}</li>
     *  <li>{@code int > 0}, if {@code str1} is greater than {@code str2}</li>
     * </ul>
     *
     * <p>This is a {@code null} safe version of :</p>
     * <blockquote><pre>str1.compareToIgnoreCase(str2)</pre></blockquote>
     *
     * <p>{@code null} inputs are handled according to the {@code nullIsLess} parameter.
     * Two {@code null} references are considered equal.
     * Comparison is case insensitive.</p>
     *
     * <pre>
     * StringUtils.compareIgnoreCase(null, null, *)     = 0
     * StringUtils.compareIgnoreCase(null , "a", true)  &lt; 0
     * StringUtils.compareIgnoreCase(null , "a", false) &gt; 0
     * StringUtils.compareIgnoreCase("a", null, true)   &gt; 0
     * StringUtils.compareIgnoreCase("a", null, false)  &lt; 0
     * StringUtils.compareIgnoreCase("abc", "abc", *)   = 0
     * StringUtils.compareIgnoreCase("abc", "ABC", *)   = 0
     * StringUtils.compareIgnoreCase("a", "b", *)       &lt; 0
     * StringUtils.compareIgnoreCase("b", "a", *)       &gt; 0
     * StringUtils.compareIgnoreCase("a", "B", *)       &lt; 0
     * StringUtils.compareIgnoreCase("A", "b", *)       &lt; 0
     * StringUtils.compareIgnoreCase("ab", "abc", *)    &lt; 0
     * </pre>
     *
     * @param str1       the String to compare from
     * @param str2       the String to compare to
     * @param nullIsLess whether consider {@code null} value less than non-{@code null} value
     * @return &lt; 0, 0, &gt; 0, if {@code str1} is respectively less, equal ou greater than {@code str2},
     * ignoring case differences.
     * @see String#compareToIgnoreCase(String)
     * @since 3.5
     */
    public static int compareIgnoreCase(final String str1, final String str2, final boolean nullIsLess) {
        if (str1 == str2) { // NOSONARLINT this intentionally uses == to allow for both null
            return 0;
        }
        if (str1 == null) {
            return nullIsLess ? -1 : 1;
        }
        if (str2 == null) {
            return nullIsLess ? 1 : -1;
        }
        return str1.compareToIgnoreCase(str2);
    }

    /**
     * <p>Checks if CharSequence contains a search CharSequence, handling {@code null}.
     * This method uses {@link String#indexOf(String)} if possible.</p>
     *
     * <p>A {@code null} CharSequence will return {@code false}.</p>
     *
     * <pre>
     * StringUtils.contains(null, *)     = false
     * StringUtils.contains(*, null)     = false
     * StringUtils.contains("", "")      = true
     * StringUtils.contains("abc", "")   = true
     * StringUtils.contains("abc", "a")  = true
     * StringUtils.contains("abc", "z")  = false
     * </pre>
     *
     * @param seq       the CharSequence to check, may be null
     * @param searchSeq the CharSequence to find, may be null
     * @return true if the CharSequence contains the search CharSequence,
     * false if not or {@code null} string input
     * @since 2.0
     * @since 3.0 Changed signature from contains(String, String) to contains(CharSequence, CharSequence)
     */
    public static boolean contains(final CharSequence seq, final CharSequence searchSeq) {
        if (seq == null || searchSeq == null) {
            return false;
        }
        return CharSequenceUtils.indexOf(seq, searchSeq, 0) >= 0;
    }

    /**
     * <p>Checks if CharSequence contains a search character, handling {@code null}.
     * This method uses {@link String#indexOf(int)} if possible.</p>
     *
     * <p>A {@code null} or empty ("") CharSequence will return {@code false}.</p>
     *
     * <pre>
     * StringUtils.contains(null, *)    = false
     * StringUtils.contains("", *)      = false
     * StringUtils.contains("abc", 'a') = true
     * StringUtils.contains("abc", 'z') = false
     * </pre>
     *
     * @param seq        the CharSequence to check, may be null
     * @param searchChar the character to find
     * @return true if the CharSequence contains the search character,
     * false if not or {@code null} string input
     * @since 2.0
     * @since 3.0 Changed signature from contains(String, int) to contains(CharSequence, int)
     */
    public static boolean contains(final CharSequence seq, final int searchChar) {
        if (isEmpty(seq)) {
            return false;
        }
        return CharSequenceUtils.indexOf(seq, searchChar, 0) >= 0;
    }

    /**
     * <p>Checks if the CharSequence contains any character in the given
     * set of characters.</p>
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} or zero length search array will return {@code false}.</p>
     *
     * <pre>
     * StringUtils.containsAny(null, *)                  = false
     * StringUtils.containsAny("", *)                    = false
     * StringUtils.containsAny(*, null)                  = false
     * StringUtils.containsAny(*, [])                    = false
     * StringUtils.containsAny("zzabyycdxx", ['z', 'a']) = true
     * StringUtils.containsAny("zzabyycdxx", ['b', 'y']) = true
     * StringUtils.containsAny("zzabyycdxx", ['z', 'y']) = true
     * StringUtils.containsAny("aba", ['z'])             = false
     * </pre>
     *
     * @param cs          the CharSequence to check, may be null
     * @param searchChars the chars to search for, may be null
     * @return the {@code true} if any of the chars are found,
     * {@code false} if no match or null input
     * @since 2.4
     * @since 3.0 Changed signature from containsAny(String, char[]) to containsAny(CharSequence, char...)
     */
    public static boolean containsAny(final CharSequence cs, final char... searchChars) {
        if (isEmpty(cs) || ArrayUtils.isEmpty(searchChars)) {
            return false;
        }
        final int csLength = cs.length();
        final int searchLength = searchChars.length;
        final int csLast = csLength - 1;
        final int searchLast = searchLength - 1;
        for (int i = 0; i < csLength; i++) {
            final char ch = cs.charAt(i);
            for (int j = 0; j < searchLength; j++) {
                if (searchChars[j] == ch) {
                    if (Character.isHighSurrogate(ch)) {
                        if (j == searchLast) {
                            // missing low surrogate, fine, like String.indexOf(String)
                            return true;
                        }
                        if (i < csLast && searchChars[j + 1] == cs.charAt(i + 1)) {
                            return true;
                        }
                    } else {
                        // ch is in the Basic Multilingual Plane
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * <p>
     * Checks if the CharSequence contains any character in the given set of characters.
     * </p>
     *
     * <p>
     * A {@code null} CharSequence will return {@code false}. A {@code null} search CharSequence will return
     * {@code false}.
     * </p>
     *
     * <pre>
     * StringUtils.containsAny(null, *)               = false
     * StringUtils.containsAny("", *)                 = false
     * StringUtils.containsAny(*, null)               = false
     * StringUtils.containsAny(*, "")                 = false
     * StringUtils.containsAny("zzabyycdxx", "za")    = true
     * StringUtils.containsAny("zzabyycdxx", "by")    = true
     * StringUtils.containsAny("zzabyycdxx", "zy")    = true
     * StringUtils.containsAny("zzabyycdxx", "\tx")   = true
     * StringUtils.containsAny("zzabyycdxx", "$.#yF") = true
     * StringUtils.containsAny("aba", "z")            = false
     * </pre>
     *
     * @param cs          the CharSequence to check, may be null
     * @param searchChars the chars to search for, may be null
     * @return the {@code true} if any of the chars are found, {@code false} if no match or null input
     * @since 2.4
     * @since 3.0 Changed signature from containsAny(String, String) to containsAny(CharSequence, CharSequence)
     */
    public static boolean containsAny(final CharSequence cs, final CharSequence searchChars) {
        if (searchChars == null) {
            return false;
        }
        return containsAny(cs, CharSequenceUtils.toCharArray(searchChars));
    }

    /**
     * <p>
     * Checks if the CharSequence contains any of the CharSequences in the given array.
     * </p>
     *
     * <p>
     * A {@code null} {@code cs} CharSequence will return {@code false}. A {@code null} or zero length search array will
     * return {@code false}.
     * </p>
     *
     * <pre>
     * StringUtils.containsAny(null, *)            = false
     * StringUtils.containsAny("", *)              = false
     * StringUtils.containsAny(*, null)            = false
     * StringUtils.containsAny(*, [])              = false
     * StringUtils.containsAny("abcd", "ab", null) = true
     * StringUtils.containsAny("abcd", "ab", "cd") = true
     * StringUtils.containsAny("abc", "d", "abc")  = true
     * </pre>
     *
     * @param cs                  The CharSequence to check, may be null
     * @param searchCharSequences The array of CharSequences to search for, may be null. Individual CharSequences may be
     *                            null as well.
     * @return {@code true} if any of the search CharSequences are found, {@code false} otherwise
     * @since 3.4
     */
    public static boolean containsAny(final CharSequence cs, final CharSequence... searchCharSequences) {
        return containsAny(StringUtils::contains, cs, searchCharSequences);
    }

    /**
     * <p>
     * Checks if the CharSequence contains any of the CharSequences in the given array.
     * </p>
     *
     * <p>
     * A {@code null} {@code cs} CharSequence will return {@code false}. A {@code null} or zero length search array will
     * return {@code false}.
     * </p>
     *
     * @param cs                  The CharSequence to check, may be null
     * @param searchCharSequences The array of CharSequences to search for, may be null. Individual CharSequences may be
     *                            null as well.
     * @return {@code true} if any of the search CharSequences are found, {@code false} otherwise
     * @since 3.12.0
     */
    private static boolean containsAny(final ToBooleanBiFunction<CharSequence, CharSequence> test,
                                       final CharSequence cs, final CharSequence... searchCharSequences) {
        if (isEmpty(cs) || ArrayUtils.isEmpty(searchCharSequences)) {
            return false;
        }
        for (final CharSequence searchCharSequence : searchCharSequences) {
            if (test.applyAsBoolean(cs, searchCharSequence)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Checks if the CharSequence contains any of the CharSequences in the given array, ignoring case.
     * </p>
     *
     * <p>
     * A {@code null} {@code cs} CharSequence will return {@code false}. A {@code null} or zero length search array will
     * return {@code false}.
     * </p>
     *
     * <pre>
     * StringUtils.containsAny(null, *)            = false
     * StringUtils.containsAny("", *)              = false
     * StringUtils.containsAny(*, null)            = false
     * StringUtils.containsAny(*, [])              = false
     * StringUtils.containsAny("abcd", "ab", null) = true
     * StringUtils.containsAny("abcd", "ab", "cd") = true
     * StringUtils.containsAny("abc", "d", "abc")  = true
     * StringUtils.containsAny("abc", "D", "ABC")  = true
     * StringUtils.containsAny("ABC", "d", "abc")  = true
     * </pre>
     *
     * @param cs                  The CharSequence to check, may be null
     * @param searchCharSequences The array of CharSequences to search for, may be null. Individual CharSequences may be
     *                            null as well.
     * @return {@code true} if any of the search CharSequences are found, {@code false} otherwise
     * @since 3.12.0
     */
    public static boolean containsAnyIgnoreCase(final CharSequence cs, final CharSequence... searchCharSequences) {
        return containsAny(StringUtils::containsIgnoreCase, cs, searchCharSequences);
    }

    /**
     * <p>Checks if CharSequence contains a search CharSequence irrespective of case,
     * handling {@code null}. Case-insensitivity is defined as by
     * {@link String#equalsIgnoreCase(String)}.
     *
     * <p>A {@code null} CharSequence will return {@code false}.</p>
     *
     * <pre>
     * StringUtils.containsIgnoreCase(null, *) = false
     * StringUtils.containsIgnoreCase(*, null) = false
     * StringUtils.containsIgnoreCase("", "") = true
     * StringUtils.containsIgnoreCase("abc", "") = true
     * StringUtils.containsIgnoreCase("abc", "a") = true
     * StringUtils.containsIgnoreCase("abc", "z") = false
     * StringUtils.containsIgnoreCase("abc", "A") = true
     * StringUtils.containsIgnoreCase("abc", "Z") = false
     * </pre>
     *
     * @param str       the CharSequence to check, may be null
     * @param searchStr the CharSequence to find, may be null
     * @return true if the CharSequence contains the search CharSequence irrespective of
     * case or false if not or {@code null} string input
     * @since 3.0 Changed signature from containsIgnoreCase(String, String) to containsIgnoreCase(CharSequence, CharSequence)
     */
    public static boolean containsIgnoreCase(final CharSequence str, final CharSequence searchStr) {
        if (str == null || searchStr == null) {
            return false;
        }
        final int len = searchStr.length();
        final int max = str.length() - len;
        for (int i = 0; i <= max; i++) {
            if (CharSequenceUtils.regionMatches(str, true, i, searchStr, 0, len)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>Checks that the CharSequence does not contain certain characters.</p>
     *
     * <p>A {@code null} CharSequence will return {@code true}.
     * A {@code null} invalid character array will return {@code true}.
     * An empty CharSequence (length()=0) always returns true.</p>
     *
     * <pre>
     * StringUtils.containsNone(null, *)       = true
     * StringUtils.containsNone(*, null)       = true
     * StringUtils.containsNone("", *)         = true
     * StringUtils.containsNone("ab", '')      = true
     * StringUtils.containsNone("abab", 'xyz') = true
     * StringUtils.containsNone("ab1", 'xyz')  = true
     * StringUtils.containsNone("abz", 'xyz')  = false
     * </pre>
     *
     * @param cs          the CharSequence to check, may be null
     * @param searchChars an array of invalid chars, may be null
     * @return true if it contains none of the invalid chars, or is null
     * @since 2.0
     * @since 3.0 Changed signature from containsNone(String, char[]) to containsNone(CharSequence, char...)
     */
    public static boolean containsNone(final CharSequence cs, final char... searchChars) {
        if (cs == null || searchChars == null) {
            return true;
        }
        final int csLen = cs.length();
        final int csLast = csLen - 1;
        final int searchLen = searchChars.length;
        final int searchLast = searchLen - 1;
        for (int i = 0; i < csLen; i++) {
            final char ch = cs.charAt(i);
            for (int j = 0; j < searchLen; j++) {
                if (searchChars[j] == ch) {
                    if (Character.isHighSurrogate(ch)) {
                        if (j == searchLast) {
                            // missing low surrogate, fine, like String.indexOf(String)
                            return false;
                        }
                        if (i < csLast && searchChars[j + 1] == cs.charAt(i + 1)) {
                            return false;
                        }
                    } else {
                        // ch is in the Basic Multilingual Plane
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * <p>Checks that the CharSequence does not contain certain characters.</p>
     *
     * <p>A {@code null} CharSequence will return {@code true}.
     * A {@code null} invalid character array will return {@code true}.
     * An empty String ("") always returns true.</p>
     *
     * <pre>
     * StringUtils.containsNone(null, *)       = true
     * StringUtils.containsNone(*, null)       = true
     * StringUtils.containsNone("", *)         = true
     * StringUtils.containsNone("ab", "")      = true
     * StringUtils.containsNone("abab", "xyz") = true
     * StringUtils.containsNone("ab1", "xyz")  = true
     * StringUtils.containsNone("abz", "xyz")  = false
     * </pre>
     *
     * @param cs           the CharSequence to check, may be null
     * @param invalidChars a String of invalid chars, may be null
     * @return true if it contains none of the invalid chars, or is null
     * @since 2.0
     * @since 3.0 Changed signature from containsNone(String, String) to containsNone(CharSequence, String)
     */
    public static boolean containsNone(final CharSequence cs, final String invalidChars) {
        if (invalidChars == null) {
            return true;
        }
        return containsNone(cs, invalidChars.toCharArray());
    }

    /**
     * <p>Checks if the CharSequence contains only certain characters.</p>
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} valid character array will return {@code false}.
     * An empty CharSequence (length()=0) always returns {@code true}.</p>
     *
     * <pre>
     * StringUtils.containsOnly(null, *)       = false
     * StringUtils.containsOnly(*, null)       = false
     * StringUtils.containsOnly("", *)         = true
     * StringUtils.containsOnly("ab", '')      = false
     * StringUtils.containsOnly("abab", 'abc') = true
     * StringUtils.containsOnly("ab1", 'abc')  = false
     * StringUtils.containsOnly("abz", 'abc')  = false
     * </pre>
     *
     * @param cs    the String to check, may be null
     * @param valid an array of valid chars, may be null
     * @return true if it only contains valid chars and is non-null
     * @since 3.0 Changed signature from containsOnly(String, char[]) to containsOnly(CharSequence, char...)
     */
    public static boolean containsOnly(final CharSequence cs, final char... valid) {
        // All these pre-checks are to maintain API with an older version
        if (valid == null || cs == null) {
            return false;
        }
        if (cs.length() == 0) {
            return true;
        }
        if (valid.length == 0) {
            return false;
        }
        return indexOfAnyBut(cs, valid) == INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if the CharSequence contains only certain characters.</p>
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} valid character String will return {@code false}.
     * An empty String (length()=0) always returns {@code true}.</p>
     *
     * <pre>
     * StringUtils.containsOnly(null, *)       = false
     * StringUtils.containsOnly(*, null)       = false
     * StringUtils.containsOnly("", *)         = true
     * StringUtils.containsOnly("ab", "")      = false
     * StringUtils.containsOnly("abab", "abc") = true
     * StringUtils.containsOnly("ab1", "abc")  = false
     * StringUtils.containsOnly("abz", "abc")  = false
     * </pre>
     *
     * @param cs         the CharSequence to check, may be null
     * @param validChars a String of valid chars, may be null
     * @return true if it only contains valid chars and is non-null
     * @since 2.0
     * @since 3.0 Changed signature from containsOnly(String, String) to containsOnly(CharSequence, String)
     */
    public static boolean containsOnly(final CharSequence cs, final String validChars) {
        if (cs == null || validChars == null) {
            return false;
        }
        return containsOnly(cs, validChars.toCharArray());
    }

    /**
     * <p>Check whether the given CharSequence contains any whitespace characters.</p>
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
     *
     * @param seq the CharSequence to check (may be {@code null})
     * @return {@code true} if the CharSequence is not empty and
     * contains at least 1 (breaking) whitespace character
     * @since 3.0
     */
    // From org.springframework.util.StringUtils, under Apache License 2.0
    public static boolean containsWhitespace(final CharSequence seq) {
        if (isEmpty(seq)) {
            return false;
        }
        final int strLen = seq.length();
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(seq.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static void convertRemainingAccentCharacters(final StringBuilder decomposed) {
        for (int i = 0; i < decomposed.length(); i++) {
            if (decomposed.charAt(i) == '\u0141') {
                decomposed.setCharAt(i, 'L');
            } else if (decomposed.charAt(i) == '\u0142') {
                decomposed.setCharAt(i, 'l');
            }
        }
    }

    /**
     * <p>Counts how many times the char appears in the given string.</p>
     *
     * <p>A {@code null} or empty ("") String input returns {@code 0}.</p>
     *
     * <pre>
     * StringUtils.countMatches(null, *)       = 0
     * StringUtils.countMatches("", *)         = 0
     * StringUtils.countMatches("abba", 0)  = 0
     * StringUtils.countMatches("abba", 'a')   = 2
     * StringUtils.countMatches("abba", 'b')  = 2
     * StringUtils.countMatches("abba", 'x') = 0
     * </pre>
     *
     * @param str the CharSequence to check, may be null
     * @param ch  the char to count
     * @return the number of occurrences, 0 if the CharSequence is {@code null}
     * @since 3.4
     */
    public static int countMatches(final CharSequence str, final char ch) {
        if (isEmpty(str)) {
            return 0;
        }
        int count = 0;
        // We could also call str.toCharArray() for faster look ups but that would generate more garbage.
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * <p>Returns either the passed in CharSequence, or if the CharSequence is
     * whitespace, empty ("") or {@code null}, the value of {@code defaultStr}.</p>
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
     *
     * <pre>
     * StringUtils.defaultIfBlank(null, "NULL")  = "NULL"
     * StringUtils.defaultIfBlank("", "NULL")    = "NULL"
     * StringUtils.defaultIfBlank(" ", "NULL")   = "NULL"
     * StringUtils.defaultIfBlank("bat", "NULL") = "bat"
     * StringUtils.defaultIfBlank("", null)      = null
     * </pre>
     *
     * @param <T>        the specific kind of CharSequence
     * @param str        the CharSequence to check, may be null
     * @param defaultStr the default CharSequence to return
     *                   if the input is whitespace, empty ("") or {@code null}, may be null
     * @return the passed in CharSequence, or the default
     * @see StringUtils#defaultString(String, String)
     */
    public static <T extends CharSequence> T defaultIfBlank(final T str, final T defaultStr) {
        return isBlank(str) ? defaultStr : str;
    }

    /**
     * <p>Returns either the passed in CharSequence, or if the CharSequence is
     * empty or {@code null}, the value of {@code defaultStr}.</p>
     * <p>
     * public static <T extends CharSequence> T defaultIfEmpty(final T str, final T defaultStr) {
     * return isEmpty(str) ? defaultStr : str;
     * }
     * <p>
     * <p>
     * /**
     * <p>Counts how many times the substring appears in the larger string.
     * Note that the code only counts non-overlapping matches.</p>
     *
     * <p>A {@code null} or empty ("") String input returns {@code 0}.</p>
     *
     * <pre>
     * StringUtils.countMatches(null, *)       = 0
     * StringUtils.countMatches("", *)         = 0
     * StringUtils.countMatches("abba", null)  = 0
     * StringUtils.countMatches("abba", "")    = 0
     * StringUtils.countMatches("abba", "a")   = 2
     * StringUtils.countMatches("abba", "ab")  = 1
     * StringUtils.countMatches("abba", "xxx") = 0
     * StringUtils.countMatches("ababa", "aba") = 1
     * </pre>
     *
     * @param str the CharSequence to check, may be null
     * @param sub the substring to count, may be null
     * @return the number of occurrences, 0 if either CharSequence is {@code null}
     * @since 3.0 Changed signature from countMatches(String, String) to countMatches(CharSequence, CharSequence)
     */
    public static int countMatches(final CharSequence str, final CharSequence sub) {
        if (isEmpty(str) || isEmpty(sub)) {
            return 0;
        }
        int idx = 0;
        int count = 0;
        while ((idx = CharSequenceUtils.indexOf(str, sub, idx)) != INDEX_NOT_FOUND) {
            count++;
            idx += sub.length();
        }
        return count;
    }

    /**
     * <p>Returns either the passed in String,
     * or if the String is {@code null}, an empty String ("").</p>
     *
     * <pre>
     * StringUtils.defaultString(null)  = ""
     * StringUtils.defaultString("")    = ""
     * StringUtils.defaultString("bat") = "bat"
     * </pre>
     *
     * @param str the String to check, may be null
     * @return the passed in String, or the empty String if it
     * was {@code null}
     * @see ObjectUtils#toString(Object)
     * @see String#valueOf(Object)
     */
    public static String defaultString(final String str) {
        return defaultString(str, EMPTY);
    }

    /**
     * <p>Returns either the passed in String, or if the String is
     * {@code null}, the value of {@code defaultStr}.</p>
     *
     * <pre>
     * StringUtils.defaultString(null, "NULL")  = "NULL"
     * StringUtils.defaultString("", "NULL")    = ""
     * StringUtils.defaultString("bat", "NULL") = "bat"
     * </pre>
     *
     * @param str        the String to check, may be null
     * @param defaultStr the default String to return
     *                   if the input is {@code null}, may be null
     * @return the passed in String, or the default if it was {@code null}
     * @see ObjectUtils#toString(Object, String)
     * @see String#valueOf(Object)
     */
    public static String defaultString(final String str, final String defaultStr) {
        return str == null ? defaultStr : str;
    }

    /**
     * <p>Deletes all whitespaces from a String as defined by
     * {@link Character#isWhitespace(char)}.</p>
     *
     * <pre>
     * StringUtils.deleteWhitespace(null)         = null
     * StringUtils.deleteWhitespace("")           = ""
     * StringUtils.deleteWhitespace("abc")        = "abc"
     * StringUtils.deleteWhitespace("   ab  c  ") = "abc"
     * </pre>
     *
     * @param str the String to delete whitespace from, may be null
     * @return the String without whitespaces, {@code null} if null String input
     */
    public static String deleteWhitespace(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        final int sz = str.length();
        final char[] chs = new char[sz];
        int count = 0;
        for (int i = 0; i < sz; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                chs[count++] = str.charAt(i);
            }
        }
        if (count == sz) {
            return str;
        }
        if (count == 0) {
            return EMPTY;
        }
        return new String(chs, 0, count);
    }

    private static int indexOfDifference(String str1, String str2) {
        return 0;
    }

    /**
     * <p>Compares two Strings, and returns the portion where they differ.
     * More precisely, return the remainder of the second String,
     * starting from where it's different from the first. This means that
     * the difference between "abc" and "ab" is the empty String and not "c". </p>
     *
     * <p>For example,
     * {@code difference("i am a machine", "i am a robot") -> "robot"}.</p>
     *
     * <pre>
     * StringUtils.difference(null, null) = null
     * StringUtils.difference("", "") = ""
     * StringUtils.difference("", "abc") = "abc"
     * StringUtils.difference("abc", "") = ""
     * StringUtils.difference("abc", "abc") = ""
     * StringUtils.difference("abc", "ab") = ""
     * StringUtils.difference("ab", "abxyz") = "xyz"
     * StringUtils.difference("abcde", "abxyz") = "xyz"
     * StringUtils.difference("abcde", "xyz") = "xyz"
     * </pre>
     *
     * @param str1 the first String, may be null
     * @param str2 the second String, may be null
     * @return the portion of str2 where it differs from str1; returns the
     * empty String if they are equal
     * @since 2.0
     */
    public static String difference(final String str1, final String str2) {
        if (str1 == null) {
            return str2;
        }
        if (str2 == null) {
            return str1;
        }
        final int at = indexOfDifference(str1, str2);
        if (at == INDEX_NOT_FOUND) {
            return EMPTY;
        }
        return str2.substring(at);
    }

    /**
     * <p>Check if a CharSequence ends with a specified suffix.</p>
     *
     * <p>{@code null}s are handled without exceptions. Two {@code null}
     * references are considered to be equal. The comparison is case sensitive.</p>
     *
     * <pre>
     * StringUtils.endsWith(null, null)      = true
     * StringUtils.endsWith(null, "def")     = false
     * StringUtils.endsWith("abcdef", null)  = false
     * StringUtils.endsWith("abcdef", "def") = true
     * StringUtils.endsWith("ABCDEF", "def") = false
     * StringUtils.endsWith("ABCDEF", "cde") = false
     * StringUtils.endsWith("ABCDEF", "")    = true
     * </pre>
     *
     * @param str    the CharSequence to check, may be null
     * @param suffix the suffix to find, may be null
     * @return {@code true} if the CharSequence ends with the suffix, case sensitive, or
     * both {@code null}
     * @see String#endsWith(String)
     * @since 2.4
     * @since 3.0 Changed signature from endsWith(String, String) to endsWith(CharSequence, CharSequence)
     */
    public static boolean endsWith(final CharSequence str, final CharSequence suffix) {
        return endsWith(str, suffix, false);
    }

    /**
     * <p>Check if a CharSequence ends with a specified suffix (optionally case insensitive).</p>
     *
     * @param str        the CharSequence to check, may be null
     * @param suffix     the suffix to find, may be null
     * @param ignoreCase indicates whether the compare should ignore case
     *                   (case insensitive) or not.
     * @return {@code true} if the CharSequence starts with the prefix or
     * both {@code null}
     * @see String#endsWith(String)
     */
    private static boolean endsWith(final CharSequence str, final CharSequence suffix, final boolean ignoreCase) {
        if (str == null || suffix == null) {
            return str == suffix;
        }
        if (suffix.length() > str.length()) {
            return false;
        }
        final int strOffset = str.length() - suffix.length();
        return CharSequenceUtils.regionMatches(str, ignoreCase, strOffset, suffix, 0, suffix.length());
    }

    /**
     * <p>Check if a CharSequence ends with any of the provided case-sensitive suffixes.</p>
     *
     * <pre>
     * StringUtils.endsWithAny(null, null)      = false
     * StringUtils.endsWithAny(null, new String[] {"abc"})  = false
     * StringUtils.endsWithAny("abcxyz", null)     = false
     * StringUtils.endsWithAny("abcxyz", new String[] {""}) = true
     * StringUtils.endsWithAny("abcxyz", new String[] {"xyz"}) = true
     * StringUtils.endsWithAny("abcxyz", new String[] {null, "xyz", "abc"}) = true
     * StringUtils.endsWithAny("abcXYZ", "def", "XYZ") = true
     * StringUtils.endsWithAny("abcXYZ", "def", "xyz") = false
     * </pre>
     *
     * @param sequence      the CharSequence to check, may be null
     * @param searchStrings the case-sensitive CharSequences to find, may be empty or contain {@code null}
     * @return {@code true} if the input {@code sequence} is {@code null} AND no {@code searchStrings} are provided, or
     * the input {@code sequence} ends in any of the provided case-sensitive {@code searchStrings}.
     * @see StringUtils#endsWith(CharSequence, CharSequence)
     * @since 3.0
     */
    public static boolean endsWithAny(final CharSequence sequence, final CharSequence... searchStrings) {
        if (isEmpty(sequence) || ArrayUtils.isEmpty(searchStrings)) {
            return false;
        }
        for (final CharSequence searchString : searchStrings) {
            if (endsWith(sequence, searchString)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>Case insensitive check if a CharSequence ends with a specified suffix.</p>
     *
     * <p>{@code null}s are handled without exceptions. Two {@code null}
     * references are considered to be equal. The comparison is case insensitive.</p>
     *
     * <pre>
     * StringUtils.endsWithIgnoreCase(null, null)      = true
     * StringUtils.endsWithIgnoreCase(null, "def")     = false
     * StringUtils.endsWithIgnoreCase("abcdef", null)  = false
     * StringUtils.endsWithIgnoreCase("abcdef", "def") = true
     * StringUtils.endsWithIgnoreCase("ABCDEF", "def") = true
     * StringUtils.endsWithIgnoreCase("ABCDEF", "cde") = false
     * </pre>
     *
     * @param str    the CharSequence to check, may be null
     * @param suffix the suffix to find, may be null
     * @return {@code true} if the CharSequence ends with the suffix, case insensitive, or
     * both {@code null}
     * @see String#endsWith(String)
     * @since 2.4
     * @since 3.0 Changed signature from endsWithIgnoreCase(String, String) to endsWithIgnoreCase(CharSequence, CharSequence)
     */
    public static boolean endsWithIgnoreCase(final CharSequence str, final CharSequence suffix) {
        return endsWith(str, suffix, true);
    }

    /**
     * <p>Compares two CharSequences, returning {@code true} if they represent
     * equal sequences of characters.</p>
     *
     * <p>{@code null}s are handled without exceptions. Two {@code null}
     * references are considered to be equal. The comparison is <strong>case sensitive</strong>.</p>
     *
     * <pre>
     * StringUtils.equals(null, null)   = true
     * StringUtils.equals(null, "abc")  = false
     * StringUtils.equals("abc", null)  = false
     * StringUtils.equals("abc", "abc") = true
     * StringUtils.equals("abc", "ABC") = false
     * </pre>
     *
     * @param cs1 the first CharSequence, may be {@code null}
     * @param cs2 the second CharSequence, may be {@code null}
     * @return {@code true} if the CharSequences are equal (case-sensitive), or both {@code null}
     * @see Object#equals(Object)
     * @see #equalsIgnoreCase(CharSequence, CharSequence)
     * @since 3.0 Changed signature from equals(String, String) to equals(CharSequence, CharSequence)
     */
    public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
        if (cs1 == cs2) {
            return true;
        }
        if (cs1 == null || cs2 == null) {
            return false;
        }
        if (cs1.length() != cs2.length()) {
            return false;
        }
        if (cs1 instanceof String && cs2 instanceof String) {
            return cs1.equals(cs2);
        }
        // Step-wise comparison
        final int length = cs1.length();
        for (int i = 0; i < length; i++) {
            if (cs1.charAt(i) != cs2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>Compares given {@code string} to a CharSequences vararg of {@code searchStrings},
     * returning {@code true} if the {@code string} is equal to any of the {@code searchStrings}.</p>
     *
     * <pre>
     * StringUtils.equalsAny(null, (CharSequence[]) null) = false
     * StringUtils.equalsAny(null, null, null)    = true
     * StringUtils.equalsAny(null, "abc", "def")  = false
     * StringUtils.equalsAny("abc", null, "def")  = false
     * StringUtils.equalsAny("abc", "abc", "def") = true
     * StringUtils.equalsAny("abc", "ABC", "DEF") = false
     * </pre>
     *
     * @param string        to compare, may be {@code null}.
     * @param searchStrings a vararg of strings, may be {@code null}.
     * @return {@code true} if the string is equal (case-sensitive) to any other element of {@code searchStrings};
     * {@code false} if {@code searchStrings} is null or contains no matches.
     * @since 3.5
     */
    public static boolean equalsAny(final CharSequence string, final CharSequence... searchStrings) {
        if (ArrayUtils.isNotEmpty(searchStrings)) {
            for (final CharSequence next : searchStrings) {
                if (equals(string, next)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <p>Compares given {@code string} to a CharSequences vararg of {@code searchStrings},
     * returning {@code true} if the {@code string} is equal to any of the {@code searchStrings}, ignoring case.</p>
     *
     * <pre>
     * StringUtils.equalsAnyIgnoreCase(null, (CharSequence[]) null) = false
     * StringUtils.equalsAnyIgnoreCase(null, null, null)    = true
     * StringUtils.equalsAnyIgnoreCase(null, "abc", "def")  = false
     * StringUtils.equalsAnyIgnoreCase("abc", null, "def")  = false
     * StringUtils.equalsAnyIgnoreCase("abc", "abc", "def") = true
     * StringUtils.equalsAnyIgnoreCase("abc", "ABC", "DEF") = true
     * </pre>
     *
     * @param string        to compare, may be {@code null}.
     * @param searchStrings a vararg of strings, may be {@code null}.
     * @return {@code true} if the string is equal (case-insensitive) to any other element of {@code searchStrings};
     * {@code false} if {@code searchStrings} is null or contains no matches.
     * @since 3.5
     */
    public static boolean equalsAnyIgnoreCase(final CharSequence string, final CharSequence... searchStrings) {
        if (ArrayUtils.isNotEmpty(searchStrings)) {
            for (final CharSequence next : searchStrings) {
                if (equalsIgnoreCase(string, next)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <p>Compares two CharSequences, returning {@code true} if they represent
     * equal sequences of characters, ignoring case.</p>
     *
     * <p>{@code null}s are handled without exceptions. Two {@code null}
     * references are considered equal. The comparison is <strong>case insensitive</strong>.</p>
     *
     * <pre>
     * StringUtils.equalsIgnoreCase(null, null)   = true
     * StringUtils.equalsIgnoreCase(null, "abc")  = false
     * StringUtils.equalsIgnoreCase("abc", null)  = false
     * StringUtils.equalsIgnoreCase("abc", "abc") = true
     * StringUtils.equalsIgnoreCase("abc", "ABC") = true
     * </pre>
     *
     * @param cs1 the first CharSequence, may be {@code null}
     * @param cs2 the second CharSequence, may be {@code null}
     * @return {@code true} if the CharSequences are equal (case-insensitive), or both {@code null}
     * @see #equals(CharSequence, CharSequence)
     * @since 3.0 Changed signature from equalsIgnoreCase(String, String) to equalsIgnoreCase(CharSequence, CharSequence)
     */
    public static boolean equalsIgnoreCase(final CharSequence cs1, final CharSequence cs2) {
        if (cs1 == cs2) {
            return true;
        }
        if (cs1 == null || cs2 == null) {
            return false;
        }
        if (cs1.length() != cs2.length()) {
            return false;
        }
        return CharSequenceUtils.regionMatches(cs1, true, 0, cs2, 0, cs1.length());
    }

    /**
     * <p>Returns the first value in the array which is not empty (""),
     * {@code null} or whitespace only.</p>
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
     *
     * <p>If all values are blank or the array is {@code null}
     * or empty then {@code null} is returned.</p>
     *
     * <pre>
     * StringUtils.firstNonBlank(null, null, null)     = null
     * StringUtils.firstNonBlank(null, "", " ")        = null
     * StringUtils.firstNonBlank("abc")                = "abc"
     * StringUtils.firstNonBlank(null, "xyz")          = "xyz"
     * StringUtils.firstNonBlank(null, "", " ", "xyz") = "xyz"
     * StringUtils.firstNonBlank(null, "xyz", "abc")   = "xyz"
     * StringUtils.firstNonBlank()                     = null
     * </pre>
     *
     * @param <T>    the specific kind of CharSequence
     * @param values the values to test, may be {@code null} or empty
     * @return the first value from {@code values} which is not blank,
     * or {@code null} if there are no non-blank values
     * @since 3.8
     */
    @SafeVarargs
    public static <T extends CharSequence> T firstNonBlank(final T... values) {
        if (values != null) {
            for (final T val : values) {
                if (isNotBlank(val)) {
                    return val;
                }
            }
        }
        return null;
    }

    /**
     * <p>Returns the first value in the array which is not empty.</p>
     *
     * <p>If all values are empty or the array is {@code null}
     * or empty then {@code null} is returned.</p>
     *
     * <pre>
     * StringUtils.firstNonEmpty(null, null, null)   = null
     * StringUtils.firstNonEmpty(null, null, "")     = null
     * StringUtils.firstNonEmpty(null, "", " ")      = " "
     * StringUtils.firstNonEmpty("abc")              = "abc"
     * StringUtils.firstNonEmpty(null, "xyz")        = "xyz"
     * StringUtils.firstNonEmpty("", "xyz")          = "xyz"
     * StringUtils.firstNonEmpty(null, "xyz", "abc") = "xyz"
     * StringUtils.firstNonEmpty()                   = null
     * </pre>
     *
     * @param <T>    the specific kind of CharSequence
     * @param values the values to test, may be {@code null} or empty
     * @return the first value from {@code values} which is not empty,
     * or {@code null} if there are no non-empty values
     * @since 3.8
     */
    @SafeVarargs
    public static <T extends CharSequence> T firstNonEmpty(final T... values) {
        if (values != null) {
            for (final T val : values) {
                if (isNotEmpty(val)) {
                    return val;
                }
            }
        }
        return null;
    }

    /**
     * Calls {@link String#getBytes(Charset)} in a null-safe manner.
     *
     * @param string  input string
     * @param charset The {@link Charset} to encode the {@code String}. If null, then use the default Charset.
     * @return The empty byte[] if {@code string} is null, the result of {@link String#getBytes(Charset)} otherwise.
     * @see String#getBytes(Charset)
     * @since 3.10
     */
    public static byte[] getBytes(final String string, final Charset charset) {
        return string == null ? ArrayUtils.EMPTY_BYTE_ARRAY : string.getBytes(Charsets.toCharset(charset));
    }

    /**
     * Calls {@link String#getBytes(String)} in a null-safe manner.
     *
     * @param string  input string
     * @param charset The {@link Charset} name to encode the {@code String}. If null, then use the default Charset.
     * @return The empty byte[] if {@code string} is null, the result of {@link String#getBytes(String)} otherwise.
     * @throws UnsupportedEncodingException Thrown when the named charset is not supported.
     * @see String#getBytes(String)
     * @since 3.10
     */
    public static byte[] getBytes(final String string, final String charset) throws UnsupportedEncodingException {
        return string == null ? ArrayUtils.EMPTY_BYTE_ARRAY : string.getBytes(Charsets.toCharsetName(charset));
    }

    /**
     * <p>Compares all Strings in an array and returns the initial sequence of
     * characters that is common to all of them.</p>
     *
     * <p>For example,
     * {@code getCommonPrefix(new String[] {"i am a machine", "i am a robot"}) -&gt; "i am a "}</p>
     *
     * <pre>
     * StringUtils.getCommonPrefix(null) = ""
     * StringUtils.getCommonPrefix(new String[] {}) = ""
     * StringUtils.getCommonPrefix(new String[] {"abc"}) = "abc"
     * StringUtils.getCommonPrefix(new String[] {null, null}) = ""
     * StringUtils.getCommonPrefix(new String[] {"", ""}) = ""
     * StringUtils.getCommonPrefix(new String[] {"", null}) = ""
     * StringUtils.getCommonPrefix(new String[] {"abc", null, null}) = ""
     * StringUtils.getCommonPrefix(new String[] {null, null, "abc"}) = ""
     * StringUtils.getCommonPrefix(new String[] {"", "abc"}) = ""
     * StringUtils.getCommonPrefix(new String[] {"abc", ""}) = ""
     * StringUtils.getCommonPrefix(new String[] {"abc", "abc"}) = "abc"
     * StringUtils.getCommonPrefix(new String[] {"abc", "a"}) = "a"
     * StringUtils.getCommonPrefix(new String[] {"ab", "abxyz"}) = "ab"
     * StringUtils.getCommonPrefix(new String[] {"abcde", "abxyz"}) = "ab"
     * StringUtils.getCommonPrefix(new String[] {"abcde", "xyz"}) = ""
     * StringUtils.getCommonPrefix(new String[] {"xyz", "abcde"}) = ""
     * StringUtils.getCommonPrefix(new String[] {"i am a machine", "i am a robot"}) = "i am a "
     * </pre>
     *
     * @param strs array of String objects, entries may be null
     * @return the initial sequence of characters that are common to all Strings
     * in the array; empty String if the array is null, the elements are all null
     * or if there is no common prefix.
     * @since 2.4
     */
    public static String getCommonPrefix(final String... strs) {
        if (ArrayUtils.isEmpty(strs)) {
            return EMPTY;
        }
        final int smallestIndexOfDiff = indexOfDifference(strs);
        if (smallestIndexOfDiff == INDEX_NOT_FOUND) {
            // all strings were identical
            if (strs[0] == null) {
                return EMPTY;
            }
            return strs[0];
        } else if (smallestIndexOfDiff == 0) {
            // there were no common initial characters
            return EMPTY;
        } else {
            // we found a common initial character sequence
            return strs[0].substring(0, smallestIndexOfDiff);
        }
    }

    private static int indexOfDifference(String[] strs) {
        return 0;
    }

    /**
     * <p>Checks if a String {@code str} contains Unicode digits,
     * if yes then concatenate all the digits in {@code str} and return it as a String.</p>
     *
     * <p>An empty ("") String will be returned if no digits found in {@code str}.</p>
     *
     * <pre>
     * StringUtils.getDigits(null)  = null
     * StringUtils.getDigits("")    = ""
     * StringUtils.getDigits("abc") = ""
     * StringUtils.getDigits("1000$") = "1000"
     * StringUtils.getDigits("1123~45") = "112345"
     * StringUtils.getDigits("(541) 754-3010") = "5417543010"
     * StringUtils.getDigits("\u0967\u0968\u0969") = "\u0967\u0968\u0969"
     * </pre>
     *
     * @param str the String to extract digits from, may be null
     * @return String with only digits,
     * or an empty ("") String if no digits found,
     * or {@code null} String if {@code str} is null
     * @since 3.6
     */
    public static String getDigits(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        final int sz = str.length();
        final StringBuilder strDigits = new StringBuilder(sz);
        for (int i = 0; i < sz; i++) {
            final char tempChar = str.charAt(i);
            if (Character.isDigit(tempChar)) {
                strDigits.append(tempChar);
            }
        }
        return strDigits.toString();
    }

    /**
     * <p>Find the Fuzzy Distance which indicates the similarity score between two Strings.</p>
     *
     * <p>This string matching algorithm is similar to the algorithms of editors such as Sublime Text,
     * TextMate, Atom and others. One point is given for every matched character. Subsequent
     * matches yield two bonus points. A higher score indicates a higher similarity.</p>
     *
     * <pre>
     * StringUtils.getFuzzyDistance(null, null, null)                                    = IllegalArgumentException
     * StringUtils.getFuzzyDistance("", "", Locale.ENGLISH)                              = 0
     * StringUtils.getFuzzyDistance("Workshop", "b", Locale.ENGLISH)                     = 0
     * StringUtils.getFuzzyDistance("Room", "o", Locale.ENGLISH)                         = 1
     * StringUtils.getFuzzyDistance("Workshop", "w", Locale.ENGLISH)                     = 1
     * StringUtils.getFuzzyDistance("Workshop", "ws", Locale.ENGLISH)                    = 2
     * StringUtils.getFuzzyDistance("Workshop", "wo", Locale.ENGLISH)                    = 4
     * StringUtils.getFuzzyDistance("Apache Software Foundation", "asf", Locale.ENGLISH) = 3
     * </pre>
     *
     * @param term   a full term that should be matched against, must not be null
     * @param query  the query that will be matched against a term, must not be null
     * @param locale This string matching logic is case insensitive. A locale is necessary to normalize
     *               both Strings to lower case.
     * @return result score
     * @throws IllegalArgumentException if either String input {@code null} or Locale input {@code null}
     * @since 3.4
     * @deprecated as of 3.6, use commons-text
     * <a href="https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/similarity/FuzzyScore.html">
     * FuzzyScore</a> instead
     */
    @Deprecated
    public static int getFuzzyDistance(final CharSequence term, final CharSequence query, final Locale locale) {
        if (term == null || query == null) {
            throw new IllegalArgumentException("Strings must not be null");
        } else if (locale == null) {
            throw new IllegalArgumentException("Locale must not be null");
        }

        // fuzzy logic is case insensitive. We normalize the Strings to lower
        // case right from the start. Turning characters to lower case
        // via Character.toLowerCase(char) is unfortunately insufficient
        // as it does not accept a locale.
        final String termLowerCase = term.toString().toLowerCase(locale);
        final String queryLowerCase = query.toString().toLowerCase(locale);

        // the resulting score
        int score = 0;

        // the position in the term which will be scanned next for potential
        // query character matches
        int termIndex = 0;

        // index of the previously matched character in the term
        int previousMatchingCharacterIndex = Integer.MIN_VALUE;

        for (int queryIndex = 0; queryIndex < queryLowerCase.length(); queryIndex++) {
            final char queryChar = queryLowerCase.charAt(queryIndex);

            boolean termCharacterMatchFound = false;
            for (; termIndex < termLowerCase.length() && !termCharacterMatchFound; termIndex++) {
                final char termChar = termLowerCase.charAt(termIndex);

                if (queryChar == termChar) {
                    // simple character matches result in one point
                    score++;

                    // subsequent character matches further improve
                    // the score.
                    if (previousMatchingCharacterIndex + 1 == termIndex) {
                        score += 2;
                    }

                    previousMatchingCharacterIndex = termIndex;

                    // we can leave the nested loop. Every character in the
                    // query can match at most one character in the term.
                    termCharacterMatchFound = true;
                }
            }
        }

        return score;
    }

    /**
     * <p>Returns either the passed in CharSequence, or if the CharSequence is
     * whitespace, empty ("") or {@code null}, the value supplied by {@code defaultStrSupplier}.</p>
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
     *
     * <p>Caller responsible for thread-safety and exception handling of default value supplier</p>
     *
     * <pre>
     * {@code
     * StringUtils.getIfBlank(null, () -> "NULL")   = "NULL"
     * StringUtils.getIfBlank("", () -> "NULL")     = "NULL"
     * StringUtils.getIfBlank(" ", () -> "NULL")    = "NULL"
     * StringUtils.getIfBlank("bat", () -> "NULL")  = "bat"
     * StringUtils.getIfBlank("", () -> null)       = null
     * StringUtils.getIfBlank("", null)             = null
     * }</pre>
     *
     * @param <T>             the specific kind of CharSequence
     * @param str             the CharSequence to check, may be null
     * @param defaultSupplier the supplier of default CharSequence to return
     *                        if the input is whitespace, empty ("") or {@code null}, may be null
     * @return the passed in CharSequence, or the default
     * @see StringUtils#defaultString(String, String)
     * @since 3.10
     */
    public static <T extends CharSequence> T getIfBlank(final T str, final Supplier<T> defaultSupplier) {
        return isBlank(str) ? defaultSupplier == null ? null : defaultSupplier.get() : str;
    }

    public static <T extends CharSequence> boolean isBlank(T str) {
        return true;
    }

    /**
     * <p>Returns either the passed in CharSequence, or if the CharSequence is
     * empty or {@code null}, the value supplied by {@code defaultStrSupplier}.</p>
     *
     * <p>Caller responsible for thread-safety and exception handling of default value supplier</p>
     *
     * <pre>
     * {@code
     * StringUtils.getIfEmpty(null, () -> "NULL")    = "NULL"
     * StringUtils.getIfEmpty("", () -> "NULL")      = "NULL"
     * StringUtils.getIfEmpty(" ", () -> "NULL")     = " "
     * StringUtils.getIfEmpty("bat", () -> "NULL")   = "bat"
     * StringUtils.getIfEmpty("", () -> null)        = null
     * StringUtils.getIfEmpty("", null)              = null
     * }
     * </pre>
     *
     * @param <T>             the specific kind of CharSequence
     * @param str             the CharSequence to check, may be null
     * @param defaultSupplier the supplier of default CharSequence to return
     *                        if the input is empty ("") or {@code null}, may be null
     * @return the passed in CharSequence, or the default
     * @see StringUtils#defaultString(String, String)
     * @since 3.10
     */
    public static <T extends CharSequence> T getIfEmpty(final T str, final Supplier<T> defaultSupplier) {
        return isEmpty(str) ? defaultSupplier == null ? null : defaultSupplier.get() : str;
    }

    /**
     * <p>Find the Jaro Winkler Distance which indicates the similarity score between two Strings.</p>
     *
     * <p>The Jaro measure is the weighted sum of percentage of matched characters from each file and transposed characters.
     * Winkler increased this measure for matching initial characters.</p>
     *
     * <p>This implementation is based on the Jaro Winkler similarity algorithm
     * from <a href="http://en.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance">http://en.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance</a>.</p>
     *
     * <pre>
     * StringUtils.getJaroWinklerDistance(null, null)          = IllegalArgumentException
     * StringUtils.getJaroWinklerDistance("", "")              = 0.0
     * StringUtils.getJaroWinklerDistance("", "a")             = 0.0
     * StringUtils.getJaroWinklerDistance("aaapppp", "")       = 0.0
     * StringUtils.getJaroWinklerDistance("frog", "fog")       = 0.93
     * StringUtils.getJaroWinklerDistance("fly", "ant")        = 0.0
     * StringUtils.getJaroWinklerDistance("elephant", "hippo") = 0.44
     * StringUtils.getJaroWinklerDistance("hippo", "elephant") = 0.44
     * StringUtils.getJaroWinklerDistance("hippo", "zzzzzzzz") = 0.0
     * StringUtils.getJaroWinklerDistance("hello", "hallo")    = 0.88
     * StringUtils.getJaroWinklerDistance("ABC Corporation", "ABC Corp") = 0.93
     * StringUtils.getJaroWinklerDistance("D N H Enterprises Inc", "D &amp; H Enterprises, Inc.") = 0.95
     * StringUtils.getJaroWinklerDistance("My Gym Children's Fitness Center", "My Gym. Childrens Fitness") = 0.92
     * StringUtils.getJaroWinklerDistance("PENNSYLVANIA", "PENNCISYLVNIA") = 0.88
     * </pre>
     *
     * @param first  the first String, must not be null
     * @param second the second String, must not be null
     * @return result distance
     * @throws IllegalArgumentException if either String input {@code null}
     * @since 3.3
     * @deprecated as of 3.6, use commons-text
     * <a href="https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/similarity/JaroWinklerDistance.html">
     * JaroWinklerDistance</a> instead
     */
    @Deprecated
    public static double getJaroWinklerDistance(final CharSequence first, final CharSequence second) {
        final double DEFAULT_SCALING_FACTOR = 0.1;

        if (first == null || second == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }

        final int[] mtp = matches(first, second);
        final double m = mtp[0];
        if (m == 0) {
            return 0D;
        }
        final double j = (m / first.length() + m / second.length() + (m - mtp[1]) / m) / 3;
        final double jw = j < 0.7D ? j : j + Math.min(DEFAULT_SCALING_FACTOR, 1D / mtp[3]) * mtp[2] * (1D - j);
        return Math.round(jw * 100.0D) / 100.0D;
    }

    private static int[] matches(CharSequence first, CharSequence second) {
        return new int[5];
    }

    /**
     * <p>Find the Levenshtein distance between two Strings.</p>
     *
     * <p>This is the number of changes needed to change one String into
     * another, where each change is a single character modification (deletion,
     * insertion or substitution).</p>
     *
     * <p>The implementation uses a single-dimensional array of length s.length() + 1. See
     * <a href="http://blog.softwx.net/2014/12/optimizing-levenshtein-algorithm-in-c.html">
     * http://blog.softwx.net/2014/12/optimizing-levenshtein-algorithm-in-c.html</a> for details.</p>
     *
     * <pre>
     * StringUtils.getLevenshteinDistance(null, *)             = IllegalArgumentException
     * StringUtils.getLevenshteinDistance(*, null)             = IllegalArgumentException
     * StringUtils.getLevenshteinDistance("", "")              = 0
     * StringUtils.getLevenshteinDistance("", "a")             = 1
     * StringUtils.getLevenshteinDistance("aaapppp", "")       = 7
     * StringUtils.getLevenshteinDistance("frog", "fog")       = 1
     * StringUtils.getLevenshteinDistance("fly", "ant")        = 3
     * StringUtils.getLevenshteinDistance("elephant", "hippo") = 7
     * StringUtils.getLevenshteinDistance("hippo", "elephant") = 7
     * StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz") = 8
     * StringUtils.getLevenshteinDistance("hello", "hallo")    = 1
     * </pre>
     *
     * @param s the first String, must not be null
     * @param t the second String, must not be null
     * @return result distance
     * @throws IllegalArgumentException if either String input {@code null}
     * @since 3.0 Changed signature from getLevenshteinDistance(String, String) to
     * getLevenshteinDistance(CharSequence, CharSequence)
     * @deprecated as of 3.6, use commons-text
     * <a href="https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/similarity/LevenshteinDistance.html">
     * LevenshteinDistance</a> instead
     */
    @Deprecated
    public static int getLevenshteinDistance(CharSequence s, CharSequence t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }

        int n = s.length();
        int m = t.length();

        if (n == 0) {
            return m;
        } else if (m == 0) {
            return n;
        }

        if (n > m) {
            // swap the input strings to consume less memory
            final CharSequence tmp = s;
            s = t;
            t = tmp;
            n = m;
            m = t.length();
        }

        final int[] p = new int[n + 1];
        // indexes into strings s and t
        int i; // iterates through s
        int j; // iterates through t
        int upper_left;
        int upper;

        char t_j; // jth character of t
        int cost;

        for (i = 0; i <= n; i++) {
            p[i] = i;
        }

        for (j = 1; j <= m; j++) {
            upper_left = p[0];
            t_j = t.charAt(j - 1);
            p[0] = j;

            for (i = 1; i <= n; i++) {
                upper = p[i];
                cost = s.charAt(i - 1) == t_j ? 0 : 1;
                // minimum of cell to the left+1, to the top+1, diagonally left and up +cost
                p[i] = Math.min(Math.min(p[i - 1] + 1, p[i] + 1), upper_left + cost);
                upper_left = upper;
            }
        }

        return p[n];
    }

    /**
     * <p>Find the Levenshtein distance between two Strings if it's less than or equal to a given
     * threshold.</p>
     *
     * <p>This is the number of changes needed to change one String into
     * another, where each change is a single character modification (deletion,
     * insertion or substitution).</p>
     *
     * <p>This implementation follows from Algorithms on Strings, Trees and Sequences by Dan Gusfield
     * and Chas Emerick's implementation of the Levenshtein distance algorithm from
     * <a href="http://www.merriampark.com/ld.htm">http://www.merriampark.com/ld.htm</a></p>
     *
     * <pre>
     * StringUtils.getLevenshteinDistance(null, *, *)             = IllegalArgumentException
     * StringUtils.getLevenshteinDistance(*, null, *)             = IllegalArgumentException
     * StringUtils.getLevenshteinDistance(*, *, -1)               = IllegalArgumentException
     * StringUtils.getLevenshteinDistance("", "", 0)              = 0
     * StringUtils.getLevenshteinDistance("aaapppp", "", 8)       = 7
     * StringUtils.getLevenshteinDistance("aaapppp", "", 7)       = 7
     * StringUtils.getLevenshteinDistance("aaapppp", "", 6))      = -1
     * StringUtils.getLevenshteinDistance("elephant", "hippo", 7) = 7
     * StringUtils.getLevenshteinDistance("elephant", "hippo", 6) = -1
     * StringUtils.getLevenshteinDistance("hippo", "elephant", 7) = 7
     * StringUtils.getLevenshteinDistance("hippo", "elephant", 6) = -1
     * </pre>
     *
     * @param s         the first String, must not be null
     * @param t         the second String, must not be null
     * @param threshold the target threshold, must not be negative
     * @return result distance, or {@code -1} if the distance would be greater than the threshold
     * @throws IllegalArgumentException if either String input {@code null} or negative threshold
     * @deprecated as of 3.6, use commons-text
     * <a href="https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/similarity/LevenshteinDistance.html">
     * LevenshteinDistance</a> instead
     */
    @Deprecated
    public static int getLevenshteinDistance(CharSequence s, CharSequence t, final int threshold) {
        if (s == null || t == null) {
            System.out.println("");
            throw new IllegalArgumentException("Strings must not be null");
        }
        if (threshold < 0) {
            throw new IllegalArgumentException("Threshold must not be negative");
        }

        /*
        This implementation only computes the distance if it's less than or equal to the
        threshold value, returning -1 if it's greater.  The advantage is performance: unbounded
        distance is O(nm), but a bound of k allows us to reduce it to O(km) time by only
        computing a diagonal stripe of width 2k + 1 of the cost table.
        It is also possible to use this to compute the unbounded Levenshtein distance by starting
        the threshold at 1 and doubling each time until the distance is found; this is O(dm), where
        d is the distance.

        One subtlety comes from needing to ignore entries on the border of our stripe
        eg.
        p[] = |#|#|#|*
        d[] =  *|#|#|#|
        We must ignore the entry to the left of the leftmost member
        We must ignore the entry above the rightmost member

        Another subtlety comes from our stripe running off the matrix if the strings aren't
        of the same size.  Since string s is always swapped to be the shorter of the two,
        the stripe will always run off to the upper right instead of the lower left of the matrix.

        As a concrete example, suppose s is of length 5, t is of length 7, and our threshold is 1.
        In this case we're going to walk a stripe of length 3.  The matrix would look like so:

           1 2 3 4 5
        1 |#|#| | | |
        2 |#|#|#| | |
        3 | |#|#|#| |
        4 | | |#|#|#|
        5 | | | |#|#|
        6 | | | | |#|
        7 | | | | | |

        Note how the stripe leads off the table as there is no possible way to turn a string of length 5
        into one of length 7 in edit distance of 1.

        Additionally, this implementation decreases memory usage by using two
        single-dimensional arrays and swapping them back and forth instead of allocating
        an entire n by m matrix.  This requires a few minor changes, such as immediately returning
        when it's detected that the stripe has run off the matrix and initially filling the arrays with
        large values so that entries we don't compute are ignored.

        See Algorithms on Strings, Trees and Sequences by Dan Gusfield for some discussion.
         */

        int n = s.length(); // length of s
        int m = t.length(); // length of t

        // if one string is empty, the edit distance is necessarily the length of the other
        if (n == 0) {
            return m <= threshold ? m : -1;
        } else if (m == 0) {
            return n <= threshold ? n : -1;
        } else if (Math.abs(n - m) > threshold) {
            // no need to calculate the distance if the length difference is greater than the threshold
            return -1;
        }

        if (n > m) {
            // swap the two strings to consume less memory
            final CharSequence tmp = s;
            s = t;
            t = tmp;
            n = m;
            m = t.length();
        }

        int[] p = new int[n + 1]; // 'previous' cost array, horizontally
        int[] d = new int[n + 1]; // cost array, horizontally
        int[] _d; // placeholder to assist in swapping p and d

        // fill in starting table values
        final int boundary = Math.min(n, threshold) + 1;
        for (int i = 0; i < boundary; i++) {
            p[i] = i;
        }
        // these fills ensure that the value above the rightmost entry of our
        // stripe will be ignored in following loop iterations
        Arrays.fill(p, boundary, p.length, Integer.MAX_VALUE);
        Arrays.fill(d, Integer.MAX_VALUE);

        // iterates through t
        for (int j = 1; j <= m; j++) {
            final char t_j = t.charAt(j - 1); // jth character of t
            d[0] = j;

            // compute stripe indices, constrain to array size
            final int min = Math.max(1, j - threshold);
            final int max = j > Integer.MAX_VALUE - threshold ? n : Math.min(n, j + threshold);

            // the stripe may lead off of the table if s and t are of different sizes
            if (min > max) {
                return -1;
            }

            // ignore entry left of leftmost
            if (min > 1) {
                d[min - 1] = Integer.MAX_VALUE;
            }

            // iterates through [min, max] in s
            for (int i = min; i <= max; i++) {
                if (s.charAt(i - 1) == t_j) {
                    // diagonally left and up
                    d[i] = p[i - 1];
                } else {
                    // 1 + minimum of cell to the left, to the top, diagonally left and up
                    d[i] = 1 + Math.min(Math.min(d[i - 1], p[i]), p[i - 1]);
                }
            }

            // copy current distance counts to 'previous row' distance counts
            _d = p;
            p = d;
            d = _d;
        }

        // if p[n] is greater than the threshold, there's no guarantee on it being the correct
        // distance
        if (p[n] <= threshold) {
            return p[n];
        }
        return -1;
    }

    /**
     * <p>Finds the first index within a CharSequence, handling {@code null}.
     * This method uses {@link String#indexOf(String, int)} if possible.</p>
     *
     * <p>A {@code null} CharSequence will return {@code -1}.</p>
     *
     * <pre>
     * StringUtils.indexOf(null, *)          = -1
     * StringUtils.indexOf(*, null)          = -1
     * StringUtils.indexOf("", "")           = 0
     * StringUtils.indexOf("", *)            = -1 (except when * = "")
     * StringUtils.indexOf("aabaabaa", "a")  = 0
     * StringUtils.indexOf("aabaabaa", "b")  = 2
     * StringUtils.indexOf("aabaabaa", "ab") = 1
     * StringUtils.indexOf("aabaabaa", "")   = 0
     * </pre>
     *
     * @param seq       the CharSequence to check, may be null
     * @param searchSeq the CharSequence to find, may be null
     * @return the first index of the search CharSequence,
     * -1 if no match or {@code null} string input
     * @since 2.0
     * @since 3.0 Changed signature from indexOf(String, String) to indexOf(CharSequence, CharSequence)
     */
    public static int indexOf(final CharSequence seq, final CharSequence searchSeq) {
        if (seq == null || searchSeq == null) {
            return INDEX_NOT_FOUND;
        }
        return CharSequenceUtils.indexOf(seq, searchSeq, 0);
    }

    /**
     * <p>Finds the first index within a CharSequence, handling {@code null}.
     * This method uses {@link String#indexOf(String, int)} if possible.</p>
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A negative start position is treated as zero.
     * An empty ("") search CharSequence always matches.
     * A start position greater than the string length only matches
     * an empty search CharSequence.</p>
     *
     * <pre>
     * StringUtils.indexOf(null, *, *)          = -1
     * StringUtils.indexOf(*, null, *)          = -1
     * StringUtils.indexOf("", "", 0)           = 0
     * StringUtils.indexOf("", *, 0)            = -1 (except when * = "")
     * StringUtils.indexOf("aabaabaa", "a", 0)  = 0
     * StringUtils.indexOf("aabaabaa", "b", 0)  = 2
     * StringUtils.indexOf("aabaabaa", "ab", 0) = 1
     * StringUtils.indexOf("aabaabaa", "b", 3)  = 5
     * StringUtils.indexOf("aabaabaa", "b", 9)  = -1
     * StringUtils.indexOf("aabaabaa", "b", -1) = 2
     * StringUtils.indexOf("aabaabaa", "", 2)   = 2
     * StringUtils.indexOf("abc", "", 9)        = 3
     * </pre>
     *
     * @param seq       the CharSequence to check, may be null
     * @param searchSeq the CharSequence to find, may be null
     * @param startPos  the start position, negative treated as zero
     * @return the first index of the search CharSequence (always &ge; startPos),
     * -1 if no match or {@code null} string input
     * @since 2.0
     * @since 3.0 Changed signature from indexOf(String, String, int) to indexOf(CharSequence, CharSequence, int)
     */
    public static int indexOf(final CharSequence seq, final CharSequence searchSeq, final int startPos) {
        if (seq == null || searchSeq == null) {
            return INDEX_NOT_FOUND;
        }
        return CharSequenceUtils.indexOf(seq, searchSeq, startPos);
    }

    /**
     * Returns the index within {@code seq} of the first occurrence of
     * the specified character. If a character with value
     * {@code searchChar} occurs in the character sequence represented by
     * {@code seq} {@code CharSequence} object, then the index (in Unicode
     * code units) of the first such occurrence is returned. For
     * values of {@code searchChar} in the range from 0 to 0xFFFF
     * (inclusive), this is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * this.charAt(<i>k</i>) == searchChar
     * </pre></blockquote>
     * is true. For other values of {@code searchChar}, it is the
     * smallest value <i>k</i> such that:
     * <blockquote><pre>
     * this.codePointAt(<i>k</i>) == searchChar
     * </pre></blockquote>
     * is true. In either case, if no such character occurs in {@code seq},
     * then {@code INDEX_NOT_FOUND (-1)} is returned.
     *
     * <p>Furthermore, a {@code null} or empty ("") CharSequence will
     * return {@code INDEX_NOT_FOUND (-1)}.</p>
     *
     * <pre>
     * StringUtils.indexOf(null, *)         = -1
     * StringUtils.indexOf("", *)           = -1
     * StringUtils.indexOf("aabaabaa", 'a') = 0
     * StringUtils.indexOf("aabaabaa", 'b') = 2
     * </pre>
     *
     * @param seq        the CharSequence to check, may be null
     * @param searchChar the character to find
     * @return the first index of the search character,
     * -1 if no match or {@code null} string input
     * @since 2.0
     * @since 3.0 Changed signature from indexOf(String, int) to indexOf(CharSequence, int)
     * @since 3.6 Updated {@link CharSequenceUtils} call to behave more like {@code String}
     */
    public static int indexOf(final CharSequence seq, final int searchChar) {
        if (isEmpty(seq)) {
            return INDEX_NOT_FOUND;
        }
        return CharSequenceUtils.indexOf(seq, searchChar, 0);
    }

    /**
     * Returns the index within {@code seq} of the first occurrence of the
     * specified character, starting the search at the specified index.
     * <p>
     * If a character with value {@code searchChar} occurs in the
     * character sequence represented by the {@code seq} {@code CharSequence}
     * object at an index no smaller than {@code startPos}, then
     * the index of the first such occurrence is returned. For values
     * of {@code searchChar} in the range from 0 to 0xFFFF (inclusive),
     * this is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.charAt(<i>k</i>) == searchChar) &amp;&amp; (<i>k</i> &gt;= startPos)
     * </pre></blockquote>
     * is true. For other values of {@code searchChar}, it is the
     * smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.codePointAt(<i>k</i>) == searchChar) &amp;&amp; (<i>k</i> &gt;= startPos)
     * </pre></blockquote>
     * is true. In either case, if no such character occurs in {@code seq}
     * at or after position {@code startPos}, then
     * {@code -1} is returned.
     *
     * <p>
     * There is no restriction on the value of {@code startPos}. If it
     * is negative, it has the same effect as if it were zero: this entire
     * string may be searched. If it is greater than the length of this
     * string, it has the same effect as if it were equal to the length of
     * this string: {@code (INDEX_NOT_FOUND) -1} is returned. Furthermore, a
     * {@code null} or empty ("") CharSequence will
     * return {@code (INDEX_NOT_FOUND) -1}.
     *
     * <p>All indices are specified in {@code char} values
     * (Unicode code units).
     *
     * <pre>
     * StringUtils.indexOf(null, *, *)          = -1
     * StringUtils.indexOf("", *, *)            = -1
     * StringUtils.indexOf("aabaabaa", 'b', 0)  = 2
     * StringUtils.indexOf("aabaabaa", 'b', 3)  = 5
     * StringUtils.indexOf("aabaabaa", 'b', 9)  = -1
     * StringUtils.indexOf("aabaabaa", 'b', -1) = 2
     * </pre>
     *
     * @param seq        the CharSequence to check, may be null
     * @param searchChar the character to find
     * @param startPos   the start position, negative treated as zero
     * @return the first index of the search character (always &ge; startPos),
     * -1 if no match or {@code null} string input
     * @since 2.0
     * @since 3.0 Changed signature from indexOf(String, int, int) to indexOf(CharSequence, int, int)
     * @since 3.6 Updated {@link CharSequenceUtils} call to behave more like {@code String}
     */
    public static int indexOf(final CharSequence seq, final int searchChar, final int startPos) {
        if (isEmpty(seq)) {
            return INDEX_NOT_FOUND;
        }
        return CharSequenceUtils.indexOf(seq, searchChar, startPos);
    }

    /**
     * <p>Search a CharSequence to find the first index of any
     * character in the given set of characters.</p>
     *
     * <p>A {@code null} String will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.</p>
     *
     * <pre>
     * StringUtils.indexOfAny(null, *)                  = -1
     * StringUtils.indexOfAny("", *)                    = -1
     * StringUtils.indexOfAny(*, null)                  = -1
     * StringUtils.indexOfAny(*, [])                    = -1
     * StringUtils.indexOfAny("zzabyycdxx", ['z', 'a']) = 0
     * StringUtils.indexOfAny("zzabyycdxx", ['b', 'y']) = 3
     * StringUtils.indexOfAny("aba", ['z'])             = -1
     * </pre>
     *
     * @param cs          the CharSequence to check, may be null
     * @param searchChars the chars to search for, may be null
     * @return the index of any of the chars, -1 if no match or null input
     * @since 2.0
     * @since 3.0 Changed signature from indexOfAny(String, char[]) to indexOfAny(CharSequence, char...)
     */
    public static int indexOfAny(final CharSequence cs, final char... searchChars) {
        if (isEmpty(cs) || ArrayUtils.isEmpty(searchChars)) {
            return INDEX_NOT_FOUND;
        }
        final int csLen = cs.length();
        final int csLast = csLen - 1;
        final int searchLen = searchChars.length;
        final int searchLast = searchLen - 1;
        for (int i = 0; i < csLen; i++) {
            final char ch = cs.charAt(i);
            for (int j = 0; j < searchLen; j++) {
                if (searchChars[j] == ch) {
                    if (i < csLast && j < searchLast && Character.isHighSurrogate(ch)) {
                        // ch is a supplementary character
                        if (searchChars[j + 1] == cs.charAt(i + 1)) {
                            return i;
                        }
                    } else {
                        return i;
                    }
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Find the first index of any of a set of potential substrings.</p>
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     * A {@code null} search array entry will be ignored, but a search
     * array containing "" will return {@code 0} if {@code str} is not
     * null. This method uses {@link String#indexOf(String)} if possible.</p>
     *
     * <pre>
     * StringUtils.indexOfAny(null, *)                      = -1
     * StringUtils.indexOfAny(*, null)                      = -1
     * StringUtils.indexOfAny(*, [])                        = -1
     * StringUtils.indexOfAny("zzabyycdxx", ["ab", "cd"])   = 2
     * StringUtils.indexOfAny("zzabyycdxx", ["cd", "ab"])   = 2
     * StringUtils.indexOfAny("zzabyycdxx", ["mn", "op"])   = -1
     * StringUtils.indexOfAny("zzabyycdxx", ["zab", "aby"]) = 1
     * StringUtils.indexOfAny("zzabyycdxx", [""])           = 0
     * StringUtils.indexOfAny("", [""])                     = 0
     * StringUtils.indexOfAny("", ["a"])                    = -1
     * </pre>
     *
     * @param str        the CharSequence to check, may be null
     * @param searchStrs the CharSequences to search for, may be null
     * @return the first index of any of the searchStrs in str, -1 if no match
     * @since 3.0 Changed signature from indexOfAny(String, String[]) to indexOfAny(CharSequence, CharSequence...)
     */
    public static int indexOfAny(final CharSequence str, final CharSequence... searchStrs) {
        if (str == null || searchStrs == null) {
            return INDEX_NOT_FOUND;
        }

        // String's can't have a MAX_VALUEth index.
        int ret = Integer.MAX_VALUE;

        int tmp = 0;
        for (final CharSequence search : searchStrs) {
            if (search == null) {
                continue;
            }
            tmp = CharSequenceUtils.indexOf(str, search, 0);
            if (tmp == INDEX_NOT_FOUND) {
                continue;
            }

            if (tmp < ret) {
                ret = tmp;
            }
        }

        return ret == Integer.MAX_VALUE ? INDEX_NOT_FOUND : ret;
    }

    /**
     * <p>Search a CharSequence to find the first index of any
     * character in the given set of characters.</p>
     *
     * <p>A {@code null} String will return {@code -1}.
     * A {@code null} search string will return {@code -1}.</p>
     *
     * <pre>
     * StringUtils.indexOfAny(null, *)            = -1
     * StringUtils.indexOfAny("", *)              = -1
     * StringUtils.indexOfAny(*, null)            = -1
     * StringUtils.indexOfAny(*, "")              = -1
     * StringUtils.indexOfAny("zzabyycdxx", "za") = 0
     * StringUtils.indexOfAny("zzabyycdxx", "by") = 3
     * StringUtils.indexOfAny("aba", "z")         = -1
     * </pre>
     *
     * @param cs          the CharSequence to check, may be null
     * @param searchChars the chars to search for, may be null
     * @return the index of any of the chars, -1 if no match or null input
     * @since 2.0
     * @since 3.0 Changed signature from indexOfAny(String, String) to indexOfAny(CharSequence, String)
     */
    public static int indexOfAny(final CharSequence cs, final String searchChars) {
        if (isEmpty(cs) || isEmpty(searchChars)) {
            return INDEX_NOT_FOUND;
        }
        return indexOfAny(cs, searchChars.toCharArray());
    }

    /**
     * <p>Searches a CharSequence to find the first index of any
     * character not in the given set of characters.</p>
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.</p>
     *
     * <pre>
     * StringUtils.indexOfAnyBut(null, *)                              = -1
     * StringUtils.indexOfAnyBut("", *)                                = -1
     * StringUtils.indexOfAnyBut(*, null)                              = -1
     * StringUtils.indexOfAnyBut(*, [])                                = -1
     * StringUtils.indexOfAnyBut("zzabyycdxx", new char[] {'z', 'a'} ) = 3
     * StringUtils.indexOfAnyBut("aba", new char[] {'z'} )             = 0
     * StringUtils.indexOfAnyBut("aba", new char[] {'a', 'b'} )        = -1
     *
     * </pre>
     *
     * @param cs          the CharSequence to check, may be null
     * @param searchChars the chars to search for, may be null
     * @return the index of any of the chars, -1 if no match or null input
     * @since 2.0
     * @since 3.0 Changed signature from indexOfAnyBut(String, char[]) to indexOfAnyBut(CharSequence, char...)
     */
    public static int indexOfAnyBut(final CharSequence cs, final char... searchChars) {
        if (isEmpty(cs) || ArrayUtils.isEmpty(searchChars)) {
            return INDEX_NOT_FOUND;
        }
        final int csLen = cs.length();
        final int csLast = csLen - 1;
        final int searchLen = searchChars.length;
        final int searchLast = searchLen - 1;
        outer:
        for (int i = 0; i < csLen; i++) {
            final char ch = cs.charAt(i);
            for (int j = 0; j < searchLen; j++) {
                if (searchChars[j] == ch) {
                    if (i < csLast && j < searchLast && Character.isHighSurrogate(ch)) {
                        if (searchChars[j + 1] == cs.charAt(i + 1)) {
                            continue outer;
                        }
                    } else {
                        continue outer;
                    }
                }
            }
            return i;
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean isEmpty(CharSequence cs) {
        return false;
    }

    /**
     * <p>{@code StringUtils} instances should NOT be constructed in
     * standard programming. Instead, the class should be used as
     * {@code StringUtils.trim(" foo ");}.</p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    public StringUtils() {
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return false;
    }

    public static boolean isNotBlank(CharSequence cs) {
        return false;
    }

    public static boolean isAllUpperCase(String str) {
        return false;
    }

    public static boolean isNumeric(String str) {
        return false;
    }

    public static boolean isAllLowerCase(String str) {
        return false;
    }

    public static String replaceOnce(String duration, String s, String empty) {
        return null;
    }

    public static int replace(String toString, String csvQuoteStr, String s) {
        return 0;
    }

    public static String repeat(String toString, int count) {
        return null;
    }

    class NestedClass {
        private static final int MAX = 999;

        private final String field;

        public NestedClass(String field) {
            this.field = field;
        }

        public String getField() {
            return field;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NestedClass that = (NestedClass) o;
            return Objects.equals(field, that.field);
        }

        @Override
        public int hashCode() {
            return Objects.hash(field);
        }
    }

}

class Other {

    public static void main(String[] args) {
        System.out.println("test");
    }
}
