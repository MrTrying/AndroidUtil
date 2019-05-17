package com.mrtrying.utils;


/**
 * Description : utils for string.
 * PackageName : com.mrtrying.utils
 * Created by mrtrying on 2019/5/17 16:07.
 * e_mail : ztanzeyu@gmail.com
 */
public class StringUtils {

    /**
     * Return whether string1 is equals to string2.
     *
     * @param s1 first string.
     * @param s2 second string.
     *
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean equals(final CharSequence s1, final CharSequence s2) {
        if (s1 == s2) return true;
        int length;
        if (s1 != null && s2 != null && (length = s1.length()) == s2.length()) {
            if (s1 instanceof String && s2 instanceof String) {
                return s1.equals(s2);
            } else {
                for (int i = 0; i < length; i++) {
                    if (s1.charAt(i) != s2.charAt(i)) return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Return the length of string.
     *
     * @param s the string.
     *
     * @return length of string.
     */
    public static int length(final CharSequence s) {
        return s == null ? 0 : s.length();
    }

    /**
     * Return whether the string is null or string.length() == 0.
     *
     * @param s the string.
     *
     * @return {@code true}: yes<br> {@code false}: no
     */
    public static boolean isEmpty(final CharSequence s) {
        return s == null || s.length() == 0;
    }

    /**
     * Return whether the string is null or whitespace.
     *
     * @param s the string.
     *
     * @return {@code true}: yes<br> {@code false}: no
     */
    public static boolean isTrimEmpty(final String s) {
        return s == null || s.trim().length() == 0;
    }

    /**
     * Return a string that is a substring of this string.
     * The substring begins at 0 and end at index {@code endIndex - 1}.
     *
     * @param s        the string.
     * @param endIndex the end index, exclusive.
     *
     * @return the specified substring.
     */
    public static String subOverString(String s, int endIndex) {
        if (s == null || endIndex < 0) {
            return s;
        }
        return s.length() >= endIndex ? s : s.substring(0, endIndex);
    }

    /**
     * Return a string that is a substring of this string.
     * The substring begins at 0 and end at index {@code endIndex - 1}
     * and then add the suffix {@code suffix}.
     *
     * @param s        the string.
     * @param endIndex the end index, exclusive.
     * @param suffix   the suffix to be added.
     *
     * @return the specified substring.
     */
    public static String subOverString(String s, int endIndex, String suffix) {
        s = subOverString(s, endIndex);
        return suffix == null ? s : s + suffix;
    }

}
