package com.android.ts.emis.mode

/**
 *
 * @author pujiang
 * @date 2018-1-23 16:40
 * @mail 515210530@qq.com
 * @Description:
 */

data class UserLoad(
		var head: List<Head>
)

data class Head(
		var text: String, //广州
		var id: String, //广州
		var pid: String //广东省
)