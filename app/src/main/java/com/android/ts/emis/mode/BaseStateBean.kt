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
open class BaseStateBean : Serializable {
    open var code: Int = 0
    open var msg: String? = null
}
