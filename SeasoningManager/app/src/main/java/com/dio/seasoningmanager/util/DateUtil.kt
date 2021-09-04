package com.dio.seasoningmanager.util

import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.regex.Pattern

public class DateUtil {
    companion object {
        public fun toDateString(pattern: String = "yyyy/MM/dd", year: Int, month: Int, day: Int): String {
            var localDateTime: LocalDateTime = LocalDateTime.of(year, month - 1, day, 0, 0, 0);
            return localDateTime.format(DateTimeFormatter.ofPattern(pattern))
        }

        public fun String.toLocalDateTime(pattern: String = "yyyy/MM/dd"): LocalDateTime? {
            var simpleDateFormat:SimpleDateFormat;
            try {
                simpleDateFormat = SimpleDateFormat(pattern);
            } catch (ex: Exception) {
                return null;
            }
            var date: Date;
            try {
                date = simpleDateFormat.parse(this)
            } catch (ex: Exception) {
                return null;
            }
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
        public fun String.toDate(pattern: String = "yyyy/MM/dd"): Date? {
            var simpleDateFormat:SimpleDateFormat;
            try {
                simpleDateFormat = SimpleDateFormat(pattern);
            } catch (ex: Exception) {
                return null;
            }
            var date: Date;
            try {
                date = simpleDateFormat.parse(this)
            } catch (ex: Exception) {
                return null;
            }
            return date;
        }
    }
}