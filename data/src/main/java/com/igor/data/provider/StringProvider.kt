package com.igor.data.provider

import android.content.res.Resources
import com.igor.data.R

class StringProvider : StringProviderInterface {

    override val baseUrl: String
        get() = Resources.getSystem().getString(R.string.base_url)

}