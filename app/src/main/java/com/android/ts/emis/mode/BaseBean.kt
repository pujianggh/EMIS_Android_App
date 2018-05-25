package com.android.ts.emis.mode

import java.io.Serializable

/**
 * 基本状态Mode
 *
 * @author pujiang
 * @date 2017-12-20 11:38
 * @mail 515210530@qq.com
 * @Description:
 */
open class BaseBean : Serializable {
    private val AppCode: String? = null
    private val ResponseDate: String? = null
    private val Sign: String? = null
    private val ErrCode: String? = null
    private val ErrMsg: String? = null
}
