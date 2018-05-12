package com.android.ts.emis.utils

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.android.ts.emis.app.APPApplication

/**
 * 数据存储工具
 *
 * @author pujiang
 * @date 2018-1-4 19:50
 * @mail 515210530@qq.com
 * @Description:
 */
object SPUtil {
    private var mSharedPreferences: SharedPreferences? = null

    private val preferneces: SharedPreferences
        @Synchronized get() {
            return mSharedPreferences ?: PreferenceManager.getDefaultSharedPreferences(APPApplication.getInstance())
        }

    fun clear() {
        preferneces.edit().clear().commit()
    }

    fun putString(key: String, value: String) {
        preferneces.edit().putString(key, value).commit()
    }

    fun getString(key: String): String? {
        return preferneces.getString(key, null)
    }

    fun putInt(key: String, value: Int) {
        preferneces.edit().putInt(key, value).commit()
    }

    fun getInt(key: String): Int {
        return preferneces.getInt(key, 0)
    }

    fun putBoolean(key: String, value: Boolean?) {
        preferneces.edit().putBoolean(key, value!!).commit()
    }

    fun putLong(key: String, value: Long) {
        preferneces.edit().putLong(key, value).commit()
    }

    fun getLong(key: String): Long {
        return preferneces.getLong(key, 0)
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return preferneces.getBoolean(key, defValue)
    }

    fun remove(key: String) {
        preferneces.edit().remove(key).commit()
    }

    fun hasKey(key: String): Boolean {
        return preferneces.contains(key)
    }
}